package cc.cassian.wilderflowers.compat;

import cc.cassian.wilderflowers.WilderFlowers;
import cc.cassian.wilderflowers.registry.WilderFlowersBlocks;
//? if <1.21.2 {
/*import net.mehvahdjukaar.supplementaries.common.utils.FlowerPotHandler;
*///?}

public class SupplementariesCompat {
    public static void register() {
        //? if <1.21.2 {
        /*//? <1.21.5
        /^FlowerPotHandler.registerCustomFlower(WilderFlowersBlocks.CHEERY_WILDFLOWERS.flowerBedItem(), WilderFlowers.locate("block/cheery_wildflowers_potted"));^/
        FlowerPotHandler.registerCustomFlower(WilderFlowersBlocks.CHEERY_WILDFLOWERS.flowerBedItem(), WilderFlowers.locate("block/cheery_wildflowers_potted"));
        //? <1.20
        /^FlowerPotHandler.registerCustomFlower(WilderFlowersBlocks.PLAYFUL_WILDFLOWERS.flowerBedItem(), WilderFlowers.locate("block/cheery_wildflowers_potted"));^/
        FlowerPotHandler.registerCustomFlower(WilderFlowersBlocks.HOPEFUL_WILDFLOWERS.flowerBedItem(), WilderFlowers.locate("block/playful_wildflowers_potted"));
        FlowerPotHandler.registerCustomFlower(WilderFlowersBlocks.MOODY_WILDFLOWERS.flowerBedItem(), WilderFlowers.locate("block/moody_wildflowers_potted"));
        FlowerPotHandler.registerCustomFlower(WilderFlowersBlocks.HOPEFUL_WILDFLOWERS.flowerBedItem(), WilderFlowers.locate("block/hopeful_wildflowers_potted"));
        *///?}
    }
}
