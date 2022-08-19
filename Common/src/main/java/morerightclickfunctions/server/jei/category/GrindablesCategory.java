package morerightclickfunctions.server.jei.category;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import morerightclickfunctions.server.jei.recipe.GrindablesRecipe;
import morerightclickfunctions.server.jei.MoreRightClickFunctionsJeiConstants;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class GrindablesCategory implements IRecipeCategory<GrindablesRecipe> {
    private final IDrawable background;
    private final IDrawable icon;

    public GrindablesCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createBlankDrawable(80, 40);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, Items.DIAMOND_SHOVEL.getDefaultInstance());
    }

    @Override
    public RecipeType<GrindablesRecipe> getRecipeType() {
        return MoreRightClickFunctionsJeiConstants.GRINDABLES;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.morerightclickfunctions.grindables");
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
    public void setRecipe(IRecipeLayoutBuilder builder, GrindablesRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 5, 10).addIngredients(Ingredient.of(recipe.input().asItem()));
        builder.addSlot(RecipeIngredientRole.CATALYST, 32, 10).addIngredients(Ingredient.of(Items.DIAMOND_SHOVEL));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 60, 10).addIngredients(Ingredient.of(recipe.output().asItem()));
    }
}
