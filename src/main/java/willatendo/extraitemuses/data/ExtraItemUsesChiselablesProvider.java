package willatendo.extraitemuses.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.world.level.block.Blocks;
import willatendo.extraitemuses.api.ChiselablesProvider;

public class ExtraItemUsesChiselablesProvider extends ChiselablesProvider {
	public ExtraItemUsesChiselablesProvider(FabricDataOutput fabricDataOutput, String modid) {
		super(fabricDataOutput, modid);
	}

	@Override
	public void chiselables() {
		this.addChiselable(Blocks.STONE_BRICKS.defaultBlockState(), Blocks.CHISELED_STONE_BRICKS.defaultBlockState());
		this.addChiselable(Blocks.DEEPSLATE_BRICKS.defaultBlockState(), Blocks.CHISELED_DEEPSLATE.defaultBlockState());
		this.addChiselable(Blocks.NETHER_BRICKS.defaultBlockState(), Blocks.CHISELED_NETHER_BRICKS.defaultBlockState());
		this.addChiselable(Blocks.POLISHED_BLACKSTONE.defaultBlockState(), Blocks.CHISELED_POLISHED_BLACKSTONE.defaultBlockState());
		this.addChiselable(Blocks.QUARTZ_BLOCK.defaultBlockState(), Blocks.CHISELED_QUARTZ_BLOCK.defaultBlockState());
		this.addChiselable(Blocks.RED_SANDSTONE.defaultBlockState(), Blocks.CHISELED_RED_SANDSTONE.defaultBlockState());
		this.addChiselable(Blocks.SANDSTONE.defaultBlockState(), Blocks.CHISELED_SANDSTONE.defaultBlockState());
		this.addChiselable(Blocks.INFESTED_STONE_BRICKS.defaultBlockState(), Blocks.INFESTED_CHISELED_STONE_BRICKS.defaultBlockState());
	}
}
