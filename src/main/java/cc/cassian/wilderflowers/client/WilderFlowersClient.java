package cc.cassian.wilderflowers.client;

import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class WilderFlowersClient {
    public static BlockTintSource getColor() {
        return new BlockTintSource() {
            @Override
            public int colorInWorld(BlockState state, BlockAndTintGetter level, BlockPos pos) {
                return BiomeColors.getAverageGrassColor(level, pos);
            }

            @Override
            public int color(BlockState state) {
                return 9551193;
            }
        };
    }
}
