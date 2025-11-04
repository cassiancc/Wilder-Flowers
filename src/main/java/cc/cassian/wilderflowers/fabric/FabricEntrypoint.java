package cc.cassian.wilderflowers.fabric;

//? fabric {
import cc.cassian.wilderflowers.WilderFlowers;
import cc.cassian.wilderflowers.registry.WilderFlowersBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTabs;


public class FabricEntrypoint implements ModInitializer {

    @Override
    public void onInitialize() {
        WilderFlowers.init();
        WilderFlowersBlocks.touch();
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register((entries -> {
            WilderFlowersBlocks.WILDFLOWERS.forEach((wildflowerSupplier -> {
                entries.accept(wildflowerSupplier.flowerBed().get());
                entries.accept(wildflowerSupplier.garland().get());
            }));
        }));
    }

}
//?}