package com.cerbon.frozenhappyghast.particle.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FrozenParticle extends TextureSheetParticle {
    private final SpriteSet sprites;

    protected FrozenParticle(ClientLevel clientLevel, SpriteSet sprites, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        super(clientLevel, x, y, z, xSpeed, ySpeed, zSpeed);
        this.gravity = 0.225F;
        this.friction = 1.0F;
        this.sprites = sprites;
        this.xd = xSpeed + (Math.random() * 2.0 - 1.0) * 0.05F;
        this.yd = ySpeed + (Math.random() * 2.0 - 1.0) * 0.05F;
        this.zd = zSpeed + (Math.random() * 2.0 - 1.0) * 0.05F;
        this.quadSize = 0.1F * (this.random.nextFloat() * this.random.nextFloat() * 1.0F + 1.0F);
        this.lifetime = (int)(16.0 / (this.random.nextFloat() * 0.8 + 0.2)) + 6;
        this.setSpriteFromAge(sprites);
    }

    @Override
    public void tick() {
        super.tick();
        this.setSpriteFromAge(this.sprites);
        this.xd *= 0.95F;
        this.yd *= 0.9F;
        this.zd *= 0.95F;
    }

    @Override
    public @NotNull ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Environment(EnvType.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet sprite) {
            this.sprite = sprite;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new FrozenParticle(level, sprite, x, y, z, xSpeed, ySpeed, zSpeed);
        }
    }
}
