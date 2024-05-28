package willatendo.extraitemuses.server.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import willatendo.extraitemuses.server.util.ExtraItemUsesUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class ExtraItemUsesItemTags {
    public static final TagRegister<Item> ITEM_TAGS = TagRegister.create(Registries.ITEM, ExtraItemUsesUtils.ID);

    public static final TagKey<Item> CRACKABLE_ITEMS = ITEM_TAGS.register("crackable_items");
    public static final TagKey<Item> GRINDABLES_ITEMS = ITEM_TAGS.register("grindables_items");
    public static final TagKey<Item> CHISELABLES_ITEMS = ITEM_TAGS.register("chiselables_items");
}
