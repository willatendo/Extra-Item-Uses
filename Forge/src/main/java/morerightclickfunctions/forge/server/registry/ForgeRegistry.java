package morerightclickfunctions.forge.server.registry;

import morerightclickfunctions.MoreRightClickFunctionsMod;
import morerightclickfunctions.server.registry.CommonRegistry;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ForgeRegistry implements CommonRegistry {
    public static final DeferredRegister ITEMS = DeferredRegister.create(ForgeRegistries.Keys.ITEMS, MoreRightClickFunctionsMod.ID);

    @Override
    public Supplier<Item> registerItem(String id, Supplier<Item> item) {
        return ITEMS.register(id, item);
    }
}
