package net.hillsidemod.hillside.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hillsidemod.hillside.block.ModBlocks;
import net.hillsidemod.hillside.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        //BLACK BRICK
        createStairsRecipe(ModBlocks.BRICK_BLACK_STAIRS, Ingredient.ofItems(ModBlocks.BRICK_BLACK.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_BLACK.asItem()), conditionsFromItem(ModBlocks.BRICK_BLACK.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_BLACK_STAIRS.asItem())));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_BLACK_SLAB, Ingredient.ofItems(ModBlocks.BRICK_BLACK.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_BLACK.asItem()), conditionsFromItem(ModBlocks.BRICK_BLACK.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_BLACK_SLAB.asItem())));

        createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_BLACK_PLATE, Ingredient.ofItems(ModBlocks.BRICK_BLACK.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_BLACK.asItem()), conditionsFromItem(ModBlocks.BRICK_BLACK.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_BLACK_PLATE.asItem())));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_BLACK_BUTTON.asItem(), 1)
                .input(Ingredient.ofItems(ModBlocks.BRICK_BLACK.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_BLACK.asItem()), conditionsFromItem(ModBlocks.BRICK_BLACK.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_BLACK_BUTTON.asItem())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_BLACK_WALL.asItem(), 6)
                .pattern("   ")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModBlocks.BRICK_BLACK.asItem())
                .criterion(hasItem(ModBlocks.BRICK_BLACK.asItem()), conditionsFromItem(ModBlocks.BRICK_BLACK.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_BLACK_WALL.asItem())));

        //BROWN BRICK
        createStairsRecipe(ModBlocks.BRICK_BROWN_STAIRS, Ingredient.ofItems(ModBlocks.BRICK_BROWN.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_BROWN.asItem()), conditionsFromItem(ModBlocks.BRICK_BROWN.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_BROWN_STAIRS.asItem())));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_BROWN_SLAB, Ingredient.ofItems(ModBlocks.BRICK_BROWN.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_BROWN.asItem()), conditionsFromItem(ModBlocks.BRICK_BROWN.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_BROWN_SLAB.asItem())));

        createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_BROWN_PLATE, Ingredient.ofItems(ModBlocks.BRICK_BROWN.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_BROWN.asItem()), conditionsFromItem(ModBlocks.BRICK_BROWN.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_BROWN_PLATE.asItem())));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_BROWN_BUTTON.asItem(), 1)
                .input(Ingredient.ofItems(ModBlocks.BRICK_BROWN.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_BROWN.asItem()), conditionsFromItem(ModBlocks.BRICK_BROWN.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_BROWN_BUTTON.asItem())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_BROWN_WALL.asItem(), 6)
                .pattern("   ")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModBlocks.BRICK_BROWN.asItem())
                .criterion(hasItem(ModBlocks.BRICK_BROWN.asItem()), conditionsFromItem(ModBlocks.BRICK_BROWN.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_BROWN_WALL.asItem())));

        //MULTICOLORED BRICK
        createStairsRecipe(ModBlocks.BRICK_MULTICOLORED_STAIRS, Ingredient.ofItems(ModBlocks.BRICK_MULTICOLORED.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_MULTICOLORED.asItem()), conditionsFromItem(ModBlocks.BRICK_MULTICOLORED.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_MULTICOLORED_STAIRS.asItem())));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_MULTICOLORED_SLAB, Ingredient.ofItems(ModBlocks.BRICK_MULTICOLORED.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_MULTICOLORED.asItem()), conditionsFromItem(ModBlocks.BRICK_MULTICOLORED.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_MULTICOLORED_SLAB.asItem())));

        createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_MULTICOLORED_PLATE, Ingredient.ofItems(ModBlocks.BRICK_MULTICOLORED.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_MULTICOLORED.asItem()), conditionsFromItem(ModBlocks.BRICK_MULTICOLORED.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_MULTICOLORED_PLATE.asItem())));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_MULTICOLORED_BUTTON.asItem(), 1)
                .input(Ingredient.ofItems(ModBlocks.BRICK_MULTICOLORED.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_MULTICOLORED.asItem()), conditionsFromItem(ModBlocks.BRICK_MULTICOLORED.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_MULTICOLORED_BUTTON.asItem())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_MULTICOLORED_WALL.asItem(), 6)
                .pattern("   ")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModBlocks.BRICK_MULTICOLORED.asItem())
                .criterion(hasItem(ModBlocks.BRICK_MULTICOLORED.asItem()), conditionsFromItem(ModBlocks.BRICK_MULTICOLORED.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_MULTICOLORED_WALL.asItem())));

        //PINK BRICK
        createStairsRecipe(ModBlocks.BRICK_PINK_STAIRS, Ingredient.ofItems(ModBlocks.BRICK_PINK.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_PINK.asItem()), conditionsFromItem(ModBlocks.BRICK_PINK.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_PINK_STAIRS.asItem())));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_PINK_SLAB, Ingredient.ofItems(ModBlocks.BRICK_PINK.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_PINK.asItem()), conditionsFromItem(ModBlocks.BRICK_PINK.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_PINK_SLAB.asItem())));

        createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_PINK_PLATE, Ingredient.ofItems(ModBlocks.BRICK_PINK.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_PINK.asItem()), conditionsFromItem(ModBlocks.BRICK_PINK.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_PINK_PLATE.asItem())));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_PINK_BUTTON.asItem(), 1)
                .input(Ingredient.ofItems(ModBlocks.BRICK_PINK.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_PINK.asItem()), conditionsFromItem(ModBlocks.BRICK_PINK.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_PINK_BUTTON.asItem())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_PINK_WALL.asItem(), 6)
                .pattern("   ")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModBlocks.BRICK_PINK.asItem())
                .criterion(hasItem(ModBlocks.BRICK_PINK.asItem()), conditionsFromItem(ModBlocks.BRICK_PINK.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_PINK_WALL.asItem())));

        //TAN BRICK
        createStairsRecipe(ModBlocks.BRICK_TAN_STAIRS, Ingredient.ofItems(ModBlocks.BRICK_TAN.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_TAN.asItem()), conditionsFromItem(ModBlocks.BRICK_TAN.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_TAN_STAIRS.asItem())));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_TAN_SLAB, Ingredient.ofItems(ModBlocks.BRICK_TAN.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_TAN.asItem()), conditionsFromItem(ModBlocks.BRICK_TAN.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_TAN_SLAB.asItem())));

        createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_TAN_PLATE, Ingredient.ofItems(ModBlocks.BRICK_TAN.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_TAN.asItem()), conditionsFromItem(ModBlocks.BRICK_TAN.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_TAN_PLATE.asItem())));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_TAN_BUTTON.asItem(), 1)
                .input(Ingredient.ofItems(ModBlocks.BRICK_TAN.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_TAN.asItem()), conditionsFromItem(ModBlocks.BRICK_TAN.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_TAN_BUTTON.asItem())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_TAN_WALL.asItem(), 6)
                .pattern("   ")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModBlocks.BRICK_TAN.asItem())
                .criterion(hasItem(ModBlocks.BRICK_TAN.asItem()), conditionsFromItem(ModBlocks.BRICK_TAN.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_TAN_WALL.asItem())));

        //WHITE BRICK
        createStairsRecipe(ModBlocks.BRICK_WHITE_STAIRS, Ingredient.ofItems(ModBlocks.BRICK_WHITE.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_WHITE.asItem()), conditionsFromItem(ModBlocks.BRICK_WHITE.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_WHITE_STAIRS.asItem())));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_WHITE_SLAB, Ingredient.ofItems(ModBlocks.BRICK_WHITE.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_WHITE.asItem()), conditionsFromItem(ModBlocks.BRICK_WHITE.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_WHITE_SLAB.asItem())));

        createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_WHITE_PLATE, Ingredient.ofItems(ModBlocks.BRICK_WHITE.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_WHITE.asItem()), conditionsFromItem(ModBlocks.BRICK_WHITE.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_WHITE_PLATE.asItem())));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_WHITE_BUTTON.asItem(), 1)
                .input(Ingredient.ofItems(ModBlocks.BRICK_WHITE.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_WHITE.asItem()), conditionsFromItem(ModBlocks.BRICK_WHITE.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_WHITE_BUTTON.asItem())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_WHITE_WALL.asItem(), 6)
                .pattern("   ")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModBlocks.BRICK_WHITE.asItem())
                .criterion(hasItem(ModBlocks.BRICK_WHITE.asItem()), conditionsFromItem(ModBlocks.BRICK_WHITE.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BRICK_WHITE_WALL.asItem())));
    }
}
