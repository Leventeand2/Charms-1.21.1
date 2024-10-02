package net.levente.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.levente.blocks.ModBlocks;
import net.levente.items.ModItems;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTablesProvider extends FabricBlockLootTableProvider {
    public ModLootTablesProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.NETHER_RUBY_ORE, drops(ModItems.RAW_RUBY));
        addDropWithSilkTouch(ModBlocks.NETHER_RUBY_ORE, ModBlocks.NETHER_RUBY_ORE);
    }
}
