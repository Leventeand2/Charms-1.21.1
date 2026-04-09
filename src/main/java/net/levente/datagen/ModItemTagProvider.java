package net.levente.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.levente.items.ModItems;
import net.levente.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.ARTIFACT_ITEMS)
                .add(ModItems.ETHER_CROWN)
                .add(ModItems.BASIC_RING)
                .add(ModItems.GOLDEN_BRACELET)
                .add(ModItems.LAPIS_RING)
                .add(ModItems.RAW_RUBY_AMULET)
                .add(ModItems.RUBY_AMULET)
                .add(ModItems.SCULK_CHARM)
                .add(ModItems.SATURATION_CHARM)
                .add(ModItems.DAMAGE_CHARM)
                .add(ModItems.CLOSE_CALL_CHARM)
                .add(ModItems.STATS_CHARM);
        getOrCreateTagBuilder(ModTags.Items.SEED_ITEMS)
                .add(Items.WHEAT_SEEDS)
                .add(Items.BEETROOT_SEEDS)
                .add(Items.PUMPKIN_SEEDS)
                .add(Items.MELON_SEEDS)
                .add(Items.TORCHFLOWER_SEEDS)
                .add(Items.PITCHER_POD);
        getOrCreateTagBuilder(ModTags.Items.IRON_TOOLS)
                .add(Items.IRON_SWORD)
                .add(Items.IRON_SHOVEL)
                .add(Items.IRON_AXE)
                .add(Items.IRON_HOE)
                .add(Items.IRON_PICKAXE);
    }
}
