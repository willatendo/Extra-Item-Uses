package morerightclickfunctions.forge;

import morerightclickfunctions.MoreRightClickFunctionsMod;
import morerightclickfunctions.forge.server.MoreRightClickFunctionsConfig;
import morerightclickfunctions.forge.server.registry.ForgeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MoreRightClickFunctionsMod.ID)
public class MoreRightClickFunctionsForgeMod {
    public static final ForgeRegistry FORGE_REGISTRY = new ForgeRegistry();

    public MoreRightClickFunctionsForgeMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ForgeRegistry.ITEMS.register(bus);

        new MoreRightClickFunctionsMod(FORGE_REGISTRY, ModList.get().isLoaded("jei"));

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MoreRightClickFunctionsConfig.commonSpec);
    }
}
