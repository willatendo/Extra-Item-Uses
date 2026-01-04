package ca.willatendo.extraitemuses.server.event;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import willatendo.simplelibrary.server.event.registry.FabricDynamicRegistryRegister;

public final class ModEvents {
    public static void commonSetup() {
        BasicEvents.dynamicRegistryEvent(new FabricDynamicRegistryRegister());

        UseBlockCallback.EVENT.register((player, level, interactionHand, blockHitResult) -> BasicEvents.interactAt(player.getItemInHand(interactionHand), player, level, level.getBlockState(blockHitResult.getBlockPos()), blockHitResult.getBlockPos(), blockHitResult.getDirection(), interactionHand));
    }
}
