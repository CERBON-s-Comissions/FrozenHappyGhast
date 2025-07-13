package com.cerbon.frozenhappyghast.platform.services;

import com.cerbon.frozenhappyghast.registry.ResourcefulRegistry;
import net.minecraft.core.Registry;

public interface IPlatformHelper {

    <T> ResourcefulRegistry<T> create(Registry<T> registry, String id);
}
