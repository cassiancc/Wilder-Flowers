package cc.cassian.wilderflowers.neoforge;

//? neoforge {
/*import cc.cassian.wilderflowers.WilderFlowers;
import cc.cassian.wilderflowers.registry.WilderFlowersBlocks;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

import static cc.cassian.wilderflowers.WilderFlowers.MOD_ID;

@Mod(MOD_ID)
@EventBusSubscriber(modid = MOD_ID)
public class NeoforgeEntrypoint {

    public NeoforgeEntrypoint() {
        WilderFlowers.init();
    }

    @SubscribeEvent
    public static void buildCreativeModeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(Registries.BLOCK)) {
            WilderFlowersBlocks.WILDFLOWERS.forEach((wildflowerSupplier -> {
                event.accept(wildflowerSupplier.flowerBed().get());
                event.accept(wildflowerSupplier.garland().get());
            }));
        }
    }

    @SubscribeEvent
    public static void register(RegisterEvent event) {
        if (event.getRegistryKey().equals(Registries.BLOCK)) {
            WilderFlowersBlocks.touch();
        }
    }


}
*///?}