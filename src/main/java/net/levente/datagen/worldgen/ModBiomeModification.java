package net.levente.datagen.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModBiomeModification {
    public static void load() {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeature.NETHER_RUBY_ORE_KEY
        );
    }
}
