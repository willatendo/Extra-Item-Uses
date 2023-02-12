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

public record CrackablesBlockMap(BlockState input, BlockState output) {

	public static final Codec<CrackablesBlockMap> CODEC = RecordCodecBuilder.create(builder -> {
		return builder.group(BlockState.CODEC.fieldOf("input").forGetter(crackablesBlockMap -> {
			return crackablesBlockMap.input;
		}), BlockState.CODEC.fieldOf("output").forGetter(crackablesBlockMap -> {
			return crackablesBlockMap.output;
		})).apply(builder, CrackablesBlockMap::new);
	});

	public class Register {
		public static final DeferredRegister<CrackablesBlockMap> DEFERRED_CRACKABLES = DeferredRegister.create(ExtraItemUsesRegistries.CRACKABLES, ExtraItemUsesMod.ID);
		public static final Supplier<IForgeRegistry<CrackablesBlockMap>> CRACKABLES = DEFERRED_CRACKABLES.makeRegistry(() -> new RegistryBuilder<CrackablesBlockMap>().setName(ExtraItemUsesMod.resource("crackables")).setMaxID(Integer.MAX_VALUE - 1));
	}
}
