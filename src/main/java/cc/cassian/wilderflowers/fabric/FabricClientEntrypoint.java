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
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
//?} else {
/*import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import cc.cassian.wilderflowers.registry.WilderFlowersItemProperties;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.rendertype.RenderType;
*///?}
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import java.util.List;


public class FabricClientEntrypoint implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        WilderFlowers.LOG.info("Initializing {} Client", WilderFlowers.MOD_NAME);

        //? if <1.21.9
        //ClientTickEvents.END_CLIENT_TICK.register((FlowerGarlandEvent::tick));
        registerParticleTypes(ParticleProviderRegistry.getInstance());
        BlockColorRegistry.register(List.of(WilderFlowersClient.getColor()),
                WilderFlowersBlocks.MOODY_WILDFLOWERS.flowerBed().get(),
                WilderFlowersBlocks.HOPEFUL_WILDFLOWERS.flowerBed().get(),
                WilderFlowersBlocks.CLOVERS.flowerBed().get());

    }

    public static void registerParticleTypes(ParticleProviderRegistry event) {
        event.register(WilderFlowersParticleTypes.CHEERY_PETAL.get(), FlowerPetalParticle.Provider::new);
        event.register(WilderFlowersParticleTypes.PLAYFUL_PETAL.get(), FlowerPetalParticle.Provider::new);
        event.register(WilderFlowersParticleTypes.HOPEFUL_PETAL.get(), FlowerPetalParticle.Provider::new);
        event.register(WilderFlowersParticleTypes.MOODY_PETAL.get(), FlowerPetalParticle.Provider::new);
    }

}
//?}