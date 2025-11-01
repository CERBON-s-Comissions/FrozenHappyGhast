package com.cerbon.frozenhappyghast.item;

import com.cerbon.frozenhappyghast.FrozenHappyGhast;
import com.cerbon.frozenhappyghast.item.custom.GhastWandItem;
import com.cerbon.frozenhappyghast.registry.RegistryEntry;
import com.cerbon.frozenhappyghast.registry.ResourcefulRegistries;
import com.cerbon.frozenhappyghast.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class FHGItems {
    public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create(
            BuiltInRegistries.ITEM,
            FrozenHappyGhast.MOD_ID
    );

    public static final RegistryEntry<GhastWandItem> GHAST_WAND = ITEMS.register(
            "ghast_wand",
            () -> new GhastWandItem(new Item.Properties())
    );

    public static void register() {
        ITEMS.register();
    }
}
