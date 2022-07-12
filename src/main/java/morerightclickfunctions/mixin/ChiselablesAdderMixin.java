package morerightclickfunctions.mixin;

import java.util.Optional;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import morerightclickfunctions.server.MoreRightClickFunctionsMaps;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(Item.class)
public class ChiselablesAdderMixin {
	@Inject(method = "useOn", at = @At("HEAD"), cancellable = true)
	private void stickUseOn(UseOnContext useOnContext, CallbackInfoReturnable<InteractionResult> cir) {
		if (useOnContext.getItemInHand().getItem() == Items.STICK) {
			Level level = useOnContext.getLevel();
			BlockPos pos = useOnContext.getClickedPos();
			Player player = useOnContext.getPlayer();
			BlockState blockState = level.getBlockState(pos);
			ItemStack itemStack = useOnContext.getItemInHand();
			Optional<BlockState> chiselable = Optional.ofNullable(getChiselables(blockState));
			if (chiselable.isPresent()) {
				level.playSound(player, pos, SoundEvents.STONE_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
				level.setBlockAndUpdate(pos, chiselable.get());
				if (player != null) {
					itemStack.hurtAndBreak(1, player, (toBroadcastTo) -> {
						toBroadcastTo.broadcastBreakEvent(useOnContext.getHand());
					});
				}
				cir.setReturnValue(InteractionResult.sidedSuccess(level.isClientSide));
			} else {
				cir.setReturnValue(InteractionResult.PASS);
			}
		}
	}

	private static BlockState getChiselables(BlockState state) {
		Block block = MoreRightClickFunctionsMaps.CHISELABLES.build().get(state.getBlock());
		return block != null ? block.defaultBlockState() : null;
	}
}
