package cc.cassian.wilderflowers.registry;

import cc.cassian.wilderflowers.WilderFlowers;
//? if <1.21.2 {
/*import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.renderer.item.ItemPropertyFunction;
*///?}
//? if >1.20 && <1.21.2 {
/*import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
*///?} else {

//?}

import net.minecraft.world.entity.EquipmentSlot;

public class WilderFlowersItemProperties {

    //? if <1.21.2 {

    /*private static final ClampedItemPropertyFunction FLOWER_GARLAND_EQUIPPED = (stack, level, entity, i) -> {
        if (entity == null) {
            return 0.0F;
        } else {
            return entity.getItemBySlot(EquipmentSlot.HEAD) == stack ? 1.0F : 0.0F;
        }
    };

    public static void register() {
        ItemProperties.register(WilderFlowersBlocks.CHEERY_WILDFLOWERS.garlandItem(), WilderFlowers.locate("equipped"), FLOWER_GARLAND_EQUIPPED);
        ItemProperties.register(WilderFlowersBlocks.HOPEFUL_WILDFLOWERS.garlandItem(), WilderFlowers.locate("equipped"), FLOWER_GARLAND_EQUIPPED);
        ItemProperties.register(WilderFlowersBlocks.PLAYFUL_WILDFLOWERS.garlandItem(), WilderFlowers.locate("equipped"), FLOWER_GARLAND_EQUIPPED);
        ItemProperties.register(WilderFlowersBlocks.MOODY_WILDFLOWERS.garlandItem(), WilderFlowers.locate( "equipped"), FLOWER_GARLAND_EQUIPPED);
    }
    *///?}
}
