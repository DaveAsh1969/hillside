package net.hillsidemod.hillside.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.hillsidemod.hillside.block.ModBlocks;
import net.hillsidemod.hillside.block.custom.LettuceBlock;
import net.hillsidemod.hillside.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //bricks generator
        BlockStateModelGenerator.BlockTexturePool brickBlackPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BRICK_BLACK);
        BlockStateModelGenerator.BlockTexturePool brickBrownPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BRICK_BROWN);
        BlockStateModelGenerator.BlockTexturePool brickMulticoloredPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BRICK_MULTICOLORED);
        BlockStateModelGenerator.BlockTexturePool pinkBrownPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BRICK_PINK);
        BlockStateModelGenerator.BlockTexturePool tanBrownPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BRICK_TAN);
        BlockStateModelGenerator.BlockTexturePool whiteBrownPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BRICK_WHITE);

        //dungeon generator
        BlockStateModelGenerator.BlockTexturePool dungeon_andesite_cracked_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_ANDESITE_CRACKED);
        BlockStateModelGenerator.BlockTexturePool dungeon_blood_wall_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_BLOOD_WALL);
        BlockStateModelGenerator.BlockTexturePool dungeon_ceiling_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_CEILING);
        BlockStateModelGenerator.BlockTexturePool dungeon_chiseled_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_CHISELED);
        BlockStateModelGenerator.BlockTexturePool dungeon_cobblestone_mossy_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_COBBLESTONE_MOSSY);
        BlockStateModelGenerator.BlockTexturePool dungeon_cobblestone_mossy_2_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_2);
        BlockStateModelGenerator.BlockTexturePool dungeon_cracked_wall_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_CRACKED_WALL);
        BlockStateModelGenerator.BlockTexturePool dungeon_cracked_wall_2_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_CRACKED_WALL_2);
        BlockStateModelGenerator.BlockTexturePool dungeon_dark_brick_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_DARK_BRICK);
        BlockStateModelGenerator.BlockTexturePool dungeon_dark_planks_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_DARK_PLANKS);
        BlockStateModelGenerator.BlockTexturePool dungeon_diorite_ceiling_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_DIORITE_CEILING);
        BlockStateModelGenerator.BlockTexturePool dungeon_dirt_cracked_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_DIRT_CRACKED);
        BlockStateModelGenerator.BlockTexturePool dungeon_glowing_stone_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_GLOWING_STONE);
        BlockStateModelGenerator.BlockTexturePool dungeon_mossy_wall_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_MOSSY_WALL);
        BlockStateModelGenerator.BlockTexturePool dungeon_stone_floor_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_STONE_FLOOR);
        BlockStateModelGenerator.BlockTexturePool dungeon_stone_andesite_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_STONE_ANDESITE);
        BlockStateModelGenerator.BlockTexturePool dungeon_stone_andesite_path_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_STONE_ANDESITE_PATH);
        BlockStateModelGenerator.BlockTexturePool dungeon_stone_bricks_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_STONE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool dungeon_stone_cracks_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_STONE_CRACKS);
        BlockStateModelGenerator.BlockTexturePool dungeon_stone_dark_floor_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_STONE_DARK_FLOOR);
        BlockStateModelGenerator.BlockTexturePool dungeon_stone_floor_light_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_STONE_FLOOR_LIGHT);
        BlockStateModelGenerator.BlockTexturePool dungeon_stone_mossy_floor_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_STONE_MOSSY_FLOOR);
        BlockStateModelGenerator.BlockTexturePool dungeon_stone_pebbles_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_STONE_PEBBLES);
        BlockStateModelGenerator.BlockTexturePool dungeon_stony_dirt_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_STONY_DIRT);
        BlockStateModelGenerator.BlockTexturePool dungeon_stony_ground_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUNGEON_STONY_GROUND);

        //other generators
        BlockStateModelGenerator.BlockTexturePool coral_color_block_Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CORAL_COLOR_BLOCK);

        //definitions for specialty bricks
        brickBlackPool.stairs(ModBlocks.BRICK_BLACK_STAIRS);
        brickBlackPool.slab(ModBlocks.BRICK_BLACK_SLAB);
        brickBlackPool.button(ModBlocks.BRICK_BLACK_BUTTON);
        brickBlackPool.pressurePlate(ModBlocks.BRICK_BLACK_PLATE);
        brickBlackPool.wall(ModBlocks.BRICK_BLACK_WALL);

        brickBrownPool.stairs(ModBlocks.BRICK_BROWN_STAIRS);
        brickBrownPool.slab(ModBlocks.BRICK_BROWN_SLAB);
        brickBrownPool.button(ModBlocks.BRICK_BROWN_BUTTON);
        brickBrownPool.pressurePlate(ModBlocks.BRICK_BROWN_PLATE);
        brickBrownPool.wall(ModBlocks.BRICK_BROWN_WALL);

        brickMulticoloredPool.stairs(ModBlocks.BRICK_MULTICOLORED_STAIRS);
        brickMulticoloredPool.slab(ModBlocks.BRICK_MULTICOLORED_SLAB);
        brickMulticoloredPool.button(ModBlocks.BRICK_MULTICOLORED_BUTTON);
        brickMulticoloredPool.pressurePlate(ModBlocks.BRICK_MULTICOLORED_PLATE);
        brickMulticoloredPool.wall(ModBlocks.BRICK_MULTICOLORED_WALL);

        pinkBrownPool.stairs(ModBlocks.BRICK_PINK_STAIRS);
        pinkBrownPool.slab(ModBlocks.BRICK_PINK_SLAB);
        pinkBrownPool.button(ModBlocks.BRICK_PINK_BUTTON);
        pinkBrownPool.pressurePlate(ModBlocks.BRICK_PINK_PLATE);
        pinkBrownPool.wall(ModBlocks.BRICK_PINK_WALL);

        tanBrownPool.stairs(ModBlocks.BRICK_TAN_STAIRS);
        tanBrownPool.slab(ModBlocks.BRICK_TAN_SLAB);
        tanBrownPool.button(ModBlocks.BRICK_TAN_BUTTON);
        tanBrownPool.pressurePlate(ModBlocks.BRICK_TAN_PLATE);
        tanBrownPool.wall(ModBlocks.BRICK_TAN_WALL);

        whiteBrownPool.stairs(ModBlocks.BRICK_WHITE_STAIRS);
        whiteBrownPool.slab(ModBlocks.BRICK_WHITE_SLAB);
        whiteBrownPool.button(ModBlocks.BRICK_WHITE_BUTTON);
        whiteBrownPool.pressurePlate(ModBlocks.BRICK_WHITE_PLATE);
        whiteBrownPool.wall(ModBlocks.BRICK_WHITE_WALL);

        //definitions for dungeon blocks
        dungeon_andesite_cracked_Pool.stairs(ModBlocks.DUNGEON_ANDESITE_CRACKED_STAIRS);
        dungeon_andesite_cracked_Pool.slab(ModBlocks.DUNGEON_ANDESITE_CRACKED_SLAB);
        dungeon_andesite_cracked_Pool.button(ModBlocks.DUNGEON_ANDESITE_CRACKED_BUTTON);
        dungeon_andesite_cracked_Pool.pressurePlate(ModBlocks.DUNGEON_ANDESITE_CRACKED_PLATE);
        dungeon_andesite_cracked_Pool.wall(ModBlocks.DUNGEON_ANDESITE_CRACKED_WALL);

        dungeon_blood_wall_Pool.stairs(ModBlocks.DUNGEON_BLOOD_WALL_STAIRS);
        dungeon_blood_wall_Pool.slab(ModBlocks.DUNGEON_BLOOD_WALL_SLAB);
        dungeon_blood_wall_Pool.button(ModBlocks.DUNGEON_BLOOD_WALL_BUTTON);
        dungeon_blood_wall_Pool.pressurePlate(ModBlocks.DUNGEON_BLOOD_WALL_PLATE);
        dungeon_blood_wall_Pool.wall(ModBlocks.DUNGEON_BLOOD_WALL_WALL);

        dungeon_ceiling_Pool.stairs(ModBlocks.DUNGEON_CEILING_STAIRS);
        dungeon_ceiling_Pool.slab(ModBlocks.DUNGEON_CEILING_SLAB);
        dungeon_ceiling_Pool.button(ModBlocks.DUNGEON_CEILING_BUTTON);
        dungeon_ceiling_Pool.pressurePlate(ModBlocks.DUNGEON_CEILING_PLATE);
        dungeon_ceiling_Pool.wall(ModBlocks.DUNGEON_CEILING_WALL);

        dungeon_chiseled_Pool.stairs(ModBlocks.DUNGEON_CHISELED_STAIRS);
        dungeon_chiseled_Pool.slab(ModBlocks.DUNGEON_CHISELED_SLAB);
        dungeon_chiseled_Pool.button(ModBlocks.DUNGEON_CHISELED_BUTTON);
        dungeon_chiseled_Pool.pressurePlate(ModBlocks.DUNGEON_CHISELED_PLATE);
        dungeon_chiseled_Pool.wall(ModBlocks.DUNGEON_CHISELED_WALL);

        dungeon_cobblestone_mossy_Pool.stairs(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_STAIRS);
        dungeon_cobblestone_mossy_Pool.slab(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_SLAB);
        dungeon_cobblestone_mossy_Pool.button(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_BUTTON);
        dungeon_cobblestone_mossy_Pool.pressurePlate(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_PLATE);
        dungeon_cobblestone_mossy_Pool.wall(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_WALL);

        dungeon_cobblestone_mossy_2_Pool.stairs(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_2_STAIRS);
        dungeon_cobblestone_mossy_2_Pool.slab(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_2_SLAB);
        dungeon_cobblestone_mossy_2_Pool.button(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_2_BUTTON);
        dungeon_cobblestone_mossy_2_Pool.pressurePlate(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_2_PLATE);
        dungeon_cobblestone_mossy_2_Pool.wall(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_2_WALL);

        dungeon_cracked_wall_Pool.stairs(ModBlocks.DUNGEON_CRACKED_WALL_STAIRS);
        dungeon_cracked_wall_Pool.slab(ModBlocks.DUNGEON_CRACKED_WALL_SLAB);
        dungeon_cracked_wall_Pool.button(ModBlocks.DUNGEON_CRACKED_WALL_BUTTON);
        dungeon_cracked_wall_Pool.pressurePlate(ModBlocks.DUNGEON_CRACKED_WALL_PLATE);
        dungeon_cracked_wall_Pool.wall(ModBlocks.DUNGEON_CRACKED_WALL_WALL);

        dungeon_cracked_wall_2_Pool.stairs(ModBlocks.DUNGEON_CRACKED_WALL_2_STAIRS);
        dungeon_cracked_wall_2_Pool.slab(ModBlocks.DUNGEON_CRACKED_WALL_2_SLAB);
        dungeon_cracked_wall_2_Pool.button(ModBlocks.DUNGEON_CRACKED_WALL_2_BUTTON);
        dungeon_cracked_wall_2_Pool.pressurePlate(ModBlocks.DUNGEON_CRACKED_WALL_2_PLATE);
        dungeon_cracked_wall_2_Pool.wall(ModBlocks.DUNGEON_CRACKED_WALL_2_WALL);

        dungeon_dark_brick_Pool.stairs(ModBlocks.DUNGEON_DARK_BRICK_STAIRS);
        dungeon_dark_brick_Pool.slab(ModBlocks.DUNGEON_DARK_BRICK_SLAB);
        dungeon_dark_brick_Pool.button(ModBlocks.DUNGEON_DARK_BRICK_BUTTON);
        dungeon_dark_brick_Pool.pressurePlate(ModBlocks.DUNGEON_DARK_BRICK_PLATE);
        dungeon_dark_brick_Pool.wall(ModBlocks.DUNGEON_DARK_BRICK_WALL);

        dungeon_dark_planks_Pool.stairs(ModBlocks.DUNGEON_DARK_PLANKS_STAIRS);
        dungeon_dark_planks_Pool.slab(ModBlocks.DUNGEON_DARK_PLANKS_SLAB);
        dungeon_dark_planks_Pool.button(ModBlocks.DUNGEON_DARK_PLANKS_BUTTON);
        dungeon_dark_planks_Pool.pressurePlate(ModBlocks.DUNGEON_DARK_PLANKS_PLATE);
        dungeon_dark_planks_Pool.wall(ModBlocks.DUNGEON_DARK_PLANKS_WALL);

        dungeon_diorite_ceiling_Pool.stairs(ModBlocks.DUNGEON_DIORITE_CEILING_STAIRS);
        dungeon_diorite_ceiling_Pool.slab(ModBlocks.DUNGEON_DIORITE_CEILING_SLAB);
        dungeon_diorite_ceiling_Pool.button(ModBlocks.DUNGEON_DIORITE_CEILING_BUTTON);
        dungeon_diorite_ceiling_Pool.pressurePlate(ModBlocks.DUNGEON_DIORITE_CEILING_PLATE);
        dungeon_diorite_ceiling_Pool.wall(ModBlocks.DUNGEON_DIORITE_CEILING_WALL);

        dungeon_dirt_cracked_Pool.stairs(ModBlocks.DUNGEON_DIRT_CRACKED_STAIRS);
        dungeon_dirt_cracked_Pool.slab(ModBlocks.DUNGEON_DIRT_CRACKED_SLAB);
        dungeon_dirt_cracked_Pool.button(ModBlocks.DUNGEON_DIRT_CRACKED_BUTTON);
        dungeon_dirt_cracked_Pool.pressurePlate(ModBlocks.DUNGEON_DIRT_CRACKED_PLATE);
        dungeon_dirt_cracked_Pool.wall(ModBlocks.DUNGEON_DIRT_CRACKED_WALL);

        dungeon_glowing_stone_Pool.stairs(ModBlocks.DUNGEON_GLOWING_STONE_STAIRS);
        dungeon_glowing_stone_Pool.slab(ModBlocks.DUNGEON_GLOWING_STONE_SLAB);
        dungeon_glowing_stone_Pool.button(ModBlocks.DUNGEON_GLOWING_STONE_BUTTON);
        dungeon_glowing_stone_Pool.pressurePlate(ModBlocks.DUNGEON_GLOWING_STONE_PLATE);
        dungeon_glowing_stone_Pool.wall(ModBlocks.DUNGEON_GLOWING_STONE_WALL);

        dungeon_mossy_wall_Pool.stairs(ModBlocks.DUNGEON_MOSSY_WALL_STAIRS);
        dungeon_mossy_wall_Pool.slab(ModBlocks.DUNGEON_MOSSY_WALL_SLAB);
        dungeon_mossy_wall_Pool.button(ModBlocks.DUNGEON_MOSSY_WALL_BUTTON);
        dungeon_mossy_wall_Pool.pressurePlate(ModBlocks.DUNGEON_MOSSY_WALL_PLATE);
        dungeon_mossy_wall_Pool.wall(ModBlocks.DUNGEON_MOSSY_WALL_WALL);

        dungeon_stone_floor_Pool.stairs(ModBlocks.DUNGEON_STONE_FLOOR_STAIRS);
        dungeon_stone_floor_Pool.slab(ModBlocks.DUNGEON_STONE_FLOOR_SLAB);
        dungeon_stone_floor_Pool.button(ModBlocks.DUNGEON_STONE_FLOOR_BUTTON);
        dungeon_stone_floor_Pool.pressurePlate(ModBlocks.DUNGEON_STONE_FLOOR_PLATE);
        dungeon_stone_floor_Pool.wall(ModBlocks.DUNGEON_STONE_FLOOR_WALL);

        dungeon_stone_andesite_Pool.stairs(ModBlocks.DUNGEON_STONE_ANDESITE_STAIRS);
        dungeon_stone_andesite_Pool.slab(ModBlocks.DUNGEON_STONE_ANDESITE_SLAB);
        dungeon_stone_andesite_Pool.button(ModBlocks.DUNGEON_STONE_ANDESITE_BUTTON);
        dungeon_stone_andesite_Pool.pressurePlate(ModBlocks.DUNGEON_STONE_ANDESITE_PLATE);
        dungeon_stone_andesite_Pool.wall(ModBlocks.DUNGEON_STONE_ANDESITE_WALL);

        dungeon_stone_andesite_path_Pool.stairs(ModBlocks.DUNGEON_STONE_ANDESITE_PATH_STAIRS);
        dungeon_stone_andesite_path_Pool.slab(ModBlocks.DUNGEON_STONE_ANDESITE_PATH_SLAB);
        dungeon_stone_andesite_path_Pool.button(ModBlocks.DUNGEON_STONE_ANDESITE_PATH_BUTTON);
        dungeon_stone_andesite_path_Pool.pressurePlate(ModBlocks.DUNGEON_STONE_ANDESITE_PATH_PLATE);
        dungeon_stone_andesite_path_Pool.wall(ModBlocks.DUNGEON_STONE_ANDESITE_PATH_WALL);

        dungeon_stone_bricks_Pool.stairs(ModBlocks.DUNGEON_STONE_BRICKS_STAIRS);
        dungeon_stone_bricks_Pool.slab(ModBlocks.DUNGEON_STONE_BRICKS_SLAB);
        dungeon_stone_bricks_Pool.button(ModBlocks.DUNGEON_STONE_BRICKS_BUTTON);
        dungeon_stone_bricks_Pool.pressurePlate(ModBlocks.DUNGEON_STONE_BRICKS_PLATE);
        dungeon_stone_bricks_Pool.wall(ModBlocks.DUNGEON_STONE_BRICKS_WALL);

        dungeon_stone_cracks_Pool.stairs(ModBlocks.DUNGEON_STONE_CRACKS_STAIRS);
        dungeon_stone_cracks_Pool.slab(ModBlocks.DUNGEON_STONE_CRACKS_SLAB);
        dungeon_stone_cracks_Pool.button(ModBlocks.DUNGEON_STONE_CRACKS_BUTTON);
        dungeon_stone_cracks_Pool.pressurePlate(ModBlocks.DUNGEON_STONE_CRACKS_PLATE);
        dungeon_stone_cracks_Pool.wall(ModBlocks.DUNGEON_STONE_CRACKS_WALL);

        dungeon_stone_dark_floor_Pool.stairs(ModBlocks.DUNGEON_STONE_DARK_FLOOR_STAIRS);
        dungeon_stone_dark_floor_Pool.slab(ModBlocks.DUNGEON_STONE_DARK_FLOOR_SLAB);
        dungeon_stone_dark_floor_Pool.button(ModBlocks.DUNGEON_STONE_DARK_FLOOR_BUTTON);
        dungeon_stone_dark_floor_Pool.pressurePlate(ModBlocks.DUNGEON_STONE_DARK_FLOOR_PLATE);
        dungeon_stone_dark_floor_Pool.wall(ModBlocks.DUNGEON_STONE_DARK_FLOOR_WALL);

        dungeon_stone_floor_light_Pool.stairs(ModBlocks.DUNGEON_STONE_FLOOR_LIGHT_STAIRS);
        dungeon_stone_floor_light_Pool.slab(ModBlocks.DUNGEON_STONE_FLOOR_LIGHT_SLAB);
        dungeon_stone_floor_light_Pool.button(ModBlocks.DUNGEON_STONE_FLOOR_LIGHT_BUTTON);
        dungeon_stone_floor_light_Pool.pressurePlate(ModBlocks.DUNGEON_STONE_FLOOR_LIGHT_PLATE);
        dungeon_stone_floor_light_Pool.wall(ModBlocks.DUNGEON_STONE_FLOOR_LIGHT_WALL);

        dungeon_stone_mossy_floor_Pool.stairs(ModBlocks.DUNGEON_STONE_MOSSY_FLOOR_STAIRS);
        dungeon_stone_mossy_floor_Pool.slab(ModBlocks.DUNGEON_STONE_MOSSY_FLOOR_SLAB);
        dungeon_stone_mossy_floor_Pool.button(ModBlocks.DUNGEON_STONE_MOSSY_FLOOR_BUTTON);
        dungeon_stone_mossy_floor_Pool.pressurePlate(ModBlocks.DUNGEON_STONE_MOSSY_FLOOR_PLATE);
        dungeon_stone_mossy_floor_Pool.wall(ModBlocks.DUNGEON_STONE_MOSSY_FLOOR_WALL);

        dungeon_stone_pebbles_Pool.stairs(ModBlocks.DUNGEON_STONE_PEBBLES_STAIRS);
        dungeon_stone_pebbles_Pool.slab(ModBlocks.DUNGEON_STONE_PEBBLES_SLAB);
        dungeon_stone_pebbles_Pool.button(ModBlocks.DUNGEON_STONE_PEBBLES_BUTTON);
        dungeon_stone_pebbles_Pool.pressurePlate(ModBlocks.DUNGEON_STONE_PEBBLES_PLATE);
        dungeon_stone_pebbles_Pool.wall(ModBlocks.DUNGEON_STONE_PEBBLES_WALL);

        dungeon_stony_dirt_Pool.stairs(ModBlocks.DUNGEON_STONY_DIRT_STAIRS);
        dungeon_stony_dirt_Pool.slab(ModBlocks.DUNGEON_STONY_DIRT_SLAB);
        dungeon_stony_dirt_Pool.button(ModBlocks.DUNGEON_STONY_DIRT_BUTTON);
        dungeon_stony_dirt_Pool.pressurePlate(ModBlocks.DUNGEON_STONY_DIRT_PLATE);
        dungeon_stony_dirt_Pool.wall(ModBlocks.DUNGEON_STONY_DIRT_WALL);

        dungeon_stony_ground_Pool.stairs(ModBlocks.DUNGEON_STONY_GROUND_STAIRS);
        dungeon_stony_ground_Pool.slab(ModBlocks.DUNGEON_STONY_GROUND_SLAB);
        dungeon_stony_ground_Pool.button(ModBlocks.DUNGEON_STONY_GROUND_BUTTON);
        dungeon_stony_ground_Pool.pressurePlate(ModBlocks.DUNGEON_STONY_GROUND_PLATE);
        dungeon_stony_ground_Pool.wall(ModBlocks.DUNGEON_STONY_GROUND_WALL);

        //other generators
        coral_color_block_Pool.stairs(ModBlocks.CORAL_COLOR_BLOCK_STAIRS);
        coral_color_block_Pool.slab(ModBlocks.CORAL_COLOR_BLOCK_SLAB);
        coral_color_block_Pool.button(ModBlocks.CORAL_COLOR_BLOCK_BUTTON);
        coral_color_block_Pool.pressurePlate(ModBlocks.CORAL_COLOR_BLOCK_PLATE);
        coral_color_block_Pool.wall(ModBlocks.CORAL_COLOR_BLOCK_WALL);

        //generic generator
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_LAVA);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_LIGHT);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.BOP, ModBlocks.BOP_POTTED, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerItemModel(ModItems.CHEESE);
        blockStateModelGenerator.registerParentedItemModel(ModItems.DECAYING_ZOMBIE_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.DUCK_ENTITY_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerDoor(ModBlocks.DUNGEON_DOOR);
        blockStateModelGenerator.registerItemModel(ModItems.DUNGEON_KEY);
        blockStateModelGenerator.registerGlassPane(ModBlocks.GLASS_MOD, ModBlocks.GLASS_MOD_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.GLASS_MOD_BLUE, ModBlocks.GLASS_MOD_BLUE_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.GLASS_MOD_GREEN, ModBlocks.GLASS_MOD_GREEN_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.GLASS_MOD_LIGHT_BLUE, ModBlocks.GLASS_MOD_LIGHT_BLUE_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.GLASS_MOD_PURPLE, ModBlocks.GLASS_MOD_PURPLE_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.GLASS_MOD_WHITE, ModBlocks.GLASS_MOD_WHITE_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.GLASS_MOD_YELLOW, ModBlocks.GLASS_MOD_YELLOW_PANE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LAVA_BLOCK);
        blockStateModelGenerator.registerItemModel(ModItems.LETTUCE);
        blockStateModelGenerator.registerCrop(ModBlocks.LETTUCE_CROP, LettuceBlock.AGE, 0,1,2,3,4);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OCEAN_FLARE);
        blockStateModelGenerator.registerItemModel(ModItems.TACO);
        blockStateModelGenerator.registerItemModel(ModItems.TORTILLA);
        blockStateModelGenerator.registerParentedItemModel(ModItems.TROLL_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WAVES_BLUE);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.XANTHE, ModBlocks.XANTHE_POTTED, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerParentedItemModel(ModItems.ZOMBIE_PILLAGER_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
    }
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.DECAYING_FLESH, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUCK_COOKED, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUCK_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUCK_FEATHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUCK_RAW, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_PICKAXE, Models.HANDHELD);
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RUBY_BOOTS));
    }
}