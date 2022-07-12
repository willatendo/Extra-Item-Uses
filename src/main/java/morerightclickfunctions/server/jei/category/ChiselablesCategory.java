package morerightclickfunctions.server.jei.category;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import morerightclickfunctions.server.jei.MoreRightClickFunctionsJeiConstants;
import morerightclickfunctions.server.jei.recipe.ChiselablesRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class ChiselablesCategory implements IRecipeCategory<ChiselablesRecipe> {
	private final IDrawable background;
	private final IDrawable icon;

	public ChiselablesCategory(IGuiHelper guiHelper) {
		this.background = guiHelper.createBlankDrawable(80, 40);
		this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, Items.STICK.getDefaultInstance());
	}

	@Override
	public RecipeType<ChiselablesRecipe> getRecipeType() {
		return MoreRightClickFunctionsJeiConstants.CHISELABLES;
	}

	@Override
	public Component getTitle() {
		return Component.translatable("jei.morerightclickfunctions.chiselables");
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, ChiselablesRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 5, 10).addIngredients(Ingredient.of(recipe.input().asItem()));
		builder.addSlot(RecipeIngredientRole.CATALYST, 32, 10).addIngredients(Ingredient.of(Items.STICK));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 60, 10).addIngredients(Ingredient.of(recipe.output().asItem()));
	}
}
