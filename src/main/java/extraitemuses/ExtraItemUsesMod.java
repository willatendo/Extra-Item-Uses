package extraitemuses;

import extraitemuses.server.ExtraItemUsesRegistry;
import extraitemuses.server.impl.ExtraItemUses;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ExtraItemUsesMod.ID)
public class ExtraItemUsesMod {
	public static final String ID = "extraitemuses";

	public ExtraItemUsesMod() {
		IEventBus iEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ExtraItemUsesRegistry.DEFERRED_CRACKABLES.register(iEventBus);
		ExtraItemUsesRegistry.DEFERRED_GRINDABLES.register(iEventBus);
		ExtraItemUsesRegistry.DEFERRED_CHISELABLES.register(iEventBus);

		ExtraItemUses.load();
	}

	public static ResourceLocation resource(String path) {
		return new ResourceLocation(ID, path);
	}
}
