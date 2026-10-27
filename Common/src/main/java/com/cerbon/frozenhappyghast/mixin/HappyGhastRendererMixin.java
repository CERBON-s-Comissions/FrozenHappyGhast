package com.cerbon.frozenhappyghast.mixin;

import com.blackgear.vanillabackport.client.level.renderer.entity.mob.HappyGhastRenderer;
import com.blackgear.vanillabackport.common.level.entities.mob.animal.happy_ghast.HappyGhast;
import com.cerbon.frozenhappyghast.FrozenHappyGhast;
import com.cerbon.frozenhappyghast.util.mixin.IHappyGhastMixin;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HappyGhastRenderer.class)
public abstract class HappyGhastRendererMixin {
    @Shadow @Final private static ResourceLocation GHAST_BABY_LOCATION;
    @Shadow @Final private static ResourceLocation GHAST_LOCATION;

    @Unique private static final ResourceLocation FROZEN_GHAST_LOCATION = ResourceLocation.fromNamespaceAndPath(FrozenHappyGhast.MOD_ID, "textures/entity/ghast/frozen_happy_ghast.png");
    @Unique private static final ResourceLocation FROZEN_GHAST_BABY_LOCATION = ResourceLocation.fromNamespaceAndPath(FrozenHappyGhast.MOD_ID, "textures/entity/ghast/frozen_happy_ghast_baby.png");

    @Inject(method = "getTextureLocation(Lcom/blackgear/vanillabackport/common/level/entities/mob/animal/happy_ghast/HappyGhast;)Lnet/minecraft/resources/ResourceLocation;", at = @At("HEAD"), cancellable = true)
    private void fhg$getTextureLocation(HappyGhast entity, CallbackInfoReturnable<ResourceLocation> cir) {
        IHappyGhastMixin happyGhastMixin = (IHappyGhastMixin) entity;

        if (happyGhastMixin.fhg$isFrozen() && entity.isBaby()) {
            cir.setReturnValue(FROZEN_GHAST_BABY_LOCATION);
            return;
        }

        else if (happyGhastMixin.fhg$isFrozen()) {
            cir.setReturnValue(FROZEN_GHAST_LOCATION);
            return;
        }

        cir.setReturnValue(entity.isBaby() ? GHAST_BABY_LOCATION : GHAST_LOCATION);
    }
}
