package com.cerbon.frozenhappyghast.forge.event;

import com.cerbon.frozenhappyghast.FrozenHappyGhast;
import com.cerbon.frozenhappyghast.item.FHGItems;
import com.cerbon.frozenhappyghast.util.RandomUtil;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = FrozenHappyGhast.MOD_ID)
public class EventsNeo {

    @SubscribeEvent
    public static void modifyWandererTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        rareTrades.add((trader, random) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, RandomUtil.range(8, 17)),
                new ItemStack(FHGItems.GHAST_WAND.get()),
                3, 12, 0.15F
        ));
    }
}
