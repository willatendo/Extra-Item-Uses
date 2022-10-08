package morerightclickfunctions.server;

import org.apache.commons.lang3.tuple.Pair;

import morerightclickfunctions.server.config.CommonConfig;
import net.minecraftforge.common.ForgeConfigSpec;

public class MoreRightClickFunctionsConfig {
	public static final ForgeConfigSpec commonSpec;
	public static final CommonConfig COMMON_CONFIG;

	static {
		final Pair<CommonConfig, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
		commonSpec = commonSpecPair.getRight();
		COMMON_CONFIG = commonSpecPair.getLeft();
	}
}
