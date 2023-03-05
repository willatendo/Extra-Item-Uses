package extraitemuses.api;

import extraitemuses.ExtraItemUsesMod;
import extraitemuses.server.uses.BlockMap.ChiselablesBlockMap;
import extraitemuses.server.uses.BlockMap.CrackablesBlockMap;
import extraitemuses.server.uses.BlockMap.GrindablesBlockMap;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public class ExtraItemUsesRegistries {
	public static final ResourceKey<Registry<CrackablesBlockMap>> CRACKABLES = ResourceKey.createRegistryKey(ExtraItemUsesMod.resource("crackables"));
	public static final ResourceKey<Registry<GrindablesBlockMap>> GRINDABLES = ResourceKey.createRegistryKey(ExtraItemUsesMod.resource("grindables"));
	public static final ResourceKey<Registry<ChiselablesBlockMap>> CHISELABLES = ResourceKey.createRegistryKey(ExtraItemUsesMod.resource("chiselables"));
}
