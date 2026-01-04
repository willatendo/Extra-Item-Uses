package ca.willatendo.extraitemuses.server.extraitemuses;

import ca.willatendo.extraitemuses.network.NetworkUtils;
import ca.willatendo.extraitemuses.network.clientbound.ClientboundPlaySoundPacket;
import ca.willatendo.extraitemuses.network.clientbound.ClientboundSwingHandPacket;
import ca.willatendo.extraitemuses.server.stats.EIUStats;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

public record Chiselable(Block fromBlock, Block toBlock) implements ExtraItemUse {
    public static final Codec<Chiselable> CODEC = RecordCodecBuilder.create(instance -> instance.group(BuiltInRegistries.BLOCK.byNameCodec().fieldOf("from_block").forGetter(Chiselable::fromBlock), BuiltInRegistries.BLOCK.byNameCodec().fieldOf("to_block").forGetter(Chiselable::toBlock)).apply(instance, Chiselable::new));

    @Override
    public InteractionResult use(ItemStack toolItemStack, Player player, Level level, BlockPos clickedBlockPos, BlockState clickedBlockState, InteractionHand interactionHand, Direction face) {
        if (clickedBlockState.is(this.fromBlock()) && level instanceof ServerLevel serverLevel && player instanceof ServerPlayer serverPlayer) {
            player.awardStat(EIUStats.BLOCKS_CHISELED);
            serverLevel.setBlock(clickedBlockPos, this.toBlock().defaultBlockState(), 3);
            SoundType blockSoundType = this.toBlock().defaultBlockState().getSoundType();
            NetworkUtils.sendToClient(serverPlayer, new ClientboundPlaySoundPacket(clickedBlockPos, blockSoundType.getBreakSound(), SoundSource.BLOCKS, (blockSoundType.getVolume() + 1.0F) / 2.0F, blockSoundType.getPitch() * 0.8F, false));
            NetworkUtils.sendToClient(serverPlayer, new ClientboundSwingHandPacket());
            return InteractionResult.SUCCESS_SERVER;
        }
        return InteractionResult.PASS;
    }
}
