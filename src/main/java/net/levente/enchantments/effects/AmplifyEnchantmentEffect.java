package net.levente.enchantments.effects;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentValueEffect;
import net.minecraft.util.math.random.Random;

public record AmplifyEnchantmentEffect(EnchantmentLevelBasedValue amount) implements EnchantmentValueEffect {
    public static final MapCodec<AmplifyEnchantmentEffect> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    EnchantmentLevelBasedValue.CODEC.fieldOf("amount").forGetter(AmplifyEnchantmentEffect::amount)
            ).apply(instance, AmplifyEnchantmentEffect::new));

    @Override
    public float apply(int level, Random random, float inputValue) {
        return 0;
    }

    @Override
    public MapCodec<? extends EnchantmentValueEffect> getCodec() {
        return CODEC;
    }
}
