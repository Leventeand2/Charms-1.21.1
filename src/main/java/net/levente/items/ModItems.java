package net.levente.items;

import net.levente.Charms;
import net.levente.items.custom.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {

    public static final Item RUBY_AMULET = registerItem("ruby_amulet",
            new RubyAmulet(new Item.Settings().maxCount(1).maxDamage(100000000)));
    public static final Item LAPIS_RING = registerItem("lapis_ring",
            new LapisRing(new Item.Settings().maxCount(1).maxDamage(100000000)));
    public static final Item RUBY = registerItem("ruby",
            new Item(new Item.Settings()));
    public static final Item AMULET_STRING = registerItem("amulet_string",
            new Item(new Item.Settings().maxCount(6)));
    public static final Item BASIC_RING = registerItem("basic_ring",
            new BasicRing(new Item.Settings().maxCount(1).maxDamage(100000000)));
    public static final Item RAW_RUBY = registerItem("raw_ruby",
            new Item(new Item.Settings()));
    public static final Item GOLDEN_BRACELET = registerItem("golden_bracelet",
            new GoldenBracelet(new Item.Settings().maxCount(1).maxDamage(100000000)));
    public static final Item RAW_RUBY_AMULET = registerItem("raw_ruby_amulet",
            new RawRubyAmulet(new Item.Settings().maxCount(1).maxDamage(100000000)));
    public static final Item ETHER_CROWN = registerItem("ether_crown",
            new EtherCrown(new Item.Settings().maxCount(1).fireproof().maxDamage(100000000)));
    public static final Item PURIFIED_GOLD_INGOT = registerItem("purified_gold_ingot",
            new Item(new Item.Settings().fireproof()));
    public static final Item SCULK_CHARM = registerItem("sculk_charm",
            new SculkCharm(new Item.Settings().maxCount(1).maxDamage(100000000)));
    public static final Item SATURATION_CHARM = registerItem("saturation_charm",
            new SaturationCharm(new Item.Settings().maxCount(1).maxDamage(100000000)));
    public static final Item DAMAGE_CHARM = registerItem("damage_charm",
            new DamageCharm(new Item.Settings().maxCount(1).maxDamage(100000000)));
    public static final Item CLOSE_CALL_CHARM = registerItem("close_call_charm",
            new CloseCallCharm(new Item.Settings().maxCount(1).maxDamage(5)));
    public static final Item STATS_CHARM = registerItem("stats_charm",
            new StatsCharm(new Item.Settings().maxCount(1).maxDamage(100000000)));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Charms.id(name), item);
    }
    public static void registerModItems() {
        Charms.LOGGER.info("Registering items for: " + Charms.MOD_ID);
    }
}
