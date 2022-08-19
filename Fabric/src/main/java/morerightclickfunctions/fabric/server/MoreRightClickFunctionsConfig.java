package morerightclickfunctions.fabric.server;

import morerightclickfunctions.fabric.server.config.CommonConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class MoreRightClickFunctionsConfig {
    public static final ForgeConfigSpec commonSpec;
    public static final CommonConfig COMMON_CONFIG;

    static {
        final Pair<CommonConfig, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        commonSpec = commonSpecPair.getRight();
        COMMON_CONFIG = commonSpecPair.getLeft();
    }
}
