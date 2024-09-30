package net.levente.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.levente.Charms;
import net.levente.items.ModItemGroups;
import net.levente.items.ModItems;
import net.levente.items.custom.LapisRing;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModLangProvider extends FabricLanguageProvider {
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
    }
}
