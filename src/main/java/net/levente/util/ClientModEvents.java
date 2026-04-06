package net.levente.util;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.levente.items.custom.BasicRing;
import net.levente.items.custom.LapisRing;
import net.minecraft.text.Text;

public class ClientModEvents {

    public static void registerModEvents() {
        // Basic Ring tooltip thing
        ItemTooltipCallback.EVENT.register(((stack, context, type, tooltip) -> {
            if (stack.getItem() instanceof BasicRing) {
                tooltip.add(Text.literal("§9Grants Regeneration II"));
                tooltip.add(Text.literal("§9Grants Fire Resistance II"));
            }
            if (stack.getItem() instanceof LapisRing) {
                tooltip.add(Text.literal("§7When equipped:"));
                tooltip.add(Text.literal("§9Grants Water Breathing II"));
            }
        }));
    }
}
