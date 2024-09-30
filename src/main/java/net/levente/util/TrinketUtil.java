package net.levente.util;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Optional;

public class TrinketUtil {
    public static boolean isPlayerEquippedWith(PlayerEntity player, Item trinket) {
        Optional<TrinketComponent> optional = TrinketsApi.getTrinketComponent(player);
        if (optional.isPresent()) {
            TrinketComponent component = optional.get();
            for (var group : component.getInventory().values()) {
                for (var inventory : group.values()) {
                    for (int i = 0; i < inventory.size(); i++) {
                        ItemStack stack = inventory.getStack(i);
                        if (stack.getItem() == trinket) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
