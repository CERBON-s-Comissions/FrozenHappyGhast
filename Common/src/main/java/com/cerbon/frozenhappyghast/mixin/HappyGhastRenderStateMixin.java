package com.cerbon.frozenhappyghast.mixin;

import com.cerbon.frozenhappyghast.util.mixin.IHappyGhastMixin;
import net.minecraft.client.renderer.entity.state.HappyGhastRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(HappyGhastRenderState.class)
public class HappyGhastRenderStateMixin implements IHappyGhastMixin {
    @Unique public boolean fhg$isFrozen;

    @Override
    public boolean fhg$isFrozen() {
        return fhg$isFrozen;
    }

    @Override
    public void fhg$setFrozen(boolean value) {
        fhg$isFrozen = value;
    }
}
