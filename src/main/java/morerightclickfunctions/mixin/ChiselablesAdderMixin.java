package morerightclickfunctions.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.item.Item;

@Mixin(Item.class)
public class ChiselablesAdderMixin {
//	@Inject(method = "useOn", at = @At("HEAD"), cancellable = true)
//	private void stickUseOn(UseOnContext useOnContext, CallbackInfoReturnable<InteractionResult> cir) {
//		if (useOnContext.getItemInHand().getItem() == Items.STICK) {
//			Level level = useOnContext.getLevel();
//			BlockPos pos = useOnContext.getClickedPos();
//			Player player = useOnContext.getPlayer();
//			BlockState blockState = level.getBlockState(pos);
//			ItemStack itemStack = useOnContext.getItemInHand();
//			Optional<BlockState> chiselable = Optional.ofNullable(getChiselables(blockState));
//			if (chiselable.isPresent()) {
//				level.playSound(player, pos, SoundEvents.STONE_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
//				level.setBlockAndUpdate(pos, chiselable.get());
//				if (player != null) {
//					itemStack.hurtAndBreak(1, player, (toBroadcastTo) -> {
//						toBroadcastTo.broadcastBreakEvent(useOnContext.getHand());
//					});
//				}
//				cir.setReturnValue(InteractionResult.sidedSuccess(level.isClientSide));
//			} else {
//				cir.setReturnValue(InteractionResult.PASS);
//			}
//		}
//	}

//	private static BlockState getChiselables(BlockState state) {
//		Block block = MoreRightClickFunctionsMaps.CHISELABLES.build().get(state.getBlock());
//		return block != null ? block.defaultBlockState() : null;
//	}
}
