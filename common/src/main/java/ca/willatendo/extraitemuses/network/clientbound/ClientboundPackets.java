package ca.willatendo.extraitemuses.network.clientbound;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;

public final class ClientboundPackets {
    public static void clientboundPlaySound(ClientboundPlaySoundPacket clientboundPlaySoundPacket, Player player) {
        if (player instanceof LocalPlayer localPlayer) {
            localPlayer.clientLevel.playLocalSound(clientboundPlaySoundPacket.blockPos(), clientboundPlaySoundPacket.soundEventHolder().value(), clientboundPlaySoundPacket.getSoundSource(), clientboundPlaySoundPacket.pitch(), clientboundPlaySoundPacket.volume(), clientboundPlaySoundPacket.distanceDelay());
        }
    }

    public static void clientboundSwingHand(ClientboundSwingHandPacket clientboundSwingHandPacket, Player player) {
        if (player instanceof LocalPlayer localPlayer) {
            localPlayer.swing(InteractionHand.MAIN_HAND);
        }
    }
}
