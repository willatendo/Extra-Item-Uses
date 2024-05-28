package willatendo.extraitemuses.data;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.extraitemuses.server.item.ExtraItemUsesItemTags;

import java.util.concurrent.CompletableFuture;

public class ExtraItemUsesItemTagProvider extends ItemTagsProvider {

    public ExtraItemUsesItemTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, CompletableFuture<TagLookup<Block>> blockTags, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, provider, blockTags, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(ExtraItemUsesItemTags.CRACKABLE_ITEMS).add(Items.DIAMOND_PICKAXE, Items.GOLDEN_PICKAXE, Items.IRON_PICKAXE, Items.NETHERITE_PICKAXE, Items.STONE_PICKAXE, Items.WOODEN_PICKAXE);
        this.tag(ExtraItemUsesItemTags.GRINDABLES_ITEMS).add(Items.DIAMOND_SHOVEL, Items.GOLDEN_SHOVEL, Items.IRON_SHOVEL, Items.NETHERITE_SHOVEL, Items.STONE_SHOVEL, Items.WOODEN_SHOVEL);
        this.tag(ExtraItemUsesItemTags.CHISELABLES_ITEMS).add(Items.STICK);
    }
}
