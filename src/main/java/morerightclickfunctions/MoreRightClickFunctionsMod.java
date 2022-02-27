package morerightclickfunctions;

import java.util.Map;
import java.util.Optional;

import com.google.common.collect.ImmutableMap.Builder;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod("morerightclickfunctions")
@EventBusSubscriber(bus = Bus.FORGE, modid = "morerightclickfunctions")
public class MoreRightClickFunctionsMod {
	public static final Map<Block, Block> CRACKABLES = (new Builder<Block, Block>()).put(Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS).put(Blocks.CRACKED_STONE_BRICKS, Blocks.COBBLESTONE).put(Blocks.STONE, Blocks.COBBLESTONE).put(Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS).put(Blocks.CRACKED_DEEPSLATE_BRICKS, Blocks.COBBLED_DEEPSLATE).put(Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES).put(Blocks.CRACKED_DEEPSLATE_TILES, Blocks.COBBLED_DEEPSLATE).put(Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE).put(Blocks.NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS).put(Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS).put(Blocks.INFESTED_STONE_BRICKS, Blocks.INFESTED_CRACKED_STONE_BRICKS).build();
	public static final Map<Block, Block> GRINDABLES = (new Builder<Block, Block>()).put(Blocks.COBBLESTONE, Blocks.GRAVEL).put(Blocks.GRAVEL, Blocks.SAND).build();

	@SubscribeEvent
	public static void addRightClickFunctions(RightClickBlock event) {
		var itemInHand = event.getItemStack();
		var player = event.getPlayer();
		var level = event.getWorld();
		var pos = event.getPos();
		var blockstate = level.getBlockState(pos);
		var hand = event.getHand();
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
			}
		}

		// To Do: Fire Aspect Swords lit Candles
//		if (itemInHand.getItem() instanceof SwordItem) {
//			int fireAspect = EnchantmentHelper.getFireAspect(player);
//			if (fireAspect > 0) {
//				if (blockstate.getBlock() instanceof AbstractCandleBlock) {
//					level.playSound(player, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
//					level.setBlockAndUpdate(pos, blockstate.setValue(BlockStateProperties.LIT, true));
//
//					if (player != null) {
//						itemInHand.hurtAndBreak(1, player, (toBroadcastTo) -> {
//							toBroadcastTo.broadcastBreakEvent(hand);
//						});
//					}
//					player.swing(hand);
//				}
//			}
//		}
	}

	private static BlockState getCracked(BlockState state) {
		Block block = CRACKABLES.get(state.getBlock());
		return block != null ? block.defaultBlockState() : null;
	}

	private static BlockState getGrindables(BlockState state) {
		Block block = GRINDABLES.get(state.getBlock());
		return block != null ? block.defaultBlockState() : null;
	}
}
