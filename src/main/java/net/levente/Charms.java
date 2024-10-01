package net.levente;

import net.fabricmc.api.ModInitializer;

import net.levente.items.ModItemGroups;
import net.levente.items.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Charms implements ModInitializer {
	public static final String MOD_ID = "charms";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerItems();
		ModItemGroups.registerItemGroups();
		// Next Update: Add a new block which will "upgrade" the artifact item
		LOGGER.info("Hello Fabric world!");
	}
}