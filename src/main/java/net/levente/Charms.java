package net.levente;

import net.fabricmc.api.ModInitializer;

import net.levente.blocks.ModBlocks;
import net.levente.component.ModDataComponentTypes;
import net.levente.items.ModItemGroups;
import net.levente.items.ModItems;
import net.levente.util.ModLootTableModifiers;
import net.levente.world.gen.ModWorldGeneration;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Charms implements ModInitializer {
	public static final String MOD_ID = "charms";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
        ModBlocks.registerModBlocks();
        ModDataComponentTypes.registerDataCompTypes();
        ModWorldGeneration.generateModWorldGen();
        ModLootTableModifiers.modifyLootTables();

		LOGGER.info("Hello Fabric world!");
		LOGGER.info("Fix structure with structure blocks around the edge!");
	}

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}