package ca.willatendo.extraitemuses.platform;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;

public final class EIUNeoforgeHelper implements EIUModloaderHelper {
    @Override
    public void sendToServer(CustomPacketPayload customPacketPayload) {
        PacketDistributor.sendToServer(customPacketPayload);
    }

    @Override
    public void sendToClient(ServerPlayer serverPlayer, CustomPacketPayload customPacketPayload) {
        PacketDistributor.sendToPlayer(serverPlayer, customPacketPayload);
    }
}
