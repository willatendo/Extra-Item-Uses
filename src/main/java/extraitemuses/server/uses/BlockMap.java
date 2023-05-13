package extraitemuses.server.uses;

import net.minecraft.world.level.block.state.BlockState;

public class BlockMap {
	public BlockState input;
	public BlockState output;

	public BlockMap(BlockState input, BlockState output) {
		this.input = input;
		this.output = output;
	}

	public BlockState getInput() {
		return this.input;
	}

	public BlockState getOutput() {
		return this.output;
	}
}
