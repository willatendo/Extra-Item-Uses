package willatendo.extraitemuses.server.jei;

//@JeiPlugin
//public class ExtraItemUsesJeiPlugin implements IModPlugin {
//	@Override
//	public ResourceLocation getPluginUid() {
//		return ExtraItemUsesJeiConstants.ID;
//	}
//
//	@Override
//	public void registerRecipes(IRecipeRegistration recipeRegistration) {
//		IJeiHelpers jeiHelpers = recipeRegistration.getJeiHelpers();
//		IIngredientManager ingredientManager = recipeRegistration.getIngredientManager();
//
//		recipeRegistration.addRecipes(ExtraItemUsesJeiConstants.CHISELABLES, ExtraItemUsesRecipeManager.getChiselableRecipes(ingredientManager, jeiHelpers));
//		recipeRegistration.addRecipes(ExtraItemUsesJeiConstants.CRACKABLES, ExtraItemUsesRecipeManager.getCrackablesRecipes(ingredientManager, jeiHelpers));
//		recipeRegistration.addRecipes(ExtraItemUsesJeiConstants.GRINDABLES, ExtraItemUsesRecipeManager.getGrindablesRecipes(ingredientManager, jeiHelpers));
//	}
//
//	@Override
//	public void registerCategories(IRecipeCategoryRegistration recipeCategoryRegistration) {
//		IGuiHelper helper = recipeCategoryRegistration.getJeiHelpers().getGuiHelper();
//
//		recipeCategoryRegistration.addRecipeCategories(new ChiselablesCategory(helper));
//		recipeCategoryRegistration.addRecipeCategories(new CrackablesCategory(helper));
//		recipeCategoryRegistration.addRecipeCategories(new GrindablesCategory(helper));
//	}
//
//	@Override
//	public void registerRecipeCatalysts(IRecipeCatalystRegistration recipeCatalystRegistration) {
//		recipeCatalystRegistration.addRecipeCatalyst(Items.STICK.getDefaultInstance(), ExtraItemUsesJeiConstants.CHISELABLES);
//		recipeCatalystRegistration.addRecipeCatalyst(Items.DIAMOND_PICKAXE.getDefaultInstance(), ExtraItemUsesJeiConstants.CRACKABLES);
//		recipeCatalystRegistration.addRecipeCatalyst(Items.GOLDEN_PICKAXE.getDefaultInstance(), ExtraItemUsesJeiConstants.CRACKABLES);
//		recipeCatalystRegistration.addRecipeCatalyst(Items.IRON_PICKAXE.getDefaultInstance(), ExtraItemUsesJeiConstants.CRACKABLES);
//		recipeCatalystRegistration.addRecipeCatalyst(Items.NETHERITE_PICKAXE.getDefaultInstance(), ExtraItemUsesJeiConstants.CRACKABLES);
//		recipeCatalystRegistration.addRecipeCatalyst(Items.STONE_PICKAXE.getDefaultInstance(), ExtraItemUsesJeiConstants.CRACKABLES);
//		recipeCatalystRegistration.addRecipeCatalyst(Items.WOODEN_PICKAXE.getDefaultInstance(), ExtraItemUsesJeiConstants.CRACKABLES);
//		recipeCatalystRegistration.addRecipeCatalyst(Items.DIAMOND_SHOVEL.getDefaultInstance(), ExtraItemUsesJeiConstants.GRINDABLES);
//		recipeCatalystRegistration.addRecipeCatalyst(Items.GOLDEN_SHOVEL.getDefaultInstance(), ExtraItemUsesJeiConstants.GRINDABLES);
//		recipeCatalystRegistration.addRecipeCatalyst(Items.IRON_SHOVEL.getDefaultInstance(), ExtraItemUsesJeiConstants.GRINDABLES);
//		recipeCatalystRegistration.addRecipeCatalyst(Items.NETHERITE_SHOVEL.getDefaultInstance(), ExtraItemUsesJeiConstants.GRINDABLES);
//		recipeCatalystRegistration.addRecipeCatalyst(Items.STONE_SHOVEL.getDefaultInstance(), ExtraItemUsesJeiConstants.GRINDABLES);
//		recipeCatalystRegistration.addRecipeCatalyst(Items.WOODEN_SHOVEL.getDefaultInstance(), ExtraItemUsesJeiConstants.GRINDABLES);
//	}
//}
