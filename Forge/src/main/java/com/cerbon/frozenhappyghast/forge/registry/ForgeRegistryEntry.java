package com.cerbon.frozenhappyghast.forge.registry;

import com.cerbon.frozenhappyghast.registry.RegistryEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.RegistryObject;

public class ForgeRegistryEntry<R, T extends R> implements RegistryEntry<T> {
    private final RegistryObject<T> object;

    public ForgeRegistryEntry(RegistryObject<T> object) {
        this.object = object;
    }

    @Override
    public T get() {
        return object.get();
    }

    @Override
    public ResourceLocation getId() {
        return object.getId();
    }
}