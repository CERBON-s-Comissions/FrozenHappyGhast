package com.cerbon.frozenhappyghast.mixin;

import com.cerbon.frozenhappyghast.util.mixin.IHappyGhastMixin;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.HappyGhast;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HappyGhast.class)
public abstract class HappyGhastMixin extends Animal implements IHappyGhastMixin {
    @Unique private boolean fhg$isFrozen = false;
    @Unique private float fhg$xRotFrozen = 0;
    @Unique private float fhg$yRotFrozen = 0;

    @Unique private String fhg$isFrozenTag = "fhg_isFrozen";
    @Unique private String fhg$xRotFrozenTag = "fhg_xRotFrozen";
    @Unique private String fhg$yRotFrozenTag = "fhg_yRotFrozen";

    @Unique private static final EntityDataAccessor<Boolean> FHG_IS_FROZEN = SynchedEntityData.defineId(HappyGhast.class, EntityDataSerializers.BOOLEAN);

    protected HappyGhastMixin(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "defineSynchedData", at = @At("TAIL"))
    private void fhg$defineSynchedData(SynchedEntityData.Builder builder, CallbackInfo ci) {
        builder.define(FHG_IS_FROZEN, false);
    }

    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    private void fhg$saveAdditional(ValueOutput valueOutput, CallbackInfo ci) {
        valueOutput.putBoolean(fhg$isFrozenTag, fhg$isFrozen);
        valueOutput.putFloat(fhg$xRotFrozenTag, fhg$xRotFrozen);
        valueOutput.putFloat(fhg$yRotFrozenTag, fhg$yRotFrozen);
    }

    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    private void fhg$readAdditional(ValueInput valueInput, CallbackInfo ci) {
        fhg$isFrozen = valueInput.getBooleanOr(fhg$isFrozenTag, fhg$isFrozen);
        fhg$xRotFrozen = valueInput.getFloatOr(fhg$xRotFrozenTag, fhg$xRotFrozen);
        fhg$yRotFrozen = valueInput.getFloatOr(fhg$yRotFrozenTag, fhg$yRotFrozen);
        ((HappyGhast) (Object) this).getEntityData().set(FHG_IS_FROZEN, fhg$isFrozen);
    }

    @WrapOperation(method = "isOnStillTimeout", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/HappyGhast;staysStill()Z"))
    private boolean fhg$isOnStillTimeout(HappyGhast instance, Operation<Boolean> original) {
        if (fhg$isFrozen()) return true;
        return original.call(instance);
    }

    @Inject(method = "travel", at = @At("HEAD"), cancellable = true)
    private void fhg$travel(Vec3 travelVector, CallbackInfo ci) {
        if (fhg$isFrozen()) {
            this.setDeltaMovement(Vec3.ZERO);
            ci.cancel();
        }
    }

    @Inject(method = "tick", at = @At("TAIL"))
    private void fhg$tick(CallbackInfo ci) {
        if (fhg$isFrozen() && this.isBaby()) {
            this.forceSetRotation(fhg$yRotFrozen, fhg$xRotFrozen);
        }
    }

    @Override
    public boolean fhg$isFrozen() {
        return ((HappyGhast) (Object) this).getEntityData().get(FHG_IS_FROZEN);
    }

    @Override
    public void fhg$setFrozen(boolean value) {
        fhg$isFrozen = value;
        fhg$xRotFrozen = this.getXRot();
        fhg$yRotFrozen = this.getYRot();
        ((HappyGhast) (Object) this).getEntityData().set(FHG_IS_FROZEN, value);
    }
}
