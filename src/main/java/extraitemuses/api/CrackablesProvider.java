package extraitemuses.api;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;

import extraitemuses.server.uses.BlockMap;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class CrackablesProvider implements DataProvider {
	private final List<BlockMap> blockMaps = Lists.newArrayList();
	private final PackOutput packOutput;
	private final String modid;

	public CrackablesProvider(PackOutput packOutput, String modid) {
		this.packOutput = packOutput;
		this.modid = modid;
	}

	@Override
	public CompletableFuture<?> run(CachedOutput cachedOutput) {
		this.crackables();

		Path path = this.packOutput.getOutputFolder();
		ArrayList<CompletableFuture> completableFutures = Lists.newArrayList();
		for (BlockMap blockMap : this.blockMaps) {
			JsonObject crackable = new JsonObject();
			JsonObject input = new JsonObject();
			crackable.add("input", input);
			input.addProperty("Name", ForgeRegistries.BLOCKS.getKey(blockMap.getInput().getBlock()).toString());
			JsonObject output = new JsonObject();
			crackable.add("output", output);
			output.addProperty("Name", ForgeRegistries.BLOCKS.getKey(blockMap.getOutput().getBlock()).toString());

			completableFutures.add(DataProvider.saveStable(cachedOutput, crackable, path.resolve("data/" + this.modid + "/extraitemuses/crackables/" + ForgeRegistries.BLOCKS.getKey(blockMap.getInput().getBlock()).getPath() + "_to_" + ForgeRegistries.BLOCKS.getKey(blockMap.getOutput().getBlock()).getPath() + ".json")));
		}

		return CompletableFuture.allOf(completableFutures.stream().toArray(CompletableFuture[]::new));
	}

	public abstract void crackables();

	public void addCrackable(BlockState input, BlockState output) {
		this.blockMaps.add(new BlockMap(input, output));
	}

	@Override
	public String getName() {
		return "Crackables";
	}
}
