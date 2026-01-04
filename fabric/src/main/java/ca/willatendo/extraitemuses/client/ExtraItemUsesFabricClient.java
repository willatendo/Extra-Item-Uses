package ca.willatendo.extraitemuses.client;

import ca.willatendo.extraitemuses.network.ClientboundPacketRegistry;
import net.fabricmc.api.ClientModInitializer;
import willatendo.simplelibrary.client.event.registry.FabricClientboundPacketRegister;

public final class ExtraItemUsesFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientboundPacketRegistry.clientboundPacketSetup(new FabricClientboundPacketRegister());
    }
}
