package extraitemuses.server.jei.recipe;

import java.util.ArrayList;
import java.util.List;

import extraitemuses.server.uses.BlockMap;
import extraitemuses.server.uses.BlockMap.ChiselablesBlockMap;
import extraitemuses.server.uses.BlockMap.CrackablesBlockMap;
import extraitemuses.server.uses.BlockMap.GrindablesBlockMap;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.runtime.IIngredientManager;

public class MoreRightClickFunctionsRecipeManager {
	public static ArrayList<ChiselablesRecipe> getChiselableRecipes(IIngredientManager ingredientManager, IJeiHelpers helpers) {
		ArrayList<ChiselablesRecipe> recipes = new ArrayList<>();
		for (int i = 0; i < BlockMap.Register.CHISELABLES.get().getValues().size(); i++) {
			List<ChiselablesBlockMap> chiselablesBlockMaps = BlockMap.Register.CHISELABLES.get().getValues().stream().toList();
			recipes.add(new ChiselablesRecipe(chiselablesBlockMaps.get(i).getBlockMap().input().getBlock(), chiselablesBlockMaps.get(i).getBlockMap().output().getBlock()));
		}
		return recipes;
	}

	public static ArrayList<CrackablesRecipe> getCrackablesRecipes(IIngredientManager ingredientManager, IJeiHelpers helpers) {
		ArrayList<CrackablesRecipe> recipes = new ArrayList<>();
		for (int i = 0; i < BlockMap.Register.CRACKABLES.get().getValues().size(); i++) {
			List<CrackablesBlockMap> crackablesBlockMaps = BlockMap.Register.CRACKABLES.get().getValues().stream().toList();
			recipes.add(new CrackablesRecipe(crackablesBlockMaps.get(i).getBlockMap().input().getBlock(), crackablesBlockMaps.get(i).getBlockMap().output().getBlock()));
		}
		return recipes;
	}

	public static ArrayList<GrindablesRecipe> getGrindablesRecipes(IIngredientManager ingredientManager, IJeiHelpers helpers) {
		ArrayList<GrindablesRecipe> recipes = new ArrayList<>();
		for (int i = 0; i < BlockMap.Register.GRINDABLES.get().getValues().size(); i++) {
			List<GrindablesBlockMap> grindablesBlockMaps = BlockMap.Register.GRINDABLES.get().getValues().stream().toList();
			recipes.add(new GrindablesRecipe(grindablesBlockMaps.get(i).getBlockMap().input().getBlock(), grindablesBlockMaps.get(i).getBlockMap().output().getBlock()));
		}
		return recipes;
	}
}
