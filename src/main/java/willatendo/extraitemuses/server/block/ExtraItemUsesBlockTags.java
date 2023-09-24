package willatendo.extraitemuses.server.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import willatendo.extraitemuses.server.util.ExtraItemUsesUtils;
import willatendo.simplelibrary.server.util.SimpleUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class ExtraItemUsesBlockTags {
	public static final TagRegister<Block> BLOCK_TAGS = SimpleUtils.create(Registries.BLOCK, ExtraItemUsesUtils.ID);

	public static final TagKey<Block> COAL_POPPABLES = BLOCK_TAGS.register("coal_poppables");
	public static final TagKey<Block> RAW_IRON_POPPABLES = BLOCK_TAGS.register("raw_iron_poppables");
	public static final TagKey<Block> RAW_COPPER_POPPABLES = BLOCK_TAGS.register("raw_copper_poppables");
	public static final TagKey<Block> RAW_GOLD_POPPABLES = BLOCK_TAGS.register("raw_gold_poppables");
	public static final TagKey<Block> REDSTONE_POPPABLES = BLOCK_TAGS.register("redstone_poppables");
	public static final TagKey<Block> EMERALD_POPPABLES = BLOCK_TAGS.register("emerald_poppables");
	public static final TagKey<Block> LAPIS_POPPABLES = BLOCK_TAGS.register("lapis_poppables");
	public static final TagKey<Block> DIAMOND_POPPABLES = BLOCK_TAGS.register("diamond_poppables");
	public static final TagKey<Block> QUARTZ_POPPABLES = BLOCK_TAGS.register("quartz_poppables");
}
