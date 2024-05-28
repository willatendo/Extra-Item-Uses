package willatendo.extraitemuses.data;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import willatendo.extraitemuses.api.CrackablesProvider;

public class ExtraItemUsesCrackablesProvider extends CrackablesProvider {
    public ExtraItemUsesCrackablesProvider(PackOutput packOutput, String modId) {
        super(packOutput, modId);
    }

    @Override
    public void crackables() {
        this.addCrackable(Blocks.STONE_BRICKS.defaultBlockState(), Blocks.CRACKED_STONE_BRICKS.defaultBlockState());
        this.addCrackable(Blocks.CRACKED_STONE_BRICKS.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState());
        this.addCrackable(Blocks.STONE.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState());
        this.addCrackable(Blocks.DEEPSLATE.defaultBlockState(), Blocks.COBBLED_DEEPSLATE.defaultBlockState());
        this.addCrackable(Blocks.DEEPSLATE_BRICKS.defaultBlockState(), Blocks.CRACKED_DEEPSLATE_BRICKS.defaultBlockState());
        this.addCrackable(Blocks.CRACKED_DEEPSLATE_BRICKS.defaultBlockState(), Blocks.COBBLED_DEEPSLATE.defaultBlockState());
        this.addCrackable(Blocks.DEEPSLATE_TILES.defaultBlockState(), Blocks.CRACKED_DEEPSLATE_TILES.defaultBlockState());
        this.addCrackable(Blocks.CRACKED_DEEPSLATE_TILES.defaultBlockState(), Blocks.COBBLED_DEEPSLATE.defaultBlockState());
        this.addCrackable(Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.CRACKED_NETHER_BRICKS.defaultBlockState());
        this.addCrackable(Blocks.POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS.defaultBlockState());
        this.addCrackable(Blocks.INFESTED_STONE_BRICKS.defaultBlockState(), Blocks.INFESTED_CRACKED_STONE_BRICKS.defaultBlockState());
        this.addCrackable(Blocks.COAL_ORE.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState());
        this.addCrackable(Blocks.DEEPSLATE_COAL_ORE.defaultBlockState(), Blocks.COBBLED_DEEPSLATE.defaultBlockState());
        this.addCrackable(Blocks.IRON_ORE.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState());
        this.addCrackable(Blocks.DEEPSLATE_IRON_ORE.defaultBlockState(), Blocks.COBBLED_DEEPSLATE.defaultBlockState());
        this.addCrackable(Blocks.COPPER_ORE.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState());
        this.addCrackable(Blocks.DEEPSLATE_COPPER_ORE.defaultBlockState(), Blocks.COBBLED_DEEPSLATE.defaultBlockState());
        this.addCrackable(Blocks.GOLD_ORE.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState());
        this.addCrackable(Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState(), Blocks.COBBLED_DEEPSLATE.defaultBlockState());
        this.addCrackable(Blocks.REDSTONE_ORE.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState());
        this.addCrackable(Blocks.DEEPSLATE_REDSTONE_ORE.defaultBlockState(), Blocks.COBBLED_DEEPSLATE.defaultBlockState());
        this.addCrackable(Blocks.EMERALD_ORE.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState());
        this.addCrackable(Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState(), Blocks.COBBLED_DEEPSLATE.defaultBlockState());
        this.addCrackable(Blocks.LAPIS_ORE.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState());
        this.addCrackable(Blocks.DEEPSLATE_LAPIS_ORE.defaultBlockState(), Blocks.COBBLED_DEEPSLATE.defaultBlockState());
        this.addCrackable(Blocks.DIAMOND_ORE.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState());
        this.addCrackable(Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState(), Blocks.COBBLED_DEEPSLATE.defaultBlockState());
        this.addCrackable(Blocks.NETHER_QUARTZ_ORE.defaultBlockState(), Blocks.NETHERRACK.defaultBlockState());
    }
}
