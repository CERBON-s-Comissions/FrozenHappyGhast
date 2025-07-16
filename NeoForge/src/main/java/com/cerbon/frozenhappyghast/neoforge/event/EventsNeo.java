package com.cerbon.frozenhappyghast.neoforge.event;

import com.cerbon.frozenhappyghast.FrozenHappyGhast;
import com.cerbon.frozenhappyghast.item.FHGItems;
import com.cerbon.frozenhappyghast.util.RandomUtil;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.List;

@EventBusSubscriber(modid = FrozenHappyGhast.MOD_ID)
public class EventsNeo {

    @SubscribeEvent
    public static void modifyWandererTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        rareTrades.add((trader, random) -> new MerchantOffer(
                new ItemCost(() -> Items.EMERALD, RandomUtil.range(8, 17)),
                new ItemStack(FHGItems.GHAST_WAND.get()),
                3, 12, 0.15F
        ));
    }
}
