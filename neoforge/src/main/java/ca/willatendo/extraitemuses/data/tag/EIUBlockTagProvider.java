package ca.willatendo.extraitemuses.data.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public final class EIUBlockTagProvider extends BlockTagsProvider {
    public EIUBlockTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId) {
        super(packOutput, lookupProvider, modId);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
    }
}
