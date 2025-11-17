package cc.cassian.wilderflowers.fabric;

//? fabric {
import cc.cassian.wilderflowers.WilderFlowers;
import cc.cassian.wilderflowers.registry.WilderFlowersBlocks;
import cc.cassian.wilderflowers.registry.WildflowerSupplier;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class FabricClientEntrypoint implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        WilderFlowers.LOG.info("Initializing {} Client", WilderFlowers.MOD_ID);
        for (WildflowerSupplier wildflower : WilderFlowersBlocks.WILDFLOWERS) {
            cutout(wildflower);
        }
        ColorProviderRegistry.BLOCK.register(((blockState, blockAndTintGetter, blockPos, i) -> {
            if (blockAndTintGetter == null ||  blockPos == null) {
                return 9551193;
            }
            return 9551193;
        }), WilderFlowersBlocks.MOODY_WILDFLOWERS.flowerBed().get(), WilderFlowersBlocks.CHEERY_WILDFLOWERS.flowerBed().get(), WilderFlowersBlocks.HOPEFUL_WILDFLOWERS.flowerBed().get(), WilderFlowersBlocks.PLAYFUL_WILDFLOWERS.flowerBed().get(), WilderFlowersBlocks.CLOVERS.flowerBed().get());

    }

    private void cutout(WildflowerSupplier wildflowerSupplier) {
        BlockRenderLayerMap.putBlocks(ChunkSectionLayer.CUTOUT, wildflowerSupplier.flowerBed().get(), wildflowerSupplier.pot().get());
        if (wildflowerSupplier.garland().isPresent()) {
            BlockRenderLayerMap.putBlocks(ChunkSectionLayer.CUTOUT, wildflowerSupplier.garland().get().get());
        }
    }

}
//?}