package com.jujutsu.jujutsucraftaddon.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CursedPowerItadoriParticle extends TextureSheetParticle {
    public static CursedPowerItadoriParticleProvider provider(SpriteSet spriteSet) {
        return new CursedPowerItadoriParticleProvider(spriteSet);
    }

    public static class CursedPowerItadoriParticleProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public CursedPowerItadoriParticleProvider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new CursedPowerItadoriParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
        }
    }

    private final SpriteSet spriteSet;

    protected CursedPowerItadoriParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
        super(world, x, y, z);
        this.spriteSet = spriteSet;
        this.setSize(0.5f, 0.5f);
        this.quadSize *= 3f;
        this.lifetime = Math.max(1, 20 + (this.random.nextInt(4) - 2));
        this.gravity = 0f;
        this.hasPhysics = true;
        this.xd = vx * 0;
        this.yd = vy * 0;
        this.zd = vz * 0;
        this.setSpriteFromAge(spriteSet);
    }

    @Override
    public int getLightColor(float partialTick) {
        return 15728880;
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_LIT;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.removed) {
            this.setSprite(this.spriteSet.get((this.age / 2) % 15 + 1, 15));
        }
    }
}
