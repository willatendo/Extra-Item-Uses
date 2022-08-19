package morerightclickfunctions.forge.server.jei;

import mezz.jei.api.recipe.RecipeType;
import morerightclickfunctions.MoreRightClickFunctionsMod;
import morerightclickfunctions.forge.server.jei.recipe.ChiselablesRecipe;
import morerightclickfunctions.forge.server.jei.recipe.CrackablesRecipe;
import morerightclickfunctions.forge.server.jei.recipe.GrindablesRecipe;
import net.minecraft.resources.ResourceLocation;

public class MoreRightClickFunctionsJeiConstants {
    public static final ResourceLocation MORE_RIGHT_CLICK_FUNCTIONS_PLUGIN = MoreRightClickFunctionsMod.rL("more_right_click_functions_plugin");

    public static final RecipeType CHISELABLES = RecipeType.create(MoreRightClickFunctionsMod.ID, "chiselables_category", ChiselablesRecipe.class);
    public static final RecipeType CRACKABLES = RecipeType.create(MoreRightClickFunctionsMod.ID, "crackables_category", CrackablesRecipe.class);
    public static final RecipeType GRINDABLES = RecipeType.create(MoreRightClickFunctionsMod.ID, "grindables_category", GrindablesRecipe.class);
}
