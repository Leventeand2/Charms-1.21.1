package net.levente;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.levente.datagen.provider.ModLangProvider;
import net.levente.datagen.provider.ModLootTablesProvider;
import net.levente.datagen.provider.ModRecipesProvider;
import net.levente.datagen.provider.ModModelProvider;
import net.levente.datagen.generator.CharmsModWorldGenerator;
import net.levente.datagen.worldgen.ModConfiguredFeature;
import net.levente.datagen.worldgen.ModPlacedFeature;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class CharmsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModLangProvider::new);
		pack.addProvider(ModRecipesProvider::new);
		pack.addProvider(CharmsModWorldGenerator::new);
		pack.addProvider(ModLootTablesProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeature::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeature::bootstrap);
	}
}
