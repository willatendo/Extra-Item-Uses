package morerightclickfunctions.server.registry;

import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public interface CommonRegistry {
    Supplier<Item> registerItem(String id, Supplier<Item> item);
}
