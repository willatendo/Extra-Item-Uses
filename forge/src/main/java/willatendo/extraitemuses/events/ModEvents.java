package willatendo.extraitemuses.events;

import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DataPackRegistryEvent;
import willatendo.extraitemuses.server.event.ModSetup;
import willatendo.extraitemuses.server.util.ExtraItemUsesUtils;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = ExtraItemUsesUtils.ID)
public class ModEvents {
    @SubscribeEvent
    public static void registerDataPackRegistries(DataPackRegistryEvent.NewRegistry event) {
        Map<ResourceKey<?>, Codec<?>> saved = new HashMap<>();
        ModSetup.registerDataPackRegistries(saved);
        saved.forEach(((resourceKey, codec) -> {
            event.dataPackRegistry((ResourceKey) resourceKey, codec);
        }));
    }
}
