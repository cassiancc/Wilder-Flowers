package cc.cassian.wilderflowers.neoforge;
//? if neoforge {

/*import cc.cassian.wilderflowers.WilderFlowers;
import cc.cassian.wilderflowers.client.particle.FlowerPetalParticle;
import cc.cassian.wilderflowers.events.FlowerGarlandEvent;
import cc.cassian.wilderflowers.registry.WilderFlowersBlocks;
import cc.cassian.wilderflowers.registry.WilderFlowersItemProperties;
import cc.cassian.wilderflowers.registry.WilderFlowersParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

import static cc.cassian.wilderflowers.WilderFlowers.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, value= Dist.CLIENT)
public class NeoForgeClientEntrypoint {
    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event){
        event.register(((state, view, pos, tintIndex) -> {
            if (view == null || pos == null) {
                return 9551193;
            }
            return BiomeColors.getAverageFoliageColor(view, pos);
        }), WilderFlowersBlocks.MOODY_WILDFLOWERS.flowerBed().get(), WilderFlowersBlocks.CHEERY_WILDFLOWERS.flowerBed().get(), WilderFlowersBlocks.HOPEFUL_WILDFLOWERS.flowerBed().get(), WilderFlowersBlocks.PLAYFUL_WILDFLOWERS.flowerBed().get(), WilderFlowersBlocks.CLOVERS.flowerBed().get());
    }

    @SubscribeEvent
    public static void registerParticleTypes(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(WilderFlowersParticleTypes.CHEERY_PETAL.get(), FlowerPetalParticle.Provider::new);
        event.registerSpriteSet(WilderFlowersParticleTypes.PLAYFUL_PETAL.get(), FlowerPetalParticle.Provider::new);
        event.registerSpriteSet(WilderFlowersParticleTypes.HOPEFUL_PETAL.get(), FlowerPetalParticle.Provider::new);
        event.registerSpriteSet(WilderFlowersParticleTypes.MOODY_PETAL.get(), FlowerPetalParticle.Provider::new);
    }

    //? if <1.21.2 {
    /^@SubscribeEvent
    public static void setupClient(FMLClientSetupEvent event) {
        WilderFlowersItemProperties.register();
    }
    ^///?}

    @SubscribeEvent
    public static void clickTick(ClientTickEvent.Post event) {
        //? if <1.21.2
        /^FlowerGarlandEvent.tick(Minecraft.getInstance());^/
    }

    //? if <1.21.2 {
    /^@SubscribeEvent
    public static void onModelBake(ModelEvent.RegisterAdditional event) {
        // This should probably be extracted into a handler of some kind
        event.register(WilderFlowers.locateModel("block/cheery_wildflowers_potted"));
        event.register(WilderFlowers.locateModel("block/moody_wildflowers_potted"));
        event.register(WilderFlowers.locateModel("block/playful_wildflowers_potted"));
        event.register(WilderFlowers.locateModel("block/hopeful_wildflowers_potted"));
    }
    ^///?}
}

*///?}