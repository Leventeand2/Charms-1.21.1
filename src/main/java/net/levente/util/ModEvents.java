package net.levente.util;

import dev.emi.trinkets.api.TrinketsApi;
import net.levente.Charms;
import net.levente.items.ModItems;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.LivingEntity;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.world.World;

public class ModEvents {

    private static final Identifier CLOSE_CALL_COOLDOWN_ID = Charms.id("close_call_cooldown");
    private static final int CLOSE_CALL_COOLDOWN = 6000; // 20 ticks (1 s) for testing purposes. Original was 6000 ticks (5 mins)

    public static void registerModEvents() {
        ServerLivingEntityEvents.ALLOW_DEATH.register((entity, damageSource, damageAmount) -> {

            if (!(entity instanceof ServerPlayerEntity player)) return true; // allow death for non-players

            // Check if the player has Close Call Charm equipped
            boolean hasCharmEquipped = TrinketsApi.getTrinketComponent(player)
                    .map(component -> component.isEquipped(ModItems.CLOSE_CALL_CHARM))
                    .orElse(false);

            if (!hasCharmEquipped) return true; // no charm → normal death

            // Check cooldown
            if (player.getItemCooldownManager().isCoolingDown(ModItems.CLOSE_CALL_CHARM)) {
                return true; // on cooldown → normal death
            }

            // Save the player
            player.setHealth(4.0F);
            player.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.REGENERATION, 100, 1, true, false));
            player.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.ABSORPTION, 200, 2, true, false));

            // Optional: play a sound or particle effect here

            // Apply cooldown (e.g., 5 seconds = 100 ticks)
            player.getItemCooldownManager().set(ModItems.CLOSE_CALL_CHARM, CLOSE_CALL_COOLDOWN);

            TrinketsApi.getTrinketComponent(player).ifPresent(comp -> {
                comp.getEquipped(ModItems.CLOSE_CALL_CHARM).forEach(pair -> {
                    ItemStack stack = pair.getRight();
                    World world = player.getWorld();
                    if (world instanceof ServerWorld serverWorld) {
                        stack.damage(1, serverWorld, player, item -> {});
                    }
                });
            });

            return false; // cancel death
        });
    }
}