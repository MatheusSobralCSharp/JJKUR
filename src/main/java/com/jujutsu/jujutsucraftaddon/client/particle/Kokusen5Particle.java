package com.jujutsu.jujutsucraftaddon.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Kokusen5Particle extends TextureSheetParticle {
    public static Kokusen5ParticleProvider provider(SpriteSet spriteSet) {
        return new Kokusen5ParticleProvider(spriteSet);
    }

    public static class Kokusen5ParticleProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public Kokusen5ParticleProvider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new Kokusen5Particle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
        }
    }

    private final SpriteSet spriteSet;

    protected Kokusen5Particle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
        super(world, x, y, z);
        this.spriteSet = spriteSet;
        this.setSize(0.2f, 0.2f);
        this.quadSize *= 4f;
        this.lifetime = 20;
        this.gravity = 0f;
        this.hasPhysics = true;
        this.xd = vx + (this.random.nextFloat() - 0.5f) * 0.1f; // Random X-axis motion
        this.yd = vy + (this.random.nextFloat() - 0.5f) * 0.1f; // Random Y-axis motion
        this.zd = vz + (this.random.nextFloat() - 0.5f) * 0.1f;
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
            this.setSprite(this.spriteSet.get((this.age / 2) % 16 + 1, 16));
        }
    }
}
