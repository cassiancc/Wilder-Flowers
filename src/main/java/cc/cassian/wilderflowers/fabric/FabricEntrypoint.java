package cc.cassian.wilderflowers.fabric;

//? fabric || unobf {
import cc.cassian.wilderflowers.Platform;
import cc.cassian.wilderflowers.WilderFlowers;
import cc.cassian.wilderflowers.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

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
        ResourceManagerHelper.registerBuiltinResourcePack(
                WilderFlowers.locate("wildflowers"),
                FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(),
                Component.literal("Wilder Flowers"),
                ResourcePackActivationType.DEFAULT_ENABLED);
        WilderFlowersBlocks.getWildflowerItems().forEach((stack -> CompostingChanceRegistry.INSTANCE.add(stack.getItem(), 0.3f)));

        // cheery - replaced by vanilla in 1.21.5+
        //? if <1.21.5 {
        /*addFeature(WilderFlowersTags.CHEERY_WILDFLOWERS_BIOMES, WilderFlowersPlacedFeatures.CHEERY_WILDFLOWERS);
        addFeature(WilderFlowersTags.MEDIUM_CHEERY_WILDFLOWERS_BIOMES, WilderFlowersPlacedFeatures.MEDIUM_CHEERY_WILDFLOWERS);
        addFeature(WilderFlowersTags.DENSE_CHEERY_WILDFLOWERS_BIOMES, WilderFlowersPlacedFeatures.DENSE_CHEERY_WILDFLOWERS);
        *///?}
        // moody
        addFeature(WilderFlowersTags.MOODY_WILDFLOWERS_BIOMES, WilderFlowersPlacedFeatures.MOODY_WILDFLOWERS);
        addFeature(WilderFlowersTags.MEDIUM_MOODY_WILDFLOWERS_BIOMES, WilderFlowersPlacedFeatures.MEDIUM_MOODY_WILDFLOWERS);
        addFeature(WilderFlowersTags.DENSE_MOODY_WILDFLOWERS_BIOMES, WilderFlowersPlacedFeatures.DENSE_MOODY_WILDFLOWERS);
        // hopeful
        addFeature(WilderFlowersTags.HOPEFUL_WILDFLOWERS_BIOMES, WilderFlowersPlacedFeatures.HOPEFUL_WILDFLOWERS);
        addFeature(WilderFlowersTags.MEDIUM_HOPEFUL_WILDFLOWERS_BIOMES, WilderFlowersPlacedFeatures.MEDIUM_HOPEFUL_WILDFLOWERS);
        addFeature(WilderFlowersTags.DENSE_HOPEFUL_WILDFLOWERS_BIOMES, WilderFlowersPlacedFeatures.DENSE_HOPEFUL_WILDFLOWERS);
        // clovers
        addFeature(WilderFlowersTags.CLOVERS_BIOMES, WilderFlowersPlacedFeatures.CLOVERS);
        addFeature(WilderFlowersTags.MEDIUM_CLOVERS_BIOMES, WilderFlowersPlacedFeatures.MEDIUM_CLOVERS);
        addFeature(WilderFlowersTags.DENSE_CLOVERS_BIOMES, WilderFlowersPlacedFeatures.DENSE_CLOVERS);
    }

    static void addFeature(TagKey<Biome> biomeTagKey, ResourceKey<PlacedFeature> placedFeatureResourceKey) {
        BiomeModifications.addFeature(BiomeSelectors.tag(biomeTagKey), GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatureResourceKey);
    }

}
//?}