package net.levente.util;

import net.levente.Charms;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> ARTIFACT_ITEMS = createTag("artifact_items");
        public static final TagKey<Item> SEED_ITEMS = createTag("seed_items");
        public static final TagKey<Item> IRON_TOOLS = createTag("iron_tools");

        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Charms.MOD_ID, name));
        }
    }
}
