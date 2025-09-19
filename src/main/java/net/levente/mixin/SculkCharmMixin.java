package net.levente.mixin;


import dev.emi.trinkets.api.TrinketsApi;
import net.levente.items.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.Vibrations;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Vibrations.VibrationListener.class)
public class SculkCharmMixin {

    @Inject(method = "listen(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/registry/entry/RegistryEntry;Lnet/minecraft/world/event/GameEvent$Emitter;Lnet/minecraft/util/math/Vec3d;)Z",
    at = @At("HEAD"), cancellable = true)
    private void onListen(ServerWorld world, RegistryEntry<GameEvent> event, GameEvent.Emitter emitter, Vec3d emitterPos, CallbackInfoReturnable<Boolean> cir) {
        if (emitter.sourceEntity() instanceof PlayerEntity player) {
            boolean hasCharm = TrinketsApi.getTrinketComponent(player)
                    .map(comp -> comp.isEquipped(ModItems.SCULK_CHARM))
                    .orElse(false);

            if (hasCharm) {
                cir.setReturnValue(false);
            }
        }
    }


}


