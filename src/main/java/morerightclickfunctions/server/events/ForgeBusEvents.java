package morerightclickfunctions.server.events;

import java.util.Optional;

import morerightclickfunctions.MoreRightClickFunctionsMod;
import morerightclickfunctions.server.MoreRightClickFunctionsMaps;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.AbstractCandleBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.FORGE, modid = MoreRightClickFunctionsMod.ID)
public class ForgeBusEvents {
	@SubscribeEvent
	public static void addRightClickFunctions(RightClickBlock event) {
		var itemInHand = event.getItemStack();
		var player = event.getPlayer();
		var level = event.getWorld();
		var pos = event.getPos();
		var blockstate = level.getBlockState(pos);
		var hand = event.getHand();
		int fireAspect = EnchantmentHelper.getFireAspect(player);

		if (itemInHand.getItem() instanceof PickaxeItem) {
			Optional<BlockState> crack = Optional.ofNullable(getCracked(blockstate));
			if (crack.isPresent()) {
				level.playSound(player, pos, SoundEvents.STONE_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
				level.setBlockAndUpdate(pos, crack.get());
				if (player != null) {
					itemInHand.hurtAndBreak(1, player, (toBroadcastTo) -> {
						toBroadcastTo.broadcastBreakEvent(hand);
					});
				}
				player.swing(hand);
				event.setUseBlock(Result.DENY);
			}
		}

		if (itemInHand.getItem() instanceof ShovelItem) {
			Optional<BlockState> grind = Optional.ofNullable(getGrindables(blockstate));
			if (grind.isPresent()) {
				level.playSound(player, pos, SoundEvents.SAND_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
				level.setBlockAndUpdate(pos, grind.get());
				if (player != null) {
					itemInHand.hurtAndBreak(1, player, (toBroadcastTo) -> {
						toBroadcastTo.broadcastBreakEvent(hand);
					});
				}
				player.swing(hand);
				event.setUseBlock(Result.DENY);
			}
		}

		if (itemInHand.is(Items.STICK)) {
			Optional<BlockState> chisel = Optional.ofNullable(getChiseled(blockstate));
			if (chisel.isPresent()) {
				level.playSound(player, pos, SoundEvents.STONE_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
				level.setBlockAndUpdate(pos, chisel.get());
				if (player != null) {
					itemInHand.hurtAndBreak(1, player, (toBroadcastTo) -> {
						toBroadcastTo.broadcastBreakEvent(hand);
					});
				}
				player.swing(hand);
				event.setUseBlock(Result.DENY);
			}
		}

		if (fireAspect > 0) {
			event.setUseBlock(Result.DENY);
			if (blockstate.getBlock() instanceof AbstractCandleBlock) {
				if (blockstate.getValue(BlockStateProperties.LIT) == false) {
					level.playSound(player, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
					level.setBlock(pos, blockstate.setValue(BlockStateProperties.LIT, true), 11);

					if (player != null) {
						itemInHand.hurtAndBreak(1, player, (toBroadcastTo) -> {
							toBroadcastTo.broadcastBreakEvent(hand);
						});
					}
					player.swing(hand);
				}
			}
		}
	}

	private static BlockState getCracked(BlockState state) {
		Block block = MoreRightClickFunctionsMaps.CRACKABLES.build().get(state.getBlock());
		return block != null ? block.defaultBlockState() : null;
	}

	private static BlockState getGrindables(BlockState state) {
		Block block = MoreRightClickFunctionsMaps.GRINDABLES.build().get(state.getBlock());
		return block != null ? block.defaultBlockState() : null;
	}

	private static BlockState getChiseled(BlockState state) {
		Block block = MoreRightClickFunctionsMaps.CHISELABLES.build().get(state.getBlock());
		return block != null ? block.defaultBlockState() : null;
	}
}
