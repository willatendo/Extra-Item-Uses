package extraitemuses.server.events;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import extraitemuses.ExtraItemUsesMod;
import extraitemuses.server.ExtraItemUsesRegistry;
import extraitemuses.server.uses.ChiselablesBlockMap;
import extraitemuses.server.uses.CrackablesBlockMap;
import extraitemuses.server.uses.GrindablesBlockMap;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.loading.FMLEnvironment;

@EventBusSubscriber(bus = Bus.FORGE, modid = ExtraItemUsesMod.ID)
public class DebugCommands {
	@SubscribeEvent
	public static void commandSetup(RegisterCommandsEvent event) {
		if (!FMLEnvironment.production) {
			register(event.getDispatcher());
		}
	}

	private static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("debug.getAllLoaded").executes(new Command<CommandSourceStack>() {
			@Override
			public int run(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
				for (CrackablesBlockMap crackablesBlockMap : ExtraItemUsesRegistry.CRACKABLES.get().getValues()) {
					context.getSource().sendSuccess(Component.literal(ExtraItemUsesRegistry.CRACKABLES.get().getKey(crackablesBlockMap) + " Registered!"), true);
				}
				for (GrindablesBlockMap grindablesBlockMap : ExtraItemUsesRegistry.GRINDABLES.get().getValues()) {
					context.getSource().sendSuccess(Component.literal(ExtraItemUsesRegistry.GRINDABLES.get().getKey(grindablesBlockMap) + " Registered!"), true);
				}
				for (ChiselablesBlockMap chiselablesBlockMap : ExtraItemUsesRegistry.CHISELABLES.get().getValues()) {
					context.getSource().sendSuccess(Component.literal(ExtraItemUsesRegistry.CHISELABLES.get().getKey(chiselablesBlockMap) + " Registered!"), true);
				}

				context.getSource().sendSuccess(Component.literal("Done"), true);
				return 0;
			}
		}));
	}
}
