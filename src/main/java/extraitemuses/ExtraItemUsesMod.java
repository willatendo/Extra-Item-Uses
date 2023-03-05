package extraitemuses;

import extraitemuses.api.ExtraItemUsesRegistries;
import extraitemuses.server.impl.ExtraItemUses;
import extraitemuses.server.uses.BlockMap;
import extraitemuses.server.uses.BlockMap.ChiselablesBlockMap;
import extraitemuses.server.uses.BlockMap.CrackablesBlockMap;
import extraitemuses.server.uses.BlockMap.GrindablesBlockMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DataPackRegistryEvent;

@Mod(ExtraItemUsesMod.ID)
public class ExtraItemUsesMod {
	public static final String ID = "extraitemuses";

	public ExtraItemUsesMod() {
		IEventBus iEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		BlockMap.Register.DEFERRED_CRACKABLES.register(iEventBus);
		BlockMap.Register.DEFERRED_GRINDABLES.register(iEventBus);
		BlockMap.Register.DEFERRED_CHISELABLES.register(iEventBus);

		iEventBus.addListener((DataPackRegistryEvent.NewRegistry event) -> {
			event.dataPackRegistry(ExtraItemUsesRegistries.CRACKABLES, CrackablesBlockMap.CODEC);
			event.dataPackRegistry(ExtraItemUsesRegistries.GRINDABLES, GrindablesBlockMap.CODEC);
			event.dataPackRegistry(ExtraItemUsesRegistries.CHISELABLES, ChiselablesBlockMap.CODEC);
		});

		ExtraItemUses.load();
	}

	public static ResourceLocation resource(String path) {
		return new ResourceLocation(ID, path);
	}
}
