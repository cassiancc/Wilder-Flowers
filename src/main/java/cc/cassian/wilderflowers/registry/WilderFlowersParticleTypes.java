package cc.cassian.wilderflowers.registry;

//? if fabric || unobf
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.function.Supplier;

public class WilderFlowersParticleTypes {

    public static final Supplier<SimpleParticleType> CHEERY_PETAL;
    public static final Supplier<SimpleParticleType> PLAYFUL_PETAL;
    public static final Supplier<SimpleParticleType> HOPEFUL_PETAL;
    public static final Supplier<SimpleParticleType> MOODY_PETAL;

    private static Supplier<SimpleParticleType> registerSimpleParticleType(boolean alwaysShow, String name) {
        return CommonRegistry.registerParticleType(name, ()->
            //? if fabric || unobf {
            FabricParticleTypes.simple(alwaysShow)
            //?} else {
            /*new SimpleParticleType(alwaysShow)
            *///?}
        );
    }

    static {
        CHEERY_PETAL = registerSimpleParticleType(true, "cheery_petal");
        PLAYFUL_PETAL = registerSimpleParticleType(true, "playful_petal");
        HOPEFUL_PETAL = registerSimpleParticleType(true, "hopeful_petal");
        MOODY_PETAL = registerSimpleParticleType(true, "moody_petal");
    }

    public static void touch() {

    }
}
