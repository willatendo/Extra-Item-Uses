package morerightclickfunctions.quilt;

import morerightclickfunctions.MoreRightClickFunctionsMod;
import morerightclickfunctions.server.MoreRightClickFunctionsMaps;
import morerightclickfunctions.quilt.server.config.CommonConfig;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.config.QuiltConfig;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class MoreRightClickFunctionsQuiltMod implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        QuiltConfig.create(MoreRightClickFunctionsMod.ID, MoreRightClickFunctionsMod.ID + "-common", new CommonConfig());

        for (int i = 0; i < CommonConfig.INSTANCE.crackables_input.size(); i++) {
            Block input = Registry.BLOCK.get(new ResourceLocation(CommonConfig.INSTANCE.crackables_input.get(i)));
            Block output = Registry.BLOCK.get(new ResourceLocation(CommonConfig.INSTANCE.crackables_output.get(i)));
            if (input == null) {
                MoreRightClickFunctionsMod.LOGGER.debug("Warning! Crackables is broken and the game will crash!");
            }
            if (output == null) {
                MoreRightClickFunctionsMod.LOGGER.debug("Warning! Crackables is broken and the game will crash!");
            }
            MoreRightClickFunctionsMaps.CRACKABLES.put(input, output);
        }
        for (int i = 0; i < CommonConfig.INSTANCE.grindables_input.size(); i++) {
            Block input = Registry.BLOCK.get(new ResourceLocation(CommonConfig.INSTANCE.grindables_input.get(i)));
            Block output = Registry.BLOCK.get(new ResourceLocation(CommonConfig.INSTANCE.grindables_output.get(i)));
            if (input == null) {
                MoreRightClickFunctionsMod.LOGGER.debug("Warning! Grindables is broken and the game will crash!");
            }
            if (output == null) {
                MoreRightClickFunctionsMod.LOGGER.debug("Warning! Grindables is broken and the game will crash!");
            }
            MoreRightClickFunctionsMaps.GRINDABLES.put(input, output);
        }
        for (int i = 0; i < CommonConfig.INSTANCE.chiselables_input.size(); i++) {
            Block input = Registry.BLOCK.get(new ResourceLocation(CommonConfig.INSTANCE.chiselables_input.get(i)));
            Block output = Registry.BLOCK.get(new ResourceLocation(CommonConfig.INSTANCE.chiselables_output.get(i)));
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
