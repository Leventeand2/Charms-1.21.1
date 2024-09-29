package net.levente.items;

import net.levente.Charms;
import net.levente.items.custom.RubyAmulet;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RUBY_AMULET = registerItem("ruby_amulet",
            new RubyAmulet(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Charms.MOD_ID, name), item);
    }
    public static void registerItems() {
        Charms.LOGGER.info("Registering items for: " + Charms.MOD_ID);
    }
}
