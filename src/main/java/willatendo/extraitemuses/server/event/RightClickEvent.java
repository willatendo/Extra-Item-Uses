package willatendo.extraitemuses.server.event;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.phys.BlockHitResult;
import willatendo.extraitemuses.api.ExtraItemUse;
import willatendo.extraitemuses.api.ItemUses;

public class RightClickEvent implements UseBlockCallback {
	@Override
	public InteractionResult interact(Player player, Level level, InteractionHand interactionHand, BlockHitResult blockHitResult) {
		ItemStack itemStack = player.getItemInHand(interactionHand);
		BlockPos blockPos = blockHitResult.getBlockPos();
		BlockState blockState = level.getBlockState(blockPos);
		int fireAspect = EnchantmentHelper.getFireAspect(player);

		if (itemStack.getItem() instanceof PickaxeItem) {
			for (ExtraItemUse extraItemUse : ItemUses.EXTRA_PICKAXE_USES) {
				extraItemUse.onRightClick(itemStack, player, level, blockPos, blockState, interactionHand, fireAspect);
			}
		}

		if (itemStack.getItem() instanceof ShovelItem) {
			for (ExtraItemUse extraItemUse : ItemUses.EXTRA_SHOVEL_USES) {
				extraItemUse.onRightClick(itemStack, player, level, blockPos, blockState, interactionHand, fireAspect);
			}

		}

		if (itemStack.is(Items.STICK)) {
			for (ExtraItemUse extraItemUse : ItemUses.EXTRA_STICK_USES) {
				extraItemUse.onRightClick(itemStack, player, level, blockPos, blockState, interactionHand, fireAspect);
			}

		}

		if (fireAspect > 0) {
			if (blockState.getBlock() instanceof AbstractCandleBlock) {
				if (blockState.getValue(BlockStateProperties.LIT) == false) {
					level.playSound(player, blockPos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
					level.setBlock(blockPos, blockState.setValue(BlockStateProperties.LIT, true), 11);

					if (player != null) {
						itemStack.hurtAndBreak(1, player, (toBroadcastTo) -> {
							toBroadcastTo.broadcastBreakEvent(interactionHand);
						});
					}
					return InteractionResult.sidedSuccess(level.isClientSide());
				}
			}
		}

		return InteractionResult.PASS;
	}
}
