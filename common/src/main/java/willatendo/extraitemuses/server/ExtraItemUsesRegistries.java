package willatendo.extraitemuses.server;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.extraitemuses.server.uses.ChiselablesBlockMap;
import willatendo.extraitemuses.server.uses.CrackablesBlockMap;
import willatendo.extraitemuses.server.uses.GrindablesBlockMap;
import willatendo.extraitemuses.server.util.ExtraItemUsesUtils;

public class ExtraItemUsesRegistries {
	public static final ResourceLocation CRACKABLES_ID = ExtraItemUsesUtils.resource("crackables");
	public static final ResourceLocation GRINDABLES_ID = ExtraItemUsesUtils.resource("grindables");
	public static final ResourceLocation CHISELABLES_ID = ExtraItemUsesUtils.resource("chiselables");

	public static final ResourceKey<Registry<CrackablesBlockMap>> CRACKABLES = ResourceKey.createRegistryKey(CRACKABLES_ID);
	public static final ResourceKey<Registry<GrindablesBlockMap>> GRINDABLES = ResourceKey.createRegistryKey(GRINDABLES_ID);
	public static final ResourceKey<Registry<ChiselablesBlockMap>> CHISELABLES = ResourceKey.createRegistryKey(CHISELABLES_ID);
}
