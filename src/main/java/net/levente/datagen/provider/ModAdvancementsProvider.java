package net.levente.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.levente.Charms;
import net.levente.items.ModItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementsProvider extends FabricAdvancementProvider {
    public static final Text AMULET_STRING_TITLE = Text.translatable("advancements.charms.amulet_string_title");
    public static final Text AMULET_STRING_DESCRIPTION = Text.translatable("advancements.charms.amulet_string_description");
    public static final Text RUBY_AMULET_TITLE = Text.translatable("advancements." + Charms.MOD_ID + ".ruby_amulet_title");
    public static final Text RUBY_AMULET_DESCRIPTION = Text.translatable("advancements." + Charms.MOD_ID + ".ruby_amulet_description");
    public static final Text LAPIS_RING_TITLE = Text.translatable("advancements." + Charms.MOD_ID + ".lapis_ring_title");
    public static final Text LAPIS_RING_DESCRIPTION = Text.translatable("advancements." + Charms.MOD_ID + ".lapis_ring_description");

    public ModAdvancementsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry rootAdvancement = Advancement.Builder.create()
                .display(
                        ModItems.AMULET_STRING,
                        Text.translatable(AMULET_STRING_TITLE.getString()),
                        Text.translatable(AMULET_STRING_DESCRIPTION.getString()),
                        Identifier.of("charms:textures/gui/advancements/backgrounds/advancement.png"),
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .criterion("has_amulet_string", InventoryChangedCriterion.Conditions.items(ModItems.AMULET_STRING))
                .build(consumer, "charms" + "/root");
        AdvancementEntry gotRubyAmulet = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.RUBY_AMULET,
                        RUBY_AMULET_TITLE,
                        RUBY_AMULET_DESCRIPTION,
                        Identifier.of(Charms.MOD_ID + ":textures/gui/advancements/backgrounds/advancement.png"),
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .criterion("has_ruby_amulet", InventoryChangedCriterion.Conditions.items(ModItems.RUBY_AMULET))
                .build(consumer, Charms.MOD_ID + "/has_ruby_amulet");
        AdvancementEntry gotLapisRing = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.LAPIS_RING,
                        LAPIS_RING_TITLE,
                        LAPIS_RING_DESCRIPTION,
                        Identifier.of(Charms.MOD_ID + ":textures/gui/advancements/backgrounds/advancement.png"),
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .criterion("has_lapis_ring", InventoryChangedCriterion.Conditions.items(ModItems.LAPIS_RING))
                .build(consumer, Charms.MOD_ID + "/has_lapis_ring");
    }
}
