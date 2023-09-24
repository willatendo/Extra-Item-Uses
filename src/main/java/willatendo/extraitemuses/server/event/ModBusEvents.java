package willatendo.extraitemuses.server.event;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DataPackRegistryEvent;
import willatendo.extraitemuses.server.ExtraItemUsesRegistries;
import willatendo.extraitemuses.server.uses.ChiselablesBlockMap;
import willatendo.extraitemuses.server.uses.CrackablesBlockMap;
import willatendo.extraitemuses.server.uses.GrindablesBlockMap;
import willatendo.extraitemuses.server.util.ExtraItemUsesUtils;

@EventBusSubscriber(bus = Bus.MOD, modid = ExtraItemUsesUtils.ID)
public class ModBusEvents {
	@SubscribeEvent
	public static void dataPackRegistry(DataPackRegistryEvent.NewRegistry event) {
		event.dataPackRegistry(ExtraItemUsesRegistries.CRACKABLES, CrackablesBlockMap.CODEC);
		event.dataPackRegistry(ExtraItemUsesRegistries.GRINDABLES, GrindablesBlockMap.CODEC);
		event.dataPackRegistry(ExtraItemUsesRegistries.CHISELABLES, ChiselablesBlockMap.CODEC);
	}
}
