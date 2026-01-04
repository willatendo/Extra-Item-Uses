package ca.willatendo.extraitemuses.server.event;

import ca.willatendo.extraitemuses.server.extraitemuses.Chiselable;
import ca.willatendo.extraitemuses.server.extraitemuses.Crackable;
import ca.willatendo.extraitemuses.server.extraitemuses.Grindable;
import ca.willatendo.extraitemuses.server.registry.EIURegistries;
import ca.willatendo.extraitemuses.server.tags.EIUItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.simplelibrary.server.event.registry.DynamicRegistryRegister;

public final class BasicEvents {
    public static InteractionResult interactAt(ItemStack toolItemStack, Player player, Level level, BlockState clickedBlockState, BlockPos clickedBlockPos, Direction face, InteractionHand interactionHand) {
        if (toolItemStack.is(EIUItemTags.CRACKING_ITEM)) {
            for (Crackable crackable : level.registryAccess().lookupOrThrow(EIURegistries.CRACKABLES)) {
                if (clickedBlockState.is(crackable.fromBlock())) {
                    return crackable.use(toolItemStack, player, level, clickedBlockPos, clickedBlockState, interactionHand, face);
                }
            }
        }
        if (toolItemStack.is(EIUItemTags.GRINDING_ITEM)) {
            for (Grindable grindable : level.registryAccess().lookupOrThrow(EIURegistries.GRINDABLES)) {
                if (clickedBlockState.is(grindable.fromBlock())) {
                    return grindable.use(toolItemStack, player, level, clickedBlockPos, clickedBlockState, interactionHand, face);
                }
            }
        }
        if (toolItemStack.is(EIUItemTags.CHISELING_ITEM)) {
            for (Chiselable chiselable : level.registryAccess().lookupOrThrow(EIURegistries.CHISELABLES)) {
                if (clickedBlockState.is(chiselable.fromBlock())) {
                    return chiselable.use(toolItemStack, player, level, clickedBlockPos, clickedBlockState, interactionHand, face);
                }
            }
        }

        return InteractionResult.PASS;
    }

    public static void dynamicRegistryEvent(DynamicRegistryRegister dynamicRegistryRegister) {
        dynamicRegistryRegister.register(EIURegistries.CHISELABLES, Chiselable.CODEC);
        dynamicRegistryRegister.register(EIURegistries.CRACKABLES, Crackable.CODEC);
        dynamicRegistryRegister.register(EIURegistries.GRINDABLES, Grindable.CODEC);
    }
}
