package net.levente.items.custom;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;

import java.util.List;

public class MaskOfShadows extends TrinketItem {
    public MaskOfShadows(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (!(entity instanceof PlayerEntity player)) return;

        boolean isSneaking = player.isSneaking();
        boolean invisActive = player.getPersistentData().getBoolean("MaskOfShadowsActive");

        if (isSneaking) {
            // Apply invisibility every tick to keep it smooth
            if (!player.hasStatusEffect(StatusEffects.INVISIBILITY)) {
                player.addStatusEffect(new StatusEffectInstance(
                        StatusEffects.INVISIBILITY,
                        2,
                        0,
                        false,
                        false,
                        false
                ));
            }

            // Play sound & particles only once per activation
            if (!invisActive && !player.getWorld().isClient()) {
                player.getPersistentData().putBoolean("MaskOfShadowsActive", true);

                player.getWorld().playSound(
                        null,
                        player.getX(),
                        player.getY(),
                        player.getZ(),
                        SoundEvents.BLOCK_LAVA_EXTINGUISH,
                        SoundCategory.PLAYERS,
                        1.0f,
                        1.0f
                );

                if (player.getWorld() instanceof ServerWorld serverWorld) {
                    serverWorld.spawnParticles(
                            ParticleTypes.SMOKE,
                            player.getX(),
                            player.getY() + 1.0,
                            player.getZ(),
                            20,
                            0.5, 0.5, 0.5,
                            0.1
                    );
                }
            }
        } else {
            // Stop invisibility and reset the NBT flag when not sneaking
            if (player.hasStatusEffect(StatusEffects.INVISIBILITY)) {
                player.removeStatusEffect(StatusEffects.INVISIBILITY);
            }
            if (invisActive) {
                player.getPersistentData().putBoolean("MaskOfShadowsActive", false);
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip) {
        tooltip.add(Text.literal("§7When equipped:"));
        tooltip.add(Text.literal("§9Makes the player invisible (not including armor)."));
        super.appendTooltip(stack, context, tooltip);
    }
}
