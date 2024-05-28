package willatendo.extraitemuses;

import willatendo.extraitemuses.server.impl.ExtraItemUses;

public class ExtraItemUsesMod {
    public static void onInitialize() {
        ExtraItemUses.load();
    }
}
