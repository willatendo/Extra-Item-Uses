package willatendo.extraitemuses.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import willatendo.simplelibrary.data.DataHandler;

public class ExtraItemUsesData implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		DataHandler dataHandler = new DataHandler(fabricDataGenerator);

//		dataHandler.addLanguageProvider((fabricDataOutput, modId) -> new ExtraItemUsesLanguageProvider(fabricDataOutput, modId, "en_us"));
		dataHandler.addProvider((fabricDataOutput, provider, modId, existingFileHelper) -> new ExtraItemUsesBlockTagsProvider(fabricDataOutput, provider, modId, existingFileHelper));
		dataHandler.addProvider((fabricDataOutput, modId) -> new ExtraItemUsesCrackablesProvider(fabricDataOutput, modId));
		dataHandler.addProvider((fabricDataOutput, modId) -> new ExtraItemUsesChiselablesProvider(fabricDataOutput, modId));
		dataHandler.addProvider((fabricDataOutput, modId) -> new ExtraItemUsesGrindablesProvider(fabricDataOutput, modId));
	}
}
