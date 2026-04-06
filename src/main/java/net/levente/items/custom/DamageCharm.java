package net.levente.items.custom;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;

import java.util.Objects;

public class DamageCharm extends TrinketItem {
    public DamageCharm(Settings settings) {
        super(settings);
    }
    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.tick(stack, slot, entity);
        if (entity instanceof PlayerEntity player) {
            float maxHealth = player.getMaxHealth();
            float playerHealth = player.getHealth();
            float difference = maxHealth / playerHealth;

            float currentDmg = (float) Objects.requireNonNull(player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE)).getBaseValue();
            Objects.requireNonNull(player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE)).setBaseValue(currentDmg * difference);
        }
    }
}
