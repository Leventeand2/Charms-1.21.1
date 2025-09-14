package net.levente.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.levente.Charms;
import net.levente.items.ModItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
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
        ItemPredicate relics = ItemPredicate.Builder.create().items(
                ModItems.BASIC_RING,
                ModItems.LAPIS_RING,
                ModItems.GOLDEN_BRACELET,
                ModItems.ETHER_CROWN,
                ModItems.RAW_RUBY_AMULET,
                ModItems.RUBY_AMULET
        ).build();


        AdvancementEntry getRuby = Advancement.Builder.create()
                .display(
                        ModItems.RUBY, // Display icon
                        Text.literal("Introduction into relics!"), // Title
                        Text.literal("Look at some craftings with ruby!"), // desc.
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // background only if this is a root advancement
                        AdvancementFrame.GOAL,
                        true, // Show the toast when completing
                        true, // Announce it to chat
                        true // Hide until achieved
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
                        true
                )

                .criterion("got_relic", InventoryChangedCriterion.Conditions.items(relics))

                .build(consumer, Charms.MOD_ID + ":get_relic");

        AdvancementEntry getMaskOfShadows = Advancement.Builder.create()
                .parent(getRuby)
                .display(
                        ModItems.MASK_OF_SHADOWS,
                        Text.literal("Lurking in the Shadows"),
                        Text.literal("This looks creepy"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        true
                )
                .criterion("got_mask_of_shadows", InventoryChangedCriterion.Conditions.items(ModItems.MASK_OF_SHADOWS))
                .build(consumer, Charms.MOD_ID + ":get_mask_of_shadows");
    }
}
