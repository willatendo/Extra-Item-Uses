package ca.willatendo.extraitemuses.api.data;

import ca.willatendo.extraitemuses.server.extraitemuses.Crackable;
import com.google.common.collect.Maps;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public abstract class CrackablesProvider implements DataProvider {
    private final Map<ResourceLocation, Crackable> crackables = Maps.newHashMap();
    private final PackOutput packOutput;
    private final String modId;

    public CrackablesProvider(PackOutput packOutput, String modId) {
        this.packOutput = packOutput;
        this.modId = modId;
    }

    protected abstract void getAll();

    protected String makeId(Block fromBlock, Block toBlock) {
        String id = "";
        id += BuiltInRegistries.BLOCK.getKey(fromBlock).getPath();
        id += "_to_";
        id += BuiltInRegistries.BLOCK.getKey(toBlock).getPath();
        return id;
    }

    protected void add(String id, Crackable crackable) {
        this.crackables.put(ResourceLocation.fromNamespaceAndPath(this.modId, id), crackable);
    }

    protected void add(Block fromBlock, Block toBlock) {
        this.add(this.makeId(fromBlock, toBlock), new Crackable(fromBlock, toBlock));
    }

    protected void addWithLoot(Block fromBlock, Block toBlock) {
        this.add(this.makeId(fromBlock, toBlock), new Crackable(fromBlock, toBlock, true));
    }

    protected void add(Block fromBlock, Block toBlock, ItemStack itemStackDrop) {
        this.add(this.makeId(fromBlock, toBlock), new Crackable(fromBlock, toBlock, itemStackDrop));
    }

    protected void add(Block fromBlock, Block toBlock, ItemStack itemStackDrop, IntProvider experienceDrop) {
        this.add(this.makeId(fromBlock, toBlock), new Crackable(fromBlock, toBlock, false, Optional.of(itemStackDrop), Optional.of(experienceDrop)));
    }

    protected void addWithLoot(Block fromBlock, Block toBlock, IntProvider experienceDrop) {
        this.add(this.makeId(fromBlock, toBlock), new Crackable(fromBlock, toBlock, true, Optional.empty(), Optional.of(experienceDrop)));
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        this.getAll();
        return DataProvider.saveAll(cachedOutput, Crackable.CODEC, this.packOutput.createPathProvider(PackOutput.Target.DATA_PACK, "extraitemuses/crackables"), this.crackables);
    }

    @Override
    public String getName() {
        return "Crackables: " + this.modId;
    }
}
