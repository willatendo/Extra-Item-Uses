package willatendo.extraitemuses;

import net.minecraftforge.fml.common.Mod;
import willatendo.extraitemuses.server.util.ExtraItemUsesUtils;

@Mod(ExtraItemUsesUtils.ID)
public class ExtraItemUsesForgeMod {
    public ExtraItemUsesForgeMod() {
        ExtraItemUsesMod.onInitialize();
    }
}
