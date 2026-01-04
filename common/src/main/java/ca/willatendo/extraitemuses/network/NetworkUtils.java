package ca.willatendo.extraitemuses.network;

import ca.willatendo.extraitemuses.platform.EIUModloaderHelper;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;

public final class NetworkUtils {
    public static void sendToClient(ServerPlayer serverPlayer, CustomPacketPayload customPacketPayload) {
        EIUModloaderHelper.INSTANCE.sendToClient(serverPlayer, customPacketPayload);
    }

    public static void sendToServer(CustomPacketPayload customPacketPayload) {
        EIUModloaderHelper.INSTANCE.sendToServer(customPacketPayload);
    }
}
