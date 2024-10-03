package net.levente.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.levente.blocks.ModBlocks;
import net.levente.items.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_RUBY_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGen) {
        itemModelGen.register(ModItems.LAPIS_RING, Models.GENERATED);
        itemModelGen.register(ModItems.RUBY, Models.GENERATED);
        itemModelGen.register(ModItems.AMULET_STRING, Models.GENERATED);
        itemModelGen.register(ModItems.BASIC_RING, Models.GENERATED);
        itemModelGen.register(ModItems.RAW_RUBY, Models.GENERATED);
        itemModelGen.register(ModItems.GOLDEN_BRACELET, Models.GENERATED);
        itemModelGen.register(ModItems.RAW_RUBY_AMULET, Models.GENERATED);
        itemModelGen.register(ModItems.MASK_OF_SHADOWS, Models.GENERATED);
    }
}
