package morerightclickfunctions.server.jei.category;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import morerightclickfunctions.server.jei.JEIItems;
import morerightclickfunctions.server.jei.MoreRightClickFunctionsJeiConstants;
import morerightclickfunctions.server.jei.recipe.ReapablesRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class ReapablesCategory implements IRecipeCategory<ReapablesRecipe> {
    private final IDrawable background;
    private final IDrawable icon;

    public ReapablesCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createBlankDrawable(80, 40);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, Items.DIAMOND_HOE.getDefaultInstance());
    }

    @Override
    public RecipeType<ReapablesRecipe> getRecipeType() {
        return MoreRightClickFunctionsJeiConstants.REAPABLES;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.morerightclickfunctions.reapables");
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
    public void setRecipe(IRecipeLayoutBuilder builder, ReapablesRecipe recipe, IFocusGroup focuses) {
        Item input = recipe.input().asItem();
        if (input == Items.WHEAT_SEEDS) {
            builder.addSlot(RecipeIngredientRole.INPUT, 5, 10).addIngredients(Ingredient.of(JEIItems.WHEAT.get()));
        }
        if (input == Items.POTATO) {
            builder.addSlot(RecipeIngredientRole.INPUT, 5, 10).addIngredients(Ingredient.of(JEIItems.POTATOES.get()));
        }
        if (input == Items.CARROT) {
            builder.addSlot(RecipeIngredientRole.INPUT, 5, 10).addIngredients(Ingredient.of(JEIItems.CARROTS.get()));
        }
        if (input == Items.BEETROOT_SEEDS) {
            builder.addSlot(RecipeIngredientRole.INPUT, 5, 10).addIngredients(Ingredient.of(JEIItems.BEETROOTS.get()));
        }
        builder.addSlot(RecipeIngredientRole.CATALYST, 32, 10).addIngredients(Ingredient.of(Items.DIAMOND_HOE));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 60, 10).addIngredients(Ingredient.of(recipe.output()));
    }
}
