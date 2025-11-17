package cc.cassian.wilderflowers.fabric;

//? fabric {
import cc.cassian.wilderflowers.WilderFlowers;
import cc.cassian.wilderflowers.registry.WilderFlowersBlocks;
import cc.cassian.wilderflowers.registry.WilderFlowersItemProperties;
import cc.cassian.wilderflowers.registry.WilderFlowersParticleTypes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTabs;


public class FabricEntrypoint implements ModInitializer {

    @Override
    public void onInitialize() {
        WilderFlowers.init();
        WilderFlowersBlocks.touch();
        WilderFlowersParticleTypes.touch();
        //? if <1.21.2 {
        /*WilderFlowersItemProperties.register();
        *///?}
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register((entries -> {
            WilderFlowersBlocks.WILDFLOWERS.forEach((wildflowerSupplier -> {
                entries.accept(wildflowerSupplier.flowerBed().get());
                if (wildflowerSupplier.garland().isPresent())
                    entries.accept(wildflowerSupplier.garland().get().get());
            }));
        }));
    }

}
//?}