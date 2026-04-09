package net.levente.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.levente.items.ModItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            Identifier id = key.getValue();

            // all archaeology tables (sand + gravel)
            if ("minecraft".equals(id.getNamespace()) && id.getPath().startsWith("archaeology/")) {
                LootPool.Builder pool = LootPool.builder()
                        .rolls(BinomialLootNumberProvider.create(1, 0.3f)) // 30% chance to roll one item
                        .with(ItemEntry.builder(ModItems.RUBY_AMULET).weight(1))
                        .with(ItemEntry.builder(ModItems.LAPIS_RING).weight(1))
                        .with(ItemEntry.builder(ModItems.BASIC_RING).weight(1))
                        .with(ItemEntry.builder(ModItems.GOLDEN_BRACELET).weight(1))
                        .with(ItemEntry.builder(ModItems.RAW_RUBY_AMULET).weight(1))
                        .with(ItemEntry.builder(ModItems.ETHER_CROWN).weight(1))
                        .with(ItemEntry.builder(ModItems.SCULK_CHARM).weight(1))
                        .with(ItemEntry.builder(ModItems.SATURATION_CHARM).weight(1))
                        .with(ItemEntry.builder(ModItems.DAMAGE_CHARM).weight(1))
                        .with(ItemEntry.builder(ModItems.CLOSE_CALL_CHARM).weight(1))
                        .with(ItemEntry.builder(ModItems.STATS_CHARM).weight(1));

                tableBuilder.pool(pool);
            }

            if ("minecraft".equals(id.getNamespace())) {
                switch (id.getPath()) {
                    case "chests/trial_chamber/common" -> addTrialLoot(tableBuilder, 0.05f);
                    case "chests/trial_chamber/rare" -> addTrialLoot(tableBuilder, 0.15f);
                    case "chests/trial_chamber/epic" -> addTrialLoot(tableBuilder, 0.3f);
                }
            }
        });
    }

    private static void addTrialLoot(LootTable.Builder tableBuilder, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(BinomialLootNumberProvider.create(1, chance))
                .with(ItemEntry.builder(ModItems.RUBY_AMULET).weight(1))
                .with(ItemEntry.builder(ModItems.LAPIS_RING).weight(1))
                .with(ItemEntry.builder(ModItems.BASIC_RING).weight(1))
                .with(ItemEntry.builder(ModItems.GOLDEN_BRACELET).weight(1))
                .with(ItemEntry.builder(ModItems.RAW_RUBY_AMULET).weight(1))
                .with(ItemEntry.builder(ModItems.ETHER_CROWN).weight(1))
                .with(ItemEntry.builder(ModItems.SCULK_CHARM).weight(1))
                .with(ItemEntry.builder(ModItems.SATURATION_CHARM).weight(1))
                .with(ItemEntry.builder(ModItems.DAMAGE_CHARM).weight(1))
                .with(ItemEntry.builder(ModItems.CLOSE_CALL_CHARM).weight(1))
                .with(ItemEntry.builder(ModItems.STATS_CHARM).weight(1));
    }
}
