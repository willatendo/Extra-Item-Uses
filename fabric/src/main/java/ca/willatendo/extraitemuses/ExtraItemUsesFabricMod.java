package ca.willatendo.extraitemuses;

import ca.willatendo.extraitemuses.server.event.ModEvents;
import net.fabricmc.api.ModInitializer;
import willatendo.simplelibrary.server.event.registry.FabricSimpleRegistryRegister;

public final class ExtraItemUsesFabricMod implements ModInitializer {
    @Override
    public void onInitialize() {
        ExtraItemUsesMod.onInitialize(new FabricSimpleRegistryRegister());

        ModEvents.commonSetup();
    }
}
