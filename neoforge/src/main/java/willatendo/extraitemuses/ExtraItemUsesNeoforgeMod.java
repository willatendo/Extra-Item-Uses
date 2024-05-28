package willatendo.extraitemuses;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import willatendo.extraitemuses.server.util.ExtraItemUsesUtils;

@Mod(ExtraItemUsesUtils.ID)
public class ExtraItemUsesNeoforgeMod {
    public ExtraItemUsesNeoforgeMod(IEventBus iEventBus) {
        ExtraItemUsesMod.onInitialize();
    }
}
