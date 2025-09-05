package net.p4pingvin4ik.buro.mixin;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.render.SkyRendering;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.p4pingvin4ik.buro.config.ModConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SkyRendering.class)
public class SkyRenderingMixin {

    @Inject(method = "renderTopSky", at = @At("HEAD"), cancellable = true)
    public void onRenderTopSky(float red, float green, float blue, CallbackInfo ci) {
        ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        if (!config.isModEnabled){
            return;
        }
        ci.cancel();
    }

    @Inject(method = "renderSkyDark", at = @At("HEAD"), cancellable = true)
    public void onRenderSkyDark(CallbackInfo ci) {
        ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        if (!config.isModEnabled){
            return;
        }
        ci.cancel();
    }

    @Inject(method = "renderCelestialBodies", at = @At("HEAD"), cancellable = true)
    public void onRenderCelestialBodies(MatrixStack matrices, VertexConsumerProvider.Immediate vertexConsumers, float rot, int phase, float alpha, float starBrightness, CallbackInfo ci) {
        ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        if (!config.isModEnabled){
            return;
        }
        ci.cancel();
    }

    @Inject(method = "renderGlowingSky", at = @At("HEAD"), cancellable = true)
    public void onRenderGlowingSky(MatrixStack matrices, VertexConsumerProvider.Immediate vertexConsumers, float angleRadians, int color, CallbackInfo ci) {
        ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        if (!config.isModEnabled){
            return;
        }
        ci.cancel();
    }

    @Inject(method = "renderEndSky", at = @At("HEAD"), cancellable = true)
    public void onRenderEndSky(CallbackInfo ci) {
        ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        if (!config.isModEnabled){
            return;
        }
        ci.cancel();
    }
}