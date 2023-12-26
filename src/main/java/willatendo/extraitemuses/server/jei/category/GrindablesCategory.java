package willatendo.extraitemuses.server.jei.category;

//public class GrindablesCategory implements IRecipeCategory<GrindablesRecipe> {
//	private final IDrawable background;
//	private final IDrawable icon;
//
//	public GrindablesCategory(IGuiHelper guiHelper) {
//		this.background = guiHelper.createBlankDrawable(80, 40);
//		this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, Items.DIAMOND_SHOVEL.getDefaultInstance());
//	}
//
//	@Override
//	public RecipeType<GrindablesRecipe> getRecipeType() {
//		return ExtraItemUsesJeiConstants.GRINDABLES;
//	}
//
//	@Override
//	public Component getTitle() {
//		return ExtraItemUsesUtils.translation("jei", "grindables");
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
//	public void setRecipe(IRecipeLayoutBuilder builder, GrindablesRecipe recipe, IFocusGroup focuses) {
//		builder.addSlot(RecipeIngredientRole.INPUT, 5, 10).addIngredients(Ingredient.of(recipe.input().asItem()));
//		builder.addSlot(RecipeIngredientRole.CATALYST, 32, 10).addIngredients(Ingredient.of(Items.DIAMOND_SHOVEL));
//		builder.addSlot(RecipeIngredientRole.OUTPUT, 60, 10).addIngredients(Ingredient.of(recipe.output().asItem()));
//	}
//}
