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
import net.minecraft.world.item.ItemStack;
import willatendo.extraitemuses.server.item.ExtraItemUsesItemTags;
import willatendo.extraitemuses.server.jei.category.ChiselablesCategory;
import willatendo.extraitemuses.server.jei.category.CrackablesCategory;
import willatendo.extraitemuses.server.jei.category.GrindablesCategory;
import willatendo.extraitemuses.server.jei.recipe.ExtraItemUsesRecipeManager;

import java.util.Collection;

@JeiPlugin
public class ExtraItemUsesJEI implements IModPlugin {
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
        Collection<ItemStack> itemStacks = recipeCatalystRegistration.getIngredientManager().getAllItemStacks();
        itemStacks.forEach(itemStack -> {
            if (itemStack.is(ExtraItemUsesItemTags.CRACKABLE_ITEMS)) {
                recipeCatalystRegistration.addRecipeCatalyst(itemStack, ExtraItemUsesJeiConstants.CRACKABLES);
            }
            if (itemStack.is(ExtraItemUsesItemTags.GRINDABLES_ITEMS)) {
                recipeCatalystRegistration.addRecipeCatalyst(itemStack, ExtraItemUsesJeiConstants.GRINDABLES);
            }
            if (itemStack.is(ExtraItemUsesItemTags.CHISELABLES_ITEMS)) {
                recipeCatalystRegistration.addRecipeCatalyst(itemStack, ExtraItemUsesJeiConstants.CHISELABLES);
            }
        });
    }
}
