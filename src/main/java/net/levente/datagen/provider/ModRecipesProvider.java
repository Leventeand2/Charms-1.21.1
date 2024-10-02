package net.levente.datagen.provider;

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
                .pattern("GGG")
                .pattern("G G")
                .pattern("GGG")
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
    }
}
