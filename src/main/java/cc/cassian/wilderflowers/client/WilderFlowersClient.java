package cc.cassian.wilderflowers.client;

import cc.cassian.wilderflowers.WilderFlowers;
import cc.cassian.wilderflowers.registry.WilderFlowersTags;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;

public class WilderFlowersClient {
    public static int getColor(BlockState state, BlockAndTintGetter blockAndTintGetter, BlockPos blockPos, int tintIndex) {
        if (tintIndex ==1) return -1;
        if (blockAndTintGetter == null || blockPos == null) {
            return 9551193;
        }
        return BiomeColors.getAverageGrassColor(blockAndTintGetter, blockPos);
    }
}
