package com.cerbon.frozenhappyghast.item.custom;

import com.cerbon.frozenhappyghast.util.mixin.IHappyGhastMixin;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.HappyGhast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GhastWandItem extends Item {

    public GhastWandItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity interactionTarget, InteractionHand usedHand) {
        if (!(interactionTarget instanceof HappyGhast happyGhast)) return super.interactLivingEntity(stack, player, interactionTarget, usedHand);

        IHappyGhastMixin happyGhastMixin = (IHappyGhastMixin) happyGhast;
        happyGhastMixin.fhg$setFrozen(!happyGhastMixin.fhg$isFrozen());

        return InteractionResult.SUCCESS;
    }
}
