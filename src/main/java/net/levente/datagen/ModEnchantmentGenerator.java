package net.levente.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.levente.enchantments.ModEnchantments;
import net.levente.util.ModTags;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModEnchantmentGenerator extends FabricDynamicRegistryProvider {
    public ModEnchantmentGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        RegistryWrapper<Item> itemLookup = registries.getWrapperOrThrow(RegistryKeys.ITEM);

        register(entries, ModEnchantments.AMPLIFY_KEY, Enchantment.builder(
                Enchantment.definition(
                        itemLookup.getOrThrow(ModTags.Items.ARTIFACT_ITEMS),
                        10, // probability of showing up in enchantment table
                        2, // max level
                        Enchantment.leveledCost(1, 10), // cost per level (base)
                        Enchantment.leveledCost(1, 15), // cost per level (max)
                        7, // anvil applying cost
                        AttributeModifierSlot.HAND

                ))
                .addEffect(Enchan)
        );
    }

    private static void register(Entries entries, RegistryKey<Enchantment> key, Enchantment.Builder builder, ResourceCondition... conditions) {
        entries.add(key, builder.build(key.getValue()), conditions);
    }

    @Override
    public String getName() {
        return "Enchantment Generator";
    }
}
