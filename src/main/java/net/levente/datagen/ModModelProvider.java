package net.levente.datagen;

import com.terraformersmc.modmenu.util.mod.Mod;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
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

    }

    @Override
    public void generateItemModels(ItemModelGenerator modelGen) {
        modelGen.register(ModItems.LAPIS_RING, Models.GENERATED);
        modelGen.register(ModItems.RUBY, Models.GENERATED);
        modelGen.register(ModItems.AMULET_STRING, Models.GENERATED);
        modelGen.register(ModItems.BASIC_RING, Models.GENERATED);
        modelGen.register(ModItems.RAW_RUBY, Models.GENERATED);
        modelGen.register(ModItems.GOLDEN_BRACELET, Models.GENERATED);
        modelGen.register(ModItems.RAW_RUBY_AMULET, Models.GENERATED);
    }
}
