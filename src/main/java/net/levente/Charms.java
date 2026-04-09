package net.levente;

import net.fabricmc.api.ModInitializer;

import net.levente.blocks.ModBlocks;
import net.levente.items.ModItemGroups;
import net.levente.items.ModItems;
import net.levente.util.ModEvents;
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
        ModWorldGeneration.generateModWorldGen();
        ModLootTableModifiers.modifyLootTables();
		ModEvents.registerModEvents();

		LOGGER.info("Hello Fabric world!");
	}

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}