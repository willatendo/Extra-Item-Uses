package morerightclickfunctions.forge.server.config;

import com.google.common.collect.Lists;
import morerightclickfunctions.MoreRightClickFunctionsMod;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class CommonConfig {
    public final ForgeConfigSpec.ConfigValue<List<? extends String>> crackables_input;
    public final ForgeConfigSpec.ConfigValue<List<? extends String>> crackables_output;
    public final ForgeConfigSpec.ConfigValue<List<? extends String>> grindables_input;
    public final ForgeConfigSpec.ConfigValue<List<? extends String>> grindables_output;
    public final ForgeConfigSpec.ConfigValue<List<? extends String>> chiselables_input;
    public final ForgeConfigSpec.ConfigValue<List<? extends String>> chiselables_output;

    public CommonConfig(ForgeConfigSpec.Builder builder) {
        this.crackables_input = builder.comment("Sets the input that when right clicked with a pickaxe will be refined into an output. Must have the same amount of entries as crackables_output").translation("config." + MoreRightClickFunctionsMod.ID + ".crackables_input").defineList("crackables_input", Lists.newArrayList("minecraft:stone_bricks", "minecraft:cracked_stone_bricks", "minecraft:stone", "minecraft:deepslate", "minecraft:deepslate_bricks", "minecraft:cracked_deepslate_bricks", "minecraft:deepslate_tiles", "minecraft:cracked_deepslate_tiles", "minecraft:nether_bricks", "minecraft:polished_blackstone_bricks", "minecraft:infested_stone_bricks"), o -> o instanceof String);
        this.crackables_output = builder.comment("Sets the output that when the input is right clicked with a pickaxe will be refined into. Must have the same amount of entries as crackables_input").translation("config." + MoreRightClickFunctionsMod.ID + ".crackables_output").defineList("crackables_output", Lists.newArrayList("minecraft:cracked_stone_bricks", "minecraft:cobblestone", "minecraft:cobblestone", "minecraft:cobbled_deepslate", "minecraft:cracked_deepslate_bricks", "minecraft:cobbled_deepslate", "minecraft:cracked_deepslate_tiles", "minecraft:cobbled_deepslate", "minecraft:cracked_nether_bricks", "minecraft:cracked_polished_blackstone_bricks", "minecraft:infested_cracked_stone_bricks"), o -> o instanceof String);
        this.grindables_input = builder.comment("Sets the input that when right clicked with a shovel will be refined into an output. Must have the same amount of entries as shovel_output").translation("config." + MoreRightClickFunctionsMod.ID + ".grindables_input").defineList("grindables_input", Lists.newArrayList("minecraft:cobblestone", "minecraft:gravel"), o -> o instanceof String);
        this.grindables_output = builder.comment("Sets the output that when the input is right clicked with a shovel will be refined into. Must have the same amount of entries as shovel_input").translation("config." + MoreRightClickFunctionsMod.ID + ".grindables_output").defineList("grindables_output", Lists.newArrayList("minecraft:gravel", "minecraft:sand"), o -> o instanceof String);
        this.chiselables_input = builder.comment("Sets the input that when right clicked with a stick will be refined into an output. Must have the same amount of entries as chiselables_output").translation("config." + MoreRightClickFunctionsMod.ID + ".chiselables_input").defineList("chiselables_input", Lists.newArrayList("minecraft:stone_bricks", "minecraft:deepslate_bricks", "minecraft:nether_bricks", "minecraft:polished_blackstone", "minecraft:quartz_block", "minecraft:red_sandstone", "minecraft:sandstone", "minecraft:infested_stone_bricks"), o -> o instanceof String);
        this.chiselables_output = builder.comment("Sets the output that when the input is right clicked with a stick will be refined into. Must have the same amount of entries as chiselables_input").translation("config." + MoreRightClickFunctionsMod.ID + ".chiselables_output").defineList("chiselables_output", Lists.newArrayList("minecraft:chiseled_stone_bricks", "minecraft:chiseled_deepslate", "minecraft:chiseled_nether_bricks", "minecraft:chiseled_polished_blackstone", "minecraft:chiseled_quartz_block", "minecraft:chiseled_red_sandstone", "minecraft:chiseled_sandstone", "minecraft:infested_chiseled_stone_bricks"), o -> o instanceof String);
    }
}
