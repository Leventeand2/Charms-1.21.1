package net.levente.items.custom;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.levente.util.TrinketsHelperMethods;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class SculkCharm extends TrinketItem {
    public SculkCharm(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.tick(stack, slot, entity);
        if (entity instanceof PlayerEntity player) {
            player.setSilent(true);

            boolean hasCharm = TrinketsHelperMethods.isEquippedInSlot(player, this);
            if (hasCharm) {
                if (player.getWorld() instanceof ServerWorld serverWorld) {
                    stack.damage(1, serverWorld, null, item -> {});
                }
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("When equipped:"));
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("§9Disables the activation of sculk sensors."));
        } else {
            tooltip.add(Text.literal("Hold SHIFT for more info!").formatted(Formatting.ITALIC, Formatting.GRAY));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
