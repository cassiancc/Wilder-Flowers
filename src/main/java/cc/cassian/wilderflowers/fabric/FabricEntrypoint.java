package cc.cassian.wilderflowers.fabric;

//? fabric {
import cc.cassian.wilderflowers.Platform;
import cc.cassian.wilderflowers.WilderFlowers;
import cc.cassian.wilderflowers.compat.SupplementariesCompat;
import cc.cassian.wilderflowers.registry.WilderFlowersBlocks;
import cc.cassian.wilderflowers.registry.WilderFlowersItemProperties;
import cc.cassian.wilderflowers.registry.WilderFlowersParticleTypes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;


public class FabricEntrypoint implements ModInitializer {

    @Override
    public void onInitialize() {
        WilderFlowers.init();
        WilderFlowersBlocks.touch();
        WilderFlowersParticleTypes.touch();
        //? if <1.21.2 {
        /*WilderFlowersItemProperties.register();
        *///?}
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register((event -> {
            WilderFlowersBlocks.getWildflowerItems().forEach((wildflowerSupplier -> {
                //? if >1.21.4 {
                event.addAfter(Items.WILDFLOWERS.getDefaultInstance(), wildflowerSupplier);
                //?} else {
                /*event.addAfter(Items.PINK_PETALS.getDefaultInstance(), wildflowerSupplier);
                *///?}
            }));
        }));
        if (Platform.INSTANCE.isModLoaded("supplementaries")) {
            SupplementariesCompat.register();
        }
    }

}
//?}