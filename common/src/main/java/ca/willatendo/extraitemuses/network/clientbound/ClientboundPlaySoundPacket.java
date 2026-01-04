package ca.willatendo.extraitemuses.network.clientbound;

import ca.willatendo.extraitemuses.network.EIUPackets;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;

public record ClientboundPlaySoundPacket(BlockPos blockPos, Holder<SoundEvent> soundEventHolder, String soundSource, float pitch, float volume, boolean distanceDelay) implements CustomPacketPayload {
    public static final Type<ClientboundPlaySoundPacket> TYPE = new Type<>(EIUPackets.CLIENTBOUND_PLAY_SOUND);
    public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundPlaySoundPacket> STREAM_CODEC = StreamCodec.composite(BlockPos.STREAM_CODEC, ClientboundPlaySoundPacket::blockPos, ByteBufCodecs.holderRegistry(Registries.SOUND_EVENT), ClientboundPlaySoundPacket::soundEventHolder, ByteBufCodecs.STRING_UTF8, ClientboundPlaySoundPacket::soundSource, ByteBufCodecs.FLOAT, ClientboundPlaySoundPacket::pitch, ByteBufCodecs.FLOAT, ClientboundPlaySoundPacket::volume, ByteBufCodecs.BOOL, ClientboundPlaySoundPacket::distanceDelay, ClientboundPlaySoundPacket::new);

    public ClientboundPlaySoundPacket(BlockPos blockPos, SoundEvent soundEventHolder, SoundSource soundSource, float pitch, float volume, boolean distanceDelay) {
        this(blockPos, BuiltInRegistries.SOUND_EVENT.getOrThrow(BuiltInRegistries.SOUND_EVENT.getResourceKey(soundEventHolder).get()), soundSource.toString(), pitch, volume, distanceDelay);
    }

    public SoundSource getSoundSource() {
        return SoundSource.valueOf(this.soundSource());
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
