package net.levente.items.custom;

import dev.emi.trinkets.api.*;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.levente.items.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

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
                if (entity instanceof PlayerEntity player && player.isSneaking()) {
                    makePlayerInvisible(player);
                } else {
                    assert entity instanceof PlayerEntity;
                    makePlayerVisible((PlayerEntity) entity);
                }
            }
        }
    }
    public static void makePlayerInvisible(@NotNull PlayerEntity player) {
        player.setInvisible(true);
    }
    public static void makePlayerVisible(@NotNull PlayerEntity player) {
        player.setInvisible(false);
    }
}
