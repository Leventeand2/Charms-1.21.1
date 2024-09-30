package net.levente.items.custom;

import dev.emi.trinkets.api.*;
import net.levente.Charms;
import net.levente.util.TrinketUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class LapisRing extends TrinketItem {
    public static final Text LAPIS_RING_TOOLTIP_1 = Text.translatable("tooltip." + Charms.MOD_ID + ".lapis_ring_tooltip");
    public static final Text LAPIS_RING_TOOLTIP_2 = Text.translatable("tooltip." + Charms.MOD_ID + ".lapis_ring_tooltip_2");

    public LapisRing(Settings settings) {
        super(settings);
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);

        if (entity instanceof PlayerEntity player) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, -1, 2, false , false));
        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof PlayerEntity player) {
            player.removeStatusEffect(StatusEffects.CONDUIT_POWER);
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(LAPIS_RING_TOOLTIP_1);
        tooltip.add(LAPIS_RING_TOOLTIP_2);

        super.appendTooltip(stack, context, tooltip, type);
    }
}