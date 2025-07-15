package com.cerbon.frozenhappyghast.neoforge.event;

import com.cerbon.frozenhappyghast.FrozenHappyGhast;
import com.cerbon.frozenhappyghast.particle.FHGParticles;
import com.cerbon.frozenhappyghast.particle.custom.FrozenParticle;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = FrozenHappyGhast.MOD_ID, value = Dist.CLIENT)
public class ClientEventsNeo {

    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(FHGParticles.FROZEN_PARTICLE.get(), FrozenParticle.Provider::new);
    }
}
