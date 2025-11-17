package cc.cassian.wilderflowers.neoforge;
//? if neoforge {

/*import cc.cassian.wilderflowers.registry.WilderFlowersBlocks;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

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

//    @SubscribeEvent
//    public static void onModelBake(ModelEvent.RegisterStandalone event) {
//        // This should probably be extracted into a handler of some kind
//        event.register(WilderFlowers.locate("block/cheery_wildflowers_potted"));
//        event.register(WilderFlowers.locate("block/moody_wildflowers_potted"));
//        event.register(WilderFlowers.locate("block/playful_wildflowers_potted"));
//        event.register(WilderFlowers.locate("block/hopeful_wildflowers_potted"));
//    }
}

*///?}