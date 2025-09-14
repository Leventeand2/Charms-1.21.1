package net.levente.items.custom;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.levente.Charms;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class EtherCrown extends TrinketItem {
    public static final Text ETHER_CROWN_TOOLTIP_1 = Text.translatable("tooltip." + Charms.MOD_ID + ".ether_crown_tooltip");
    public static final Text ETHER_CROWN_TOOLTIP_2 = Text.translatable("tooltip." + Charms.MOD_ID + ".ether_crown_tooltip_2");

    // TODO: Add particle effects after canceling the bad effects

    public EtherCrown(Settings settings) {
        super(settings);
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);
        if (entity instanceof PlayerEntity player) {
            StatusEffectInstance luck = new StatusEffectInstance(StatusEffects.LUCK, -1, 3, false, false);
            StatusEffectInstance nVision = new StatusEffectInstance(StatusEffects.NIGHT_VISION, -1, 3, false, false);
            player.addStatusEffect(luck);
            player.addStatusEffect(nVision);
        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);
        if (entity instanceof PlayerEntity player) {
            if (player.hasStatusEffect(StatusEffects.LUCK) && player.hasStatusEffect(StatusEffects.NIGHT_VISION) && player.getStatusEffect(StatusEffects.LUCK).isAmbient() && player.getStatusEffect(StatusEffects.NIGHT_VISION).isAmbient()) {
                player.removeStatusEffect(StatusEffects.LUCK);
                player.removeStatusEffect(StatusEffects.NIGHT_VISION);
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(ETHER_CROWN_TOOLTIP_1);

        if (Screen.hasShiftDown()) {
            tooltip.add(ETHER_CROWN_TOOLTIP_2);
        } else {
            tooltip.add(Text.literal("Hold SHIFT for more info!").formatted(Formatting.GRAY,
                    Formatting.ITALIC));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.tick(stack, slot, entity);

        if (entity instanceof PlayerEntity player) {

            if (player.hasStatusEffect(StatusEffects.MINING_FATIGUE)) {
                player.removeStatusEffect(StatusEffects.MINING_FATIGUE);
            }

            if (player.hasStatusEffect(StatusEffects.POISON)) {
                player.removeStatusEffect(StatusEffects.POISON);
            }
        }
    }
}
