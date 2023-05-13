package extraitemuses.api;

import extraitemuses.ExtraItemUsesMod;
import extraitemuses.server.uses.ChiselablesBlockMap;
import extraitemuses.server.uses.CrackablesBlockMap;
import extraitemuses.server.uses.GrindablesBlockMap;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class ExtraItemUsesRegistries {
	public static final ResourceLocation CRACKABLES_ID = ExtraItemUsesMod.resource("crackables");
	public static final ResourceLocation GRINDABLES_ID = ExtraItemUsesMod.resource("grindables");
	public static final ResourceLocation CHISELABLES_ID = ExtraItemUsesMod.resource("chiselables");

	public static final ResourceKey<Registry<CrackablesBlockMap>> CRACKABLES = ResourceKey.createRegistryKey(CRACKABLES_ID);
	public static final ResourceKey<Registry<GrindablesBlockMap>> GRINDABLES = ResourceKey.createRegistryKey(GRINDABLES_ID);
	public static final ResourceKey<Registry<ChiselablesBlockMap>> CHISELABLES = ResourceKey.createRegistryKey(CHISELABLES_ID);
}
