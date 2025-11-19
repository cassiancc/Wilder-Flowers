package cc.cassian.wilderflowers.registry;

import cc.cassian.wilderflowers.WilderFlowers;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import static cc.cassian.wilderflowers.WilderFlowers.MOD_ID;

public class WilderFlowersPlacedFeatures {
    public static final ResourceKey<PlacedFeature> CHEERY_WILDFLOWERS = placedFeature("cheery_wildflowers");
    public static final ResourceKey<PlacedFeature> MEDIUM_CHEERY_WILDFLOWERS = placedFeature("cheery_wildflowers_medium");
    public static final ResourceKey<PlacedFeature> DENSE_CHEERY_WILDFLOWERS = placedFeature("cheery_wildflowers_dense");

    public static final ResourceKey<PlacedFeature> CLOVERS = placedFeature("clovers");
    public static final ResourceKey<PlacedFeature> MEDIUM_CLOVERS = placedFeature("clovers_medium");
    public static final ResourceKey<PlacedFeature> DENSE_CLOVERS = placedFeature("clovers_dense");

    public static final ResourceKey<PlacedFeature> HOPEFUL_WILDFLOWERS = placedFeature("hopeful_wildflowers");
    public static final ResourceKey<PlacedFeature> MEDIUM_HOPEFUL_WILDFLOWERS = placedFeature("hopeful_wildflowers_medium");
    public static final ResourceKey<PlacedFeature> DENSE_HOPEFUL_WILDFLOWERS = placedFeature("hopeful_wildflowers_dense");

    public static final ResourceKey<PlacedFeature> MOODY_WILDFLOWERS = placedFeature("moody_wildflowers");
    public static final ResourceKey<PlacedFeature> MEDIUM_MOODY_WILDFLOWERS = placedFeature("moody_wildflowers_medium");
    public static final ResourceKey<PlacedFeature> DENSE_MOODY_WILDFLOWERS = placedFeature("moody_wildflowers_dense");

    public static ResourceKey<PlacedFeature> placedFeature(String id) {
        return placedFeature(MOD_ID, id);
    }

    public static ResourceKey<PlacedFeature> placedFeature(String namespace, String id) {
        return ResourceKey.create(Registries.PLACED_FEATURE, WilderFlowers.locate(namespace, id));
    }
}
