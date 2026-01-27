package cc.cassian.wilderflowers.items;

import net.minecraft.world.entity.EquipmentSlot;
//? if <1.21.2 {
/*import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Equipable;
*///?}
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DispenserBlock;


public class FlowerGarlandItem extends BlockItem
        //? if <1.21.2
        //implements Equipable
{

    public FlowerGarlandItem(Block block, Properties props) {
        super(block, props);
        //? if <1.21.2 {
        /*DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
        *///?}
    }
    
    //? if <1.21.2 {
    /*@Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }
    *///?}
}