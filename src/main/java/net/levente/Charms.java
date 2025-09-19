package net.levente;

import net.fabricmc.api.ModInitializer;

import net.levente.blocks.ModBlocks;
import net.levente.component.ModDataComponentTypes;
import net.levente.items.ModItemGroups;
import net.levente.items.ModItems;
import net.levente.util.ClientModEvents;
import net.levente.world.gen.ModWorldGeneration;
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

		LOGGER.info("Hello Fabric world!");
	}
}