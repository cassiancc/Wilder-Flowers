package cc.cassian.wilderflowers.client.particle;

import com.mojang.blaze3d.vertex.VertexConsumer;
//? if <1.19.2 {
/*import com.mojang.math.Vector3f;
*///?} else {
import net.minecraft.client.renderer.state.QuadParticleRenderState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import org.joml.Vector3f;
//?}
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;


public class FlowerPetalParticle extends
        //? if >1.21.9 {
        SingleQuadParticle
        //?} else {
    /*TextureSheetParticle
        *///?}
         {
    private final float yRot;
    private final float yOffset;

    protected FlowerPetalParticle(ClientLevel level, double x, double y, double z,
                                  double vx, double vy, double vz, TextureAtlasSprite sprite) {
        super(level, x, y, z, vx, vy, vz, sprite);
        this.lifetime = 200 + this.random.nextInt(20);
        this.gravity = 0.01F;
        this.yd = -0.08F;
        this.xd = (-0.5 + this.random.nextFloat()) / 10;
        this.zd = (-0.5 + this.random.nextFloat()) / 10;
        this.quadSize = 0.5F;
        this.yOffset = this.random.nextFloat() / 10;
        this.yRot = (float) (Math.PI / 2 * this.random.nextInt(4)); // 0, 90°, 180°, 270°
    }

    @Override
    public void tick() {
        super.tick();
        // Add slight movement wandering
        this.xd = Mth.clamp(this.xd + this.random.nextFloat() / 1000.0F * (this.random.nextBoolean() ? 1 : -1), -0.05F, 0.05F);
        this.zd = Mth.clamp(this.zd + this.random.nextFloat() / 1000.0F * (this.random.nextBoolean() ? 1 : -1), -0.05F, 0.05F);
    }

    //? if >1.21.9 {
    @Override
    protected Layer getLayer() {
        return Layer.TRANSLUCENT;
    }
    //?} else {
    /*@Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
    *///?}


    @Override
    //? if >1.21.9 {
    public void extract(QuadParticleRenderState reusedState, Camera camera, float partialTicks) {
    //?} else {
        /*public void render(VertexConsumer buffer, Camera camera, float partialTicks) {
    *///?}
        Vec3 pos = new Vec3(
            Mth.lerp(partialTicks, this.xo, this.x) - camera.getPosition().x,
            Mth.lerp(partialTicks, this.yo, this.y) - camera.getPosition().y,
            Mth.lerp(partialTicks, this.zo, this.z) - camera.getPosition().z
        );

        float half = this.quadSize * 0.5F;
        Vector3f[] corners = new Vector3f[]{
            new Vector3f(-half, 0, -half),
            new Vector3f(-half, 0, half),
            new Vector3f(half, 0, half),
            new Vector3f(half, 0, -half)
        };

        float cos = Mth.cos(yRot);
        float sin = Mth.sin(yRot);
        for (Vector3f corner : corners) {
            float xOld = corner.x();
            float zOld = corner.z();
            // Set rotation
            corner.set(xOld * cos - zOld * sin, corner.y(), xOld * sin + zOld * cos);
            // Set position
            corner.add((float)pos.x, (float)pos.y + yOffset, (float)pos.z);
        }

        int light = this.getLightColor(partialTicks);
        float u0 = this.getU0(), u1 = this.getU1();
        float v0 = this.getV0(), v1 = this.getV1();

        //? if <1.19.2 {
        /*buffer.vertex(corners[0].x(), corners[0].y(), corners[0].z()).uv(u1, v1).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
        buffer.vertex(corners[1].x(), corners[1].y(), corners[1].z()).uv(u1, v0).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
        buffer.vertex(corners[2].x(), corners[2].y(), corners[2].z()).uv(u0, v0).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
        buffer.vertex(corners[3].x(), corners[3].y(), corners[3].z()).uv(u0, v1).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
        *///?}
//        buffer.addVertex(corners[0].x(), corners[0].y(), corners[0].z()).setUv(u1, v1).setColor(rCol, gCol, bCol, alpha).setLight(light);
//        buffer.addVertex(corners[1].x(), corners[1].y(), corners[1].z()).setUv(u1, v0).setColor(rCol, gCol, bCol, alpha).setLight(light);
//        buffer.addVertex(corners[2].x(), corners[2].y(), corners[2].z()).setUv(u0, v0).setColor(rCol, gCol, bCol, alpha).setLight(light);
//        buffer.addVertex(corners[3].x(), corners[3].y(), corners[3].z()).setUv(u0, v1).setColor(rCol, gCol, bCol, alpha).setLight(light);


    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) { this.sprites = sprites; }


        public @Nullable Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, RandomSource random) {
            return new FlowerPetalParticle(level, x, y, z, xSpeed, ySpeed, zSpeed, sprites.get(random));
        }
//
//        public Particle createParticle(SimpleParticleType type, ClientLevel level,
//                                       double x, double y, double z,
//                                       double xSpeed, double ySpeed, double zSpeed) {
//            FlowerPetalParticle p = new FlowerPetalParticle(level, x, y, z, xSpeed, ySpeed, zSpeed);
//            p.pickSprite(sprites);
//            return p;
//        }


    }
}