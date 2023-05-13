package extraitemuses.server.events;

import java.util.List;

import extraitemuses.ExtraItemUsesMod;
import extraitemuses.api.ExtraItemUse;
import extraitemuses.api.ItemUses;
import extraitemuses.server.ExtraItemUsesMaps;
import extraitemuses.server.uses.BlockMap;
import extraitemuses.server.uses.BlockMap.ChiselablesBlockMap;
import extraitemuses.server.uses.BlockMap.CrackablesBlockMap;
import extraitemuses.server.uses.BlockMap.GrindablesBlockMap;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractCandleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.event.OnDatapackSyncEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.FORGE, modid = ExtraItemUsesMod.ID)
public class ForgeBusEvents {
	@SubscribeEvent
	public static void addRightClickFunctions(OnDatapackSyncEvent event) {
		for (int i = 0; i < BlockMap.Register.CRACKABLES.get().getValues().size(); i++) {
			List<CrackablesBlockMap> crackablesBlockMaps = BlockMap.Register.CRACKABLES.get().getValues().stream().toList();
			ExtraItemUsesMaps.CRACKABLES.put(crackablesBlockMaps.get(i).getBlockMap().input().getBlock(), crackablesBlockMaps.get(i).getBlockMap().output().getBlock());
		}

		for (int i = 0; i < BlockMap.Register.GRINDABLES.get().getValues().size(); i++) {
			List<GrindablesBlockMap> grindablesBlockMaps = BlockMap.Register.GRINDABLES.get().getValues().stream().toList();
			ExtraItemUsesMaps.GRINDABLES.put(grindablesBlockMaps.get(i).getBlockMap().input().getBlock(), grindablesBlockMaps.get(i).getBlockMap().output().getBlock());
		}

		for (int i = 0; i < BlockMap.Register.CHISELABLES.get().getValues().size(); i++) {
			List<ChiselablesBlockMap> chiselablesBlockMaps = BlockMap.Register.CHISELABLES.get().getValues().stream().toList();
			ExtraItemUsesMaps.CHISELABLES.put(chiselablesBlockMaps.get(i).getBlockMap().input().getBlock(), chiselablesBlockMaps.get(i).getBlockMap().output().getBlock());
		}
	}

	@SubscribeEvent
	public static void rightClickFunctions(RightClickBlock event) {
		ItemStack itemStack = event.getItemStack();
		Player player = event.getEntity();
		Level level = event.getLevel();
		BlockPos blockPos = event.getPos();
		BlockState blockState = level.getBlockState(blockPos);
		InteractionHand interactionHand = event.getHand();
		int fireAspect = EnchantmentHelper.getFireAspect(player);

		if (itemStack.getItem() instanceof PickaxeItem) {
			event.setUseBlock(Result.DENY);
			for (ExtraItemUse extraItemUse : ItemUses.EXTRA_PICKAXE_USES) {
				extraItemUse.onRightClick(itemStack, player, level, blockPos, blockState, interactionHand, fireAspect);
			}
		}

		if (itemStack.getItem() instanceof ShovelItem) {
			event.setUseBlock(Result.DENY);
			for (ExtraItemUse extraItemUse : ItemUses.EXTRA_SHOVEL_USES) {
				extraItemUse.onRightClick(itemStack, player, level, blockPos, blockState, interactionHand, fireAspect);
			}

		}

		if (itemStack.is(Items.STICK)) {
			event.setUseBlock(Result.DENY);
			for (ExtraItemUse extraItemUse : ItemUses.EXTRA_STICK_USES) {
				extraItemUse.onRightClick(itemStack, player, level, blockPos, blockState, interactionHand, fireAspect);
			}

		}

		if (fireAspect > 0) {
			event.setUseBlock(Result.DENY);
			if (blockState.getBlock() instanceof AbstractCandleBlock) {
				if (blockState.getValue(BlockStateProperties.LIT) == false) {
					level.playSound(player, blockPos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
					level.setBlock(blockPos, blockState.setValue(BlockStateProperties.LIT, true), 11);

					if (player != null) {
						itemStack.hurtAndBreak(1, player, (toBroadcastTo) -> {
							toBroadcastTo.broadcastBreakEvent(interactionHand);
						});
					}
					player.swing(interactionHand);
				}
			}
		}
	}
}
