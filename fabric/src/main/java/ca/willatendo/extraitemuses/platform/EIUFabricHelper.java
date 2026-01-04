package ca.willatendo.extraitemuses.platform;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;

public final class EIUFabricHelper implements EIUModloaderHelper {
    @Override
    public void sendToServer(CustomPacketPayload customPacketPayload) {
        ClientPlayNetworking.send(customPacketPayload);
    }

    @Override
    public void sendToClient(ServerPlayer serverPlayer, CustomPacketPayload customPacketPayload) {
        ServerPlayNetworking.send(serverPlayer, customPacketPayload);
    }
}
