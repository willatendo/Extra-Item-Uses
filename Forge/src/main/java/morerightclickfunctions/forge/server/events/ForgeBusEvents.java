package morerightclickfunctions.forge.server.events;

import morerightclickfunctions.MoreRightClickFunctionsMod;
import morerightclickfunctions.server.MoreRightClickFunctionsMaps;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.AbstractCandleBlock;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Optional;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = MoreRightClickFunctionsMod.ID)
public class ForgeBusEvents {
    @SubscribeEvent
    public static void addRightClickFunctions(RightClickBlock event) {
        var itemInHand = event.getItemStack();
        var player = event.getEntity();
        var level = event.getLevel();
        var pos = event.getPos();
        var blockstate = level.getBlockState(pos);
        var hand = event.getHand();
        int fireAspect = EnchantmentHelper.getFireAspect(player);

        if (itemInHand.getItem() instanceof PickaxeItem) {
            event.setUseBlock(Result.DENY);
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
            event.setUseBlock(Result.DENY);
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

        if (itemInHand.getItem() instanceof HoeItem) {
            event.setUseBlock(Result.DENY);
            Optional<Item> reapables = Optional.ofNullable(getReapables(blockstate));
            if (reapables.isPresent()) {
                if (level.getBlockState(pos).getBlock() instanceof CropBlock cropBlock) {
                    if (cropBlock.isMaxAge(level.getBlockState(pos))) {
                        level.playSound(player, pos, SoundEvents.GRASS_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
                        level.setBlockAndUpdate(pos, level.getBlockState(pos).setValue(cropBlock instanceof BeetrootBlock ? BeetrootBlock.AGE : CropBlock.AGE, 0));
                        for (int i = 0; i < RandomSource.create().nextInt(2) + 1; i++) {
                            Block.popResource(level, pos, reapables.get().getDefaultInstance());
                        }
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

        if (itemInHand.is(Items.STICK)) {
            event.setUseBlock(Result.DENY);
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

    private static Item getReapables(BlockState state) {
        return MoreRightClickFunctionsMaps.REAPABLES.build().get(state.getBlock());
    }
}
