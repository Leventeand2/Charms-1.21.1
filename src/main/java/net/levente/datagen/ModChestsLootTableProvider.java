package net.levente.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.levente.Charms;
import net.levente.items.ModItems;
import net.levente.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.loot.entry.EmptyEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.TagEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
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
        RegistryKey<LootTable> witchHouseNonSecret = RegistryKey.of(RegistryKeys.LOOT_TABLE,
                Charms.id("chests/witch_house/non_secret"));
        RegistryKey<LootTable> witchHouseSecret = RegistryKey.of(RegistryKeys.LOOT_TABLE,
                Charms.id("chests/witch_house/secret"));
        RegistryKey<LootTable> cottageSmall = RegistryKey.of(RegistryKeys.LOOT_TABLE,
                Charms.id("chests/cottage/small"));
        RegistryKey<LootTable> cottageLarge = RegistryKey.of(RegistryKeys.LOOT_TABLE,
                Charms.id("chests/cottage/large"));
        RegistryKey<LootTable> cottageBarrel = RegistryKey.of(RegistryKeys.LOOT_TABLE,
                Charms.id("chests/cottage/barrel"));

        lootTableBiConsumer.accept(witchHouseNonSecret, LootTable.builder()
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
        lootTableBiConsumer.accept(witchHouseSecret, LootTable.builder()
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
        lootTableBiConsumer.accept(cottageSmall, LootTable.builder()
                .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(10, 15))
                        .with(ItemEntry.builder(Items.BREAD).weight(10))
                        .with(ItemEntry.builder(Items.DRIED_KELP).weight(12))
                        .with(ItemEntry.builder(Items.APPLE).weight(9))
                        .with(ItemEntry.builder(Items.CANDLE).weight(7))
                        .with(ItemEntry.builder(Items.LANTERN).weight(8))
                        .with(ItemEntry.builder(Items.STRING).weight(9))
                        .with(ItemEntry.builder(Items.STICK).weight(11))
                        .with(TagEntry.expandBuilder(ModTags.Items.SEED_ITEMS).weight(10))
                        .with(ItemEntry.builder(Items.FLINT).weight(8))
                        .with(TagEntry.expandBuilder(ModTags.Items.IRON_TOOLS).weight(5))));
        lootTableBiConsumer.accept(cottageLarge, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1))
                        .with(TagEntry.expandBuilder(ModTags.Items.ARTIFACT_ITEMS).weight(3))
                        .with(EmptyEntry.builder().weight(80)))
                .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(40, 60))
                        .with(ItemEntry.builder(Items.IRON_INGOT).weight(12))
                        .with(ItemEntry.builder(Items.GOLD_NUGGET).weight(12))
                        .with(ItemEntry.builder(ModItems.RUBY).weight(9))
                        .with(ItemEntry.builder(ModItems.PURIFIED_GOLD_INGOT).weight(7))
                        .with(ItemEntry.builder(Items.NAME_TAG).weight(10))
                        .with(ItemEntry.builder(Items.SADDLE).weight(9))));
        lootTableBiConsumer.accept(cottageBarrel, LootTable.builder()
                .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(5, 9))
                        .with(ItemEntry.builder(Items.BREAD).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4, 8))))
                        .with(ItemEntry.builder(Items.APPLE).weight(12))
                        .with(ItemEntry.builder(Items.CARROT).weight(12))
                        .with(ItemEntry.builder(Items.POTATO).weight(12))
                        .with(ItemEntry.builder(Items.BROWN_MUSHROOM).weight(11))
                        .with(ItemEntry.builder(Items.RED_MUSHROOM).weight(11))
                        .with(ItemEntry.builder(Items.SUSPICIOUS_STEW).weight(10))
                        .with(ItemEntry.builder(Items.GLASS_BOTTLE).weight(10))
                        .with(ItemEntry.builder(Items.BOWL).weight(10))
                        .with(ItemEntry.builder(Items.HONEY_BOTTLE).weight(9))
                        .with(ItemEntry.builder(Items.BEETROOT_SOUP).weight(8))));
    }
}