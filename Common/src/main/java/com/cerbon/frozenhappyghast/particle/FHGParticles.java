package com.cerbon.frozenhappyghast.particle;

import com.cerbon.frozenhappyghast.FrozenHappyGhast;
import com.cerbon.frozenhappyghast.particle.custom.FHGSimpleParticleType;
import com.cerbon.frozenhappyghast.registry.RegistryEntry;
import com.cerbon.frozenhappyghast.registry.ResourcefulRegistries;
import com.cerbon.frozenhappyghast.registry.ResourcefulRegistry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;

public class FHGParticles {
    public static final ResourcefulRegistry<ParticleType<?>> PARTICLES = ResourcefulRegistries.create(
            BuiltInRegistries.PARTICLE_TYPE,
            FrozenHappyGhast.MOD_ID
    );

    public static final RegistryEntry<ParticleType<SimpleParticleType>> FROZEN_PARTICLE = PARTICLES.register(
            "frozen_particle",
            () -> new FHGSimpleParticleType(true)
    );

    public static void register() {
        PARTICLES.register();
    }
}
