package morerightclickfunctions;

import morerightclickfunctions.server.jei.JEIItems;
import morerightclickfunctions.server.registry.CommonRegistry;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MoreRightClickFunctionsMod {
    public static final String ID = "morerightclickfunctions";
    public static final Logger LOGGER = LogManager.getLogger(ID);
    public static CommonRegistry commonRegistry;

    public MoreRightClickFunctionsMod(CommonRegistry specific, boolean loadJEIItems) {
        commonRegistry = specific;

        if (loadJEIItems) {
            new JEIItems();
        }
    }

    public static ResourceLocation rL(String path) {
        return new ResourceLocation(ID, path);
    }
}