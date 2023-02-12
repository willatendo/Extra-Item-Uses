package extraitemuses.server.block;

import extraitemuses.ExtraItemUsesMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ExtraItemUsesBlockTags {
	public static final TagKey<Block> COAL_POPPABLES = create("coal_poppables");
	public static final TagKey<Block> RAW_IRON_POPPABLES = create("raw_iron_poppables");
	public static final TagKey<Block> RAW_COPPER_POPPABLES = create("raw_copper_poppables");
	public static final TagKey<Block> RAW_GOLD_POPPABLES = create("raw_gold_poppables");
	public static final TagKey<Block> REDSTONE_POPPABLES = create("redstone_poppables");
	public static final TagKey<Block> EMERALD_POPPABLES = create("emerald_poppables");
	public static final TagKey<Block> LAPIS_POPPABLES = create("lapis_poppables");
	public static final TagKey<Block> DIAMOND_POPPABLES = create("diamond_poppables");
	public static final TagKey<Block> QUARTZ_POPPABLES = create("quartz_poppables");

	public static TagKey<Block> create(String name) {
		return TagKey.create(Registries.BLOCK, ExtraItemUsesMod.resource(name));
	}
}
