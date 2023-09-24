package willatendo.extraitemuses.server.uses;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.world.level.block.state.BlockState;

public class GrindablesBlockMap {
	public static final Codec<GrindablesBlockMap> CODEC = RecordCodecBuilder.create(builder -> {
		return builder.group(BlockState.CODEC.fieldOf("input").forGetter(blockMap -> {
			return blockMap.getInputState();
		}), BlockState.CODEC.fieldOf("output").forGetter(blockMap -> {
			return blockMap.getOutputState();
		})).apply(builder, GrindablesBlockMap::new);
	});
	private final BlockState inputState;
	private final BlockState outputState;

	public GrindablesBlockMap(BlockState inputState, BlockState outputState) {
		this.inputState = inputState;
		this.outputState = outputState;
	}

	public BlockState getInputState() {
		return this.inputState;
	}

	public BlockState getOutputState() {
		return this.outputState;
	}
}
