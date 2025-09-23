package net.levente.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.emi.trinkets.api.TrinketsApi;
import net.levente.items.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.SculkSensorBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;


@Mixin(SculkSensorBlock.class)
public class SculkCharmStepOnMixin {

    @ModifyExpressionValue(
            method = "onSteppedOn",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/SculkSensorBlock;isInactive(Lnet/minecraft/block/BlockState;)Z")
    )
    private boolean isPlayer(boolean original, World world, BlockPos pos, BlockState state, Entity entity) {
        return original && isNotPlayer(entity);
    }

    private boolean isNotPlayer(Entity entity) {
        if (entity instanceof PlayerEntity player) {
            boolean hasCharmEquipped = TrinketsApi.getTrinketComponent(player)
                    .map(comp -> comp.isEquipped(ModItems.SCULK_CHARM))
                    .orElse(false);

            return !hasCharmEquipped;
        }
        return true;
    }
}
