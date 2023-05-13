package extraitemuses.data;

import extraitemuses.api.CrackablesProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;

public class ExtraItemUsesCrackablesProvider extends CrackablesProvider {
	public ExtraItemUsesCrackablesProvider(PackOutput packOutput, String modid) {
		super(packOutput, modid);
	}

	@Override
	public void crackables() {
		this.addCrackable(Blocks.WHITE_WOOL.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState());
	}
}
