package ca.willatendo.extraitemuses.server.event;

import ca.willatendo.extraitemuses.network.ClientboundPacketRegistry;
import ca.willatendo.extraitemuses.server.utils.EIUUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;
import willatendo.simplelibrary.server.event.registry.NeoforgeDynamicRegistryRegister;
import willatendo.simplelibrary.server.event.registry.NeoforgePacketRegister;

@EventBusSubscriber(modid = EIUUtils.ID)
public final class ModEvents {
    @SubscribeEvent
    public static void registerPayloadHandlersEvent(RegisterPayloadHandlersEvent event) {
        NeoforgePacketRegister neoforgePacketRegister = new NeoforgePacketRegister(event, EIUUtils.ID, "1.0.0");
        ClientboundPacketRegistry.clientboundPacketSetup(neoforgePacketRegister);
    }

    @SubscribeEvent
    public static void playerInteractEvent_RightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos blockPos = event.getPos();
        if (BasicEvents.interactAt(event.getItemStack(), event.getEntity(), level, level.getBlockState(blockPos), blockPos, event.getFace(), event.getHand()) != InteractionResult.PASS) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void dataPackRegistryEvent_NewRegistry(DataPackRegistryEvent.NewRegistry event) {
        BasicEvents.dynamicRegistryEvent(new NeoforgeDynamicRegistryRegister(event));
    }
}
