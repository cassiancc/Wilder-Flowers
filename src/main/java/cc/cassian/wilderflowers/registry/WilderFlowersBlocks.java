package cc.cassian.wilderflowers.registry;

import cc.cassian.wilderflowers.WilderFlowers;
import cc.cassian.wilderflowers.blocks.FlowerBedBlock;
import cc.cassian.wilderflowers.blocks.FlowerGarlandBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.ArrayList;
import java.util.function.Supplier;

public class WilderFlowersBlocks {
    public static ArrayList<WildflowerSupplier> WILDFLOWERS = new ArrayList<>();

    public static final WildflowerSupplier HOPEFUL_WILDFLOWERS = registerWildflowerBlock("hopeful_wildflowers");
    public static final WildflowerSupplier CHEERY_WILDFLOWERS = registerWildflowerBlock("cheery_wildflowers");
    public static final WildflowerSupplier MOODY_WILDFLOWERS = registerWildflowerBlock("moody_wildflowers");
    public static final WildflowerSupplier PLAYFUL_WILDFLOWERS = registerWildflowerBlock("playful_wildflowers");

    private static WildflowerSupplier registerWildflowerBlock(String id) {
        Supplier<FlowerBedBlock> flowerBedBlockSupplier = CommonRegistry.registerBlock(id, () -> new FlowerBedBlock(flowerBedProperties().setId(blockKey(id))));
        Supplier<BlockItem> flowerBedItem = CommonRegistry.registerItem(id, ()-> new BlockItem(flowerBedBlockSupplier.get(), new Item.Properties().useBlockDescriptionPrefix().setId(itemKey(id))));

        var garlandId = id.replace("flowers", "flower_garland");
        Supplier<FlowerGarlandBlock> flowerGarlandBlockSupplier = CommonRegistry.registerBlock(garlandId, () -> new FlowerGarlandBlock(flowerBedProperties().setId(blockKey(garlandId))));
        Supplier<BlockItem> flowerGarlandItem = CommonRegistry.registerItem(garlandId, ()-> new BlockItem(flowerGarlandBlockSupplier.get(), new Item.Properties().useBlockDescriptionPrefix().setId(itemKey(garlandId)).equippableUnswappable(EquipmentSlot.HEAD)));

        Supplier<Block> flowerPotSupplier = CommonRegistry.registerBlock("potted_"+ id, () -> new FlowerPotBlock(flowerBedBlockSupplier.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(blockKey("potted_"+ id))));

        WildflowerSupplier wildflowerSupplier = new WildflowerSupplier(id, flowerBedBlockSupplier, flowerGarlandBlockSupplier, flowerPotSupplier);
        WilderFlowersBlocks.WILDFLOWERS.add(wildflowerSupplier);
        return wildflowerSupplier;
    }

    private static ResourceKey<Block> blockKey(String id) {
        return ResourceKey.create(Registries.BLOCK, WilderFlowers.locate(id));
    }

    private static ResourceKey<Item> itemKey(String id) {
        return ResourceKey.create(Registries.ITEM, WilderFlowers.locate(id));
    }

    private static BlockBehaviour.Properties flowerBedProperties() {
        return BlockBehaviour.Properties.of().noCollision().sound(SoundType.PINK_PETALS);
    }

    public static void touch() {

    }
}
