package willatendo.extraitemuses.data;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.world.level.block.Blocks;
import willatendo.extraitemuses.server.block.ExtraItemUsesBlockTags;
import willatendo.simplelibrary.data.SimpleBlockTagsProvider;
import willatendo.simplelibrary.data.util.ExistingFileHelper;

public class ExtraItemUsesBlockTagsProvider extends SimpleBlockTagsProvider {
	public ExtraItemUsesBlockTagsProvider(FabricDataOutput fabricDataOutput, CompletableFuture<Provider> completableFuture, String modId, ExistingFileHelper existingFileHelper) {
		super(fabricDataOutput, completableFuture, modId, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(ExtraItemUsesBlockTags.COAL_POPPABLES).add(Blocks.COAL_ORE, Blocks.DEEPSLATE_COAL_ORE);
		this.tag(ExtraItemUsesBlockTags.RAW_IRON_POPPABLES).add(Blocks.IRON_ORE, Blocks.DEEPSLATE_IRON_ORE);
		this.tag(ExtraItemUsesBlockTags.RAW_COPPER_POPPABLES).add(Blocks.COPPER_ORE, Blocks.DEEPSLATE_COPPER_ORE);
		this.tag(ExtraItemUsesBlockTags.RAW_GOLD_POPPABLES).add(Blocks.GOLD_ORE, Blocks.DEEPSLATE_GOLD_ORE);
		this.tag(ExtraItemUsesBlockTags.REDSTONE_POPPABLES).add(Blocks.REDSTONE_ORE, Blocks.DEEPSLATE_REDSTONE_ORE);
		this.tag(ExtraItemUsesBlockTags.EMERALD_POPPABLES).add(Blocks.EMERALD_ORE, Blocks.DEEPSLATE_EMERALD_ORE);
		this.tag(ExtraItemUsesBlockTags.LAPIS_POPPABLES).add(Blocks.LAPIS_ORE, Blocks.DEEPSLATE_LAPIS_ORE);
		this.tag(ExtraItemUsesBlockTags.DIAMOND_POPPABLES).add(Blocks.DIAMOND_ORE, Blocks.DEEPSLATE_DIAMOND_ORE);
		this.tag(ExtraItemUsesBlockTags.QUARTZ_POPPABLES).add(Blocks.NETHER_QUARTZ_ORE);
	}
}
