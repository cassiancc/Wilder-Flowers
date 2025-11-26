package cc.cassian.wilderflowers.registry;

import cc.cassian.wilderflowers.WilderFlowers;
import cc.cassian.wilderflowers.blocks.FlowerBedBlock;
import cc.cassian.wilderflowers.blocks.FlowerGarlandBlock;
import cc.cassian.wilderflowers.items.FlowerGarlandItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static cc.cassian.wilderflowers.registry.CommonRegistry.registerBlock;

public class WilderFlowersBlocks {
    public static ArrayList<WildflowerSupplier> WILDFLOWERS = new ArrayList<>();

    public static final WildflowerSupplier HOPEFUL_WILDFLOWERS = registerWildflowerBlock("hopeful_wildflowers");
    public static final WildflowerSupplier CHEERY_WILDFLOWERS = registerWildflowerBlock("cheery_wildflowers", true, false,
            //? if >1.21.5 {
            Blocks.WILDFLOWERS
            //?} else {
            /*null
            *///?}
    );
    public static final WildflowerSupplier MOODY_WILDFLOWERS = registerWildflowerBlock("moody_wildflowers");
    public static final WildflowerSupplier PLAYFUL_WILDFLOWERS = registerWildflowerBlock("playful_wildflowers", true, false, Blocks.PINK_PETALS);
    public static final WildflowerSupplier CLOVERS = registerWildflowerBlock("clovers", false, true, null);


    private static WildflowerSupplier registerWildflowerBlock(String id, boolean generateGarland, boolean replaceable, Block flowerbed) {
        // Register flowerbed or use vanilla variant.
        Supplier<Block> flowerBedBlockSupplier;
        if (flowerbed == null) {
            flowerBedBlockSupplier = registerBlock(id, () -> new FlowerBedBlock(flowerBedProperties(id, replaceable)));
            CommonRegistry.registerItem(id, () -> new BlockItem(flowerBedBlockSupplier.get(), blockItemProperties(id)));
        } else {
            flowerBedBlockSupplier =  ()->flowerbed;
        }

        // Register flower garland (if needed)
        Supplier<FlowerGarlandBlock> flowerGarlandBlockSupplier;
        if (generateGarland) {
            var garlandId = id.replace("flowers", "flower_garland");
            flowerGarlandBlockSupplier = registerBlock(garlandId, () -> new FlowerGarlandBlock(flowerBedProperties(garlandId, replaceable)));
            CommonRegistry.registerItem(garlandId, () -> new FlowerGarlandItem(flowerGarlandBlockSupplier.get(), blockItemProperties(garlandId)
                    //? if >1.21.2
                    .equippableUnswappable(EquipmentSlot.HEAD)
            ));
        } else {
            flowerGarlandBlockSupplier = null;
        }

        // Register flower pot.
        Supplier<Block> flowerPotSupplier = registerBlock("potted_" + id, () -> new FlowerPotBlock(flowerBedBlockSupplier.get(), copy(Blocks.FLOWER_POT)
                //? if >1.21.2
                .setId(blockKey("potted_" + id))
        ));

        // Return wildflower block set.
        WildflowerSupplier wildflowerSupplier = new WildflowerSupplier(id, flowerBedBlockSupplier, Optional.ofNullable(flowerGarlandBlockSupplier), flowerPotSupplier);
        WilderFlowersBlocks.WILDFLOWERS.add(wildflowerSupplier);
        return wildflowerSupplier;
    }

    private static BlockBehaviour.Properties copy(Block flowerPot) {
        //? if >1.21 {
        return BlockBehaviour.Properties.ofFullCopy(flowerPot);
        //?} else {
        /*return BlockBehaviour.Properties.copy(flowerPot);
        *///?}
    }

    private static WildflowerSupplier registerWildflowerBlock(String id) {
        return registerWildflowerBlock(id, true, false, null);
    }

    static Item.@NotNull Properties blockItemProperties(String id) {
        return new Item.Properties()
                //? if >1.21.2 {
                .useBlockDescriptionPrefix().setId(itemKey(id))
        //?}
        ;
    }

    static ResourceKey<Block> blockKey(String id) {
        return ResourceKey.create(Registries.BLOCK, WilderFlowers.locate(id));
    }

    static ResourceKey<Item> itemKey(String id) {
        return ResourceKey.create(Registries.ITEM, WilderFlowers.locate(id));
    }

    private static BlockBehaviour.Properties flowerBedProperties(String id, boolean replaceable) {
        var properties = BlockBehaviour.Properties.of().sound(SoundType.PINK_PETALS)
                //? if >1.21.2 {
                .setId(blockKey(id))
                //?}
                //? if >1.21.9 {
                .noCollision()
                //?} else {
                /*.noCollission()
                *///?}
                ;
        if (replaceable) {
            properties = properties.replaceable();
        }
        return properties;
    }

    public static void touch() {

    }

    public static List<ItemStack> getWildflowerItems() {
        ArrayList<ItemStack> list = new ArrayList<>();
        WILDFLOWERS.forEach((wildflowerSupplier -> {
            if (wildflowerSupplier.flowerBedItem().builtInRegistryHolder().key().
                    //? if >1.21.10 {
                    /*identifier()
                    *///?} else {
                    location()
                    //?}
                    .getNamespace().equals("wilderflowers")) {
                list.add(wildflowerSupplier.flowerBedItem().getDefaultInstance());
            }
            if (wildflowerSupplier.garland().isPresent())
                list.add(wildflowerSupplier.garlandItem().getDefaultInstance());
        }));
        //? if >1.21 {
        return list.reversed();
        //?} else {
        /*return list;
        *///?}

    }
}
