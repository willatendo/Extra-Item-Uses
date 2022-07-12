package morerightclickfunctions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.config.QuiltConfig;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

import morerightclickfunctions.server.MoreRightClickFunctionsMaps;
import morerightclickfunctions.server.config.CommonConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;

public class MoreRightClickFunctionsMod implements ModInitializer {
	public static final String ID = "morerightclickfunctions";
	public static final Logger LOGGER = LogManager.getLogger(ID);

	@Override
	public void onInitialize(ModContainer modContainer) {
		QuiltConfig.create(ID, ID + "-common", new CommonConfig());
		MoreRightClickFunctionsMaps.CRACKABLES.put(Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS);
	}

	public static ResourceLocation rL(String path) {
		return new ResourceLocation(ID, path);
	}
}
