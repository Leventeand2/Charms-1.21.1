package net.levente.items.custom;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.levente.util.TrinketsHelperMethods;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class StatsCharm extends TrinketItem {
    public StatsCharm(Settings settings) {
        super(settings);
    }

    @Override
    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, Identifier slotIdentifier) {
        var modifiers = super.getModifiers(stack, slot, entity, slotIdentifier);

        modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(slotIdentifier,
                0.05, EntityAttributeModifier.Operation.ADD_VALUE));
        modifiers.put(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE, new EntityAttributeModifier(slotIdentifier,
                2.0, EntityAttributeModifier.Operation.ADD_VALUE));
        modifiers.put(EntityAttributes.GENERIC_LUCK, new EntityAttributeModifier(slotIdentifier,
                2.0, EntityAttributeModifier.Operation.ADD_VALUE));
        modifiers.put(EntityAttributes.GENERIC_JUMP_STRENGTH, new EntityAttributeModifier(slotIdentifier,
                0.05, EntityAttributeModifier.Operation.ADD_VALUE));
        return modifiers;
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.tick(stack, slot, entity);
        if (entity instanceof PlayerEntity player) {
            boolean hasCharm = TrinketsHelperMethods.isEquipped(player, this);
            if (hasCharm) {
                if (player.getWorld() instanceof ServerWorld serverWorld) {
                    stack.damage(1, serverWorld, null, item -> {});
                }
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
    }
}
