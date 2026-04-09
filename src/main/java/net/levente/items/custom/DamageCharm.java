package net.levente.items.custom;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.levente.Charms;
import net.levente.util.TrinketsHelperMethods;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class DamageCharm extends TrinketItem {

    private static final Identifier MODIFIER_ID = Charms.id("damage_charm_bonus");

    public DamageCharm(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (!(entity instanceof PlayerEntity player)) return;

        EntityAttributeInstance attribute = player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        if (attribute == null) return;

        // Remove previous modifier (prevents stacking)
        attribute.removeModifier(MODIFIER_ID);

        float maxHealth = player.getMaxHealth();
        float health = Math.max(player.getHealth(), 1.0f); // avoid division by zero

        float healthPercent = health / maxHealth;

        // Missing health increases damage
        float multiplier = 1.0f + (1.0f - healthPercent);
        // full HP = 1.0x
        // half HP = 1.5x
        // low HP ≈ up to 2.0x

        EntityAttributeModifier modifier = new EntityAttributeModifier(
                MODIFIER_ID,
                multiplier - 1.0f,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
        );

        attribute.addTemporaryModifier(modifier);

        boolean hasCharm = TrinketsHelperMethods.isEquipped(player, this);
        if (hasCharm) {
            if (player.getWorld() instanceof ServerWorld serverWorld) {
                stack.damage(1, serverWorld, null, item -> {});
            }
        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof PlayerEntity player) {
            EntityAttributeInstance attribute = player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
            if (attribute != null) {
                attribute.removeModifier(MODIFIER_ID);
            }
        }

        super.onUnequip(stack, slot, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.literal("§7When equipped:"));
        tooltip.add(Text.literal("§9The lower your health, the more damage you do."));
    }
}