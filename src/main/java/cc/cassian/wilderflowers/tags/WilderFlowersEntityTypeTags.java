package cc.cassian.wilderflowers.tags;

import cc.cassian.wilderflowers.WilderFlowers;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class WilderFlowersEntityTypeTags {
	public static final TagKey<EntityType<?>> GARLAND_WEARERS = entityTypeTag("garland_wearers");

	private static TagKey<EntityType<?>> entityTypeTag(String name) {
		return TagKey.create(Registries.ENTITY_TYPE, WilderFlowers.locate(name));
	}
}
