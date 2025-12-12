package cc.cassian.wilderflowers.blocks;

import cc.cassian.wilderflowers.WilderFlowers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;

import java.util.function.BiFunction;

public class FlowerBedBlock
    //? if >1.21.2 {
    extends net.minecraft.world.level.block.FlowerBedBlock {
    //?} else {
    /*extends PinkPetalsBlock {
    *///?}

    public FlowerBedBlock(Properties properties) {
        super(properties);
    }

}
