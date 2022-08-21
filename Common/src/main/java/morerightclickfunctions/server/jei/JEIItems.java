package morerightclickfunctions.server.jei;

import morerightclickfunctions.MoreRightClickFunctionsMod;
import morerightclickfunctions.server.registry.CommonRegistry;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class JEIItems {
    private static CommonRegistry commonRegistry = MoreRightClickFunctionsMod.commonRegistry;
    public static final Supplier<Item> WHEAT = commonRegistry.registerItem("wheat", () -> new Item(new Item.Properties()) {
        @Override
        public void fillItemCategory(CreativeModeTab $$0, NonNullList<ItemStack> $$1) {
        }
    });

    public static final Supplier<Item> CARROTS = commonRegistry.registerItem("carrots", () -> new Item(new Item.Properties()) {
        @Override
        public void fillItemCategory(CreativeModeTab $$0, NonNullList<ItemStack> $$1) {
        }
    });

    public static final Supplier<Item> POTATOES = commonRegistry.registerItem("potatoes", () -> new Item(new Item.Properties()) {
        @Override
        public void fillItemCategory(CreativeModeTab $$0, NonNullList<ItemStack> $$1) {
        }
    });

    public static final Supplier<Item> BEETROOTS = commonRegistry.registerItem("beetroots", () -> new Item(new Item.Properties()) {
        @Override
        public void fillItemCategory(CreativeModeTab $$0, NonNullList<ItemStack> $$1) {
        }
    });
}
