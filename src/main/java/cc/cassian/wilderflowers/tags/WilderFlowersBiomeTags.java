package cc.cassian.wilderflowers.tags;

import cc.cassian.wilderflowers.WilderFlowers;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

import static cc.cassian.wilderflowers.WilderFlowers.MOD_ID;

public class WilderFlowersBiomeTags {
    public static final TagKey<Biome> MORE_GARLANDS = biomeTag("more_garlands");
    public static final TagKey<Biome> INFREQUENT_GARLANDS = biomeTag("infrequent_garlands");
    public static final TagKey<Biome> CHEERY_GARLANDS = biomeTag("cheery_garlands");
    public static final TagKey<Biome> MOODY_GARLANDS = biomeTag("moody_garlands");
    public static final TagKey<Biome> HOPEFUL_GARLANDS = biomeTag("hopeful_garlands");
    public static final TagKey<Biome> PLAYFUL_GARLANDS = biomeTag("playful_garlands");

    public static final TagKey<Biome> CHEERY_WILDFLOWERS_BIOMES = biomeTag("cheery_wildflowers_biomes");
    public static final TagKey<Biome> MEDIUM_CHEERY_WILDFLOWERS_BIOMES = biomeTag("medium_cheery_wildflowers_biomes");
    public static final TagKey<Biome> DENSE_CHEERY_WILDFLOWERS_BIOMES = biomeTag("dense_cheery_wildflowers_biomes");

    public static final TagKey<Biome> CLOVERS_BIOMES = biomeTag("clovers_biomes");
    public static final TagKey<Biome> MEDIUM_CLOVERS_BIOMES = biomeTag("medium_clovers_biomes");
    public static final TagKey<Biome> DENSE_CLOVERS_BIOMES = biomeTag("dense_clovers_biomes");

    public static final TagKey<Biome> HOPEFUL_WILDFLOWERS_BIOMES = biomeTag("hopeful_wildflowers_biomes");
    public static final TagKey<Biome> MEDIUM_HOPEFUL_WILDFLOWERS_BIOMES = biomeTag("medium_hopeful_wildflowers_biomes");
    public static final TagKey<Biome> DENSE_HOPEFUL_WILDFLOWERS_BIOMES = biomeTag("dense_hopeful_wildflowers_biomes");

    public static final TagKey<Biome> MOODY_WILDFLOWERS_BIOMES = biomeTag("moody_wildflowers_biomes");
    public static final TagKey<Biome> MEDIUM_MOODY_WILDFLOWERS_BIOMES = biomeTag("medium_moody_wildflowers_biomes");
    public static final TagKey<Biome> DENSE_MOODY_WILDFLOWERS_BIOMES = biomeTag("dense_moody_wildflowers_biomes");

    public static TagKey<Biome> biomeTag(String id) {
        return biomeTag(MOD_ID, id);
    }

    public static TagKey<Biome> biomeTag(String namespace, String id) {
        return TagKey.create(Registries.BIOME, WilderFlowers.locate(namespace, id));
    }
}
