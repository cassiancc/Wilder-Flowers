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
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

import static cc.cassian.wilderflowers.WilderFlowers.MOD_ID;


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
        ResourceManagerHelper.registerBuiltinResourcePack(
                WilderFlowers.locate("wildflowers"),
                FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(),
                Component.literal("Wilder Flowers"),
                ResourcePackActivationType.DEFAULT_ENABLED);
        WilderFlowersBlocks.getWildflowerItems().forEach((stack -> CompostingChanceRegistry.INSTANCE.add(stack.getItem(), 0.3f)));
    }

}
//?}