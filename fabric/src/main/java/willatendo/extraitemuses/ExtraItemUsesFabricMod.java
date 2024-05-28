package willatendo.extraitemuses;

import com.mojang.serialization.Codec;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.fabricmc.fabric.api.event.registry.DynamicRegistrySetupCallback;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import willatendo.extraitemuses.server.ExtraItemUsesRegistries;
import willatendo.extraitemuses.server.event.ModSetup;

import java.util.HashMap;
import java.util.Map;

public class ExtraItemUsesFabricMod implements ModInitializer {
    @Override
    public void onInitialize() {
        ExtraItemUsesMod.onInitialize();

        Map<ResourceKey<?>, Codec<?>> saved = new HashMap<>();
        ModSetup.registerDataPackRegistries(saved);
        saved.forEach(((resourceKey, codec) -> {
            DynamicRegistries.registerSynced((ResourceKey) resourceKey, codec);
        }));

        DynamicRegistrySetupCallback.EVENT.register(dynamicRegistrySetupCallback -> {
            RegistryAccess registryAccess = dynamicRegistrySetupCallback.asDynamicRegistryManager();

            dynamicRegistrySetupCallback.registerEntryAdded(ExtraItemUsesRegistries.CHISELABLES, (rawId, id, object) -> {
                ModSetup.addRightClickFunctions(registryAccess, true, false, false);
            });
            dynamicRegistrySetupCallback.registerEntryAdded(ExtraItemUsesRegistries.CRACKABLES, (rawId, id, object) -> {
                ModSetup.addRightClickFunctions(registryAccess, false, true, false);
            });
            dynamicRegistrySetupCallback.registerEntryAdded(ExtraItemUsesRegistries.GRINDABLES, (rawId, id, object) -> {
                ModSetup.addRightClickFunctions(registryAccess, false, false, true);
            });
        });

        UseBlockCallback.EVENT.register(ModSetup::interact);
    }
}
