package extraitemuses;

import extraitemuses.api.ExtraItemUsesRegistries;
import extraitemuses.server.ExtraItemUsesConfig;
import extraitemuses.server.impl.ExtraItemUses;
import extraitemuses.server.uses.CrackablesBlockMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DataPackRegistryEvent;

@Mod(ExtraItemUsesMod.ID)
public class ExtraItemUsesMod {
	public static final String ID = "extraitemuses";

	public ExtraItemUsesMod() {
		IEventBus iEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ExtraItemUses.load();
		ModLoadingContext.get().registerConfig(Type.COMMON, ExtraItemUsesConfig.commonSpec);
		CrackablesBlockMap.Register.DEFERRED_CRACKABLES.register(iEventBus);
		iEventBus.addListener((DataPackRegistryEvent.NewRegistry event) -> {
			event.dataPackRegistry(ExtraItemUsesRegistries.CRACKABLES, CrackablesBlockMap.CODEC);
		});
	}

	public static ResourceLocation resource(String path) {
		return new ResourceLocation(ID, path);
	}
}
