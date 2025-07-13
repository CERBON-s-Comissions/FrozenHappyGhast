package com.cerbon.frozenhappyghast.mixin;

import com.cerbon.frozenhappyghast.util.mixin.IHappyGhastMixin;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.animal.HappyGhast;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HappyGhast.class)
public abstract class HappyGhastMixin implements IHappyGhastMixin {
    @Unique private boolean fhg$isFrozen = false;
    @Unique private String fhg$isFrozenTag = "fhg_isFrozen";

    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    private void fhg$saveAdditional(ValueOutput valueOutput, CallbackInfo ci) {
        valueOutput.putBoolean(fhg$isFrozenTag, fhg$isFrozen);
    }

    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    private void fhg$readAdditional(ValueInput valueInput, CallbackInfo ci) {
        fhg$isFrozen = valueInput.getBooleanOr(fhg$isFrozenTag, fhg$isFrozen);
    }

    @WrapOperation(method = "isOnStillTimeout", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/HappyGhast;staysStill()Z"))
    private boolean fhg$still(HappyGhast instance, Operation<Boolean> original) {
        if (fhg$isFrozen) return true;
        return original.call(instance);
    }

    @Override
    public boolean fhg$isFrozen() {
        return fhg$isFrozen;
    }

    @Override
    public void fhg$setFrozen(boolean value) {
        fhg$isFrozen = value;
    }
}
