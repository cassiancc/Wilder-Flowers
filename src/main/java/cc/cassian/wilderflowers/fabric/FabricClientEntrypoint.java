package cc.cassian.wilderflowers.fabric;

//? fabric || unobf {
import cc.cassian.wilderflowers.WilderFlowers;
import cc.cassian.wilderflowers.client.WilderFlowersClient;
import cc.cassian.wilderflowers.client.particle.FlowerPetalParticle;
import cc.cassian.wilderflowers.events.FlowerGarlandEvent;
import cc.cassian.wilderflowers.registry.WilderFlowersBlocks;
import cc.cassian.wilderflowers.registry.WilderFlowersParticleTypes;
import cc.cassian.wilderflowers.registry.WildflowerSupplier;
import net.fabricmc.api.ClientModInitializer;
//? if >1.21.2 {
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
//?} else {
/*import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
*///?}
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

public class FabricClientEntrypoint implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        WilderFlowers.LOG.info("Initializing {} Client", WilderFlowers.MOD_ID);
        for (WildflowerSupplier wildflower : WilderFlowersBlocks.WILDFLOWERS) {
            cutout(wildflower);
        }
        ColorProviderRegistry.BLOCK.register((WilderFlowersClient::getColor),
                WilderFlowersBlocks.MOODY_WILDFLOWERS.flowerBed().get(),
                //? if <1.21.5
                /*WilderFlowersBlocks.CHEERY_WILDFLOWERS.flowerBed().get(),*/
                WilderFlowersBlocks.HOPEFUL_WILDFLOWERS.flowerBed().get(),
                //? if <1.20
                /*WilderFlowersBlocks.PLAYFUL_WILDFLOWERS.flowerBed().get(),*/
                WilderFlowersBlocks.CLOVERS.flowerBed().get());
        //? if <1.21.9
        /*ClientTickEvents.END_CLIENT_TICK.register((FlowerGarlandEvent::tick));*/
        registerParticleTypes(ParticleFactoryRegistry.getInstance());
    }

    private void cutout(WildflowerSupplier wildflowerSupplier) {
        //? if <1.21.2 {
        /*BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(), wildflowerSupplier.flowerBed().get(), wildflowerSupplier.pot().get());
        if (wildflowerSupplier.garland().isPresent()) {
            BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(), wildflowerSupplier.garland().get().get());
        }
        *///?} else {
        BlockRenderLayerMap.putBlocks(ChunkSectionLayer.CUTOUT, wildflowerSupplier.flowerBed().get(), wildflowerSupplier.pot().get());
        if (wildflowerSupplier.garland().isPresent()) {
            BlockRenderLayerMap.putBlocks(ChunkSectionLayer.CUTOUT, wildflowerSupplier.garland().get().get());
        }
        //?}

    }

    public static void registerParticleTypes(ParticleFactoryRegistry event) {
        event.register(WilderFlowersParticleTypes.CHEERY_PETAL.get(), FlowerPetalParticle.Provider::new);
        event.register(WilderFlowersParticleTypes.PLAYFUL_PETAL.get(), FlowerPetalParticle.Provider::new);
        event.register(WilderFlowersParticleTypes.HOPEFUL_PETAL.get(), FlowerPetalParticle.Provider::new);
        event.register(WilderFlowersParticleTypes.MOODY_PETAL.get(), FlowerPetalParticle.Provider::new);
    }

}
//?}