package cc.cassian.wilderflowers.mixin;


//? if =1.21.1 {
/*import cc.cassian.wilderflowers.registry.WilderFlowersTags;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.mehvahdjukaar.supplementaries.client.renderers.color.FlowerBoxColor;
*///?}
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

//? if =1.21.1 {
/*@Mixin(FlowerBoxColor.class)
*///?} else {
@Mixin(BlockColors.class)
//?}
public class FlowerBoxColorMixin {
    //? if =1.21.1 {
    /*@WrapOperation(
            method = "getColor",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/color/block/BlockColors;getColor(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/BlockAndTintGetter;Lnet/minecraft/core/BlockPos;I)I")
    )
    private int bypassExpensiveCalculationIfNecessary(BlockColors instance, BlockState state, BlockAndTintGetter level, BlockPos pos, int tintIndex, Operation<Integer> original) {
        if (state.is(WilderFlowersTags.WILDFLOWERS))
            return -1;
        return original.call(instance, state, level, pos, tintIndex);
    }
    *///?}
}
