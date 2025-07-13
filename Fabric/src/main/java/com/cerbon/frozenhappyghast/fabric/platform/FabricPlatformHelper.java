package com.cerbon.frozenhappyghast.fabric.platform;

import com.cerbon.frozenhappyghast.fabric.registry.FabricResourcefulRegistry;
import com.cerbon.frozenhappyghast.platform.services.IPlatformHelper;
import com.cerbon.frozenhappyghast.registry.ResourcefulRegistry;
import net.minecraft.core.Registry;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public <T> ResourcefulRegistry<T> create(Registry<T> registry, String id) {
        return new FabricResourcefulRegistry<>(registry, id);
    }
}
