package extraitemuses.server.events;

import extraitemuses.ExtraItemUsesMod;
import extraitemuses.api.ExtraItemUse;
import extraitemuses.api.ItemUses;
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
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.FORGE, modid = ExtraItemUsesMod.ID)
public class ForgeBusEvents {
	@SubscribeEvent
	public static void addRightClickFunctions(RightClickBlock event) {
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
