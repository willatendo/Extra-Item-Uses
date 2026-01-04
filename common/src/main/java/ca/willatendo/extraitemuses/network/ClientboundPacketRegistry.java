package ca.willatendo.extraitemuses.network;

import ca.willatendo.extraitemuses.network.clientbound.ClientboundPackets;
import ca.willatendo.extraitemuses.network.clientbound.ClientboundPlaySoundPacket;
import ca.willatendo.extraitemuses.network.clientbound.ClientboundSwingHandPacket;
import willatendo.simplelibrary.client.event.registry.ClientboundPacketRegister;

public final class ClientboundPacketRegistry {
    public static void clientboundPacketSetup(ClientboundPacketRegister clientboundPacketRegister) {
        clientboundPacketRegister.registerClientbound(ClientboundPlaySoundPacket.TYPE, ClientboundPlaySoundPacket.STREAM_CODEC, ClientboundPackets::clientboundPlaySound);
        clientboundPacketRegister.registerClientbound(ClientboundSwingHandPacket.TYPE, ClientboundSwingHandPacket.STREAM_CODEC, ClientboundPackets::clientboundSwingHand);
    }
}
