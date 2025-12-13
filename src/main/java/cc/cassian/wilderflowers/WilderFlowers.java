package cc.cassian.wilderflowers;

import cc.cassian.wilderflowers.registry.WilderFlowersBlocks;
//? if <1.21.2 {
/*import net.minecraft.client.resources.model.ModelResourceLocation;
*///?}

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WilderFlowers {

    public static final String MOD_ID = "wilderflowers";
    public static final String MOD_NAME = "Wilder Flowers";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        LOG.info("Initializing {} on {}", MOD_NAME, Platform.INSTANCE.loader());
        //? if >1.21 {
        BuiltInRegistries.BLOCK.addAlias(locate("pink_petals"), locate("minecraft","pink_petals"));
        BuiltInRegistries.ITEM.addAlias(locate("pink_petals"), locate("minecraft","pink_petals"));
        BuiltInRegistries.BLOCK.addAlias(locate("playful_wildflowers"), locate("minecraft","pink_petals"));
        BuiltInRegistries.ITEM.addAlias(locate("playful_wildflowers"), locate("minecraft","pink_petals"));
        //?}
        //? if >1.21.5 {
        BuiltInRegistries.BLOCK.addAlias(locate("cheery_wildflowers"), locate("minecraft","wildflowers"));
        BuiltInRegistries.ITEM.addAlias(locate("cheery_wildflowers"), locate("minecraft","wildflowers"));
        //?}

    }

    public static ResourceLocation locate(String s) {
        return locate(MOD_ID, s);
    }

    public static ResourceLocation locate(String namespace, String s) {
        return ResourceLocation.fromNamespaceAndPath(namespace, s);
    }
}
