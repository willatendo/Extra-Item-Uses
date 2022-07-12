package morerightclickfunctions.server.config;

import java.io.Serializable;

import org.quiltmc.config.api.Config;
import org.quiltmc.config.api.Config.Builder;
import org.quiltmc.config.api.values.ValueList;

import com.google.common.collect.Lists;

public class CommonConfig implements Config.Creator {
	public static final CommonConfig INSTANCE = new CommonConfig();
	public ValueList<Serializable> crackables_input = ValueList.create("crackables_input", Lists.newArrayList("minecraft:stone_bricks", "minecraft:cracked_stone_bricks", "minecraft:stone", "minecraft:deepslate", "minecraft:deepslate_bricks", "minecraft:cracked_deepslate_bricks", "minecraft:deepslate_tiles", "minecraft:cracked_deepslate_tiles", "minecraft:nether_bricks", "minecraft:polished_blackstone_bricks", "minecraft:infested_stone_bricks"));
	public ValueList<String> crackables_output;
	public ValueList<String> grindables_input;
	public ValueList<String> grindables_output;
	public ValueList<String> chiselables_input;
	public ValueList<String> chiselables_output;

	@Override
	public void create(Builder builder) {
//		builder.field();
	}
}
