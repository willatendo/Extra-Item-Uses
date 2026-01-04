package ca.willatendo.extraitemuses.server.registry;

import ca.willatendo.extraitemuses.server.extraitemuses.Chiselable;
import ca.willatendo.extraitemuses.server.extraitemuses.Crackable;
import ca.willatendo.extraitemuses.server.extraitemuses.Grindable;
import ca.willatendo.extraitemuses.server.utils.EIUUtils;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public class EIURegistries {
    public static final ResourceKey<Registry<Chiselable>> CHISELABLES = ResourceKey.createRegistryKey(EIUUtils.resource("chiselables"));
    public static final ResourceKey<Registry<Crackable>> CRACKABLES = ResourceKey.createRegistryKey(EIUUtils.resource("crackables"));
    public static final ResourceKey<Registry<Grindable>> GRINDABLES = ResourceKey.createRegistryKey(EIUUtils.resource("grindables"));
}
