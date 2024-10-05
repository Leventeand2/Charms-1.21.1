package net.levente.items;

import net.levente.Charms;
import net.levente.items.custom.*;
import net.levente.items.custom.food.ArtifactEssence;
import net.levente.items.custom.food.ModFoodComponents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RUBY_AMULET = registerItem("ruby_amulet",
            new RubyAmulet(new Item.Settings().maxCount(1)));
    public static final Item LAPIS_RING = registerItem("lapis_ring",
            new LapisRing(new Item.Settings().maxCount(1)));
    public static final Item RUBY = registerItem("ruby",
            new Item(new Item.Settings()));
    public static final Item AMULET_STRING = registerItem("amulet_string",
            new Item(new Item.Settings().maxCount(3)));
    public static final Item BASIC_RING = registerItem("basic_ring",
            new BasicRing(new Item.Settings().maxCount(1)));
    public static final Item RAW_RUBY = registerItem("raw_ruby",
            new Item(new Item.Settings().maxCount(1)));
    public static final Item GOLDEN_BRACELET = registerItem("golden_bracelet",
            new GoldenBracelet(new Item.Settings().maxCount(1)));
    public static final Item RAW_RUBY_AMULET = registerItem("raw_ruby_amulet",
            new RawRubyAmulet(new Item.Settings().maxCount(1)));
    public static final Item MASK_OF_SHADOWS = registerItem("mask_of_shadows",
            new MaskOfShadows(new Item.Settings().maxCount(1)));
    public static final Item RUBY_RING = registerItem("ruby_ring",
            new RubyRing(new Item.Settings().maxCount(1)));
    public static final Item ARTIFACT_ESSENCE = registerItem("artifact_essence",
            new ArtifactEssence(new Item.Settings().food(ModFoodComponents.ARTIFACT_ESSENCE)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Charms.MOD_ID, name), item);
    }
    public static void registerItems() {
        Charms.LOGGER.info("Registering items for: " + Charms.MOD_ID);
    }
}
