package morerightclickfunctions.forge;

import morerightclickfunctions.MoreRightClickFunctionsMod;
import morerightclickfunctions.forge.server.MoreRightClickFunctionsConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(MoreRightClickFunctionsMod.ID)
public class MoreRightClickFunctionsForgeMod {
    public MoreRightClickFunctionsForgeMod() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MoreRightClickFunctionsConfig.commonSpec);
    }
}
