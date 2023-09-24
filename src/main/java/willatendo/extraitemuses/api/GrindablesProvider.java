package willatendo.extraitemuses.api;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class GrindablesProvider implements DataProvider {
	private final Map<BlockState, BlockState> blockMaps = new HashMap<>();
	private final PackOutput packOutput;
	private final String modid;

	public GrindablesProvider(PackOutput packOutput, String modid) {
		this.packOutput = packOutput;
		this.modid = modid;
	}

	@Override
	public CompletableFuture<?> run(CachedOutput cachedOutput) {
		this.grindables();

		Path path = this.packOutput.getOutputFolder();
		ArrayList<CompletableFuture> completableFutures = Lists.newArrayList();
		for (int i = 0; i < this.blockMaps.size(); i++) {
			BlockState inputState = this.blockMaps.keySet().stream().toList().get(i);
			BlockState outputState = this.blockMaps.values().stream().toList().get(i);
			JsonObject crackable = new JsonObject();
			JsonObject input = new JsonObject();
			crackable.add("input", input);
			input.addProperty("Name", ForgeRegistries.BLOCKS.getKey(inputState.getBlock()).toString());
			JsonObject output = new JsonObject();
			crackable.add("output", output);
			output.addProperty("Name", ForgeRegistries.BLOCKS.getKey(outputState.getBlock()).toString());

			completableFutures.add(DataProvider.saveStable(cachedOutput, crackable, path.resolve("data/" + this.modid + "/extraitemuses/grindables/" + ForgeRegistries.BLOCKS.getKey(inputState.getBlock()).getPath() + "_to_" + ForgeRegistries.BLOCKS.getKey(outputState.getBlock()).getPath() + ".json")));
		}

		return CompletableFuture.allOf(completableFutures.stream().toArray(CompletableFuture[]::new));
	}

	public abstract void grindables();

	public void addGrindable(BlockState input, BlockState output) {
		this.blockMaps.put(input, output);
	}

	@Override
	public String getName() {
		return "Grindables";
	}
}
