package net.levente.util;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;

public class GetRandomItem {

    public static Item getRandomItem(ServerWorld world, TagKey<Item> tagKey) {
        var registry = world.getRegistryManager().get(RegistryKeys.ITEM);

        var entryListOptional = registry.getEntryList(tagKey).orElse(null);
        if () // TODO: Fix this!
    }
}
