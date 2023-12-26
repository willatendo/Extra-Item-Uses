package willatendo.extraitemuses.server.event;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.fabricmc.fabric.api.event.registry.DynamicRegistrySetupCallback;
import net.minecraft.core.RegistryAccess;
import willatendo.extraitemuses.server.ExtraItemUsesRegistries;
import willatendo.extraitemuses.server.impl.ExtraItemUses;
import willatendo.extraitemuses.server.uses.ChiselablesBlockMap;
import willatendo.extraitemuses.server.uses.CrackablesBlockMap;
import willatendo.extraitemuses.server.uses.GrindablesBlockMap;

public class ServerEvents {
	public static void makeRegistries() {
//		FabricRegistryBuilder.createSimple(ExtraItemUsesRegistries.CRACKABLES).buildAndRegister();
//		FabricRegistryBuilder.createSimple(ExtraItemUsesRegistries.GRINDABLES).buildAndRegister();
//		FabricRegistryBuilder.createSimple(ExtraItemUsesRegistries.CHISELABLES).buildAndRegister();
	}

	public static void dataPackRegistry() {
		DynamicRegistries.registerSynced(ExtraItemUsesRegistries.CRACKABLES, CrackablesBlockMap.CODEC);
		DynamicRegistries.registerSynced(ExtraItemUsesRegistries.GRINDABLES, GrindablesBlockMap.CODEC);
		DynamicRegistries.registerSynced(ExtraItemUsesRegistries.CHISELABLES, ChiselablesBlockMap.CODEC);
	}

	public static void addRightClickFunctions() {
		DynamicRegistrySetupCallback.EVENT.register(dynamicRegistrySetupCallback -> {
			RegistryAccess registryAccess = dynamicRegistrySetupCallback.asDynamicRegistryManager();

			dynamicRegistrySetupCallback.registerEntryAdded(ExtraItemUsesRegistries.CHISELABLES, (rawId, id, object) -> {
				ExtraItemUses.CHISELABLES.clear();
				for (ChiselablesBlockMap chiselablesBlockMap : registryAccess.registryOrThrow(ExtraItemUsesRegistries.CHISELABLES)) {
					ExtraItemUses.CHISELABLES.put(chiselablesBlockMap.getInputState(), chiselablesBlockMap.getOutputState());
				}
			});

			dynamicRegistrySetupCallback.registerEntryAdded(ExtraItemUsesRegistries.CRACKABLES, (rawId, id, object) -> {
				ExtraItemUses.CRACKABLES.clear();
				for (CrackablesBlockMap crackablesBlockMap : registryAccess.registryOrThrow(ExtraItemUsesRegistries.CRACKABLES)) {
					ExtraItemUses.CRACKABLES.put(crackablesBlockMap.getInputState(), crackablesBlockMap.getOutputState());
				}
			});

			dynamicRegistrySetupCallback.registerEntryAdded(ExtraItemUsesRegistries.GRINDABLES, (rawId, id, object) -> {
				ExtraItemUses.GRINDABLES.clear();
				for (GrindablesBlockMap grindablesBlockMap : registryAccess.registryOrThrow(ExtraItemUsesRegistries.GRINDABLES)) {
					ExtraItemUses.GRINDABLES.put(grindablesBlockMap.getInputState(), grindablesBlockMap.getOutputState());
				}
			});
		});
	}

	public static void rightClickFunctions() {
		UseBlockCallback.EVENT.register(new RightClickEvent());
	}
}
