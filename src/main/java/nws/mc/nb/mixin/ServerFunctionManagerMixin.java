package nws.mc.nb.mixin;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.functions.CommandFunction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerFunctionManager;
import nws.mc.nb.config.Configs;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collection;

@Mixin(ServerFunctionManager.class)
public class ServerFunctionManagerMixin {
    @Shadow
    @Final
    private MinecraftServer server;

    @Inject(method = "executeTagFunctions", at = @At("HEAD"), cancellable = true)
    private void nb$executeTagFunctions$ban(Collection<CommandFunction<CommandSourceStack>> pFunctionObjects, ResourceLocation pIdentifier, CallbackInfo ci) {
        if (Configs.I.getDatas().disableExecute) {
            this.server.getProfiler().push(pIdentifier::toString);
            this.server.getProfiler().pop();
            ci.cancel();
        }
    }
}
