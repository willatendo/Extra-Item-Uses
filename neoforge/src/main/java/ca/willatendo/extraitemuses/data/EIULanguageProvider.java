package ca.willatendo.extraitemuses.data;

import ca.willatendo.extraitemuses.server.stats.EIUStats;
import ca.willatendo.extraitemuses.server.tags.EIUItemTags;
import net.minecraft.data.PackOutput;
import willatendo.simplelibrary.data.SimpleLanguageProvider;

public class EIULanguageProvider extends SimpleLanguageProvider {
    public EIULanguageProvider(PackOutput packOutput, String modId, String local) {
        super(packOutput, modId, local);
    }

    @Override
    protected void addTranslations() {
        this.add("resourcePack.extraitemuses.description", "Extra Item Uses assets.");

        this.add(EIUItemTags.CHISELING_ITEM, "Chiseling Item");
        this.add(EIUItemTags.CRACKING_ITEM, "Cracking Item");
        this.add(EIUItemTags.GRINDING_ITEM, "Grinding Item");

        this.addStat(EIUStats.BLOCKS_CHISELED, "Blocks Chiseled");
        this.addStat(EIUStats.BLOCKS_CRUSHED, "Blocks Crushed");
        this.addStat(EIUStats.BLOCKS_GROUND, "Blocks Ground");
    }
}
