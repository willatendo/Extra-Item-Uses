package willatendo.extraitemuses.server.jei;

import mezz.jei.api.recipe.RecipeType;
import net.minecraft.resources.ResourceLocation;
import willatendo.extraitemuses.server.jei.recipe.ChiselablesRecipe;
import willatendo.extraitemuses.server.jei.recipe.CrackablesRecipe;
import willatendo.extraitemuses.server.jei.recipe.GrindablesRecipe;
import willatendo.extraitemuses.server.util.ExtraItemUsesUtils;

public class ExtraItemUsesJeiConstants {
    public static final ResourceLocation ID = ExtraItemUsesUtils.resource("extra_item_uses");

    public static final RecipeType CHISELABLES = RecipeType.create(ExtraItemUsesUtils.ID, "chiselables_category", ChiselablesRecipe.class);
    public static final RecipeType CRACKABLES = RecipeType.create(ExtraItemUsesUtils.ID, "crackables_category", CrackablesRecipe.class);
    public static final RecipeType GRINDABLES = RecipeType.create(ExtraItemUsesUtils.ID, "grindables_category", GrindablesRecipe.class);
}
