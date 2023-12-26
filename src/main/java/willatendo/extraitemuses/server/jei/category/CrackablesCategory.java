package willatendo.extraitemuses.server.jei.category;

//public class CrackablesCategory implements IRecipeCategory<CrackablesRecipe> {
//	private final IDrawable background;
//	private final IDrawable icon;
//
//	public CrackablesCategory(IGuiHelper guiHelper) {
//		this.background = guiHelper.createBlankDrawable(80, 40);
//		this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, Items.DIAMOND_PICKAXE.getDefaultInstance());
//	}
//
//	@Override
//	public RecipeType<CrackablesRecipe> getRecipeType() {
//		return ExtraItemUsesJeiConstants.CRACKABLES;
//	}
//
//	@Override
//	public Component getTitle() {
//		return ExtraItemUsesUtils.translation("jei", "crackables");
//	}
//
//	@Override
//	public IDrawable getBackground() {
//		return this.background;
//	}
//
//	@Override
//	public IDrawable getIcon() {
//		return this.icon;
//	}
//
//	@Override
//	public void setRecipe(IRecipeLayoutBuilder builder, CrackablesRecipe recipe, IFocusGroup focuses) {
//		builder.addSlot(RecipeIngredientRole.INPUT, 5, 10).addIngredients(Ingredient.of(recipe.input().asItem()));
//		builder.addSlot(RecipeIngredientRole.CATALYST, 32, 10).addIngredients(Ingredient.of(Items.DIAMOND_PICKAXE));
//		builder.addSlot(RecipeIngredientRole.OUTPUT, 60, 10).addIngredients(Ingredient.of(recipe.output().asItem()));
//	}
//}
