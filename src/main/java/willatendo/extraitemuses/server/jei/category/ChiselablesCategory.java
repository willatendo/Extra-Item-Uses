package willatendo.extraitemuses.server.jei.category;

//public class ChiselablesCategory implements IRecipeCategory<ChiselablesRecipe> {
//	private final IDrawable background;
//	private final IDrawable icon;
//
//	public ChiselablesCategory(IGuiHelper guiHelper) {
//		this.background = guiHelper.createBlankDrawable(80, 40);
//		this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, Items.STICK.getDefaultInstance());
//	}
//
//	@Override
//	public RecipeType<ChiselablesRecipe> getRecipeType() {
//		return ExtraItemUsesJeiConstants.CHISELABLES;
//	}
//
//	@Override
//	public Component getTitle() {
//		return ExtraItemUsesUtils.translation("jei", "chiselables");
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
//	public void setRecipe(IRecipeLayoutBuilder builder, ChiselablesRecipe recipe, IFocusGroup focuses) {
//		builder.addSlot(RecipeIngredientRole.INPUT, 5, 10).addIngredients(Ingredient.of(recipe.input().asItem()));
//		builder.addSlot(RecipeIngredientRole.CATALYST, 32, 10).addIngredients(Ingredient.of(Items.STICK));
//		builder.addSlot(RecipeIngredientRole.OUTPUT, 60, 10).addIngredients(Ingredient.of(recipe.output().asItem()));
//	}
//}
