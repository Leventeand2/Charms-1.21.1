package net.levente.items.custom;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.levente.Charms;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class GoldenBracelet extends TrinketItem {
    public static final Text GOLDEN_BRACELET_TOOLTIP_1 = Text.translatable("tooltip." + Charms.MOD_ID + ".golden_bracelet_tooltip");
    public static final Text GOLDEN_BRACELET_TOOLTIP_2 = Text.translatable("tooltip." + Charms.MOD_ID + ".golden_bracelet_tooltip_2");

    public GoldenBracelet(Settings settings) {
        super(settings);
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);
        if (entity instanceof PlayerEntity player) {
            StatusEffectInstance resistance = new StatusEffectInstance(StatusEffects.RESISTANCE, -1, 1, false, false);
            player.addStatusEffect(resistance);
        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onUnequip(stack, slot, entity);
        if (entity instanceof PlayerEntity player) {
            player.removeStatusEffect(StatusEffects.RESISTANCE);
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(GOLDEN_BRACELET_TOOLTIP_1);
        tooltip.add(GOLDEN_BRACELET_TOOLTIP_2);

        super.appendTooltip(stack, context, tooltip, type);
    }
}
