package com.cerbon.frozenhappyghast.fabric;

import com.cerbon.frozenhappyghast.FrozenHappyGhast;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

public class FrozenHappyGhastFabric implements ModInitializer, ClientModInitializer {

    @Override
    public void onInitialize() {
        FrozenHappyGhast.init();
    }

    @Override
    public void onInitializeClient() {}
}