package willatendo.extraitemuses;

import net.minecraftforge.fml.common.Mod;
import willatendo.extraitemuses.server.impl.ExtraItemUses;
import willatendo.extraitemuses.server.util.ExtraItemUsesUtils;

@Mod(ExtraItemUsesUtils.ID)
public class ExtraItemUsesMod {
	public ExtraItemUsesMod() {
		ExtraItemUses.load();
	}
}
