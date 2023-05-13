package extraitemuses.server.events;

import java.util.List;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import extraitemuses.ExtraItemUsesMod;
import extraitemuses.server.ExtraItemUsesMaps;
import extraitemuses.server.uses.BlockMap;
import extraitemuses.server.uses.BlockMap.ChiselablesBlockMap;
import extraitemuses.server.uses.BlockMap.CrackablesBlockMap;
import extraitemuses.server.uses.BlockMap.GrindablesBlockMap;
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
				for (CrackablesBlockMap crackablesBlockMap : BlockMap.Register.CRACKABLES.get().getValues()) {
					context.getSource().sendSuccess(Component.literal(BlockMap.Register.CRACKABLES.get().getKey(crackablesBlockMap) + " Registered!"), true);
				}
				for (GrindablesBlockMap grindablesBlockMap : BlockMap.Register.GRINDABLES.get().getValues()) {
					context.getSource().sendSuccess(Component.literal(BlockMap.Register.GRINDABLES.get().getKey(grindablesBlockMap) + " Registered!"), true);
				}
				for (ChiselablesBlockMap chiselablesBlockMap : BlockMap.Register.CHISELABLES.get().getValues()) {
					context.getSource().sendSuccess(Component.literal(BlockMap.Register.CHISELABLES.get().getKey(chiselablesBlockMap) + " Registered!"), true);
				}

				context.getSource().sendSuccess(Component.literal("Done"), true);
				return 0;
			}
		}));
		dispatcher.register(Commands.literal("debug.reloadmaps").executes(new Command<CommandSourceStack>() {
			@Override
			public int run(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
				for (int i = 0; i < BlockMap.Register.CRACKABLES.get().getValues().size(); i++) {
					List<CrackablesBlockMap> crackablesBlockMaps = BlockMap.Register.CRACKABLES.get().getValues().stream().toList();
					ExtraItemUsesMaps.CRACKABLES.put(crackablesBlockMaps.get(i).getBlockMap().input().getBlock(), crackablesBlockMaps.get(i).getBlockMap().output().getBlock());
					context.getSource().sendSuccess(Component.literal("Done"), true);
				}

				for (int i = 0; i < BlockMap.Register.GRINDABLES.get().getValues().size(); i++) {
					List<GrindablesBlockMap> grindablesBlockMaps = BlockMap.Register.GRINDABLES.get().getValues().stream().toList();
					ExtraItemUsesMaps.GRINDABLES.put(grindablesBlockMaps.get(i).getBlockMap().input().getBlock(), grindablesBlockMaps.get(i).getBlockMap().output().getBlock());
					context.getSource().sendSuccess(Component.literal("Done"), true);
				}

				for (int i = 0; i < BlockMap.Register.CHISELABLES.get().getValues().size(); i++) {
					List<ChiselablesBlockMap> chiselablesBlockMaps = BlockMap.Register.CHISELABLES.get().getValues().stream().toList();
					ExtraItemUsesMaps.CHISELABLES.put(chiselablesBlockMaps.get(i).getBlockMap().input().getBlock(), chiselablesBlockMaps.get(i).getBlockMap().output().getBlock());
					context.getSource().sendSuccess(Component.literal("Done"), true);
				}

				context.getSource().sendSuccess(Component.literal("Done"), true);
				return 0;
			}
		}));
	}
}
