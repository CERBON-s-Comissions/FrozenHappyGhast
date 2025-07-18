package com.cerbon.frozenhappyghast.neoforge.mixin.test;

import com.cerbon.frozenhappyghast.FrozenHappyGhast;
import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// Class used to test if neoforge only mixins are being applied
@Mixin(Minecraft.class)
public abstract class TestMixin {

    @Inject(method = "<init>", at = @At("TAIL"))
    private void sendMessageIfWorking(GameConfig gameConfig, CallbackInfo ci) {
        FrozenHappyGhast.LOGGER.info("NeoForge only mixins are working for {}!",  FrozenHappyGhast.MOD_NAME);
    }
}
