package net.levente.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.levente.Charms;
import net.levente.blocks.ModBlocks;
import net.levente.items.ModItemGroups;
import net.levente.items.ModItems;
import net.levente.items.custom.GoldenBracelet;
import net.levente.items.custom.LapisRing;
import net.levente.items.custom.RawRubyAmulet;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import org.jetbrains.annotations.NotNull;
import net.levente.datagen.provider.ModAdvancementsProvider.ModAdvancementTexts;

import java.util.concurrent.CompletableFuture;

public class ModLangProvider extends FabricLanguageProvider {
    private static final Text BRACELET = Text.translatable("trinkets.slot.hand.bracelet");

    public ModLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    private static void addText(@NotNull TranslationBuilder builder, @NotNull Text text, @NotNull String value) {
        if (text.getContent() instanceof TranslatableTextContent translatableTextContent) {
            builder.add(translatableTextContent.getKey(), value);
        } else {
            Charms.LOGGER.error("Failed to add translation for text: " + text);
        }
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.RUBY, "Ruby");
        translationBuilder.add(ModItems.RUBY_AMULET, "Ruby Amulet");
        translationBuilder.add(ModItems.LAPIS_RING, "Lapis Ring");
        addText(translationBuilder, ModItemGroups.CHARMS_TITLE, "Charms Item Group");
        addText(translationBuilder, LapisRing.LAPIS_RING_TOOLTIP_1, "§7When equipped:");
        addText(translationBuilder, LapisRing.LAPIS_RING_TOOLTIP_2, "§9Grants infinite water breathing");
        translationBuilder.add(ModItems.AMULET_STRING, "Amulet String");
        translationBuilder.add(ModItems.BASIC_RING, "Ring");
        translationBuilder.add(ModItems.RAW_RUBY, "Raw Ruby");
        addText(translationBuilder, BRACELET, "Bracelet");
        translationBuilder.add(ModItems.GOLDEN_BRACELET, "§6Binding of §cSerenity");
        translationBuilder.add(ModItems.RAW_RUBY_AMULET, "Raw Ruby Amulet");
        translationBuilder.add(ModBlocks.NETHER_RUBY_ORE, "Ruby Ore");
        addText(translationBuilder, ModAdvancementTexts.RUBY_TITLE, "Intro into Artifacts");
        addText(translationBuilder, ModAdvancementTexts.RUBY_DESCRIPTION, "This is just the beginning");
        addText(translationBuilder, GoldenBracelet.GOLDEN_BRACELET_TOOLTIP_1, "§7When equipped:");
        addText(translationBuilder, GoldenBracelet.GOLDEN_BRACELET_TOOLTIP_2, "§9Grants Resistance II");
        addText(translationBuilder, RawRubyAmulet.RAW_RUBY_AMULET_TOOLTIP_1, "§7When equipped:");
        addText(translationBuilder, RawRubyAmulet.RAW_RUBY_AMULET_TOOLTIP_2, "§9Grants Slow Falling");
        addText(translationBuilder, ModAdvancementTexts.RUBY_AMULET_TITLE, "What a Gem!");
        addText(translationBuilder, ModAdvancementTexts.RUBY_AMULET_DESCRIPTION, "You've made a Ruby Amulet!");
        addText(translationBuilder, ModAdvancementTexts.BASIC_RING_TITLE, "Ohh so beautiful!");
        addText(translationBuilder, ModAdvancementTexts.BASIC_RING_DESCRIPTION, "You've made a Basic Ring!");
        addText(translationBuilder, ModAdvancementTexts.LAPIS_RING_TITLE, "Lapis is useful now!");
        addText(translationBuilder, ModAdvancementTexts.LAPIS_RING_DESCRIPTION, "You've made a Lapis Ring!");
        translationBuilder.add(ModItems.MASK_OF_SHADOWS, "Mask of Shadows");
        addText(translationBuilder, ModAdvancementTexts.MASK_OF_SHADOWS_TITLE, "Shadowy Figure");
        addText(translationBuilder, ModAdvancementTexts.MASK_OF_SHADOWS_DESCRIPTION, "You've made a Mask of Shadows!");
    }
}
