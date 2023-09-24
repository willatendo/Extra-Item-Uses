package willatendo.extraitemuses.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import willatendo.extraitemuses.server.util.ExtraItemUsesUtils;

@EventBusSubscriber(bus = Bus.MOD, modid = ExtraItemUsesUtils.ID)
public class DataGen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator dataGenerator = event.getGenerator();
		PackOutput packOutput = dataGenerator.getPackOutput();

		dataGenerator.addProvider(event.includeClient(), new ExtraItemUsesLanguageProvider(packOutput, ExtraItemUsesUtils.ID, "en_us"));
		dataGenerator.addProvider(event.includeServer(), new ExtraItemUsesBlockTagsProvider(packOutput, event.getLookupProvider(), ExtraItemUsesUtils.ID, event.getExistingFileHelper()));
		dataGenerator.addProvider(event.includeServer(), new ExtraItemUsesCrackablesProvider(packOutput, ExtraItemUsesUtils.ID));
		dataGenerator.addProvider(event.includeServer(), new ExtraItemUsesChiselablesProvider(packOutput, ExtraItemUsesUtils.ID));
		dataGenerator.addProvider(event.includeServer(), new ExtraItemUsesGrindablesProvider(packOutput, ExtraItemUsesUtils.ID));
	}
}
