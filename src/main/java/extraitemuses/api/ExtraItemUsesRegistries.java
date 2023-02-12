package extraitemuses.api;

import extraitemuses.ExtraItemUsesMod;
import extraitemuses.server.uses.CrackablesBlockMap;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public class ExtraItemUsesRegistries {
	public static final ResourceKey<Registry<CrackablesBlockMap>> CRACKABLES = ResourceKey.createRegistryKey(ExtraItemUsesMod.resource("crackables"));
}
