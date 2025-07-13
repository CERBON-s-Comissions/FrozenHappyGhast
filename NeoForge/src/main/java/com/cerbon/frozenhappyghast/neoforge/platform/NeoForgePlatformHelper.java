package com.cerbon.frozenhappyghast.neoforge.platform;

import com.cerbon.frozenhappyghast.neoforge.registry.NeoForgeResourcefulRegistry;
import com.cerbon.frozenhappyghast.platform.services.IPlatformHelper;
import com.cerbon.frozenhappyghast.registry.ResourcefulRegistry;
import net.minecraft.core.Registry;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public <T> ResourcefulRegistry<T> create(Registry<T> registry, String id) {
        return new NeoForgeResourcefulRegistry<>(registry, id);
    }
}
