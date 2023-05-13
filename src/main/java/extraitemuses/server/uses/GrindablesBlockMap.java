package extraitemuses.server.uses;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.world.level.block.state.BlockState;

public class GrindablesBlockMap {
	public static final Codec<GrindablesBlockMap> CODEC = RecordCodecBuilder.create(builder -> {
		return builder.group(BlockState.CODEC.fieldOf("input").forGetter(blockMap -> {
			return blockMap.getBlockMap().input;
		}), BlockState.CODEC.fieldOf("output").forGetter(blockMap -> {
			return blockMap.getBlockMap().output;
		})).apply(builder, GrindablesBlockMap::new);
	});
	private final BlockMap blockMap;

	public GrindablesBlockMap(BlockState input, BlockState output) {
		this.blockMap = new BlockMap(input, output);
	}

	public BlockMap getBlockMap() {
		return this.blockMap;
	}
}
