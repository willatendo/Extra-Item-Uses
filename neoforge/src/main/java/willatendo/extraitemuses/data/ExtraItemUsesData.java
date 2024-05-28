package willatendo.extraitemuses.data;

import net.minecraft.DetectedVersion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import willatendo.extraitemuses.server.util.ExtraItemUsesUtils;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = ExtraItemUsesUtils.ID)
public class ExtraItemUsesData {
    @SubscribeEvent
    public static void gatherDataEvent(GatherDataEvent gatherDataEvent) {
        DataGenerator dataGenerator = gatherDataEvent.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        ExistingFileHelper existingFileHelper = gatherDataEvent.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> registries = gatherDataEvent.getLookupProvider();

        dataGenerator.addProvider(gatherDataEvent.includeClient(), new ExtraItemUsesLanguageProvider(packOutput, ExtraItemUsesUtils.ID, "en_us"));

        ExtraItemUsesBlockTagsProvider extraItemUsesBlockTagsProvider = new ExtraItemUsesBlockTagsProvider(packOutput, registries, ExtraItemUsesUtils.ID, existingFileHelper);
        dataGenerator.addProvider(gatherDataEvent.includeServer(), extraItemUsesBlockTagsProvider);
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new ExtraItemUsesItemTagProvider(packOutput, registries, extraItemUsesBlockTagsProvider.contentsGetter(), ExtraItemUsesUtils.ID, existingFileHelper));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new ExtraItemUsesCrackablesProvider(packOutput, ExtraItemUsesUtils.ID));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new ExtraItemUsesChiselablesProvider(packOutput, ExtraItemUsesUtils.ID));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new ExtraItemUsesGrindablesProvider(packOutput, ExtraItemUsesUtils.ID));
        dataGenerator.addProvider(gatherDataEvent.includeServer(), new PackMetadataGenerator(packOutput).add(PackMetadataSection.TYPE, new PackMetadataSection(ExtraItemUsesUtils.translation("resourcePack", "description"), DetectedVersion.BUILT_IN.getPackVersion(PackType.CLIENT_RESOURCES), Optional.empty())));
    }
}
