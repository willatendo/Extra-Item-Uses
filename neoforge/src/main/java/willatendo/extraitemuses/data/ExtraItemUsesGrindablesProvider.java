package willatendo.extraitemuses.data;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import willatendo.extraitemuses.api.GrindablesProvider;

public class ExtraItemUsesGrindablesProvider extends GrindablesProvider {
    public ExtraItemUsesGrindablesProvider(PackOutput packOutput, String modId) {
        super(packOutput, modId);
    }

    @Override
    public void grindables() {
        this.addGrindable(Blocks.COBBLESTONE.defaultBlockState(), Blocks.GRAVEL.defaultBlockState());
        this.addGrindable(Blocks.GRAVEL.defaultBlockState(), Blocks.SAND.defaultBlockState());
    }
}
