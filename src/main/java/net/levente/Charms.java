package net.levente;

import net.fabricmc.api.ModInitializer;

import net.levente.enchantments.ModEnchantments;
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
		ModEnchantments.registerModEnchantments();
		//ModLootTableModifiers.modifyLootTables();
		// Next Update: Add a new enchantment which increases the trinket's percent. Like when I enchant the Basic Ring,
		// it will increase the percent of the running modifier by X%.
		LOGGER.info("Hello Fabric world!");
	}
}