package ca.willatendo.extraitemuses;

import ca.willatendo.extraitemuses.server.stats.EIUStats;
import willatendo.simplelibrary.server.event.registry.SimpleRegistryRegister;

public final class ExtraItemUsesMod {
    public static void onInitialize(SimpleRegistryRegister simpleRegistryRegister) {
        simpleRegistryRegister.register(EIUStats.STATS);
    }
}
