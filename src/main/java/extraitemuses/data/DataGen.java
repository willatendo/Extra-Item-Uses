package extraitemuses.data;

import extraitemuses.ExtraItemUsesMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.MOD, modid = ExtraItemUsesMod.ID)
public class DataGen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator dataGenerator = event.getGenerator();
		dataGenerator.addProvider(event.includeServer(), new ExtraItemUsesBlockTagsProvider(dataGenerator.getPackOutput(), event.getLookupProvider(), ExtraItemUsesMod.ID, event.getExistingFileHelper()));
		dataGenerator.addProvider(event.includeServer(), new ExtraItemUsesCrackablesProvider(dataGenerator.getPackOutput(), ExtraItemUsesMod.ID));
	}
}
