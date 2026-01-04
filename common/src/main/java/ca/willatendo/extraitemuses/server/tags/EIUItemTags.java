package ca.willatendo.extraitemuses.server.tags;

import ca.willatendo.extraitemuses.server.utils.EIUUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import willatendo.simplelibrary.server.util.TagRegister;

public final class EIUItemTags {
    private static final TagRegister<Item> ITEM_TAGS = TagRegister.create(Registries.ITEM, EIUUtils.ID);

    public static final TagKey<Item> CHISELING_ITEM = ITEM_TAGS.register("chiseling_item");
    public static final TagKey<Item> CRACKING_ITEM = ITEM_TAGS.register("cracking_item");
    public static final TagKey<Item> GRINDING_ITEM = ITEM_TAGS.register("grinding_item");
}
