package com.cerbon.frozenhappyghast.creative_tabs;

import com.cerbon.frozenhappyghast.FrozenHappyGhast;
import com.cerbon.frozenhappyghast.item.FHGItems;
import com.cerbon.frozenhappyghast.registry.RegistryEntry;
import com.cerbon.frozenhappyghast.registry.ResourcefulRegistries;
import com.cerbon.frozenhappyghast.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

public class FHGCreativeTabs {
    public static final ResourcefulRegistry<CreativeModeTab> CREATIVE_MODE_TABS = ResourcefulRegistries.create(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            FrozenHappyGhast.MOD_ID
    );

    public static final RegistryEntry<CreativeModeTab> TAB = CREATIVE_MODE_TABS.register(
            FrozenHappyGhast.MOD_ID + "_tab",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 6)
                    .title(Component.translatable("itemGroup." + FrozenHappyGhast.MOD_ID + ".title"))
                    .icon(() -> FHGItems.GHAST_WAND.get().getDefaultInstance())
                    .displayItems((itemDisplayParameters, output) -> FHGItems.ITEMS.boundStream().forEach(output::accept))
                    .build()
    );

    public static void register() {
        CREATIVE_MODE_TABS.register();
    }
}
