package net.levente.items.custom;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.levente.util.TrinketsHelperMethods;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class SaturationCharm extends TrinketItem {
    public SaturationCharm(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof PlayerEntity player) {
            StatusEffectInstance saturation = new StatusEffectInstance(
                    StatusEffects.SATURATION,
                    2,
                    3,
                    true,
                    false,
                    false
            );
            player.addStatusEffect(saturation);

            boolean hasCharm = TrinketsHelperMethods.isEquippedInSlot(player, this);
            if (hasCharm) {
                if (player.getWorld() instanceof ServerWorld serverWorld) {
                    stack.damage(1, serverWorld, null, item -> {});
                }
            }
        }
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof PlayerEntity player) {
            StatusEffectInstance haste = new StatusEffectInstance(
                    StatusEffects.HASTE,
                    -1,
                    3,
                    true,
                    false,
                    false
            );
            player.addStatusEffect(haste);
        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof PlayerEntity player) {
            if (player.hasStatusEffect(StatusEffects.HASTE)) {
                player.removeStatusEffect(StatusEffects.HASTE);
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.literal("When equipped:").formatted(Formatting.GRAY));
        tooltip.add(Text.literal("§9Grants Saturation II"));
        tooltip.add(Text.literal("§9Grants Haste III"));
    }
}
