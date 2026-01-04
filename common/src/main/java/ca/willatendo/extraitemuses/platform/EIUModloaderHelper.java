package ca.willatendo.extraitemuses.platform;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import willatendo.simplelibrary.server.util.SimpleUtils;

public interface EIUModloaderHelper {
    EIUModloaderHelper INSTANCE = SimpleUtils.loadModloaderHelper(EIUModloaderHelper.class);

    void sendToServer(CustomPacketPayload customPacketPayload);

    void sendToClient(ServerPlayer serverPlayer, CustomPacketPayload customPacketPayload);
}
