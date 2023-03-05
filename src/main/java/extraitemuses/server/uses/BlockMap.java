package extraitemuses.server.uses;

import java.util.function.Supplier;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import extraitemuses.ExtraItemUsesMod;
import extraitemuses.api.ExtraItemUsesRegistries;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

public record BlockMap(BlockState input, BlockState output) {

	public static class CrackablesBlockMap {
		public static final Codec<CrackablesBlockMap> CODEC = RecordCodecBuilder.create(builder -> {
			return builder.group(BlockState.CODEC.fieldOf("input").forGetter(blockMap -> {
				return blockMap.getBlockMap().input;
			}), BlockState.CODEC.fieldOf("output").forGetter(blockMap -> {
				return blockMap.getBlockMap().output;
			})).apply(builder, CrackablesBlockMap::new);
		});
		private final BlockMap blockMap;

		public CrackablesBlockMap(BlockState input, BlockState output) {
			this.blockMap = new BlockMap(input, output);
		}

		public BlockMap getBlockMap() {
			return this.blockMap;
		}
	}

	public static class GrindablesBlockMap {
		public static final Codec<GrindablesBlockMap> CODEC = RecordCodecBuilder.create(builder -> {
			return builder.group(BlockState.CODEC.fieldOf("input").forGetter(blockMap -> {
				return blockMap.getBlockMap().input;
			}), BlockState.CODEC.fieldOf("output").forGetter(blockMap -> {
				return blockMap.getBlockMap().output;
			})).apply(builder, GrindablesBlockMap::new);
		});
		private final BlockMap blockMap;

		public GrindablesBlockMap(BlockState input, BlockState output) {
			this.blockMap = new BlockMap(input, output);
		}

		public BlockMap getBlockMap() {
			return this.blockMap;
		}
	}

	public static class ChiselablesBlockMap {
		public static final Codec<ChiselablesBlockMap> CODEC = RecordCodecBuilder.create(builder -> {
			return builder.group(BlockState.CODEC.fieldOf("input").forGetter(blockMap -> {
				return blockMap.getBlockMap().input;
			}), BlockState.CODEC.fieldOf("output").forGetter(blockMap -> {
				return blockMap.getBlockMap().output;
			})).apply(builder, ChiselablesBlockMap::new);
		});
		private final BlockMap blockMap;

		public ChiselablesBlockMap(BlockState input, BlockState output) {
			this.blockMap = new BlockMap(input, output);
		}

		public BlockMap getBlockMap() {
			return this.blockMap;
		}
	}

	public class Register {
		public static final DeferredRegister<CrackablesBlockMap> DEFERRED_CRACKABLES = DeferredRegister.create(ExtraItemUsesRegistries.CRACKABLES, ExtraItemUsesMod.ID);
		public static final Supplier<IForgeRegistry<CrackablesBlockMap>> CRACKABLES = DEFERRED_CRACKABLES.makeRegistry(() -> new RegistryBuilder<CrackablesBlockMap>().setName(ExtraItemUsesMod.resource("crackables")).setMaxID(Integer.MAX_VALUE - 1).disableSync().disableSaving());

		public static final DeferredRegister<GrindablesBlockMap> DEFERRED_GRINDABLES = DeferredRegister.create(ExtraItemUsesRegistries.GRINDABLES, ExtraItemUsesMod.ID);
		public static final Supplier<IForgeRegistry<GrindablesBlockMap>> GRINDABLES = DEFERRED_GRINDABLES.makeRegistry(() -> new RegistryBuilder<GrindablesBlockMap>().setName(ExtraItemUsesMod.resource("grindables")).setMaxID(Integer.MAX_VALUE - 1).disableSync().disableSaving());

		public static final DeferredRegister<ChiselablesBlockMap> DEFERRED_CHISELABLES = DeferredRegister.create(ExtraItemUsesRegistries.CHISELABLES, ExtraItemUsesMod.ID);
		public static final Supplier<IForgeRegistry<ChiselablesBlockMap>> CHISELABLES = DEFERRED_CHISELABLES.makeRegistry(() -> new RegistryBuilder<ChiselablesBlockMap>().setName(ExtraItemUsesMod.resource("chiselables")).setMaxID(Integer.MAX_VALUE - 1).disableSync().disableSaving());
	}
}
