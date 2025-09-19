package net.levente.items.custom;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class RawRubyAmulet extends TrinketItem {
    public RawRubyAmulet(Settings settings) {
        super(settings);
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);
        if (entity instanceof PlayerEntity player) {
                Trinket asd = TrinketsApi.getTrinket(this);
                StatusEffectInstance slow_falling = new StatusEffectInstance(StatusEffects.SLOW_FALLING, -1, 1, true, false);
                player.addStatusEffect(slow_falling);

        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onUnequip(stack, slot, entity);
        if (entity instanceof PlayerEntity player) {
            if (player.hasStatusEffect(StatusEffects.SLOW_FALLING)) {
                player.removeStatusEffect(StatusEffects.SLOW_FALLING);
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("When equipped:").formatted(Formatting.GRAY));
        tooltip.add(Text.literal("§9Grants Slow Falling I"));

        super.appendTooltip(stack, context, tooltip, type);
    }
}
