package cc.cassian.wilderflowers.registry;

import cc.cassian.wilderflowers.blocks.FlowerBedBlock;
import cc.cassian.wilderflowers.blocks.FlowerGarlandBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class WildflowerSupplier {
    private final String blockID;
    private final Supplier<FlowerBedBlock> flowerbed;
    private final Supplier<FlowerGarlandBlock> garland;
    private final Supplier<Block> pottedBlock;

    public WildflowerSupplier(String blockID, Supplier<FlowerBedBlock> flowerbed, Supplier<FlowerGarlandBlock> garland, Supplier<Block> pottedBlock) {
        this.blockID = blockID;
        this.flowerbed = flowerbed;
        this.garland = garland;
        this.pottedBlock = pottedBlock;
    }

    public Supplier<FlowerBedBlock> flowerBed() {
        return flowerbed;
    }

    public Supplier<FlowerGarlandBlock> garland() {
        return garland;
    }

    public BlockState defaultBlockState() {
        return flowerbed.get().defaultBlockState();
    }

    public String getID() {
        return blockID;
    }

    public Supplier<Block> pot() {
        return pottedBlock;
    }
}
