package morerightclickfunctions.quilt.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;

@Mixin(SwordItem.class)
public class FireAspectLightsCandleAdderMixin extends TieredItem {
	public FireAspectLightsCandleAdderMixin(Tier tier, int attackDamage, float speed, Properties properties) {
		super(tier, properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext useOnContext) {
		Player player = useOnContext.getPlayer();
		Level level = useOnContext.getLevel();
		BlockPos blockPos = useOnContext.getClickedPos();
		BlockState blockState = level.getBlockState(blockPos);
		if (EnchantmentHelper.getFireAspect(useOnContext.getPlayer()) > 0) {
			if (CandleBlock.canLight(blockState) || CandleCakeBlock.canLight(blockState)) {
				level.playSound(player, blockPos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
				level.setBlock(blockPos, blockState.setValue(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
				level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);
				if (player != null) {
					useOnContext.getItemInHand().hurtAndBreak(1, player, playerx -> playerx.broadcastBreakEvent(useOnContext.getHand()));
				}
			}
		}
		return InteractionResult.sidedSuccess(level.isClientSide());
	}
}
