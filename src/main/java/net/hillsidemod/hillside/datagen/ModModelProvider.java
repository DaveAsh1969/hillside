package net.hillsidemod.hillside.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.hillsidemod.hillside.block.ModBlocks;
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

        brickBlackPool.stairs(ModBlocks.BRICK_BLACK_STAIRS);
        brickBlackPool.slab(ModBlocks.BRICK_BLACK_SLAB);
        brickBlackPool.button(ModBlocks.BRICK_BLACK_BUTTON);
        brickBlackPool.pressurePlate(ModBlocks.BRICK_BLACK_PLATE);
        brickBlackPool.wall(ModBlocks.BRICK_BLACK_WALL);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
       // itemModelGenerator.register(ModItems.BRICK_BLACK, Models.GENERATED);

    }
}