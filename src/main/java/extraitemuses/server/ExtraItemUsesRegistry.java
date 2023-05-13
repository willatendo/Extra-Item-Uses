package extraitemuses.server;

import java.util.function.Supplier;

import extraitemuses.ExtraItemUsesMod;
import extraitemuses.api.ExtraItemUsesRegistries;
import extraitemuses.server.uses.ChiselablesBlockMap;
import extraitemuses.server.uses.CrackablesBlockMap;
import extraitemuses.server.uses.GrindablesBlockMap;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

public class ExtraItemUsesRegistry {
	public static final DeferredRegister<CrackablesBlockMap> DEFERRED_CRACKABLES = DeferredRegister.create(ExtraItemUsesRegistries.CRACKABLES, ExtraItemUsesMod.ID);
	public static final Supplier<IForgeRegistry<CrackablesBlockMap>> CRACKABLES = DEFERRED_CRACKABLES.makeRegistry(() -> new RegistryBuilder<CrackablesBlockMap>().setMaxID(Integer.MAX_VALUE - 1).disableSync().disableSaving());

	public static final DeferredRegister<GrindablesBlockMap> DEFERRED_GRINDABLES = DeferredRegister.create(ExtraItemUsesRegistries.GRINDABLES, ExtraItemUsesMod.ID);
	public static final Supplier<IForgeRegistry<GrindablesBlockMap>> GRINDABLES = DEFERRED_GRINDABLES.makeRegistry(() -> new RegistryBuilder<GrindablesBlockMap>().setMaxID(Integer.MAX_VALUE - 1).disableSync().disableSaving());

	public static final DeferredRegister<ChiselablesBlockMap> DEFERRED_CHISELABLES = DeferredRegister.create(ExtraItemUsesRegistries.CHISELABLES, ExtraItemUsesMod.ID);
	public static final Supplier<IForgeRegistry<ChiselablesBlockMap>> CHISELABLES = DEFERRED_CHISELABLES.makeRegistry(() -> new RegistryBuilder<ChiselablesBlockMap>().setMaxID(Integer.MAX_VALUE - 1).disableSync().disableSaving());
}