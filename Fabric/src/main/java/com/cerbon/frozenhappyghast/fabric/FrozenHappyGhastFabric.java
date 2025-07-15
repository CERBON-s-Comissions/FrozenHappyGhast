package com.cerbon.frozenhappyghast.fabric;

import com.cerbon.frozenhappyghast.FrozenHappyGhast;
import com.cerbon.frozenhappyghast.particle.FHGParticles;
import com.cerbon.frozenhappyghast.particle.custom.FrozenParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

public class FrozenHappyGhastFabric implements ModInitializer, ClientModInitializer {

    @Override
    public void onInitialize() {
        FrozenHappyGhast.init();
    }

    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(
                FHGParticles.FROZEN_PARTICLE.get(),
                FrozenParticle.Provider::new
        );
    }
}