package morerightclickfunctions.server.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import morerightclickfunctions.server.jei.category.ChiselablesCategory;
import morerightclickfunctions.server.jei.category.CrackablesCategory;
import morerightclickfunctions.server.jei.category.GrindablesCategory;
import morerightclickfunctions.server.jei.category.ReapablesCategory;
import morerightclickfunctions.server.jei.recipe.MoreRightClickFunctionsRecipeManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

@JeiPlugin
public class MoreRightClickFunctionsJeiPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return MoreRightClickFunctionsJeiConstants.MORE_RIGHT_CLICK_FUNCTIONS_PLUGIN;
    }

    @Override
    public void registerRecipes(IRecipeRegistration recipeRegistration) {
        IJeiHelpers jeiHelpers = recipeRegistration.getJeiHelpers();
        IIngredientManager ingredientManager = recipeRegistration.getIngredientManager();

        recipeRegistration.addRecipes(MoreRightClickFunctionsJeiConstants.CHISELABLES, MoreRightClickFunctionsRecipeManager.getChiselableRecipes(ingredientManager, jeiHelpers));
        recipeRegistration.addRecipes(MoreRightClickFunctionsJeiConstants.CRACKABLES, MoreRightClickFunctionsRecipeManager.getCrackablesRecipes(ingredientManager, jeiHelpers));
        recipeRegistration.addRecipes(MoreRightClickFunctionsJeiConstants.GRINDABLES, MoreRightClickFunctionsRecipeManager.getGrindablesRecipes(ingredientManager, jeiHelpers));
        recipeRegistration.addRecipes(MoreRightClickFunctionsJeiConstants.REAPABLES, MoreRightClickFunctionsRecipeManager.getReapablesRecipes(ingredientManager, jeiHelpers));
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration recipeCategoryRegistration) {
        IGuiHelper helper = recipeCategoryRegistration.getJeiHelpers().getGuiHelper();

        recipeCategoryRegistration.addRecipeCategories(new ChiselablesCategory(helper));
        recipeCategoryRegistration.addRecipeCategories(new CrackablesCategory(helper));
        recipeCategoryRegistration.addRecipeCategories(new GrindablesCategory(helper));
        recipeCategoryRegistration.addRecipeCategories(new ReapablesCategory(helper));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration recipeCatalystRegistration) {
        recipeCatalystRegistration.addRecipeCatalyst(Items.STICK.getDefaultInstance(), MoreRightClickFunctionsJeiConstants.CHISELABLES);
        recipeCatalystRegistration.addRecipeCatalyst(Items.DIAMOND_PICKAXE.getDefaultInstance(), MoreRightClickFunctionsJeiConstants.CRACKABLES);
        recipeCatalystRegistration.addRecipeCatalyst(Items.GOLDEN_PICKAXE.getDefaultInstance(), MoreRightClickFunctionsJeiConstants.CRACKABLES);
        recipeCatalystRegistration.addRecipeCatalyst(Items.IRON_PICKAXE.getDefaultInstance(), MoreRightClickFunctionsJeiConstants.CRACKABLES);
        recipeCatalystRegistration.addRecipeCatalyst(Items.NETHERITE_PICKAXE.getDefaultInstance(), MoreRightClickFunctionsJeiConstants.CRACKABLES);
        recipeCatalystRegistration.addRecipeCatalyst(Items.STONE_PICKAXE.getDefaultInstance(), MoreRightClickFunctionsJeiConstants.CRACKABLES);
        recipeCatalystRegistration.addRecipeCatalyst(Items.WOODEN_PICKAXE.getDefaultInstance(), MoreRightClickFunctionsJeiConstants.CRACKABLES);
        recipeCatalystRegistration.addRecipeCatalyst(Items.DIAMOND_SHOVEL.getDefaultInstance(), MoreRightClickFunctionsJeiConstants.GRINDABLES);
        recipeCatalystRegistration.addRecipeCatalyst(Items.GOLDEN_SHOVEL.getDefaultInstance(), MoreRightClickFunctionsJeiConstants.GRINDABLES);
        recipeCatalystRegistration.addRecipeCatalyst(Items.IRON_SHOVEL.getDefaultInstance(), MoreRightClickFunctionsJeiConstants.GRINDABLES);
        recipeCatalystRegistration.addRecipeCatalyst(Items.NETHERITE_SHOVEL.getDefaultInstance(), MoreRightClickFunctionsJeiConstants.GRINDABLES);
        recipeCatalystRegistration.addRecipeCatalyst(Items.STONE_SHOVEL.getDefaultInstance(), MoreRightClickFunctionsJeiConstants.GRINDABLES);
        recipeCatalystRegistration.addRecipeCatalyst(Items.WOODEN_SHOVEL.getDefaultInstance(), MoreRightClickFunctionsJeiConstants.GRINDABLES);
        recipeCatalystRegistration.addRecipeCatalyst(Items.DIAMOND_HOE.getDefaultInstance(), MoreRightClickFunctionsJeiConstants.REAPABLES);
        recipeCatalystRegistration.addRecipeCatalyst(Items.GOLDEN_HOE.getDefaultInstance(), MoreRightClickFunctionsJeiConstants.REAPABLES);
        recipeCatalystRegistration.addRecipeCatalyst(Items.IRON_HOE.getDefaultInstance(), MoreRightClickFunctionsJeiConstants.REAPABLES);
        recipeCatalystRegistration.addRecipeCatalyst(Items.NETHERITE_HOE.getDefaultInstance(), MoreRightClickFunctionsJeiConstants.REAPABLES);
        recipeCatalystRegistration.addRecipeCatalyst(Items.STONE_HOE.getDefaultInstance(), MoreRightClickFunctionsJeiConstants.REAPABLES);
        recipeCatalystRegistration.addRecipeCatalyst(Items.WOODEN_HOE.getDefaultInstance(), MoreRightClickFunctionsJeiConstants.REAPABLES);
    }
}
