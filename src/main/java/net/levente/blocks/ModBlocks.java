package net.levente.blocks;

import net.levente.Charms;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlocks {

    public static final Block NETHER_RUBY_ORE = registerBlock("nether_ruby_ore", new Block(AbstractBlock.Settings.create()
            .strength(0.5F, 0F).sounds(BlockSoundGroup.NETHER_ORE)));
    public static final Block ARTIFACT_CRAFTER = registerBlock("artifact_crafter",
            new Block(AbstractBlock.Settings.copy(Blocks.CRAFTING_TABLE)));

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Charms.id(name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Charms.id(name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Charms.LOGGER.info("Registering blocks for: " + Charms.MOD_ID);
    }
}
