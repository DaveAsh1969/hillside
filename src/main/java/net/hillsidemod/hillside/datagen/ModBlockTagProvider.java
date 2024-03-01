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
                .add(ModBlocks.BRICK_WHITE_WALL)
                .add(ModBlocks.DUNGEON_ANDESITE_CRACKED_WALL)
                .add(ModBlocks.DUNGEON_BLOOD_WALL_WALL)
                .add(ModBlocks.DUNGEON_CEILING_WALL)
                .add(ModBlocks.DUNGEON_CHISELED_WALL)
                .add(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_WALL)
                .add(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_2_WALL)
                .add(ModBlocks.DUNGEON_CRACKED_WALL_WALL)
                .add(ModBlocks.DUNGEON_CRACKED_WALL_2_WALL)
                .add(ModBlocks.DUNGEON_DARK_BRICK_WALL)
                .add(ModBlocks.DUNGEON_DARK_PLANKS_WALL)
                .add(ModBlocks.DUNGEON_DIORITE_CEILING_WALL)
                .add(ModBlocks.DUNGEON_DIRT_CRACKED_WALL)
                .add(ModBlocks.DUNGEON_GLOWING_STONE_WALL)
                .add(ModBlocks.DUNGEON_MOSSY_WALL_WALL)
                .add(ModBlocks.DUNGEON_STONE_FLOOR_WALL)
                .add(ModBlocks.DUNGEON_STONE_ANDESITE_WALL)
                .add(ModBlocks.DUNGEON_STONE_ANDESITE_PATH_WALL)
                .add(ModBlocks.DUNGEON_STONE_BRICKS_WALL)
                .add(ModBlocks.DUNGEON_STONE_CRACKS_WALL)
                .add(ModBlocks.DUNGEON_STONE_DARK_FLOOR_WALL)
                .add(ModBlocks.DUNGEON_STONE_FLOOR_LIGHT_WALL)
                .add(ModBlocks.DUNGEON_STONE_MOSSY_FLOOR_WALL)
                .add(ModBlocks.DUNGEON_STONE_PEBBLES_WALL)
                .add(ModBlocks.DUNGEON_STONY_DIRT_WALL)
                .add(ModBlocks.DUNGEON_STONY_GROUND_WALL);
        
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DUNGEON_ANDESITE_CRACKED)
                .add(ModBlocks.DUNGEON_BLOOD_WALL)
                .add(ModBlocks.DUNGEON_CEILING)
                .add(ModBlocks.DUNGEON_CHISELED)
                .add(ModBlocks.DUNGEON_COBBLESTONE_MOSSY)
                .add(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_2)
                .add(ModBlocks.DUNGEON_CRACKED_WALL)
                .add(ModBlocks.DUNGEON_CRACKED_WALL_2)
                .add(ModBlocks.DUNGEON_DARK_BRICK)
                .add(ModBlocks.DUNGEON_DARK_PLANKS)
                .add(ModBlocks.DUNGEON_DIORITE_CEILING)
                .add(ModBlocks.DUNGEON_DIRT_CRACKED)
                .add(ModBlocks.DUNGEON_GLOWING_STONE)
                .add(ModBlocks.DUNGEON_MOSSY_WALL)
                .add(ModBlocks.DUNGEON_STONE_FLOOR)
                .add(ModBlocks.DUNGEON_STONE_ANDESITE)
                .add(ModBlocks.DUNGEON_STONE_ANDESITE_PATH)
                .add(ModBlocks.DUNGEON_STONE_BRICKS)
                .add(ModBlocks.DUNGEON_STONE_CRACKS)
                .add(ModBlocks.DUNGEON_STONE_DARK_FLOOR)
                .add(ModBlocks.DUNGEON_STONE_FLOOR_LIGHT)
                .add(ModBlocks.DUNGEON_STONE_MOSSY_FLOOR)
                .add(ModBlocks.DUNGEON_STONE_PEBBLES)
                .add(ModBlocks.DUNGEON_STONY_DIRT)
                .add(ModBlocks.DUNGEON_STONY_GROUND);

    }
}