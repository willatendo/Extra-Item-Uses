package morerightclickfunctions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

import net.minecraft.resources.ResourceLocation;

public class MoreRightClickFunctionsMod implements ModInitializer {
	public static final String ID = "morerightclickfunctions";
	public static final Logger LOGGER = LogManager.getLogger(ID);

	@Override
	public void onInitialize(ModContainer modContainer) {
	}

	public static ResourceLocation rL(String path) {
		return new ResourceLocation(ID, path);
	}
}
