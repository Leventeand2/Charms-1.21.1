package net.levente.util;

import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;

public class TrinketsHelperMethods {
    public static boolean isEquipped(PlayerEntity player, Item item, String group, String name) {
        return TrinketsApi.getTrinketComponent(player).map(component ->
                component.getAllEquipped().stream().anyMatch(entry -> {
                    var slot = entry.getLeft().inventory().getSlotType();
                    return entry.getRight().getItem() == item &&
                            slot.getGroup().equals(group) &&
                            slot.getName().equals(name);
                })
        ).orElse(false);
    }

    public static boolean isEquipped(PlayerEntity player, Item item) {
        return TrinketsApi.getTrinketComponent(player)
                .map(comp -> comp.isEquipped(item))
                .orElse(false);
    }
}
