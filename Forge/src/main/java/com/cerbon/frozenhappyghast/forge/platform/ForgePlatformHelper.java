package com.cerbon.frozenhappyghast.forge.platform;

import com.cerbon.frozenhappyghast.forge.registry.ForgeResourcefulRegistry;
import com.cerbon.frozenhappyghast.platform.services.IPlatformHelper;
import com.cerbon.frozenhappyghast.registry.ResourcefulRegistry;
import net.minecraft.core.Registry;

public class ForgePlatformHelper implements IPlatformHelper {

    @Override
    public <T> ResourcefulRegistry<T> create(Registry<T> registry, String id) {
        return new ForgeResourcefulRegistry<>(registry, id);
    }
}
