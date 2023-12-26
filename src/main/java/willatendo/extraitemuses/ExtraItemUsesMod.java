package willatendo.extraitemuses;

import net.fabricmc.api.ModInitializer;
import willatendo.extraitemuses.server.event.ServerEvents;
import willatendo.extraitemuses.server.impl.ExtraItemUses;

public class ExtraItemUsesMod implements ModInitializer {
	@Override
	public void onInitialize() {
		ServerEvents.dataPackRegistry();
		ServerEvents.makeRegistries();
		ServerEvents.addRightClickFunctions();
		ServerEvents.rightClickFunctions();

		ExtraItemUses.load();
	}
}
