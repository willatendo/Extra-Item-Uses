package ca.willatendo.extraitemuses.server.stats;

import ca.willatendo.extraitemuses.server.utils.EIUUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatFormatter;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.HashMap;
import java.util.Map;

public class EIUStats {
    public static final Map<ResourceLocation, StatFormatter> STAT_FORMATTERS = new HashMap<>();
    public static final SimpleRegistry<ResourceLocation> STATS = SimpleRegistry.create(Registries.CUSTOM_STAT, EIUUtils.ID);

    public static final ResourceLocation BLOCKS_CHISELED = EIUStats.makeCustomStat("blocks_chiseled", StatFormatter.DEFAULT);
    public static final ResourceLocation BLOCKS_CRUSHED = EIUStats.makeCustomStat("blocks_crushed", StatFormatter.DEFAULT);
    public static final ResourceLocation BLOCKS_GROUND = EIUStats.makeCustomStat("blocks_ground", StatFormatter.DEFAULT);

    private static ResourceLocation makeCustomStat(String name, StatFormatter statFormatter) {
        ResourceLocation statId = EIUUtils.resource(name);
        STATS.register(name, () -> statId);
        EIUStats.STAT_FORMATTERS.put(statId, statFormatter);
        return statId;
    }
}
