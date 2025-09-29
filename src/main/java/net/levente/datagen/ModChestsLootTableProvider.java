package net.levente.datagen;

import dev.emi.trinkets.api.TrinketItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.levente.Charms;
import net.levente.util.ModTags;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextType;
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




    }
}
