package net.levente.items.custom;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.levente.Charms;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class EtherCrown extends TrinketItem {
    public static final Text ETHER_CROWN_TOOLTIP_1 = Text.translatable("tooltip." + Charms.MOD_ID + ".ether_crown_tooltip");
    public static final Text ETHER_CROWN_TOOLTIP_2 = Text.translatable("tooltip." + Charms.MOD_ID + ".ether_crown_tooltip_2");

    // TODO: Make purified gold ingot

    public EtherCrown(Settings settings) {
        super(settings);
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);
        if (entity instanceof PlayerEntity player) {
            StatusEffectInstance luck = new StatusEffectInstance(StatusEffects.LUCK, -1, 3, false, false);
            player.addStatusEffect(luck);
        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);
        if (entity instanceof PlayerEntity player) {
            player.removeStatusEffect(StatusEffects.LUCK);
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(ETHER_CROWN_TOOLTIP_1);
        tooltip.add(ETHER_CROWN_TOOLTIP_2);

        super.appendTooltip(stack, context, tooltip, type);
    }
}
