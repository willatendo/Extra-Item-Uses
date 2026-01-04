package ca.willatendo.extraitemuses.data;

import ca.willatendo.extraitemuses.api.data.ChiselablesProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;

public final class EIUChiselablesProvider extends ChiselablesProvider {
    public EIUChiselablesProvider(PackOutput packOutput, String modId) {
        super(packOutput, modId);
    }

    @Override
    protected void getAll() {
        this.add(Blocks.COPPER_BLOCK, Blocks.CHISELED_COPPER);
        this.add(Blocks.EXPOSED_COPPER, Blocks.EXPOSED_CHISELED_COPPER);
        this.add(Blocks.WEATHERED_COPPER, Blocks.WEATHERED_CHISELED_COPPER);
        this.add(Blocks.OXIDIZED_COPPER, Blocks.OXIDIZED_CHISELED_COPPER);
        this.add(Blocks.WAXED_COPPER_BLOCK, Blocks.WAXED_CHISELED_COPPER);
        this.add(Blocks.WAXED_EXPOSED_COPPER, Blocks.WAXED_EXPOSED_CHISELED_COPPER);
        this.add(Blocks.WAXED_WEATHERED_COPPER, Blocks.WAXED_WEATHERED_CHISELED_COPPER);
        this.add(Blocks.WAXED_OXIDIZED_COPPER, Blocks.WAXED_OXIDIZED_CHISELED_COPPER);
        this.add(Blocks.DEEPSLATE_BRICKS, Blocks.CHISELED_DEEPSLATE);
        this.add(Blocks.INFESTED_STONE_BRICKS, Blocks.INFESTED_CHISELED_STONE_BRICKS);
        this.add(Blocks.NETHER_BRICKS, Blocks.CHISELED_NETHER_BRICKS);
        this.add(Blocks.QUARTZ_BLOCK, Blocks.CHISELED_QUARTZ_BLOCK);
        this.add(Blocks.RED_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE);
        this.add(Blocks.RESIN_BRICKS, Blocks.CHISELED_RESIN_BRICKS);
        this.add(Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE);
        this.add(Blocks.STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS);
        this.add(Blocks.TUFF, Blocks.CHISELED_TUFF);
        this.add(Blocks.TUFF_BRICKS, Blocks.CHISELED_TUFF_BRICKS);
    }
}
