package extraitemuses.server.jei.recipe;

import java.util.ArrayList;
import java.util.List;

import extraitemuses.server.ExtraItemUsesRegistry;
import extraitemuses.server.uses.ChiselablesBlockMap;
import extraitemuses.server.uses.CrackablesBlockMap;
import extraitemuses.server.uses.GrindablesBlockMap;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.runtime.IIngredientManager;

public class MoreRightClickFunctionsRecipeManager {
	public static ArrayList<ChiselablesRecipe> getChiselableRecipes(IIngredientManager ingredientManager, IJeiHelpers helpers) {
		ArrayList<ChiselablesRecipe> recipes = new ArrayList<>();
		for (int i = 0; i < ExtraItemUsesRegistry.CHISELABLES.get().getValues().size(); i++) {
			List<ChiselablesBlockMap> chiselablesBlockMaps = ExtraItemUsesRegistry.CHISELABLES.get().getValues().stream().toList();
			recipes.add(new ChiselablesRecipe(chiselablesBlockMaps.get(i).getBlockMap().getInput().getBlock(), chiselablesBlockMaps.get(i).getBlockMap().getOutput().getBlock()));
		}
		return recipes;
	}

	public static ArrayList<CrackablesRecipe> getCrackablesRecipes(IIngredientManager ingredientManager, IJeiHelpers helpers) {
		ArrayList<CrackablesRecipe> recipes = new ArrayList<>();
		for (int i = 0; i < ExtraItemUsesRegistry.CRACKABLES.get().getValues().size(); i++) {
			List<CrackablesBlockMap> crackablesBlockMaps = ExtraItemUsesRegistry.CRACKABLES.get().getValues().stream().toList();
			recipes.add(new CrackablesRecipe(crackablesBlockMaps.get(i).getBlockMap().getInput().getBlock(), crackablesBlockMaps.get(i).getBlockMap().getOutput().getBlock()));
		}
		return recipes;
	}

	public static ArrayList<GrindablesRecipe> getGrindablesRecipes(IIngredientManager ingredientManager, IJeiHelpers helpers) {
		ArrayList<GrindablesRecipe> recipes = new ArrayList<>();
		for (int i = 0; i < ExtraItemUsesRegistry.GRINDABLES.get().getValues().size(); i++) {
			List<GrindablesBlockMap> grindablesBlockMaps = ExtraItemUsesRegistry.GRINDABLES.get().getValues().stream().toList();
			recipes.add(new GrindablesRecipe(grindablesBlockMaps.get(i).getBlockMap().getInput().getBlock(), grindablesBlockMaps.get(i).getBlockMap().getOutput().getBlock()));
		}
		return recipes;
	}
}
