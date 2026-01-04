package ca.willatendo.extraitemuses.data;

import ca.willatendo.extraitemuses.api.data.GrindablesProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;

public final class EIUGrindablesProvider extends GrindablesProvider {
    public EIUGrindablesProvider(PackOutput packOutput, String modId) {
        super(packOutput, modId);
    }

    @Override
    protected void getAll() {
        this.add(Blocks.COBBLESTONE, Blocks.GRAVEL);
        this.add(Blocks.GRAVEL, Blocks.SAND);
    }
}
