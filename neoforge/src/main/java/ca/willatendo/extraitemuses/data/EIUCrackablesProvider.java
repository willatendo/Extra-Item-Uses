package ca.willatendo.extraitemuses.data;

import ca.willatendo.extraitemuses.api.data.CrackablesProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;

public final class EIUCrackablesProvider extends CrackablesProvider {
    public EIUCrackablesProvider(PackOutput packOutput, String modId) {
        super(packOutput, modId);
    }

    @Override
    protected void getAll() {
        this.add(Blocks.CRACKED_DEEPSLATE_BRICKS, Blocks.COBBLED_DEEPSLATE);
        this.add(Blocks.CRACKED_DEEPSLATE_TILES, Blocks.COBBLED_DEEPSLATE);
        this.add(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, Blocks.BLACKSTONE);
        this.add(Blocks.CRACKED_STONE_BRICKS, Blocks.COBBLESTONE);
        this.add(Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS);
        this.add(Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES);
        this.add(Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE);
        this.add(Blocks.INFESTED_STONE_BRICKS, Blocks.INFESTED_CRACKED_STONE_BRICKS);
        this.add(Blocks.NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS);
        this.add(Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
        this.add(Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS);
        this.add(Blocks.STONE, Blocks.COBBLESTONE);

        this.addWithLoot(Blocks.COAL_ORE, Blocks.COBBLESTONE, UniformInt.of(0, 2));
        this.addWithLoot(Blocks.DEEPSLATE_COAL_ORE, Blocks.COBBLED_DEEPSLATE, UniformInt.of(0, 2));
        this.addWithLoot(Blocks.COPPER_ORE, Blocks.COBBLESTONE);
        this.addWithLoot(Blocks.DEEPSLATE_COPPER_ORE, Blocks.COBBLED_DEEPSLATE);
        this.addWithLoot(Blocks.DIAMOND_ORE, Blocks.COBBLESTONE, UniformInt.of(3, 7));
        this.addWithLoot(Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.COBBLED_DEEPSLATE, UniformInt.of(3, 7));
        this.addWithLoot(Blocks.EMERALD_ORE, Blocks.COBBLESTONE);
        this.addWithLoot(Blocks.DEEPSLATE_EMERALD_ORE, Blocks.COBBLED_DEEPSLATE);
        this.addWithLoot(Blocks.GOLD_ORE, Blocks.COBBLESTONE);
        this.addWithLoot(Blocks.DEEPSLATE_GOLD_ORE, Blocks.COBBLED_DEEPSLATE);
        this.addWithLoot(Blocks.NETHER_GOLD_ORE, Blocks.NETHERRACK, UniformInt.of(0, 1));
        this.addWithLoot(Blocks.IRON_ORE, Blocks.COBBLESTONE);
        this.addWithLoot(Blocks.DEEPSLATE_IRON_ORE, Blocks.COBBLED_DEEPSLATE);
        this.addWithLoot(Blocks.LAPIS_ORE, Blocks.COBBLESTONE, UniformInt.of(2, 5));
        this.addWithLoot(Blocks.DEEPSLATE_LAPIS_ORE, Blocks.COBBLED_DEEPSLATE, UniformInt.of(2, 5));
        this.addWithLoot(Blocks.NETHER_QUARTZ_ORE, Blocks.NETHERRACK, UniformInt.of(2, 5));
        this.addWithLoot(Blocks.REDSTONE_ORE, Blocks.COBBLESTONE, UniformInt.of(1, 5));
        this.addWithLoot(Blocks.DEEPSLATE_REDSTONE_ORE, Blocks.COBBLED_DEEPSLATE, UniformInt.of(1, 5));
    }
}
