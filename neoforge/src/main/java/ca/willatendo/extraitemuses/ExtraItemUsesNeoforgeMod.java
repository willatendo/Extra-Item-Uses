package ca.willatendo.extraitemuses;

import ca.willatendo.extraitemuses.server.utils.EIUUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import willatendo.simplelibrary.server.event.registry.NeoforgeSimpleRegistryRegister;

@Mod(EIUUtils.ID)
public final class ExtraItemUsesNeoforgeMod {
    public ExtraItemUsesNeoforgeMod(IEventBus iEventBus) {
        ExtraItemUsesMod.onInitialize(new NeoforgeSimpleRegistryRegister(iEventBus));
    }
}
