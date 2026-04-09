package net.levente.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.levente.items.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends FabricRecipeProvider {

    public ModRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> RUBY_SMELTING = List.of(ModItems.RAW_RUBY);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AMULET_STRING)
                .pattern("G G")
                .pattern("G G")
                .pattern(" G ")
                .input('G', Items.GOLD_NUGGET)
                .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_AMULET)
                .pattern(" S ")
                .pattern(" R ")
                .pattern("   ")
                .input('R', ModItems.RUBY)
                .input('S', ModItems.AMULET_STRING)
                .criterion(hasItem(ModItems.AMULET_STRING), conditionsFromItem(ModItems.AMULET_STRING))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAPIS_RING)
                .pattern(" L ")
                .pattern(" R ")
                .pattern("   ")
                .input('L', Items.LAPIS_LAZULI)
                .input('R', ModItems.BASIC_RING)
                .criterion(hasItem(ModItems.BASIC_RING), conditionsFromItem(ModItems.BASIC_RING))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BASIC_RING)
                .pattern(" G ")
                .pattern("G G")
                .pattern(" G ")
                .input('G', Items.GOLD_NUGGET)
                .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                .offerTo(exporter);

        offerSmelting(exporter, RUBY_SMELTING, RecipeCategory.MISC, ModItems.RUBY, 0.25f, 600, "ruby");
        offerBlasting(exporter, RUBY_SMELTING, RecipeCategory.MISC, ModItems.RUBY, 0.25f, 300, "ruby");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GOLDEN_BRACELET)
                .pattern("GGG")
                .pattern("GRG")
                .pattern("GGG")
                .input('G', Items.GOLD_NUGGET)
                .input('R', ModItems.BASIC_RING)
                .criterion(hasItem(ModItems.BASIC_RING), conditionsFromItem(ModItems.BASIC_RING))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_RUBY_AMULET)
                .pattern(" S ")
                .pattern(" R ")
                .pattern("   ")
                .input('R', ModItems.RAW_RUBY)
                .input('S', ModItems.AMULET_STRING)
                .criterion(hasItem(ModItems.RAW_RUBY), conditionsFromItem(ModItems.RAW_RUBY))
                .criterion(hasItem(ModItems.AMULET_STRING), conditionsFromItem(ModItems.AMULET_STRING))
                .offerTo(exporter);

        offerSmelting(
                exporter,
                List.of(Items.GOLD_BLOCK),
                RecipeCategory.MISC,
                ModItems.PURIFIED_GOLD_INGOT,
                3.0f,
                400,
                "purified_gold"
        );

        offerBlasting(
                exporter,
                List.of(Items.GOLD_BLOCK),
                RecipeCategory.MISC,
                ModItems.PURIFIED_GOLD_INGOT,
                3.8f,
                200,
                "purified_gold"
        );

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ETHER_CROWN)
                .pattern("G G")
                .pattern("GGG")
                .pattern("GGG")
                .input('G', ModItems.PURIFIED_GOLD_INGOT)
                .criterion(hasItem(ModItems.PURIFIED_GOLD_INGOT), conditionsFromItem(ModItems.PURIFIED_GOLD_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SCULK_CHARM)
                .pattern("SSS")
                .pattern("SCS")
                .pattern("SSS")
                .input('S', Items.ECHO_SHARD)
                .input('C', ModItems.ETHER_CROWN)
                .criterion(hasItem(Items.ECHO_SHARD), conditionsFromItem(Items.ECHO_SHARD))
                .criterion(hasItem(ModItems.ETHER_CROWN), conditionsFromItem(ModItems.ETHER_CROWN))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SATURATION_CHARM)
                .pattern(" S ")
                .pattern(" C ")
                .pattern("   ")
                .input('S', ModItems.AMULET_STRING)
                .input('C', Items.COOKED_BEEF)
                .criterion(hasItem(Items.COOKED_BEEF), conditionsFromItem(Items.COOKED_BEEF))
                .criterion(hasItem(ModItems.AMULET_STRING), conditionsFromItem(ModItems.AMULET_STRING))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DAMAGE_CHARM)
                .pattern("GGG")
                .pattern("G G")
                .pattern("GGG")
                .input('G', Items.GOLD_NUGGET)
                .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CLOSE_CALL_CHARM)
                .input(ModItems.DAMAGE_CHARM)
                .input(Items.TOTEM_OF_UNDYING)
                .criterion(hasItem(ModItems.DAMAGE_CHARM), conditionsFromItem(ModItems.DAMAGE_CHARM))
                .criterion(hasItem(Items.TOTEM_OF_UNDYING), conditionsFromItem(Items.TOTEM_OF_UNDYING))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STATS_CHARM)
                .pattern("S  ")
                .pattern("A  ")
                .pattern("   ")
                .input('S', ModItems.AMULET_STRING)
                .input('A', Items.AMETHYST_SHARD)
                .criterion(hasItem(ModItems.AMULET_STRING), conditionsFromItem(ModItems.AMULET_STRING))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter);


    }
}
