package extraitemuses.server.jei.recipe;

import java.util.ArrayList;
import java.util.List;

import extraitemuses.server.uses.CrackablesBlockMap;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.runtime.IIngredientManager;

public class MoreRightClickFunctionsRecipeManager {
	public static ArrayList<ChiselablesRecipe> getChiselableRecipes(IIngredientManager ingredientManager, IJeiHelpers helpers) {
		ArrayList<ChiselablesRecipe> recipes = new ArrayList<>();
//		for (int i = 0; i < CrackablesBlockMap.Register.CRACKABLES.get().getValues().size(); i++) {
//			List<CrackablesBlockMap> crackablesBlockMaps = CrackablesBlockMap.Register.CRACKABLES.get().getValues().stream().toList();
//			recipes.add(new ChiselablesRecipe(crackablesBlockMaps.get(i).input().getBlock(), crackablesBlockMaps.get(i).output().getBlock()));
//		}
		return recipes;
	}

	public static ArrayList<CrackablesRecipe> getCrackablesRecipes(IIngredientManager ingredientManager, IJeiHelpers helpers) {
		ArrayList<CrackablesRecipe> recipes = new ArrayList<>();
		for (int i = 0; i < CrackablesBlockMap.Register.CRACKABLES.get().getValues().size(); i++) {
			List<CrackablesBlockMap> crackablesBlockMaps = CrackablesBlockMap.Register.CRACKABLES.get().getValues().stream().toList();
			recipes.add(new CrackablesRecipe(crackablesBlockMaps.get(i).input().getBlock(), crackablesBlockMaps.get(i).output().getBlock()));
		}
		return recipes;
	}

	public static ArrayList<GrindablesRecipe> getGrindablesRecipes(IIngredientManager ingredientManager, IJeiHelpers helpers) {
		ArrayList<GrindablesRecipe> recipes = new ArrayList<>();
//		for (int i = 0; i < ExtraItemUsesMaps.GRINDABLES.build().size(); i++) {
//			recipes.add(new GrindablesRecipe(ExtraItemUsesMaps.GRINDABLES.build().entrySet().stream().toList().get(i).getKey(), ExtraItemUsesMaps.GRINDABLES.build().entrySet().stream().toList().get(i).getValue()));
//		}
		return recipes;
	}
}
