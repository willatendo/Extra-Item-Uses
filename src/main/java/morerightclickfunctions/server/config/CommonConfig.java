package morerightclickfunctions.server.config;

import org.quiltmc.config.api.Config;
import org.quiltmc.config.api.Config.Builder;
import org.quiltmc.config.api.values.TrackedValue;
import org.quiltmc.config.api.values.ValueList;

public class CommonConfig implements Config.Creator {
	public static final CommonConfig INSTANCE = new CommonConfig();
	public final ValueList<String> crackables_input = ValueList.create("minecraft:stone_bricks", "minecraft:stone_bricks", "minecraft:cracked_stone_bricks", "minecraft:stone", "minecraft:deepslate", "minecraft:deepslate_bricks", "minecraft:cracked_deepslate_bricks", "minecraft:deepslate_tiles", "minecraft:cracked_deepslate_tiles", "minecraft:nether_bricks", "minecraft:polished_blackstone_bricks", "minecraft:infested_stone_bricks");
	public final ValueList<String> crackables_output = ValueList.create("minecraft:cracked_stone_bricks", "minecraft:cracked_stone_bricks", "minecraft:cobblestone", "minecraft:cobblestone", "minecraft:cobbled_deepslate", "minecraft:cracked_deepslate_bricks", "minecraft:cobbled_deepslate", "minecraft:cracked_deepslate_tiles", "minecraft:cobbled_deepslate", "minecraft:cracked_nether_bricks", "minecraft:cracked_polished_blackstone_bricks", "minecraft:infested_cracked_stone_bricks");
	public final ValueList<String> grindables_input = ValueList.create("minecraft:cobblestone", "minecraft:cobblestone", "minecraft:gravel");
	public final ValueList<String> grindables_output = ValueList.create("minecraft:gravel", "minecraft:gravel", "minecraft:sand");
	public final ValueList<String> chiselables_input = ValueList.create("minecraft:stone_bricks", "minecraft:stone_bricks", "minecraft:deepslate_bricks", "minecraft:nether_bricks", "minecraft:polished_blackstone", "minecraft:quartz_block", "minecraft:red_sandstone", "minecraft:sandstone", "minecraft:infested_stone_bricks");
	public final ValueList<String> chiselables_output = ValueList.create("minecraft:chiseled_stone_bricks", "minecraft:chiseled_stone_bricks", "minecraft:chiseled_deepslate", "minecraft:chiseled_nether_bricks", "minecraft:chiseled_polished_blackstone", "minecraft:chiseled_quartz_block", "minecraft:chiseled_red_sandstone", "minecraft:chiseled_sandstone", "minecraft:infested_chiseled_stone_bricks");

	@Override
	public void create(Builder builder) {
		builder.section("crackables", b -> {
			b.field(TrackedValue.create(this.crackables_input, "crackables_input", c -> c.getDefaultValue()));
			b.field(TrackedValue.create(this.crackables_output, "crackables_output", c -> c.getDefaultValue()));
		});
	}
}
