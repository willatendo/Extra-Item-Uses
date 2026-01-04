package ca.willatendo.extraitemuses.data;

import ca.willatendo.extraitemuses.data.tag.EIUBlockTagProvider;
import ca.willatendo.extraitemuses.data.tag.EIUItemTagProvider;
import ca.willatendo.extraitemuses.server.utils.EIUUtils;
import net.minecraft.DetectedVersion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = EIUUtils.ID)
public final class ExtraItemUsesData {
    @SubscribeEvent
    public static void gatherDataEvent(GatherDataEvent.Client event) {
        DataGenerator dataGenerator = event.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();

        event.addProvider(new EIULanguageProvider(packOutput, EIUUtils.ID, "en_us"));

        CompletableFuture<HolderLookup.Provider> registries = event.getLookupProvider();
        event.addProvider(new EIUChiselablesProvider(packOutput, EIUUtils.ID));
        event.addProvider(new EIUCrackablesProvider(packOutput, EIUUtils.ID));
        event.addProvider(new EIUGrindablesProvider(packOutput, EIUUtils.ID));
        EIUBlockTagProvider eiuBlockTagProvider = new EIUBlockTagProvider(packOutput, registries, EIUUtils.ID);
        event.addProvider(eiuBlockTagProvider);
        event.addProvider(new EIUItemTagProvider(packOutput, registries, eiuBlockTagProvider.contentsGetter(), EIUUtils.ID));

        event.addProvider(new PackMetadataGenerator(packOutput).add(PackMetadataSection.TYPE, new PackMetadataSection(EIUUtils.translation("resourcePack", "description"), DetectedVersion.BUILT_IN.getPackVersion(PackType.CLIENT_RESOURCES), Optional.empty())));
    }
}
