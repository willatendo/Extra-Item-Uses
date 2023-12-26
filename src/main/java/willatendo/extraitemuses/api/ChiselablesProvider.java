package willatendo.extraitemuses.api;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.world.level.block.state.BlockState;

public abstract class ChiselablesProvider implements DataProvider {
	private final Map<BlockState, BlockState> blockMaps = new HashMap<>();
	private final FabricDataOutput fabricDataOutput;
	private final String modId;

	public ChiselablesProvider(FabricDataOutput fabricDataOutput, String modId) {
		this.fabricDataOutput = fabricDataOutput;
		this.modId = modId;
	}

	@Override
	public CompletableFuture<?> run(CachedOutput cachedOutput) {
		this.chiselables();

		Path path = this.fabricDataOutput.getOutputFolder();
		ArrayList<CompletableFuture> completableFutures = Lists.newArrayList();
		for (int i = 0; i < this.blockMaps.size(); i++) {
			BlockState inputState = this.blockMaps.keySet().stream().toList().get(i);
			BlockState outputState = this.blockMaps.values().stream().toList().get(i);
			JsonObject crackable = new JsonObject();
			JsonObject input = new JsonObject();
			crackable.add("input", input);
			input.addProperty("Name", BuiltInRegistries.BLOCK.getKey(inputState.getBlock()).toString());
			JsonObject output = new JsonObject();
			crackable.add("output", output);
			output.addProperty("Name", BuiltInRegistries.BLOCK.getKey(outputState.getBlock()).toString());

			completableFutures.add(DataProvider.saveStable(cachedOutput, crackable, path.resolve("data/" + this.modId + "/extraitemuses/chiselables/" + BuiltInRegistries.BLOCK.getKey(inputState.getBlock()).getPath() + "_to_" + BuiltInRegistries.BLOCK.getKey(outputState.getBlock()).getPath() + ".json")));
		}

		return CompletableFuture.allOf(completableFutures.stream().toArray(CompletableFuture[]::new));
	}

	public abstract void chiselables();

	public void addChiselable(BlockState input, BlockState output) {
		this.blockMaps.put(input, output);
	}

	@Override
	public String getName() {
		return "Chiselables: " + this.modId;
	}
}
