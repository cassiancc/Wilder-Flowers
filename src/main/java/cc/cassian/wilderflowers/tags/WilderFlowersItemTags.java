package cc.cassian.wilderflowers.tags;

import cc.cassian.wilderflowers.WilderFlowers;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class WilderFlowersItemTags {
	public static final TagKey<Item> FLOWER_GARLANDS = itemTag("flower_garlands");

	private static TagKey<Item> itemTag(String name) {
		return TagKey.create(Registries.ITEM, WilderFlowers.locate(name));
	}
}
