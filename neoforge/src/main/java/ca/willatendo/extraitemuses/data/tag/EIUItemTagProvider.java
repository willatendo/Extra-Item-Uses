package ca.willatendo.extraitemuses.data.tag;

import ca.willatendo.extraitemuses.server.tags.EIUItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public final class EIUItemTagProvider extends ItemTagsProvider {
    public EIUItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, String modId) {
        super(packOutput, lookupProvider, blockTags, modId);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(EIUItemTags.CHISELING_ITEM).add(
                Items.STICK
        );
        this.tag(EIUItemTags.CRACKING_ITEM).add(
                Items.WOODEN_PICKAXE,
                Items.STONE_PICKAXE,
                Items.IRON_PICKAXE,
                Items.GOLDEN_PICKAXE,
                Items.DIAMOND_PICKAXE,
                Items.NETHERITE_PICKAXE
        );
        this.tag(EIUItemTags.GRINDING_ITEM).add(
                Items.WOODEN_SHOVEL,
                Items.STONE_SHOVEL,
                Items.IRON_SHOVEL,
                Items.GOLDEN_SHOVEL,
                Items.DIAMOND_SHOVEL,
                Items.NETHERITE_SHOVEL
        );
    }
}
