package willatendo.extraitemuses.server.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import willatendo.extraitemuses.server.jei.category.ChiselablesCategory;
import willatendo.extraitemuses.server.jei.category.CrackablesCategory;
import willatendo.extraitemuses.server.jei.category.GrindablesCategory;
import willatendo.extraitemuses.server.jei.recipe.ExtraItemUsesRecipeManager;

@JeiPlugin
public class ExtraItemUsesJeiPlugin implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return ExtraItemUsesJeiConstants.ID;
	}

	@Override
	public void registerRecipes(IRecipeRegistration recipeRegistration) {
		IJeiHelpers jeiHelpers = recipeRegistration.getJeiHelpers();
		IIngredientManager ingredientManager = recipeRegistration.getIngredientManager();

		recipeRegistration.addRecipes(ExtraItemUsesJeiConstants.CHISELABLES, ExtraItemUsesRecipeManager.getChiselableRecipes(ingredientManager, jeiHelpers));
		recipeRegistration.addRecipes(ExtraItemUsesJeiConstants.CRACKABLES, ExtraItemUsesRecipeManager.getCrackablesRecipes(ingredientManager, jeiHelpers));
		recipeRegistration.addRecipes(ExtraItemUsesJeiConstants.GRINDABLES, ExtraItemUsesRecipeManager.getGrindablesRecipes(ingredientManager, jeiHelpers));
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration recipeCategoryRegistration) {
		IGuiHelper helper = recipeCategoryRegistration.getJeiHelpers().getGuiHelper();

		recipeCategoryRegistration.addRecipeCategories(new ChiselablesCategory(helper));
		recipeCategoryRegistration.addRecipeCategories(new CrackablesCategory(helper));
		recipeCategoryRegistration.addRecipeCategories(new GrindablesCategory(helper));
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration recipeCatalystRegistration) {
		recipeCatalystRegistration.addRecipeCatalyst(Items.STICK.getDefaultInstance(), ExtraItemUsesJeiConstants.CHISELABLES);
		recipeCatalystRegistration.addRecipeCatalyst(Items.DIAMOND_PICKAXE.getDefaultInstance(), ExtraItemUsesJeiConstants.CRACKABLES);
		recipeCatalystRegistration.addRecipeCatalyst(Items.GOLDEN_PICKAXE.getDefaultInstance(), ExtraItemUsesJeiConstants.CRACKABLES);
		recipeCatalystRegistration.addRecipeCatalyst(Items.IRON_PICKAXE.getDefaultInstance(), ExtraItemUsesJeiConstants.CRACKABLES);
		recipeCatalystRegistration.addRecipeCatalyst(Items.NETHERITE_PICKAXE.getDefaultInstance(), ExtraItemUsesJeiConstants.CRACKABLES);
		recipeCatalystRegistration.addRecipeCatalyst(Items.STONE_PICKAXE.getDefaultInstance(), ExtraItemUsesJeiConstants.CRACKABLES);
		recipeCatalystRegistration.addRecipeCatalyst(Items.WOODEN_PICKAXE.getDefaultInstance(), ExtraItemUsesJeiConstants.CRACKABLES);
		recipeCatalystRegistration.addRecipeCatalyst(Items.DIAMOND_SHOVEL.getDefaultInstance(), ExtraItemUsesJeiConstants.GRINDABLES);
		recipeCatalystRegistration.addRecipeCatalyst(Items.GOLDEN_SHOVEL.getDefaultInstance(), ExtraItemUsesJeiConstants.GRINDABLES);
		recipeCatalystRegistration.addRecipeCatalyst(Items.IRON_SHOVEL.getDefaultInstance(), ExtraItemUsesJeiConstants.GRINDABLES);
		recipeCatalystRegistration.addRecipeCatalyst(Items.NETHERITE_SHOVEL.getDefaultInstance(), ExtraItemUsesJeiConstants.GRINDABLES);
		recipeCatalystRegistration.addRecipeCatalyst(Items.STONE_SHOVEL.getDefaultInstance(), ExtraItemUsesJeiConstants.GRINDABLES);
		recipeCatalystRegistration.addRecipeCatalyst(Items.WOODEN_SHOVEL.getDefaultInstance(), ExtraItemUsesJeiConstants.GRINDABLES);
	}
}
