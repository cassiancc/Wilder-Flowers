package cc.cassian.wilderflowers.fabric;

//? fabric {
import cc.cassian.wilderflowers.WilderFlowers;
import cc.cassian.wilderflowers.events.CommonEvents;
import cc.cassian.wilderflowers.registry.*;
import cc.cassian.wilderflowers.tags.WilderFlowersBiomeTags;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import static cc.cassian.wilderflowers.WilderFlowers.MOD_ID;
//? if >26 {
import static net.fabricmc.fabric.api.resource.v1.pack.PackActivationType.DEFAULT_ENABLED;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.fabricmc.fabric.api.resource.v1.pack.PackActivationType;
//?} else {
/*import static net.fabricmc.fabric.api.resource.ResourcePackActivationType.DEFAULT_ENABLED;
*///?}

public class FabricEntrypoint implements ModInitializer {

    @Override
    public void onInitialize() {
        WilderFlowers.init();
        WilderFlowersBlocks.touch();
        WilderFlowersParticleTypes.touch();
        //? if >26 {
        net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents.modifyOutputEvent
        //?} else {
        /*net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents.modifyEntriesEvent
        *///?}
        (CreativeModeTabs.NATURAL_BLOCKS).register((event -> {
            WilderFlowersBlocks.getWildflowerItems().forEach((wildflowerSupplier -> {
                //? if >1.21.4 {
                event.insertAfter(Items.WILDFLOWERS.getDefaultInstance(), wildflowerSupplier);
                //?} else {
                /*event.addAfter(Items.PINK_PETALS.getDefaultInstance(), wildflowerSupplier);
                *///?}
            }));
        }));
        //? if >26 {
        ResourceLoader.registerBuiltinPack
        //?} else {
        /*ResourceManagerHelper.registerBuiltinResourcePack
        *///?}
        (
                WilderFlowers.locate("wildflowers"),
                FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(),
                Component.literal("Wilder Flowers"),
                DEFAULT_ENABLED
        );
        WilderFlowersBlocks.getWildflowerItems().forEach((stack -> {
            //? if >26 {
            net.fabricmc.fabric.api.registry.CompostableRegistry
            //?} else {
            /*net.fabricmc.fabric.api.registry.CompostingChanceRegistry
            *///?}
			.INSTANCE.add(stack, 0.3f);
		}));

        // cheery - replaced by vanilla in 1.21.5+
        //? if <1.21.5 {
        /*addFeature(WilderFlowersBiomeTags.CHEERY_WILDFLOWERS_BIOMES, WilderFlowersPlacedFeatures.CHEERY_WILDFLOWERS);
        addFeature(WilderFlowersBiomeTags.MEDIUM_CHEERY_WILDFLOWERS_BIOMES, WilderFlowersPlacedFeatures.MEDIUM_CHEERY_WILDFLOWERS);
        addFeature(WilderFlowersBiomeTags.DENSE_CHEERY_WILDFLOWERS_BIOMES, WilderFlowersPlacedFeatures.DENSE_CHEERY_WILDFLOWERS);
        *///?}
        // moody
        addFeature(WilderFlowersBiomeTags.MOODY_WILDFLOWERS_BIOMES, WilderFlowersPlacedFeatures.MOODY_WILDFLOWERS);
        addFeature(WilderFlowersBiomeTags.MEDIUM_MOODY_WILDFLOWERS_BIOMES, WilderFlowersPlacedFeatures.MEDIUM_MOODY_WILDFLOWERS);
        addFeature(WilderFlowersBiomeTags.DENSE_MOODY_WILDFLOWERS_BIOMES, WilderFlowersPlacedFeatures.DENSE_MOODY_WILDFLOWERS);
        // hopeful
        addFeature(WilderFlowersBiomeTags.HOPEFUL_WILDFLOWERS_BIOMES, WilderFlowersPlacedFeatures.HOPEFUL_WILDFLOWERS);
        addFeature(WilderFlowersBiomeTags.MEDIUM_HOPEFUL_WILDFLOWERS_BIOMES, WilderFlowersPlacedFeatures.MEDIUM_HOPEFUL_WILDFLOWERS);
        addFeature(WilderFlowersBiomeTags.DENSE_HOPEFUL_WILDFLOWERS_BIOMES, WilderFlowersPlacedFeatures.DENSE_HOPEFUL_WILDFLOWERS);
        // clovers
        addFeature(WilderFlowersBiomeTags.CLOVERS_BIOMES, WilderFlowersPlacedFeatures.CLOVERS);
        addFeature(WilderFlowersBiomeTags.MEDIUM_CLOVERS_BIOMES, WilderFlowersPlacedFeatures.MEDIUM_CLOVERS);
        addFeature(WilderFlowersBiomeTags.DENSE_CLOVERS_BIOMES, WilderFlowersPlacedFeatures.DENSE_CLOVERS);

        ServerEntityEvents.ENTITY_LOAD.register((entity, serverLevel) -> {
            CommonEvents.onEntityJoinWorld(entity);
        });
    }

    static void addFeature(TagKey<Biome> biomeTagKey, ResourceKey<PlacedFeature> placedFeatureResourceKey) {
        BiomeModifications.addFeature(BiomeSelectors.tag(biomeTagKey), GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatureResourceKey);
    }

}
//?}