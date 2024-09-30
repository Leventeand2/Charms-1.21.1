package net.levente.items.custom;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.levente.MaxHealth;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class RubyAmulet extends TrinketItem {
    public RubyAmulet(Settings settings) {
        super(settings);
    }

    @Override
    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, Identifier slotIdentifier) {
        var modifires = super.getModifiers(stack, slot, entity, slotIdentifier);
        // 10% extra health
        modifires.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier(slotIdentifier, 10, EntityAttributeModifier.Operation.ADD_VALUE));

        return modifires;
    }


}
