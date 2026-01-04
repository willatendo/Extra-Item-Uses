package ca.willatendo.extraitemuses.api.data;

import ca.willatendo.extraitemuses.server.extraitemuses.Chiselable;
import com.google.common.collect.Maps;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class ChiselablesProvider implements DataProvider {
    private final Map<ResourceLocation, Chiselable> chiselables = Maps.newHashMap();
    private final PackOutput packOutput;
    private final String modId;

    public ChiselablesProvider(PackOutput packOutput, String modId) {
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

    protected void add(String id, Chiselable chiselable) {
        this.chiselables.put(ResourceLocation.fromNamespaceAndPath(this.modId, id), chiselable);
    }

    protected void add(Block fromBlock, Block toBlock) {
        this.add(this.makeId(fromBlock, toBlock), new Chiselable(fromBlock, toBlock));
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        this.getAll();
        return DataProvider.saveAll(cachedOutput, Chiselable.CODEC, this.packOutput.createPathProvider(PackOutput.Target.DATA_PACK, "extraitemuses/chiselables"), this.chiselables);
    }

    @Override
    public String getName() {
        return "Chiselables: " + this.modId;
    }
}
