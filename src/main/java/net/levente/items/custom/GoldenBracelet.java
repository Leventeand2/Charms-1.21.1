package net.levente.items.custom;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.levente.util.TrinketsHelperMethods;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class GoldenBracelet extends TrinketItem {
    public GoldenBracelet(Settings settings) {
        super(settings);
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);
        if (entity instanceof PlayerEntity player) {
            StatusEffectInstance resistance = new StatusEffectInstance(StatusEffects.RESISTANCE, -1, 1, true, false);
            player.addStatusEffect(resistance);
        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onUnequip(stack, slot, entity);
        if (entity instanceof PlayerEntity player) {
            if (player.hasStatusEffect(StatusEffects.RESISTANCE)) {
                player.removeStatusEffect(StatusEffects.RESISTANCE);
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("When equipped:").formatted(Formatting.GRAY));
        tooltip.add(Text.literal("§9Grants Resistance I"));

        super.appendTooltip(stack, context, tooltip, type);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.tick(stack, slot, entity);

        if (entity instanceof PlayerEntity player) {
            boolean hasCharm = TrinketsHelperMethods.isEquippedInSlot(player, this);
            if (hasCharm) {
                if (player.getWorld() instanceof ServerWorld serverWorld) {
                    stack.damage(1, serverWorld, null, item -> {});
                }
            }
        }
    }
}
