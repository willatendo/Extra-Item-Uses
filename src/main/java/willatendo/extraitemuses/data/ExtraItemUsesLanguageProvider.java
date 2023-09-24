package willatendo.extraitemuses.data;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ExtraItemUsesLanguageProvider extends LanguageProvider {
	public ExtraItemUsesLanguageProvider(PackOutput packOutput, String modid, String locale) {
		super(packOutput, modid, locale);
	}

	@Override
	protected void addTranslations() {
		this.add("jei.extraitemuses.chiselables", "Chiselables");
		this.add("jei.extraitemuses.crackables", "Crackables");
		this.add("jei.extraitemuses.grindables", "Grindables");
	}
}
