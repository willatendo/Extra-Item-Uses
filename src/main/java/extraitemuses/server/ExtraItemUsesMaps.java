package extraitemuses.server;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

import net.minecraft.world.level.block.Block;

public class ExtraItemUsesMaps {
	public static Builder<Block, Block> CRACKABLES = ImmutableMap.builder();
	public static Builder<Block, Block> GRINDABLES = ImmutableMap.builder();
	public static Builder<Block, Block> CHISELABLES = ImmutableMap.builder();
}
