package morerightclickfunctions.server.jei.recipe;

import java.util.ArrayList;

import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.runtime.IIngredientManager;
import morerightclickfunctions.server.MoreRightClickFunctionsMaps;

public class MoreRightClickFunctionsRecipeManager {
	public static ArrayList<ChiselablesRecipe> getChiselableRecipes(IIngredientManager ingredientManager, IJeiHelpers helpers) {
		ArrayList<ChiselablesRecipe> recipes = new ArrayList<>();
		for (int i = 0; i < MoreRightClickFunctionsMaps.CHISELABLES.build().size(); i++) {
			recipes.add(new ChiselablesRecipe(MoreRightClickFunctionsMaps.CHISELABLES.build().entrySet().stream().toList().get(i).getKey(), MoreRightClickFunctionsMaps.CHISELABLES.build().entrySet().stream().toList().get(i).getValue()));
		}
		return recipes;
	}

	public static ArrayList<CrackablesRecipe> getCrackablesRecipes(IIngredientManager ingredientManager, IJeiHelpers helpers) {
		ArrayList<CrackablesRecipe> recipes = new ArrayList<>();
		for (int i = 0; i < MoreRightClickFunctionsMaps.CRACKABLES.build().size(); i++) {
			recipes.add(new CrackablesRecipe(MoreRightClickFunctionsMaps.CRACKABLES.build().entrySet().stream().toList().get(i).getKey(), MoreRightClickFunctionsMaps.CRACKABLES.build().entrySet().stream().toList().get(i).getValue()));
		}
		return recipes;
	}

	public static ArrayList<GrindablesRecipe> getGrindablesRecipes(IIngredientManager ingredientManager, IJeiHelpers helpers) {
		ArrayList<GrindablesRecipe> recipes = new ArrayList<>();
		for (int i = 0; i < MoreRightClickFunctionsMaps.GRINDABLES.build().size(); i++) {
			recipes.add(new GrindablesRecipe(MoreRightClickFunctionsMaps.GRINDABLES.build().entrySet().stream().toList().get(i).getKey(), MoreRightClickFunctionsMaps.GRINDABLES.build().entrySet().stream().toList().get(i).getValue()));
		}
		return recipes;
	}
}
