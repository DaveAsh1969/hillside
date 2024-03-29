package net.hillsidemod.hillside.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hillsidemod.hillside.block.ModBlocks;
import net.hillsidemod.hillside.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
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
                .offerTo(exporter);

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_BLACK_SLAB, Ingredient.ofItems(ModBlocks.BRICK_BLACK.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_BLACK.asItem()), conditionsFromItem(ModBlocks.BRICK_BLACK.asItem()))
                .offerTo(exporter);

        createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_BLACK_PLATE, Ingredient.ofItems(ModBlocks.BRICK_BLACK.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_BLACK.asItem()), conditionsFromItem(ModBlocks.BRICK_BLACK.asItem()))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_BLACK_BUTTON.asItem(), 1)
                .input(Ingredient.ofItems(ModBlocks.BRICK_BLACK.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_BLACK.asItem()), conditionsFromItem(ModBlocks.BRICK_BLACK.asItem()))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_BLACK_WALL.asItem(), 6)
                .pattern("   ")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModBlocks.BRICK_BLACK.asItem())
                .criterion(hasItem(ModBlocks.BRICK_BLACK.asItem()), conditionsFromItem(ModBlocks.BRICK_BLACK.asItem()))
                .offerTo(exporter);

        //BROWN BRICK
        createStairsRecipe(ModBlocks.BRICK_BROWN_STAIRS, Ingredient.ofItems(ModBlocks.BRICK_BROWN.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_BROWN.asItem()), conditionsFromItem(ModBlocks.BRICK_BROWN.asItem()))
                .offerTo(exporter);

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_BROWN_SLAB, Ingredient.ofItems(ModBlocks.BRICK_BROWN.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_BROWN.asItem()), conditionsFromItem(ModBlocks.BRICK_BROWN.asItem()))
                .offerTo(exporter);

        createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_BROWN_PLATE, Ingredient.ofItems(ModBlocks.BRICK_BROWN.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_BROWN.asItem()), conditionsFromItem(ModBlocks.BRICK_BROWN.asItem()))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_BROWN_BUTTON.asItem(), 1)
                .input(Ingredient.ofItems(ModBlocks.BRICK_BROWN.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_BROWN.asItem()), conditionsFromItem(ModBlocks.BRICK_BROWN.asItem()))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_BROWN_WALL.asItem(), 6)
                .pattern("   ")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModBlocks.BRICK_BROWN.asItem())
                .criterion(hasItem(ModBlocks.BRICK_BROWN.asItem()), conditionsFromItem(ModBlocks.BRICK_BROWN.asItem()))
                .offerTo(exporter);

        //PURPLE(LAVENDER) BRICK
        createStairsRecipe(ModBlocks.BRICK_LAVENDER_STAIRS, Ingredient.ofItems(ModBlocks.BRICK_LAVENDER.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_LAVENDER.asItem()), conditionsFromItem(ModBlocks.BRICK_LAVENDER.asItem()))
                .offerTo(exporter);

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_LAVENDER_SLAB, Ingredient.ofItems(ModBlocks.BRICK_LAVENDER.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_LAVENDER.asItem()), conditionsFromItem(ModBlocks.BRICK_LAVENDER.asItem()))
                .offerTo(exporter);

        createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_LAVENDER_PLATE, Ingredient.ofItems(ModBlocks.BRICK_LAVENDER.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_LAVENDER.asItem()), conditionsFromItem(ModBlocks.BRICK_LAVENDER.asItem()))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_LAVENDER_BUTTON.asItem(), 1)
                .input(Ingredient.ofItems(ModBlocks.BRICK_LAVENDER.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_LAVENDER.asItem()), conditionsFromItem(ModBlocks.BRICK_LAVENDER.asItem()))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_LAVENDER_WALL.asItem(), 6)
                .pattern("   ")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModBlocks.BRICK_LAVENDER.asItem())
                .criterion(hasItem(ModBlocks.BRICK_LAVENDER.asItem()), conditionsFromItem(ModBlocks.BRICK_LAVENDER.asItem()))
                .offerTo(exporter);

        //MULTICOLORED BRICK
        createStairsRecipe(ModBlocks.BRICK_MULTICOLORED_STAIRS, Ingredient.ofItems(ModBlocks.BRICK_MULTICOLORED.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_MULTICOLORED.asItem()), conditionsFromItem(ModBlocks.BRICK_MULTICOLORED.asItem()))
                .offerTo(exporter);

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_MULTICOLORED_SLAB, Ingredient.ofItems(ModBlocks.BRICK_MULTICOLORED.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_MULTICOLORED.asItem()), conditionsFromItem(ModBlocks.BRICK_MULTICOLORED.asItem()))
                .offerTo(exporter);

        createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_MULTICOLORED_PLATE, Ingredient.ofItems(ModBlocks.BRICK_MULTICOLORED.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_MULTICOLORED.asItem()), conditionsFromItem(ModBlocks.BRICK_MULTICOLORED.asItem()))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_MULTICOLORED_BUTTON.asItem(), 1)
                .input(Ingredient.ofItems(ModBlocks.BRICK_MULTICOLORED.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_MULTICOLORED.asItem()), conditionsFromItem(ModBlocks.BRICK_MULTICOLORED.asItem()))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_MULTICOLORED_WALL.asItem(), 6)
                .pattern("   ")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModBlocks.BRICK_MULTICOLORED.asItem())
                .criterion(hasItem(ModBlocks.BRICK_MULTICOLORED.asItem()), conditionsFromItem(ModBlocks.BRICK_MULTICOLORED.asItem()))
                .offerTo(exporter);

        //PINK BRICK
        createStairsRecipe(ModBlocks.BRICK_PINK_STAIRS, Ingredient.ofItems(ModBlocks.BRICK_PINK.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_PINK.asItem()), conditionsFromItem(ModBlocks.BRICK_PINK.asItem()))
                .offerTo(exporter);

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_PINK_SLAB, Ingredient.ofItems(ModBlocks.BRICK_PINK.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_PINK.asItem()), conditionsFromItem(ModBlocks.BRICK_PINK.asItem()))
                .offerTo(exporter);

        createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_PINK_PLATE, Ingredient.ofItems(ModBlocks.BRICK_PINK.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_PINK.asItem()), conditionsFromItem(ModBlocks.BRICK_PINK.asItem()))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_PINK_BUTTON.asItem(), 1)
                .input(Ingredient.ofItems(ModBlocks.BRICK_PINK.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_PINK.asItem()), conditionsFromItem(ModBlocks.BRICK_PINK.asItem()))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_PINK_WALL.asItem(), 6)
                .pattern("   ")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModBlocks.BRICK_PINK.asItem())
                .criterion(hasItem(ModBlocks.BRICK_PINK.asItem()), conditionsFromItem(ModBlocks.BRICK_PINK.asItem()))
                .offerTo(exporter);

        //TAN BRICK
        createStairsRecipe(ModBlocks.BRICK_TAN_STAIRS, Ingredient.ofItems(ModBlocks.BRICK_TAN.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_TAN.asItem()), conditionsFromItem(ModBlocks.BRICK_TAN.asItem()))
                .offerTo(exporter);

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_TAN_SLAB, Ingredient.ofItems(ModBlocks.BRICK_TAN.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_TAN.asItem()), conditionsFromItem(ModBlocks.BRICK_TAN.asItem()))
                .offerTo(exporter);

        createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_TAN_PLATE, Ingredient.ofItems(ModBlocks.BRICK_TAN.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_TAN.asItem()), conditionsFromItem(ModBlocks.BRICK_TAN.asItem()))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_TAN_BUTTON.asItem(), 1)
                .input(Ingredient.ofItems(ModBlocks.BRICK_TAN.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_TAN.asItem()), conditionsFromItem(ModBlocks.BRICK_TAN.asItem()))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_TAN_WALL.asItem(), 6)
                .pattern("   ")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModBlocks.BRICK_TAN.asItem())
                .criterion(hasItem(ModBlocks.BRICK_TAN.asItem()), conditionsFromItem(ModBlocks.BRICK_TAN.asItem()))
                .offerTo(exporter);

        //WHITE BRICK
        createStairsRecipe(ModBlocks.BRICK_WHITE_STAIRS, Ingredient.ofItems(ModBlocks.BRICK_WHITE.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_WHITE.asItem()), conditionsFromItem(ModBlocks.BRICK_WHITE.asItem()))
                .offerTo(exporter);

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_WHITE_SLAB, Ingredient.ofItems(ModBlocks.BRICK_WHITE.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_WHITE.asItem()), conditionsFromItem(ModBlocks.BRICK_WHITE.asItem()))
                .offerTo(exporter);

        createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_WHITE_PLATE, Ingredient.ofItems(ModBlocks.BRICK_WHITE.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_WHITE.asItem()), conditionsFromItem(ModBlocks.BRICK_WHITE.asItem()))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_WHITE_BUTTON.asItem(), 1)
                .input(Ingredient.ofItems(ModBlocks.BRICK_WHITE.asItem()))
                .criterion(hasItem(ModBlocks.BRICK_WHITE.asItem()), conditionsFromItem(ModBlocks.BRICK_WHITE.asItem()))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_WHITE_WALL.asItem(), 6)
                .pattern("   ")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModBlocks.BRICK_WHITE.asItem())
                .criterion(hasItem(ModBlocks.BRICK_WHITE.asItem()), conditionsFromItem(ModBlocks.BRICK_WHITE.asItem()))
                .offerTo(exporter);

        //Dyes to Wool Recipes
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.BLACK_DYE, 1)
                .input(Ingredient.ofItems(Blocks.BLACK_WOOL.asItem()))
                .criterion(hasItem(Blocks.BLACK_WOOL.asItem()), conditionsFromItem(Blocks.BLACK_WOOL.asItem()))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.BLUE_DYE, 1)
                .input(Ingredient.ofItems(Blocks.BLUE_WOOL.asItem()))
                .criterion(hasItem(Blocks.BLUE_WOOL.asItem()), conditionsFromItem(Blocks.BLUE_WOOL.asItem()))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.BROWN_DYE, 1)
                .input(Ingredient.ofItems(Blocks.BROWN_WOOL.asItem()))
                .criterion(hasItem(Blocks.BROWN_WOOL.asItem()), conditionsFromItem(Blocks.BROWN_WOOL.asItem()))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.CYAN_DYE, 1)
                .input(Ingredient.ofItems(Blocks.CYAN_WOOL.asItem()))
                .criterion(hasItem(Blocks.CYAN_WOOL.asItem()), conditionsFromItem(Blocks.CYAN_WOOL.asItem()))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.GRAY_DYE, 1)
                .input(Ingredient.ofItems(Blocks.GRAY_WOOL.asItem()))
                .criterion(hasItem(Blocks.GRAY_WOOL.asItem()), conditionsFromItem(Blocks.GRAY_WOOL.asItem()))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.GREEN_DYE, 1)
                .input(Ingredient.ofItems(Blocks.GREEN_WOOL.asItem()))
                .criterion(hasItem(Blocks.GREEN_WOOL.asItem()), conditionsFromItem(Blocks.GREEN_WOOL.asItem()))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.LIGHT_BLUE_DYE, 1)
                .input(Ingredient.ofItems(Blocks.LIGHT_BLUE_WOOL.asItem()))
                .criterion(hasItem(Blocks.LIGHT_BLUE_WOOL.asItem()), conditionsFromItem(Blocks.LIGHT_BLUE_WOOL.asItem()))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.LIGHT_GRAY_DYE, 1)
                .input(Ingredient.ofItems(Blocks.LIGHT_GRAY_WOOL.asItem()))
                .criterion(hasItem(Blocks.LIGHT_GRAY_WOOL.asItem()), conditionsFromItem(Blocks.LIGHT_GRAY_WOOL.asItem()))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.LIME_DYE, 1)
                .input(Ingredient.ofItems(Blocks.LIME_WOOL.asItem()))
                .criterion(hasItem(Blocks.LIME_WOOL.asItem()), conditionsFromItem(Blocks.LIME_WOOL.asItem()))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.MAGENTA_DYE, 1)
                .input(Ingredient.ofItems(Blocks.MAGENTA_WOOL.asItem()))
                .criterion(hasItem(Blocks.MAGENTA_WOOL.asItem()), conditionsFromItem(Blocks.MAGENTA_WOOL.asItem()))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.ORANGE_DYE, 1)
                .input(Ingredient.ofItems(Blocks.ORANGE_WOOL.asItem()))
                .criterion(hasItem(Blocks.ORANGE_WOOL.asItem()), conditionsFromItem(Blocks.ORANGE_WOOL.asItem()))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.PINK_DYE, 1)
                .input(Ingredient.ofItems(Blocks.PINK_WOOL.asItem()))
                .criterion(hasItem(Blocks.PINK_WOOL.asItem()), conditionsFromItem(Blocks.PINK_WOOL.asItem()))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.PURPLE_DYE, 1)
                .input(Ingredient.ofItems(Blocks.PURPLE_WOOL.asItem()))
                .criterion(hasItem(Blocks.PURPLE_WOOL.asItem()), conditionsFromItem(Blocks.PURPLE_WOOL.asItem()))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.RED_DYE, 1)
                .input(Ingredient.ofItems(Blocks.RED_WOOL.asItem()))
                .criterion(hasItem(Blocks.RED_WOOL.asItem()), conditionsFromItem(Blocks.RED_WOOL.asItem()))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.WHITE_DYE, 1)
                .input(Ingredient.ofItems(Blocks.WHITE_WOOL.asItem()))
                .criterion(hasItem(Blocks.WHITE_WOOL.asItem()), conditionsFromItem(Blocks.WHITE_WOOL.asItem()))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.YELLOW_DYE, 1)
                .input(Ingredient.ofItems(Blocks.YELLOW_WOOL.asItem()))
                .criterion(hasItem(Blocks.YELLOW_WOOL.asItem()), conditionsFromItem(Blocks.YELLOW_WOOL.asItem()))
                .offerTo(exporter);

        //Other Items
        //Brick Oven
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_OVEN.asItem(), 1)
                .pattern("XXX")
                .pattern("XCX")
                .pattern("XXX")
                .input('X', Blocks.COBBLESTONE.asItem())
                .input('C', Blocks.CAMPFIRE.asItem())
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .criterion(hasItem(Items.CAMPFIRE), conditionsFromItem(Items.CAMPFIRE))
                .offerTo(exporter);

        //Brush - made with duck feather
        //Winter Window Pane
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.BRUSH, 1)
                .pattern("#")
                .pattern("I")
                .pattern("X")
                .input('#', Items.COPPER_INGOT)
                .input('I', Items.STICK)
                .input('X', ModItems.DUCK_FEATHER)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.DUCK_FEATHER), conditionsFromItem(ModItems.DUCK_FEATHER))
                .offerTo(exporter);

        //Cake
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.CAKE, 1)
                .pattern("AAA")
                .pattern("BEB")
                .pattern("CCC")
                .input('A', Items.MILK_BUCKET)
                .input('B', Items.SUGAR)
                .input('C', Items.WHEAT)
                .input('E', ModItems.DUCK_EGG)
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .criterion(hasItem(ModItems.DUCK_EGG), conditionsFromItem(ModItems.DUCK_EGG))
                .offerTo(exporter);

        //Cheese
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Items.MILK_BUCKET), RecipeCategory.FOOD, ModItems.CHEESE, 1.0f, 200)
                .criterion(RecipeProvider.hasItem(Items.MILK_BUCKET), RecipeProvider.conditionsFromItem(Items.MILK_BUCKET))
                .offerTo(exporter);

        //Dowsing Rod Ancient Debris
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.DOWSINGROD_ANCIENT_DEBRIS, 1)
                .pattern(" X ")
                .pattern(" Y ")
                .pattern("C C")
                .input('X', Items.STICK)
                .input('Y', Items.ANCIENT_DEBRIS)
                .input('C', Items.QUARTZ)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.ANCIENT_DEBRIS), conditionsFromItem(Items.ANCIENT_DEBRIS))
                .criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
                .offerTo(exporter);

        //Dowsing Rod Coal & Copper
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.DOWSINGROD_COAL_COPPER, 1)
                .pattern(" X ")
                .pattern(" Y ")
                .pattern("C C")
                .input('X', Items.STICK)
                .input('Y', Items.COPPER_INGOT)
                .input('C', Items.COAL)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.COAL), conditionsFromItem(Items.COAL))
                .offerTo(exporter);

        //Dowsing Rod Diamond & Lapis
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.DOWSINGROD_DIAMOND_LAPIS, 1)
                .pattern(" X ")
                .pattern(" Y ")
                .pattern("C C")
                .input('X', Items.STICK)
                .input('Y', Items.DIAMOND)
                .input('C', Items.LAPIS_LAZULI)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                .offerTo(exporter);

        //Dowsing Rod Iron & Gold
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.DOWSINGROD_IRON_GOLD, 1)
                .pattern(" X ")
                .pattern(" Y ")
                .pattern("C C")
                .input('X', Items.STICK)
                .input('Y', Items.GOLD_INGOT)
                .input('C', Items.IRON_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);

        //Duck (cooking)
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(ModItems.DUCK_RAW), RecipeCategory.FOOD, ModItems.DUCK_COOKED,
                        1.0f, 200)
                .criterion(RecipeProvider.hasItem(ModItems.DUCK_RAW), RecipeProvider.conditionsFromItem(ModItems.DUCK_RAW))
                .offerTo(exporter);

        //Lamp Block
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.LAMP_BLOCK.asItem(), 1)
                .pattern("XXX")
                .pattern("XIX")
                .pattern(" C ")
                .input('X', Blocks.BROWN_WOOL.asItem())
                .input('C', Blocks.OAK_PLANKS.asItem())
                .input('I', Items.TORCH)
                .criterion(hasItem(Items.BROWN_WOOL), conditionsFromItem(Items.BROWN_WOOL))
                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
                .criterion(hasItem(Items.TORCH), conditionsFromItem(Items.TORCH))
                .offerTo(exporter);

        //Mirror - Teleporting in Overworld
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.MIRROR, 1)
                .pattern("XXX")
                .pattern("XYX")
                .pattern("XXX")
                .input('X', Blocks.OAK_PLANKS.asItem())
                .input('Y', Items.DIAMOND)
                .criterion(hasItem(Blocks.OAK_PLANKS.asItem()), conditionsFromItem(Blocks.OAK_PLANKS.asItem()))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);

        //Nether Mirror - Teleporting in Nether
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.NETHER_MIRROR, 1)
                .pattern("XXX")
                .pattern("XYX")
                .pattern("XXX")
                .input('X', Blocks.OAK_PLANKS.asItem())
                .input('Y', Blocks.ANCIENT_DEBRIS.asItem())
                .criterion(hasItem(Blocks.OAK_PLANKS.asItem()), conditionsFromItem(Blocks.OAK_PLANKS.asItem()))
                .criterion(hasItem(Blocks.ANCIENT_DEBRIS.asItem()), conditionsFromItem(Blocks.ANCIENT_DEBRIS.asItem()))
                .offerTo(exporter);

        //End Mirror - Teleporting in End
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.END_MIRROR, 1)
                .pattern("XXX")
                .pattern("XYX")
                .pattern("XXX")
                .input('X', Blocks.OAK_PLANKS.asItem())
                .input('Y', Items.ENDER_EYE)
                .criterion(hasItem(Blocks.OAK_PLANKS.asItem()), conditionsFromItem(Blocks.OAK_PLANKS.asItem()))
                .criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE))
                .offerTo(exporter);

        //Fox Cage - capture a fox and release it
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BUCKET_FOX, 1)
                .pattern("XXX")
                .pattern("XYX")
                .pattern("XXX")
                .input('X', Blocks.OAK_PLANKS.asItem())
                .input('Y', Blocks.IRON_BARS.asItem())
                .criterion(hasItem(Blocks.OAK_PLANKS.asItem()), conditionsFromItem(Blocks.OAK_PLANKS.asItem()))
                .criterion(hasItem(Blocks.IRON_BARS.asItem()), conditionsFromItem(Blocks.IRON_BARS.asItem()))
                .offerTo(exporter);

        //Pumpkin Pie with Duck Egg
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, Items.PUMPKIN_PIE, 1)
                .input(Ingredient.ofItems(Items.PUMPKIN))
                .input(Ingredient.ofItems(Items.SUGAR))
                .input(Ingredient.ofItems(ModItems.DUCK_EGG))
                .criterion(hasItem(Items.PUMPKIN), conditionsFromItem(Items.PUMPKIN))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(ModItems.DUCK_EGG), conditionsFromItem(ModItems.DUCK_EGG))
                .offerTo(exporter);

        //Ruby Boots
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_BOOTS, 1)
                .pattern("   ")
                .pattern("X X")
                .pattern("X X")
                .input('X', ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter);

        //Ruby Pickaxe
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_PICKAXE, 1)
                .pattern("XXX")
                .pattern(" Y ")
                .pattern(" Y ")
                .input('X', ModItems.RUBY)
                .input('Y', Items.STICK)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        //Star Compass
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.STAR_COMPASS, 1)
                .pattern("XXX")
                .pattern("XYX")
                .pattern("XXX")
                .input('X', Items.LAPIS_LAZULI)
                .input('Y', Items.COMPASS)
                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                .criterion(hasItem(Items.COMPASS), conditionsFromItem(Items.COMPASS))
                .offerTo(exporter);

        //Taco
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.TACO, 1)
                .input(Ingredient.ofItems(ModItems.LETTUCE))
                .input(Ingredient.ofItems(Items.COOKED_BEEF))
                .input(Ingredient.ofItems(ModItems.CHEESE))
                .input(Ingredient.ofItems(ModItems.TORTILLA))
                .criterion(hasItem(ModItems.LETTUCE), conditionsFromItem(ModItems.LETTUCE))
                .criterion(hasItem(Items.COOKED_BEEF), conditionsFromItem(Items.COOKED_BEEF))
                .criterion(hasItem(ModItems.CHEESE), conditionsFromItem(ModItems.CHEESE))
                .criterion(hasItem(ModItems.TORTILLA), conditionsFromItem(ModItems.TORTILLA))
                .offerTo(exporter);

        //Taco Bell
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TACO_BELL.asItem(), 1)
                .input(Ingredient.ofItems(Items.PURPLE_DYE))
                .input(Ingredient.ofItems(Items.PINK_DYE))
                .input(Ingredient.ofItems(Blocks.BELL.asItem()))
                .criterion(hasItem(Items.PURPLE_DYE), conditionsFromItem(Items.PURPLE_DYE))
                .criterion(hasItem(Items.PINK_DYE), conditionsFromItem(Items.PINK_DYE))
                .offerTo(exporter);

        //Tortilla
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Items.BREAD), RecipeCategory.FOOD, ModItems.TORTILLA, 1.0f, 200)
                .criterion(RecipeProvider.hasItem(Items.BREAD), RecipeProvider.conditionsFromItem(Items.BREAD))
                .offerTo(exporter);

        //Winter Window
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModBlocks.WINTER_WINDOW.asItem(), 4)
                .pattern("WXW")
                .pattern("XYX")
                .pattern("WZW")
                .input('W', Items.WHITE_WOOL)
                .input('X', Items.GREEN_WOOL)
                .input('Y', Items.GLASS)
                .input('Z', Items.BROWN_WOOL)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.GREEN_WOOL), conditionsFromItem(Items.GREEN_WOOL))
                .criterion(hasItem(Items.GLASS), conditionsFromItem(Items.GLASS))
                .criterion(hasItem(Items.BROWN_WOOL), conditionsFromItem(Items.BROWN_WOOL))
                .offerTo(exporter);

        //Winter Window Pane
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModBlocks.WINTER_WINDOW_PANE.asItem(), 12)
                .pattern("   ")
                .pattern("XXX")
                .pattern("XXX")
                .input('X', ModBlocks.WINTER_WINDOW.asItem())
                .criterion(hasItem(ModBlocks.WINTER_WINDOW.asItem()), conditionsFromItem(ModBlocks.WINTER_WINDOW.asItem()))
                .offerTo(exporter);

        //Writable Book
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.WRITABLE_BOOK, 1)
                .input(Ingredient.ofItems(Items.BOOK))
                .input(Ingredient.ofItems(Items.INK_SAC))
                .input(Ingredient.ofItems(ModItems.DUCK_FEATHER))
                .criterion(hasItem(Items.BOOK), conditionsFromItem(Items.BOOK))
                .criterion(hasItem(Items.INK_SAC), conditionsFromItem(Items.INK_SAC))
                .criterion(hasItem(ModItems.DUCK_FEATHER), conditionsFromItem(ModItems.DUCK_FEATHER))
                .offerTo(exporter);
    }
}
