package morerightclickfunctions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.config.QuiltConfig;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

import morerightclickfunctions.server.MoreRightClickFunctionsMaps;
import morerightclickfunctions.server.config.CommonConfig;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class MoreRightClickFunctionsMod implements ModInitializer {
	public static final String ID = "morerightclickfunctions";
	public static final Logger LOGGER = LogManager.getLogger(ID);

	@Override
	public void onInitialize(ModContainer modContainer) {
		QuiltConfig.create(ID, ID + "-common", new CommonConfig());

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

	public static ResourceLocation rL(String path) {
		return new ResourceLocation(ID, path);
	}
}
