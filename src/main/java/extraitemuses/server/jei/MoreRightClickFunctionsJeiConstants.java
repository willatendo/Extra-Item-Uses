package extraitemuses.server.jei;

import extraitemuses.ExtraItemUsesMod;
import extraitemuses.server.jei.recipe.ChiselablesRecipe;
import extraitemuses.server.jei.recipe.CrackablesRecipe;
import extraitemuses.server.jei.recipe.GrindablesRecipe;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.resources.ResourceLocation;

public class MoreRightClickFunctionsJeiConstants {
	public static final ResourceLocation ID = ExtraItemUsesMod.resource("extra_item_uses");

	public static final RecipeType CHISELABLES = RecipeType.create(ExtraItemUsesMod.ID, "chiselables_category", ChiselablesRecipe.class);
	public static final RecipeType CRACKABLES = RecipeType.create(ExtraItemUsesMod.ID, "crackables_category", CrackablesRecipe.class);
	public static final RecipeType GRINDABLES = RecipeType.create(ExtraItemUsesMod.ID, "grindables_category", GrindablesRecipe.class);
}
