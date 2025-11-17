package cc.cassian.wilderflowers;

import cc.cassian.wilderflowers.registry.WilderFlowersBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WilderFlowers {

    public static final String MOD_ID = "wilderflowers";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        LOG.info("Initializing {} on {}", MOD_ID, Platform.INSTANCE.loader());
        //? if >1.21 {
        BuiltInRegistries.BLOCK.addAlias(locate("pink_petals"), locate("playful_wildflowers"));
        BuiltInRegistries.ITEM.addAlias(locate("pink_petals"), locate("playful_wildflowers"));
        //?}
    }

    public static ResourceLocation locate(String s) {
        return locate(MOD_ID, s);
    }

    public static ResourceLocation locate(String namespace, String s) {
        //? if >1.21 {
        return ResourceLocation.fromNamespaceAndPath(namespace, s);
        //?} else {
        /*return new ResourceLocation(namespace, s);
        *///?}
    }
}
