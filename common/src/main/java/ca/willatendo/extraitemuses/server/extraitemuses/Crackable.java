package ca.willatendo.extraitemuses.server.extraitemuses;

import ca.willatendo.extraitemuses.network.NetworkUtils;
import ca.willatendo.extraitemuses.network.clientbound.ClientboundPlaySoundPacket;
import ca.willatendo.extraitemuses.network.clientbound.ClientboundSwingHandPacket;
import ca.willatendo.extraitemuses.server.item.ToolMaterialAccess;
import ca.willatendo.extraitemuses.server.stats.EIUStats;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.Optional;

public record Crackable(Block fromBlock, Block toBlock, boolean dropLoot, Optional<ItemStack> itemStackDrop, Optional<IntProvider> experienceDrop) implements ExtraItemUse {
    public static final Codec<Crackable> CODEC = RecordCodecBuilder.create(instance -> instance.group(BuiltInRegistries.BLOCK.byNameCodec().fieldOf("from_block").forGetter(Crackable::fromBlock), BuiltInRegistries.BLOCK.byNameCodec().fieldOf("to_block").forGetter(Crackable::toBlock), Codec.BOOL.optionalFieldOf("drop_loot", false).forGetter(Crackable::dropLoot), ItemStack.CODEC.optionalFieldOf("item_stack_drop").forGetter(Crackable::itemStackDrop), IntProvider.codec(0, 10).optionalFieldOf("experience_drop").forGetter(Crackable::experienceDrop)).apply(instance, Crackable::new));

    public Crackable(Block fromBlock, Block toBlock, ItemStack itemStackDrop) {
        this(fromBlock, toBlock, false, Optional.of(itemStackDrop), Optional.empty());
    }

    public Crackable(Block fromBlock, Block toBlock) {
        this(fromBlock, toBlock, false);
    }

    public Crackable(Block fromBlock, Block toBlock, boolean dropLoot) {
        this(fromBlock, toBlock, dropLoot, Optional.empty(), Optional.empty());
    }

    @Override
    public InteractionResult use(ItemStack toolItemStack, Player player, Level level, BlockPos clickedBlockPos, BlockState clickedBlockState, InteractionHand interactionHand, Direction face) {
        boolean hasCorrectLevel = true;
        if (toolItemStack.getItem() instanceof ToolMaterialAccess toolMaterialAccess) {
            hasCorrectLevel = !clickedBlockState.is(toolMaterialAccess.getToolMaterial().incorrectBlocksForDrops());
        }
        if (hasCorrectLevel && clickedBlockState.is(this.fromBlock()) && level instanceof ServerLevel serverLevel && player instanceof ServerPlayer serverPlayer) {
            player.awardStat(EIUStats.BLOCKS_CRUSHED);
            serverLevel.setBlock(clickedBlockPos, this.toBlock().defaultBlockState(), 3);
            BlockPos relativeBlockPos = clickedBlockPos.relative(face, 1);
            if (this.dropLoot()) {
                Block.getDrops(clickedBlockState, serverLevel, relativeBlockPos, null, player, toolItemStack).forEach(dropItemStack -> Block.popResource(level, relativeBlockPos, dropItemStack));
            }
            this.itemStackDrop().ifPresent(dropItemStack -> Block.popResource(level, relativeBlockPos, dropItemStack));
            this.experienceDrop().ifPresent(experience -> {
                int experienceAmount = EnchantmentHelper.processBlockExperience(serverLevel, toolItemStack, experience.sample(level.getRandom()));
                if (experienceAmount > 0) {
                    if (serverLevel.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)) {
                        ExperienceOrb.award(serverLevel, Vec3.atCenterOf(relativeBlockPos), experienceAmount);
                    }
                }
            });
            SoundType blockSoundType = this.toBlock().defaultBlockState().getSoundType();
            NetworkUtils.sendToClient(serverPlayer, new ClientboundPlaySoundPacket(clickedBlockPos, blockSoundType.getBreakSound(), SoundSource.BLOCKS, (blockSoundType.getVolume() + 1.0F) / 2.0F, blockSoundType.getPitch() * 0.8F, false));
            toolItemStack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
            NetworkUtils.sendToClient(serverPlayer, new ClientboundSwingHandPacket());
            return InteractionResult.SUCCESS_SERVER;
        }
        return InteractionResult.PASS;
    }
}
