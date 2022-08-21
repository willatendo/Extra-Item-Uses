package morerightclickfunctions.forge.server.events;

import morerightclickfunctions.MoreRightClickFunctionsMod;
import morerightclickfunctions.forge.server.MoreRightClickFunctionsConfig;
import morerightclickfunctions.server.MoreRightClickFunctionsMaps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MoreRightClickFunctionsMod.ID)
public class ModBusEvents {
    @SubscribeEvent
    public static void makeMapsOnCommonSetup(FMLCommonSetupEvent event) {
        makeMaps();
    }

    public static void makeMaps() {
        for (int i = 0; i < MoreRightClickFunctionsConfig.COMMON_CONFIG.crackables_input.get().size(); i++) {
            Block input = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MoreRightClickFunctionsConfig.COMMON_CONFIG.crackables_input.get().get(i)));
            Block output = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MoreRightClickFunctionsConfig.COMMON_CONFIG.crackables_output.get().get(i)));
            if (input == null) {
                MoreRightClickFunctionsMod.LOGGER.debug("Warning! Crackables is broken and the game will crash!");
            }
            if (output == null) {
                MoreRightClickFunctionsMod.LOGGER.debug("Warning! Crackables is broken and the game will crash!");
            }
            MoreRightClickFunctionsMaps.CRACKABLES.put(input, output);
        }
        for (int i = 0; i < MoreRightClickFunctionsConfig.COMMON_CONFIG.grindables_input.get().size(); i++) {
            Block input = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MoreRightClickFunctionsConfig.COMMON_CONFIG.grindables_input.get().get(i)));
            Block output = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MoreRightClickFunctionsConfig.COMMON_CONFIG.grindables_output.get().get(i)));
            if (input == null) {
                MoreRightClickFunctionsMod.LOGGER.debug("Warning! Grindables is broken and the game will crash!");
            }
            if (output == null) {
                MoreRightClickFunctionsMod.LOGGER.debug("Warning! Grindables is broken and the game will crash!");
            }
            MoreRightClickFunctionsMaps.GRINDABLES.put(input, output);
        }
        for (int i = 0; i < MoreRightClickFunctionsConfig.COMMON_CONFIG.chiselables_input.get().size(); i++) {
            Block input = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MoreRightClickFunctionsConfig.COMMON_CONFIG.chiselables_input.get().get(i)));
            Block output = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MoreRightClickFunctionsConfig.COMMON_CONFIG.chiselables_output.get().get(i)));
            if (input == null) {
                MoreRightClickFunctionsMod.LOGGER.debug("Warning! Chiselables is broken and the game will crash!");
            }
            if (output == null) {
                MoreRightClickFunctionsMod.LOGGER.debug("Warning! Chiselables is broken and the game will crash!");
            }
            MoreRightClickFunctionsMaps.CHISELABLES.put(input, output);
        }
        for (int i = 0; i < MoreRightClickFunctionsConfig.COMMON_CONFIG.reapables_input.get().size(); i++) {
            Block input = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MoreRightClickFunctionsConfig.COMMON_CONFIG.reapables_input.get().get(i)));
            Item output = ForgeRegistries.ITEMS.getValue(new ResourceLocation(MoreRightClickFunctionsConfig.COMMON_CONFIG.reapables_output.get().get(i)));
            if (input == null) {
                MoreRightClickFunctionsMod.LOGGER.debug("Warning! Chiselables is broken and the game will crash!");
            }
            if (output == null) {
                MoreRightClickFunctionsMod.LOGGER.debug("Warning! Chiselables is broken and the game will crash!");
            }
            MoreRightClickFunctionsMaps.REAPABLES.put(input, output);
        }
    }
}
