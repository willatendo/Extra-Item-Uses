package extraitemuses.server.impl;

import java.util.Optional;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

import extraitemuses.api.ExtraItemUse;
import extraitemuses.api.ItemUses;
import extraitemuses.server.block.ExtraItemUsesBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class ExtraItemUses {
	public static Builder<BlockState, BlockState> crackables = ImmutableMap.builder();
	public static Builder<BlockState, BlockState> grinding = ImmutableMap.builder();
	public static Builder<BlockState, BlockState> chiseling = ImmutableMap.builder();

	public static void load() {
		ItemUses.EXTRA_PICKAXE_USES.add(PickaxeCrackingItemUse.INSTANCE);
		ItemUses.EXTRA_PICKAXE_USES.add(PickaxeOreItemUse.INSTANCE);
		ItemUses.EXTRA_SHOVEL_USES.add(ShovelGrindingItemUse.INSTANCE);
		ItemUses.EXTRA_STICK_USES.add(StickChiselingItemUse.INSTANCE);
	}

	public static class PickaxeCrackingItemUse implements ExtraItemUse {
		public static final PickaxeCrackingItemUse INSTANCE = new PickaxeCrackingItemUse();

		@Override
		public void onRightClick(ItemStack itemStack, Player player, Level level, BlockPos blockPos, BlockState blockState, InteractionHand interactionHand, int fireAspectLevel) {
			Optional<BlockState> crack = Optional.ofNullable(getCracked(blockState));
			if (crack.isPresent()) {
				level.playSound(player, blockPos, SoundEvents.STONE_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
				level.setBlockAndUpdate(blockPos, crack.get());
				if (player != null) {
					itemStack.hurtAndBreak(1, player, (toBroadcastTo) -> {
						toBroadcastTo.broadcastBreakEvent(interactionHand);
					});
				}
				player.swing(interactionHand);
			}
		}

		public static BlockState getCracked(BlockState blockState) {
			if (ExtraItemUses.crackables == null) {
				BlockState cracked = ExtraItemUses.crackables.build().get(blockState.getBlock());
				return cracked != null ? cracked : null;
			} else {
				return null;
			}
		}
	}

	public static class PickaxeOreItemUse implements ExtraItemUse {
		public static final PickaxeOreItemUse INSTANCE = new PickaxeOreItemUse();

		@Override
		public void onRightClick(ItemStack itemStack, Player player, Level level, BlockPos blockPos, BlockState blockState, InteractionHand interactionHand, int fireAspectLevel) {
			if (blockState.is(ExtraItemUsesBlockTags.COAL_POPPABLES)) {
				ItemEntity drop = EntityType.ITEM.create(level);
				drop.moveTo(blockPos, 1.0F, 1.0F);
				drop.setItem(Items.COAL.getDefaultInstance());
				level.addFreshEntity(drop);
			}
			if (blockState.is(ExtraItemUsesBlockTags.RAW_IRON_POPPABLES)) {
				ItemEntity drop = EntityType.ITEM.create(level);
				drop.moveTo(blockPos, 1.0F, 1.0F);
				drop.setItem(Items.RAW_IRON.getDefaultInstance());
				level.addFreshEntity(drop);
			}
			if (blockState.is(ExtraItemUsesBlockTags.RAW_COPPER_POPPABLES)) {
				ItemEntity drop = EntityType.ITEM.create(level);
				drop.moveTo(blockPos, 1.0F, 1.0F);
				drop.setItem(Items.RAW_COPPER.getDefaultInstance());
				level.addFreshEntity(drop);
			}
			if (blockState.is(ExtraItemUsesBlockTags.RAW_GOLD_POPPABLES)) {
				ItemEntity drop = EntityType.ITEM.create(level);
				drop.moveTo(blockPos, 1.0F, 1.0F);
				drop.setItem(Items.RAW_GOLD.getDefaultInstance());
				level.addFreshEntity(drop);
			}
			if (blockState.is(ExtraItemUsesBlockTags.REDSTONE_POPPABLES)) {
				ItemEntity drop = EntityType.ITEM.create(level);
				drop.moveTo(blockPos, 1.0F, 1.0F);
				drop.setItem(Items.REDSTONE.getDefaultInstance());
				level.addFreshEntity(drop);
			}
			if (blockState.is(ExtraItemUsesBlockTags.EMERALD_POPPABLES)) {
				ItemEntity drop = EntityType.ITEM.create(level);
				drop.moveTo(blockPos, 1.0F, 1.0F);
				drop.setItem(Items.EMERALD.getDefaultInstance());
				level.addFreshEntity(drop);
			}
			if (blockState.is(ExtraItemUsesBlockTags.LAPIS_POPPABLES)) {
				ItemEntity drop = EntityType.ITEM.create(level);
				drop.moveTo(blockPos, 1.0F, 1.0F);
				drop.setItem(Items.LAPIS_LAZULI.getDefaultInstance());
				level.addFreshEntity(drop);
			}
			if (blockState.is(ExtraItemUsesBlockTags.DIAMOND_POPPABLES)) {
				ItemEntity drop = EntityType.ITEM.create(level);
				drop.moveTo(blockPos, 1.0F, 1.0F);
				drop.setItem(Items.DIAMOND.getDefaultInstance());
				level.addFreshEntity(drop);
			}
			if (blockState.is(ExtraItemUsesBlockTags.QUARTZ_POPPABLES)) {
				ItemEntity drop = EntityType.ITEM.create(level);
				drop.moveTo(blockPos, 1.0F, 1.0F);
				drop.setItem(Items.QUARTZ.getDefaultInstance());
				level.addFreshEntity(drop);
			}
		}
	}

	public static class ShovelGrindingItemUse implements ExtraItemUse {
		public static final ShovelGrindingItemUse INSTANCE = new ShovelGrindingItemUse();

		@Override
		public void onRightClick(ItemStack itemStack, Player player, Level level, BlockPos blockPos, BlockState blockState, InteractionHand interactionHand, int fireAspectLevel) {
			Optional<BlockState> grind = Optional.ofNullable(getGrindables(blockState));
			if (grind.isPresent()) {
				level.playSound(player, blockPos, SoundEvents.SAND_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
				level.setBlockAndUpdate(blockPos, grind.get());
				if (player != null) {
					itemStack.hurtAndBreak(1, player, (toBroadcastTo) -> {
						toBroadcastTo.broadcastBreakEvent(interactionHand);
					});
				}
				player.swing(interactionHand);
			}
		}

		public static BlockState getGrindables(BlockState blockState) {
			if (ExtraItemUses.grinding == null) {
				BlockState grinded = ExtraItemUses.grinding.build().get(blockState.getBlock());
				return grinded != null ? grinded : null;
			} else {
				return null;
			}
		}
	}

	public static class StickChiselingItemUse implements ExtraItemUse {
		public static final StickChiselingItemUse INSTANCE = new StickChiselingItemUse();

		@Override
		public void onRightClick(ItemStack itemStack, Player player, Level level, BlockPos blockPos, BlockState blockState, InteractionHand interactionHand, int fireAspectLevel) {
			Optional<BlockState> chisel = Optional.ofNullable(getChiseled(blockState));
			if (chisel.isPresent()) {
				level.playSound(player, blockPos, SoundEvents.STONE_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
				level.setBlockAndUpdate(blockPos, chisel.get());
				if (player != null) {
					itemStack.hurtAndBreak(1, player, (toBroadcastTo) -> {
						toBroadcastTo.broadcastBreakEvent(interactionHand);
					});
				}
				player.swing(interactionHand);
			}
		}

		public static BlockState getChiseled(BlockState blockState) {
			if (ExtraItemUses.chiseling == null) {
				BlockState chiseled = ExtraItemUses.chiseling.build().get(blockState.getBlock());
				return chiseled != null ? chiseled : null;
			} else {
				return null;
			}
		}
	}
}
