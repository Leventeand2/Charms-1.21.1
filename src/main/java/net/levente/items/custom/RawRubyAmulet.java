package net.levente.items.custom;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import net.levente.Charms;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class RawRubyAmulet extends TrinketItem {
    public static final Text RAW_RUBY_AMULET_TOOLTIP_1 = Text.translatable("tooltip." + Charms.MOD_ID + ".raw_ruby_amulet_tooltip");
    public static final Text RAW_RUBY_AMULET_TOOLTIP_2 = Text.translatable("tooltip." + Charms.MOD_ID + ".raw_ruby_amulet_tooltip_2");

    public RawRubyAmulet(Settings settings) {
        super(settings);
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);
        if (entity instanceof PlayerEntity player) {
                Trinket asd = TrinketsApi.getTrinket(this);
                StatusEffectInstance slow_falling = new StatusEffectInstance(StatusEffects.SLOW_FALLING, -1, 1, false, false);
                player.addStatusEffect(slow_falling);

        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onUnequip(stack, slot, entity);
        if (entity instanceof PlayerEntity player) {
            player.removeStatusEffect(StatusEffects.SLOW_FALLING);
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(RAW_RUBY_AMULET_TOOLTIP_1);
        tooltip.add(RAW_RUBY_AMULET_TOOLTIP_2);


        super.appendTooltip(stack, context, tooltip, type);
    }
}
