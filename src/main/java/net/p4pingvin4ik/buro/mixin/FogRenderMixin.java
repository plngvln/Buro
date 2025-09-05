package net.p4pingvin4ik.buro.mixin;

import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.fog.FogRenderer;
import net.minecraft.client.world.ClientWorld;
import net.p4pingvin4ik.buro.config.ModConfig;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FogRenderer.class)
public class FogRenderMixin {

    @Inject(method = "getFogColor", at = @At("HEAD"), cancellable = true)
    private void onGetFogColor(Camera camera, float tickProgress, ClientWorld world, int viewDistance, float skyDarkness, boolean thick, CallbackInfoReturnable<Vector4f> cir) {
        ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        if (!config.isModEnabled){
            return;
        }
        Vector4f blackColor = new Vector4f(0.0f, 0.0f, 0.0f, 1.0f);
        cir.setReturnValue(blackColor);
    }
}