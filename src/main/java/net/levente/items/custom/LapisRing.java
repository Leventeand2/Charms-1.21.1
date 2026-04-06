package net.levente.items.custom;

import dev.emi.trinkets.api.*;
import net.levente.Charms;
import net.levente.util.TrinketsHelperMethods;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;

import java.util.List;

public class LapisRing extends TrinketItem {

    public LapisRing(Settings settings) {
        super(settings);
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);

        if (entity instanceof PlayerEntity player) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, -1, 2, true , false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, -1, 2, true , false));
        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof PlayerEntity player) {
            if (player.hasStatusEffect(StatusEffects.CONDUIT_POWER) && player.hasStatusEffect(StatusEffects.DOLPHINS_GRACE)) {
                player.removeStatusEffect(StatusEffects.CONDUIT_POWER);
                player.removeStatusEffect(StatusEffects.DOLPHINS_GRACE);
            }
        }
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.tick(stack, slot, entity);
        if (entity instanceof PlayerEntity player) {
            if (player.hasStatusEffect(StatusEffects.CONDUIT_POWER) && player.hasStatusEffect(StatusEffects.DOLPHINS_GRACE)) {
                boolean hasCharm = TrinketsHelperMethods.isEquippedInSlot(player, this);
                if (hasCharm) {
                    if (player.getWorld() instanceof ServerWorld serverWorld) {
                        stack.damage(1, serverWorld, null, item -> {});
                    }
                }
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
    }
}