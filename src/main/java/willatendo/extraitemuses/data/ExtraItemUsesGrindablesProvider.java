package willatendo.extraitemuses.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.world.level.block.Blocks;
import willatendo.extraitemuses.api.GrindablesProvider;

public class ExtraItemUsesGrindablesProvider extends GrindablesProvider {
	public ExtraItemUsesGrindablesProvider(FabricDataOutput fabricDataOutput, String modid) {
		super(fabricDataOutput, modid);
	}

	@Override
	public void grindables() {
		this.addGrindable(Blocks.COBBLESTONE.defaultBlockState(), Blocks.GRAVEL.defaultBlockState());
		this.addGrindable(Blocks.GRAVEL.defaultBlockState(), Blocks.SAND.defaultBlockState());
	}
}
