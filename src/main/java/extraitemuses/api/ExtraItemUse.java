package extraitemuses.api;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public interface ExtraItemUse {
	void onRightClick(ItemStack itemStack, Player player, Level level, BlockPos blockPos, BlockState blockState, InteractionHand interactionHand, int fireAspectLevel);
}
