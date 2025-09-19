package net.levente.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.levente.Charms;
import net.levente.items.ModItems;
import net.levente.util.ModTags;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.RecipeCraftedCriterion;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementsProvider extends FabricAdvancementProvider {
    public ModAdvancementsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> consumer) {
        ItemPredicate relics = ItemPredicate.Builder.create().tag(ModTags.Items.ARTIFACT_ITEMS).build();


        AdvancementEntry getRuby = Advancement.Builder.create()
                .display(
                        ModItems.RUBY, // Display icon
                        Text.literal("Introduction into relics"), // Title
                        Text.literal("Look at some craftings with ruby!"), // desc.
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // background only if this is a root advancement
                        AdvancementFrame.GOAL,
                        true, // Show the toast when completing
                        true, // Announce it to chat
                        false // Hide until achieved
                )

                .criterion("got_ruby", InventoryChangedCriterion.Conditions.items(ModItems.RUBY))

                .build(consumer, Charms.MOD_ID + ":get_ruby");

        AdvancementEntry getRelic = Advancement.Builder.create()
                .parent(getRuby)
                .display(
                        ModItems.AMULET_STRING,
                        Text.literal("Ancient relics!"),
                        Text.literal("Wow, what do these do?"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )

                .criterion("got_relic", InventoryChangedCriterion.Conditions.items(relics))

                .build(consumer, Charms.MOD_ID + ":get_relic");

        AdvancementEntry getSculkCharm = Advancement.Builder.create()
                .parent(getRuby)
                .display(
                        ModItems.SCULK_CHARM,
                        Text.literal("Playing with sculk"),
                        Text.literal("You can't hear me now!"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )

                .criterion("got_sculk_charm", InventoryChangedCriterion.Conditions.items(ModItems.SCULK_CHARM))

                .build(consumer, Charms.MOD_ID + ":get_sculk_charm");

        AdvancementEntry craftEtherCrown = Advancement.Builder.create()
                .parent(getRuby)
                .display(
                        ModItems.ETHER_CROWN,
                        Text.literal("Holy crown"),
                        Text.literal("The holiest crown"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        true
                )

                .criterion("crafted_ether_crown", RecipeCraftedCriterion.Conditions.create(Identifier.of(Charms.MOD_ID, "ether_crown")))

                .build(consumer, Charms.MOD_ID + ":craft_ether_crown");
    }
}
