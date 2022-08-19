package morerightclickfunctions.fabric;

import morerightclickfunctions.MoreRightClickFunctionsMod;
import morerightclickfunctions.fabric.server.MoreRightClickFunctionsConfig;
import morerightclickfunctions.server.MoreRightClickFunctionsMaps;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class MoreRightClickFunctionsFabricMod implements ModInitializer {
    @Override
    public void onInitialize() {
        ModLoadingContext.registerConfig(MoreRightClickFunctionsMod.ID, ModConfig.Type.COMMON, MoreRightClickFunctionsConfig.commonSpec);

        for (int i = 0; i < MoreRightClickFunctionsConfig.COMMON_CONFIG.crackables_input.get().size(); i++) {
            Block input = Registry.BLOCK.get(new ResourceLocation(MoreRightClickFunctionsConfig.COMMON_CONFIG.crackables_input.get().get(i)));
            Block output = Registry.BLOCK.get(new ResourceLocation(MoreRightClickFunctionsConfig.COMMON_CONFIG.crackables_output.get().get(i)));
            if (input == null) {
                MoreRightClickFunctionsMod.LOGGER.debug("Warning! Crackables is broken and the game will crash!");
            }
            if (output == null) {
                MoreRightClickFunctionsMod.LOGGER.debug("Warning! Crackables is broken and the game will crash!");
            }
            MoreRightClickFunctionsMaps.CRACKABLES.put(input, output);
        }
        for (int i = 0; i < MoreRightClickFunctionsConfig.COMMON_CONFIG.grindables_input.get().size(); i++) {
            Block input = Registry.BLOCK.get(new ResourceLocation(MoreRightClickFunctionsConfig.COMMON_CONFIG.grindables_input.get().get(i)));
            Block output = Registry.BLOCK.get(new ResourceLocation(MoreRightClickFunctionsConfig.COMMON_CONFIG.grindables_output.get().get(i)));
            if (input == null) {
                MoreRightClickFunctionsMod.LOGGER.debug("Warning! Grindables is broken and the game will crash!");
            }
            if (output == null) {
                MoreRightClickFunctionsMod.LOGGER.debug("Warning! Grindables is broken and the game will crash!");
            }
            MoreRightClickFunctionsMaps.GRINDABLES.put(input, output);
        }
        for (int i = 0; i < MoreRightClickFunctionsConfig.COMMON_CONFIG.chiselables_input.get().size(); i++) {
            Block input = Registry.BLOCK.get(new ResourceLocation(MoreRightClickFunctionsConfig.COMMON_CONFIG.chiselables_input.get().get(i)));
            Block output = Registry.BLOCK.get(new ResourceLocation(MoreRightClickFunctionsConfig.COMMON_CONFIG.chiselables_output.get().get(i)));
            if (input == null) {
                MoreRightClickFunctionsMod.LOGGER.debug("Warning! Chiselables is broken and the game will crash!");
            }
            if (output == null) {
                MoreRightClickFunctionsMod.LOGGER.debug("Warning! Chiselables is broken and the game will crash!");
            }
            MoreRightClickFunctionsMaps.CHISELABLES.put(input, output);
        }
    }
}
