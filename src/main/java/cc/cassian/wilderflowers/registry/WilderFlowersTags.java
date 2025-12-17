package cc.cassian.wilderflowers.registry;

import cc.cassian.wilderflowers.WilderFlowers;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

import static cc.cassian.wilderflowers.WilderFlowers.MOD_ID;

public class WilderFlowersTags {

    public static final TagKey<Biome> CHEERY_WILDFLOWERS_BIOMES = biomeTagKey("cheery_wildflowers_biomes");
    public static final TagKey<Biome> MEDIUM_CHEERY_WILDFLOWERS_BIOMES = biomeTagKey("medium_cheery_wildflowers_biomes");
    public static final TagKey<Biome> DENSE_CHEERY_WILDFLOWERS_BIOMES = biomeTagKey("dense_cheery_wildflowers_biomes");

    public static final TagKey<Biome> CLOVERS_BIOMES = biomeTagKey("clovers_biomes");
    public static final TagKey<Biome> MEDIUM_CLOVERS_BIOMES = biomeTagKey("medium_clovers_biomes");
    public static final TagKey<Biome> DENSE_CLOVERS_BIOMES = biomeTagKey("dense_clovers_biomes");

    public static final TagKey<Biome> HOPEFUL_WILDFLOWERS_BIOMES = biomeTagKey("hopeful_wildflowers_biomes");
    public static final TagKey<Biome> MEDIUM_HOPEFUL_WILDFLOWERS_BIOMES = biomeTagKey("medium_hopeful_wildflowers_biomes");
    public static final TagKey<Biome> DENSE_HOPEFUL_WILDFLOWERS_BIOMES = biomeTagKey("dense_hopeful_wildflowers_biomes");

    public static final TagKey<Biome> MOODY_WILDFLOWERS_BIOMES = biomeTagKey("moody_wildflowers_biomes");
    public static final TagKey<Biome> MEDIUM_MOODY_WILDFLOWERS_BIOMES = biomeTagKey("medium_moody_wildflowers_biomes");
    public static final TagKey<Biome> DENSE_MOODY_WILDFLOWERS_BIOMES = biomeTagKey("dense_moody_wildflowers_biomes");
    public static final TagKey<Block> WILDFLOWERS = blockTagKey("wildflowers");

    public static TagKey<Biome> biomeTagKey(String id) {
        return biomeTagKey(MOD_ID, id);
    }

    public static TagKey<Biome> biomeTagKey(String namespace, String id) {
        return TagKey.create(Registries.BIOME, WilderFlowers.locate(namespace, id));
    }

    public static TagKey<Block> blockTagKey(String id) {
        return blockTagKey(MOD_ID, id);
    }

    public static TagKey<Block> blockTagKey(String namespace, String id) {
        return TagKey.create(Registries.BLOCK, WilderFlowers.locate(namespace, id));
    }
}
