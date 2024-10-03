package net.levente.items.custom;

import client.ClientEntrypoint;
import dev.emi.trinkets.api.*;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.levente.items.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class MaskOfShadows extends TrinketItem {
    public MaskOfShadows(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.tick(stack, slot, entity);

        TrinketComponent component = TrinketsApi.getTrinketComponent(entity).orElse(null);
        if (component != null) {
            if (component.isEquipped(ModItems.MASK_OF_SHADOWS)) {
                if (entity instanceof PlayerEntity player) {
                    ClientTickEvents.END_CLIENT_TICK.register(client -> {
                        while (ClientEntrypoint.keyBinding != null && ClientEntrypoint.keyBinding.wasPressed()) {
                            player.setInvisible(!player.isInvisible());
                        }
                    });
                }
            }
        }
    }
}
