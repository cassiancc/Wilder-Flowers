package cc.cassian.wilderflowers.registry;

import cc.cassian.wilderflowers.blocks.FlowerBedBlock;
import cc.cassian.wilderflowers.blocks.FlowerGarlandBlock;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;
import java.util.function.Supplier;

public record WildflowerSupplier(String blockID, Supplier<Block> flowerbed,
                                 Optional<Supplier<FlowerGarlandBlock>> garland, Supplier<Block> pottedBlock) {

    public Supplier<Block> flowerBed() {
        return flowerbed;
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

    public Item flowerBedItem() {
        return flowerbed.get().asItem();
    }

    public Item garlandItem() {
        return garland.get().get().asItem();
    }
}
