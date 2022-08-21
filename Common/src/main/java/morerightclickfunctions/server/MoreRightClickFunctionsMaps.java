package morerightclickfunctions.server;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class MoreRightClickFunctionsMaps {
    public static final ImmutableMap.Builder<Block, Block> CRACKABLES = ImmutableMap.builder();
    public static final ImmutableMap.Builder<Block, Block> GRINDABLES = ImmutableMap.builder();
    public static final ImmutableMap.Builder<Block, Block> CHISELABLES = ImmutableMap.builder();
    public static final ImmutableMap.Builder<Block, Item> REAPABLES = ImmutableMap.builder();
}
