package com.cerbon.frozenhappyghast.fabric;

import com.cerbon.frozenhappyghast.FrozenHappyGhast;
import com.cerbon.frozenhappyghast.item.FHGItems;
import com.cerbon.frozenhappyghast.particle.FHGParticles;
import com.cerbon.frozenhappyghast.particle.custom.FrozenParticle;
import com.cerbon.frozenhappyghast.util.RandomUtil;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;

public class FrozenHappyGhastFabric implements ModInitializer, ClientModInitializer {

    @Override
    public void onInitialize() {
        FrozenHappyGhast.init();

        TradeOfferHelper.registerWanderingTraderOffers(tradeBuilder -> tradeBuilder.addOffersToPool(
                TradeOfferHelper.WanderingTraderOffersBuilder.SELL_SPECIAL_ITEMS_POOL,
                (trader, random) -> new MerchantOffer(
                        new ItemCost(() -> Items.EMERALD, RandomUtil.range(8, 17)),
                        new ItemStack(FHGItems.GHAST_WAND.get()),
                        3, 12, 0.15F
                )
        ));
    }

    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(
                FHGParticles.FROZEN_PARTICLE.get(),
                FrozenParticle.Provider::new
        );
    }
}