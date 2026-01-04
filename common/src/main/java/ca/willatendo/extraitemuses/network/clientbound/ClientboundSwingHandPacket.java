package ca.willatendo.extraitemuses.network.clientbound;

import ca.willatendo.extraitemuses.network.EIUPackets;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record ClientboundSwingHandPacket() implements CustomPacketPayload {
    public static final ClientboundSwingHandPacket INSTANCE = new ClientboundSwingHandPacket();
    public static final Type<ClientboundSwingHandPacket> TYPE = new Type<>(EIUPackets.CLIENTBOUND_SWING_HAND);
    public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundSwingHandPacket> STREAM_CODEC = StreamCodec.unit(ClientboundSwingHandPacket.INSTANCE);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
