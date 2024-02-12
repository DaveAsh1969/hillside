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

        //generic generator
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.BOP, ModBlocks.BOP_POTTED, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerItemModel(ModItems.CHEESE);
        blockStateModelGenerator.registerParentedItemModel(ModItems.DECAYING_ZOMBIE_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.DUCK_ENTITY_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerDoor(ModBlocks.DUNGEON_DOOR);
        blockStateModelGenerator.registerItemModel(ModItems.DUNGEON_KEY);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LAVA_BLOCK);
        blockStateModelGenerator.registerItemModel(ModItems.LETTUCE);
        blockStateModelGenerator.registerCrop(ModBlocks.LETTUCE_CROP, LettuceBlock.AGE, 0,1,2,3,4);
        blockStateModelGenerator.registerItemModel(ModItems.TACO);
        blockStateModelGenerator.registerItemModel(ModItems.TORTILLA);
        blockStateModelGenerator.registerParentedItemModel(ModItems.TROLL_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
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