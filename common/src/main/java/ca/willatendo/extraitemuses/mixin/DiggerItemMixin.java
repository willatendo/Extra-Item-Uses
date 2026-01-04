package ca.willatendo.extraitemuses.mixin;

import ca.willatendo.extraitemuses.server.item.ToolMaterialAccess;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DiggerItem.class)
public class DiggerItemMixin implements ToolMaterialAccess {
    private ToolMaterial toolMaterial;

    @Inject(at = @At("TAIL"), method = "<init>")
    private void eiu_setToolMaterial(ToolMaterial toolMaterial, TagKey<Block> mineableBlocks, float attackDamage, float attackSpeed, Item.Properties properties, CallbackInfo callbackInfo) {
        this.toolMaterial = toolMaterial;
    }

    @Override
    public ToolMaterial getToolMaterial() {
        return this.toolMaterial;
    }
}
