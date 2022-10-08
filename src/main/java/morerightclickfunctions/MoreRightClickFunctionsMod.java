package morerightclickfunctions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import morerightclickfunctions.server.MoreRightClickFunctionsConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;

@Mod(MoreRightClickFunctionsMod.ID)
public class MoreRightClickFunctionsMod {
	public static final String ID = "morerightclickfunctions";
	public static final Logger LOGGER = LogManager.getLogger(ID);

	public MoreRightClickFunctionsMod() {
		ModLoadingContext.get().registerConfig(Type.COMMON, MoreRightClickFunctionsConfig.commonSpec);
	}

	public static ResourceLocation rL(String path) {
		return new ResourceLocation(ID, path);
	}
}
