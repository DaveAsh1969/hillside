package net.hillsidemod.hillside.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hillsidemod.hillside.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.BRICK_BLACK_WALL)
                .add(ModBlocks.BRICK_BROWN_WALL)
                .add(ModBlocks.BRICK_MULTICOLORED_WALL)
                .add(ModBlocks.BRICK_PINK_WALL)
                .add(ModBlocks.BRICK_TAN_WALL)
                .add(ModBlocks.BRICK_WHITE_WALL);


    }
}