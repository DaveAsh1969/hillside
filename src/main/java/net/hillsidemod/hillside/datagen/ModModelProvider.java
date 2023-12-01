package net.hillsidemod.hillside.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.hillsidemod.hillside.block.ModBlocks;
import net.hillsidemod.hillside.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool brickBlackPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BRICK_BLACK);
        BlockStateModelGenerator.BlockTexturePool brickBrownPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BRICK_BROWN);
        BlockStateModelGenerator.BlockTexturePool brickMulticoloredPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BRICK_MULTICOLORED);
        BlockStateModelGenerator.BlockTexturePool pinkBrownPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BRICK_PINK);
        BlockStateModelGenerator.BlockTexturePool tanBrownPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BRICK_TAN);
        BlockStateModelGenerator.BlockTexturePool whiteBrownPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BRICK_WHITE);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.XANTHE, ModBlocks.XANTHE_POTTED, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.BOP, ModBlocks.BOP_POTTED, BlockStateModelGenerator.TintType.NOT_TINTED);

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

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_PICKAXE, Models.HANDHELD);

    }
}