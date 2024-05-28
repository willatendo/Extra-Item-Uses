package willatendo.extraitemuses.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ExtraItemUsesLanguageProvider extends LanguageProvider {
    public ExtraItemUsesLanguageProvider(PackOutput packOutput, String modId, String locale) {
        super(packOutput, modId, locale);
    }

    @Override
    protected void addTranslations() {
        this.add("jei.extraitemuses.chiselables", "Chiselables");
        this.add("jei.extraitemuses.crackables", "Crackables");
        this.add("jei.extraitemuses.grindables", "Grindables");

        this.add("resourcePack.extraitemuses.description", "Extra Item Uses Assets");
    }
}
