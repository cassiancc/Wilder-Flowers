package cc.cassian.wilderflowers.fabric;

//? fabric {
import cc.cassian.wilderflowers.WilderFlowers;
import cc.cassian.wilderflowers.client.WilderFlowersClient;
import cc.cassian.wilderflowers.client.particle.FlowerPetalParticle;
import cc.cassian.wilderflowers.events.FlowerGarlandEvent;
import cc.cassian.wilderflowers.registry.WilderFlowersBlocks;
import cc.cassian.wilderflowers.registry.WilderFlowersParticleTypes;
import cc.cassian.wilderflowers.registry.WildflowerSupplier;
import net.fabricmc.api.ClientModInitializer;
//? if >26 {
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import static net.fabricmc.fabric.api.client.rendering.v1.ChunkSectionLayerMap.putBlocks;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
//?} else {
/*import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import cc.cassian.wilderflowers.registry.WilderFlowersItemProperties;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.rendertype.RenderType;
*///?}
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;


public class FabricClientEntrypoint implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        WilderFlowers.LOG.info("Initializing {} Client", WilderFlowers.MOD_NAME);
        for (WildflowerSupplier wildflower : WilderFlowersBlocks.WILDFLOWERS) {
            cutout(wildflower);
        }

        //? if <1.21.9
        //ClientTickEvents.END_CLIENT_TICK.register((FlowerGarlandEvent::tick));
        //? if >26 {
        registerParticleTypes(ParticleProviderRegistry.getInstance());
        BlockColorRegistry.register((WilderFlowersClient::getColor),
                WilderFlowersBlocks.MOODY_WILDFLOWERS.flowerBed().get(),
                WilderFlowersBlocks.HOPEFUL_WILDFLOWERS.flowerBed().get(),
                WilderFlowersBlocks.CLOVERS.flowerBed().get());
        //?} else {
        /*WilderFlowersItemProperties.register();
        registerParticleTypes(ParticleFactoryRegistry.getInstance());
        ColorProviderRegistry.BLOCK.register((WilderFlowersClient::getColor),
                WilderFlowersBlocks.MOODY_WILDFLOWERS.flowerBed().get(),
                WilderFlowersBlocks.CHEERY_WILDFLOWERS.flowerBed().get(),
                WilderFlowersBlocks.HOPEFUL_WILDFLOWERS.flowerBed().get(),
                WilderFlowersBlocks.CLOVERS.flowerBed().get());
        *///?}

    }

    private void cutout(WildflowerSupplier wildflowerSupplier) {
        //? if <1.21.2 {
        /*BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(), wildflowerSupplier.flowerBed().get(), wildflowerSupplier.pot().get());
        if (wildflowerSupplier.garland().isPresent()) {
            BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(), wildflowerSupplier.garland().get().get());
        }
        *///?} else {
        putBlocks(ChunkSectionLayer.CUTOUT, wildflowerSupplier.flowerBed().get(), wildflowerSupplier.pot().get());
        if (wildflowerSupplier.garland().isPresent()) {
            putBlocks(ChunkSectionLayer.CUTOUT, wildflowerSupplier.garland().get().get());
        }
        //?}

    }

    public static void registerParticleTypes(
            //? if >26 {
            ParticleProviderRegistry
            //?} else {
            /*ParticleFactoryRegistry
            *///?}
            event) {
        event.register(WilderFlowersParticleTypes.CHEERY_PETAL.get(), FlowerPetalParticle.Provider::new);
        event.register(WilderFlowersParticleTypes.PLAYFUL_PETAL.get(), FlowerPetalParticle.Provider::new);
        event.register(WilderFlowersParticleTypes.HOPEFUL_PETAL.get(), FlowerPetalParticle.Provider::new);
        event.register(WilderFlowersParticleTypes.MOODY_PETAL.get(), FlowerPetalParticle.Provider::new);
    }

}
//?}