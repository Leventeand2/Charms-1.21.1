package net.levente.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.levente.Charms;
import net.levente.blocks.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final Text CHARMS_TITLE = Text.translatable("itemgroup." + Charms.MOD_ID + ".charms_group");

    public static final ItemGroup CHARMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Charms.MOD_ID, "lifesteal"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RUBY))
                    .displayName(CHARMS_TITLE)
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.RUBY_AMULET);
                        entries.add(ModItems.LAPIS_RING);
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.AMULET_STRING);
                        entries.add(ModItems.BASIC_RING);
                        entries.add(ModItems.RAW_RUBY);
                        entries.add(ModItems.GOLDEN_BRACELET);
                        entries.add(ModItems.RAW_RUBY_AMULET);
                        entries.add(ModBlocks.NETHER_RUBY_ORE);
                        entries.add(ModItems.MASK_OF_SHADOWS);
                        entries.add(ModBlocks.ARTIFACT_CRAFTER);
                        entries.add(ModItems.RUBY_RING);
                    })).build());


    public static void registerItemGroups() {
            Charms.LOGGER.info("Registering item groups for: " + Charms.MOD_ID);
    }
}
