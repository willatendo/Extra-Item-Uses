package extraitemuses.server.events;

import extraitemuses.ExtraItemUsesMod;
import extraitemuses.api.ExtraItemUsesRegistries;
import extraitemuses.server.uses.BlockMap.ChiselablesBlockMap;
import extraitemuses.server.uses.BlockMap.CrackablesBlockMap;
import extraitemuses.server.uses.BlockMap.GrindablesBlockMap;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DataPackRegistryEvent;

@EventBusSubscriber(bus = Bus.MOD, modid = ExtraItemUsesMod.ID)
public class ModBusEvents {
	@SubscribeEvent
	public static void dataPackRegistry(DataPackRegistryEvent.NewRegistry event) {
		event.dataPackRegistry(ExtraItemUsesRegistries.CRACKABLES, CrackablesBlockMap.CODEC);
		event.dataPackRegistry(ExtraItemUsesRegistries.GRINDABLES, GrindablesBlockMap.CODEC);
		event.dataPackRegistry(ExtraItemUsesRegistries.CHISELABLES, ChiselablesBlockMap.CODEC);
	}
}
