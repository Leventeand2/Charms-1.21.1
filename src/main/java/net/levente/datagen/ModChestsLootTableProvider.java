package net.levente.datagen;

import dev.emi.trinkets.api.TrinketItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.levente.Charms;
import net.levente.items.ModItems;
import net.levente.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.TagEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModChestsLootTableProvider extends SimpleFabricLootTableProvider {
    public ModChestsLootTableProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup, LootContextType lootContextType) {
        super(output, registryLookup, lootContextType);
    }

    @Override
    public void accept(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> lootTableBiConsumer) {
        RegistryKey<LootTable> nonSecret = RegistryKey.of(RegistryKeys.LOOT_TABLE,
                Charms.id("chests/witch_house_loot"));
        RegistryKey<LootTable> secret = RegistryKey.of(RegistryKeys.LOOT_TABLE,
                Charms.id("chests/witch_house_secret_loot"));

        ItemPredicate predicate = ItemPredicate.Builder.create().tag(ModTags.Items.ARTIFACT_ITEMS).build();

        // nonSecret loot table
        lootTableBiConsumer.accept(nonSecret, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1))
                        .with(TagEntry.expandBuilder(ModTags.Items.ARTIFACT_ITEMS)))
                .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(7, 15))
                        .with(ItemEntry.builder(Items.GOLD_NUGGET).weight(10).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4, 8))))
                        .with(ItemEntry.builder(Items.IRON_INGOT).weight(12))
                        .with(ItemEntry.builder(Items.GOLD_INGOT).weight(11))
                        .with(ItemEntry.builder(Items.DIAMOND).weight(7))
                        .with(ItemEntry.builder(Items.GOLD_BLOCK).weight(8))
                        .with(ItemEntry.builder(ModItems.PURIFIED_GOLD_INGOT).weight(9).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 4))))
                        .with(ItemEntry.builder(ModItems.RUBY).weight(10).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 5))))
                        .with(ItemEntry.builder(Items.COBWEB).weight(12))));

        // secret loot table
        lootTableBiConsumer.accept(secret, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(2))
                        .with(TagEntry.expandBuilder(ModTags.Items.ARTIFACT_ITEMS)))
                .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(10, 20))
                        .with(ItemEntry.builder(Items.GOLD_NUGGET).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4, 8))))
                        .with(ItemEntry.builder(Items.IRON_INGOT))
                        .with(ItemEntry.builder(Items.GOLD_INGOT))
                        .with(ItemEntry.builder(Items.DIAMOND).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 4))))
                        .with(ItemEntry.builder(Items.GOLD_BLOCK))
                        .with(ItemEntry.builder(ModItems.PURIFIED_GOLD_INGOT).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 4))))
                        .with(ItemEntry.builder(ModItems.RUBY).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 5))))));
    }
}
