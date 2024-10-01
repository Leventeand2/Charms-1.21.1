package net.levente.enchantments;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.levente.Charms;
import net.levente.enchantments.effects.AmplifyEnchantmentEffect;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    public static final RegistryKey<Enchantment> AMPLIFY_KEY = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Charms.MOD_ID, "amplify"));

    public static final MapCodec<AmplifyEnchantmentEffect> LIGHTNING_EFFECT = register("amplify", (MapCodec) AmplifyEnchantmentEffect.CODEC);

    private static <T extends EnchantmentEntityEffect> MapCodec<T> register(String name, MapCodec<T> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(Charms.MOD_ID, name), codec);
    }

    public static void registerModEnchantments() {
        Charms.LOGGER.info("Registering enchantments for: " + Charms.MOD_ID);
    }
}
