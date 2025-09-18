package net.levente.blocks;

import net.levente.Charms;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block NETHER_RUBY_ORE = registerBlock("nether_ruby_ore",
            new Block(AbstractBlock.Settings.create()
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHER_ORE)
                    .strength(4.5f)
                    .requires()));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Charms.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Charms.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Charms.LOGGER.info("Registering mod blocks for: " + Charms.MOD_ID + "...");
    }
}
