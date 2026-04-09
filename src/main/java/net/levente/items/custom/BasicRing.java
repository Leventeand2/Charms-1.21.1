package net.levente.items.custom;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.client.TrinketRenderer;
import net.levente.util.TrinketsHelperMethods;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class BasicRing extends TrinketItem implements TrinketRenderer {
    public BasicRing(Settings settings) {
        super(settings);
    }

    @Override
    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, Identifier slotIdentifier) {
        var modifiers = super.getModifiers(stack, slot, entity, slotIdentifier);

        modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(slotIdentifier,
                0.05, EntityAttributeModifier.Operation.ADD_VALUE));

        return modifiers;
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);
        StatusEffectInstance healing = new StatusEffectInstance(StatusEffects.REGENERATION, -1, 1, true, false);
        StatusEffectInstance fireRes = new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, -1, 1, true, false);
        if (entity instanceof PlayerEntity player) {
            player.addStatusEffect(healing);
            player.addStatusEffect(fireRes);
        }
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
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onUnequip(stack, slot, entity);
        if (entity instanceof PlayerEntity player) {
            player.removeStatusEffect(StatusEffects.REGENERATION);
            player.removeStatusEffect(StatusEffects.FIRE_RESISTANCE);
        }

    }
    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
    }

    @Override
    public void render(ItemStack itemStack, SlotReference slotReference, EntityModel<? extends LivingEntity> entityModel, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, LivingEntity livingEntity, float v, float v1, float v2, float v3, float v4, float v5) {
        // translateToLeftArm requires a PlayerEntityModel<AbstractClientPlayerEntity> and AbstractClientPlayerEntity
        if (livingEntity instanceof AbstractClientPlayerEntity clientPlayer && entityModel instanceof PlayerEntityModel<?> playerModel) {
            @SuppressWarnings("unchecked")
            PlayerEntityModel<AbstractClientPlayerEntity> castModel = (PlayerEntityModel<AbstractClientPlayerEntity>) playerModel;
            TrinketRenderer.translateToLeftArm(matrixStack, castModel, clientPlayer);
        }
    }
}
