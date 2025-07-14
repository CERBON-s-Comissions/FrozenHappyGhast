package com.cerbon.frozenhappyghast.mixin;


import com.cerbon.frozenhappyghast.FrozenHappyGhast;
import com.cerbon.frozenhappyghast.util.mixin.IHappyGhastMixin;
import net.minecraft.client.renderer.entity.HappyGhastRenderer;
import net.minecraft.client.renderer.entity.state.HappyGhastRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.HappyGhast;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HappyGhastRenderer.class)
public abstract class HappyGhastRendererMixin {
    @Shadow @Final private static ResourceLocation GHAST_BABY_LOCATION;
    @Shadow @Final private static ResourceLocation GHAST_LOCATION;

    @Unique private static final ResourceLocation FROZEN_GHAST_LOCATION = ResourceLocation.fromNamespaceAndPath(FrozenHappyGhast.MOD_ID, "textures/entity/ghast/frozen_happy_ghast.png");
    @Unique private static final ResourceLocation FROZEN_GHAST_BABY_LOCATION = ResourceLocation.fromNamespaceAndPath(FrozenHappyGhast.MOD_ID, "textures/entity/ghast/frozen_happy_ghast_baby.png");

    @Inject(method = "getTextureLocation(Lnet/minecraft/client/renderer/entity/state/HappyGhastRenderState;)Lnet/minecraft/resources/ResourceLocation;", at = @At("HEAD"), cancellable = true)
    private void fhg$getTextureLocation(HappyGhastRenderState happyGhastRenderState, CallbackInfoReturnable<ResourceLocation> cir) {
        IHappyGhastMixin happyGhastRenderStateMixin = (IHappyGhastMixin) happyGhastRenderState;

        if (happyGhastRenderStateMixin.fhg$isFrozen() && happyGhastRenderState.isBaby) {
            cir.setReturnValue(FROZEN_GHAST_BABY_LOCATION);
            return;
        }

        else if (happyGhastRenderStateMixin.fhg$isFrozen()) {
            cir.setReturnValue(FROZEN_GHAST_LOCATION);
            return;
        }

        cir.setReturnValue(happyGhastRenderState.isBaby ? GHAST_BABY_LOCATION : GHAST_LOCATION);
    }

    @Inject(method = "extractRenderState(Lnet/minecraft/world/entity/animal/HappyGhast;Lnet/minecraft/client/renderer/entity/state/HappyGhastRenderState;F)V", at = @At("TAIL"))
    private void fhg$extractRenderState(HappyGhast happyGhast, HappyGhastRenderState happyGhastRenderState, float f, CallbackInfo ci) {
        IHappyGhastMixin happyGhastRenderStateMixin = (IHappyGhastMixin) happyGhastRenderState;
        happyGhastRenderStateMixin.fhg$setFrozen(((IHappyGhastMixin) happyGhast).fhg$isFrozen());
    }
}
