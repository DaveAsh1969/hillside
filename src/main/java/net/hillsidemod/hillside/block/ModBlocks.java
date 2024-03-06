package net.hillsidemod.hillside.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.block.custom.*;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks
{
    public static final Block BLUE_LIGHT = registerBlock("blue_light_block", new Block(FabricBlockSettings.create().mapColor(MapColor.BLUE)
            .strength(0.3f).nonOpaque().sounds(BlockSoundGroup.GLASS).luminance(state -> 15).solidBlock(Blocks::never)));
    public static final Block BOP = registerBlock("bop", new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 10,
            FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block BOP_POTTED = Registry.register(Registries.BLOCK, new Identifier(Hillside.MOD_ID, "bop_potted"),
            new FlowerPotBlock(BOP, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block BRICK_BLACK = registerBlock("brick_black",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_BLACK_BUTTON = registerBlock("brick_black_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block BRICK_BLACK_PLATE = registerBlock("brick_black_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block BRICK_BLACK_SLAB = registerBlock("brick_black_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_BLACK_SMEAR = registerBlock("brick_black_smeared",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_BLACK_STAIRS = registerBlock("brick_black_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_BLACK_WALL = registerBlock("brick_black_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_BROWN = registerBlock("brick_brown",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_BROWN_BUTTON = registerBlock("brick_brown_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block BRICK_BROWN_PLATE = registerBlock("brick_brown_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block BRICK_BROWN_SLAB = registerBlock("brick_brown_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_BROWN_SMEAR = registerBlock("brick_brown_smeared",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_BROWN_STAIRS = registerBlock("brick_brown_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_BROWN_WALL = registerBlock("brick_brown_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_MULTICOLORED = registerBlock("brick_multicolored",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_MULTICOLORED_BUTTON = registerBlock("brick_multicolored_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block BRICK_MULTICOLORED_PLATE = registerBlock("brick_multicolored_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block BRICK_MULTICOLORED_SLAB = registerBlock("brick_multicolored_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_MULTICOLORED_SMEAR = registerBlock("brick_multicolored_smeared",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_MULTICOLORED_STAIRS = registerBlock("brick_multicolored_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_MULTICOLORED_WALL = registerBlock("brick_multicolored_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_OVEN = registerBlock("brick_oven",
            new BrickOvenBlock(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE).nonOpaque()
                    .luminance((state) -> state.get(BrickOvenBlock.LIT) ? 15 : 0 )));
    public static final Block BRICK_PINK = registerBlock("brick_pink",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_PINK_BUTTON = registerBlock("brick_pink_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block BRICK_PINK_PLATE = registerBlock("brick_pink_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block BRICK_PINK_SLAB = registerBlock("brick_pink_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_PINK_SMEAR = registerBlock("brick_pink_smeared",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_PINK_STAIRS = registerBlock("brick_pink_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_PINK_WALL = registerBlock("brick_pink_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_SMEAR = registerBlock("brick_smeared",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_TAN = registerBlock("brick_tan",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_TAN_BUTTON = registerBlock("brick_tan_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block BRICK_TAN_PLATE = registerBlock("brick_tan_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block BRICK_TAN_SLAB = registerBlock("brick_tan_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_TAN_SMEAR = registerBlock("brick_tan_smeared",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_TAN_STAIRS = registerBlock("brick_tan_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_TAN_WALL = registerBlock("brick_tan_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_WHITE = registerBlock("brick_white",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_WHITE_BUTTON = registerBlock("brick_white_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block BRICK_WHITE_PLATE = registerBlock("brick_white_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block BRICK_WHITE_SLAB = registerBlock("brick_white_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_WHITE_SMEAR = registerBlock("brick_white_smeared",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_WHITE_STAIRS = registerBlock("brick_white_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_WHITE_WALL = registerBlock("brick_white_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));

    //DUNGEON BLOCKS------------------------------------------------------------------------------------
    public static final Block DUNGEON_ANDESITE_CRACKED = registerBlock("dungeon_andesite_cracked",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_ANDESITE_CRACKED_BUTTON = registerBlock("dungeon_andesite_cracked_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_ANDESITE_CRACKED_PLATE = registerBlock("dungeon_andesite_cracked_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_ANDESITE_CRACKED_SLAB = registerBlock("dungeon_andesite_cracked_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_ANDESITE_CRACKED_STAIRS = registerBlock("dungeon_andesite_cracked_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_ANDESITE_CRACKED_WALL = registerBlock("dungeon_andesite_cracked_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_BLOOD_WALL = registerBlock("dungeon_blood_wall",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_BLOOD_WALL_BUTTON = registerBlock("dungeon_blood_wall_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_BLOOD_WALL_PLATE = registerBlock("dungeon_blood_wall_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_BLOOD_WALL_SLAB = registerBlock("dungeon_blood_wall_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_BLOOD_WALL_STAIRS = registerBlock("dungeon_blood_wall_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_BLOOD_WALL_WALL = registerBlock("dungeon_blood_wall_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_CEILING = registerBlock("dungeon_ceiling",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_CEILING_BUTTON = registerBlock("dungeon_ceiling_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_CEILING_PLATE = registerBlock("dungeon_ceiling_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_CEILING_SLAB = registerBlock("dungeon_ceiling_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_CEILING_STAIRS = registerBlock("dungeon_ceiling_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_CEILING_WALL = registerBlock("dungeon_ceiling_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_CHISELED = registerBlock("dungeon_chiseled",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_CHISELED_BUTTON = registerBlock("dungeon_chiseled_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_CHISELED_PLATE = registerBlock("dungeon_chiseled_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_CHISELED_SLAB = registerBlock("dungeon_chiseled_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_CHISELED_STAIRS = registerBlock("dungeon_chiseled_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_CHISELED_WALL = registerBlock("dungeon_chiseled_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_COBBLESTONE_MOSSY = registerBlock("dungeon_cobblestone_mossy",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_COBBLESTONE_MOSSY_BUTTON = registerBlock("dungeon_cobblestone_mossy_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_COBBLESTONE_MOSSY_PLATE = registerBlock("dungeon_cobblestone_mossy_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_COBBLESTONE_MOSSY_SLAB = registerBlock("dungeon_cobblestone_mossy_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_COBBLESTONE_MOSSY_STAIRS = registerBlock("dungeon_cobblestone_mossy_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_COBBLESTONE_MOSSY_WALL = registerBlock("dungeon_cobblestone_mossy_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_COBBLESTONE_MOSSY_2 = registerBlock("dungeon_cobblestone_mossy_2",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_COBBLESTONE_MOSSY_2_BUTTON = registerBlock("dungeon_cobblestone_mossy_2_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_COBBLESTONE_MOSSY_2_PLATE = registerBlock("dungeon_cobblestone_mossy_2_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_COBBLESTONE_MOSSY_2_SLAB = registerBlock("dungeon_cobblestone_mossy_2_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_COBBLESTONE_MOSSY_2_STAIRS = registerBlock("dungeon_cobblestone_mossy_2_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_COBBLESTONE_MOSSY_2_WALL = registerBlock("dungeon_cobblestone_mossy_2_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_CRACKED_WALL = registerBlock("dungeon_cracked_wall",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_CRACKED_WALL_BUTTON = registerBlock("dungeon_cracked_wall_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_CRACKED_WALL_PLATE = registerBlock("dungeon_cracked_wall_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_CRACKED_WALL_SLAB = registerBlock("dungeon_cracked_wall_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_CRACKED_WALL_STAIRS = registerBlock("dungeon_cracked_wall_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_CRACKED_WALL_WALL = registerBlock("dungeon_cracked_wall_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_CRACKED_WALL_2 = registerBlock("dungeon_cracked_wall_2",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_CRACKED_WALL_2_BUTTON = registerBlock("dungeon_cracked_wall_2_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_CRACKED_WALL_2_PLATE = registerBlock("dungeon_cracked_wall_2_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_CRACKED_WALL_2_SLAB = registerBlock("dungeon_cracked_wall_2_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_CRACKED_WALL_2_STAIRS = registerBlock("dungeon_cracked_wall_2_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_CRACKED_WALL_2_WALL = registerBlock("dungeon_cracked_wall_2_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_DARK_BRICK = registerBlock("dungeon_dark_brick",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_DARK_BRICK_BUTTON = registerBlock("dungeon_dark_brick_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_DARK_BRICK_PLATE = registerBlock("dungeon_dark_brick_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_DARK_BRICK_SLAB = registerBlock("dungeon_dark_brick_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_DARK_BRICK_STAIRS = registerBlock("dungeon_dark_brick_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_DARK_BRICK_WALL = registerBlock("dungeon_dark_brick_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_DARK_PLANKS = registerBlock("dungeon_dark_planks",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_DARK_PLANKS_BUTTON = registerBlock("dungeon_dark_planks_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_DARK_PLANKS_PLATE = registerBlock("dungeon_dark_planks_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_DARK_PLANKS_SLAB = registerBlock("dungeon_dark_planks_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_DARK_PLANKS_STAIRS = registerBlock("dungeon_dark_planks_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_DARK_PLANKS_WALL = registerBlock("dungeon_dark_planks_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_DIORITE_CEILING = registerBlock("dungeon_diorite_ceiling",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_DIORITE_CEILING_BUTTON = registerBlock("dungeon_diorite_ceiling_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_DIORITE_CEILING_PLATE = registerBlock("dungeon_diorite_ceiling_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_DIORITE_CEILING_SLAB = registerBlock("dungeon_diorite_ceiling_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_DIORITE_CEILING_STAIRS = registerBlock("dungeon_diorite_ceiling_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_DIORITE_CEILING_WALL = registerBlock("dungeon_diorite_ceiling_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_DIRT_CRACKED = registerBlock("dungeon_dirt_cracked",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_DIRT_CRACKED_BUTTON = registerBlock("dungeon_dirt_cracked_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_DIRT_CRACKED_PLATE = registerBlock("dungeon_dirt_cracked_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_DIRT_CRACKED_SLAB = registerBlock("dungeon_dirt_cracked_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_DIRT_CRACKED_STAIRS = registerBlock("dungeon_dirt_cracked_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_DIRT_CRACKED_WALL = registerBlock("dungeon_dirt_cracked_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_DOOR = registerBlock("dungeon_door",
            new DungeonDoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR), BlockSetType.OAK));
    public static final Block DUNGEON_GLOWING_STONE = registerBlock("dungeon_glowing_stone",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_GLOWING_STONE_BUTTON = registerBlock("dungeon_glowing_stone_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_GLOWING_STONE_PLATE = registerBlock("dungeon_glowing_stone_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_GLOWING_STONE_SLAB = registerBlock("dungeon_glowing_stone_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_GLOWING_STONE_STAIRS = registerBlock("dungeon_glowing_stone_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_GLOWING_STONE_WALL = registerBlock("dungeon_glowing_stone_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_MOSSY_WALL = registerBlock("dungeon_mossy_wall",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_MOSSY_WALL_BUTTON = registerBlock("dungeon_mossy_wall_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_MOSSY_WALL_PLATE = registerBlock("dungeon_mossy_wall_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_MOSSY_WALL_SLAB = registerBlock("dungeon_mossy_wall_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_MOSSY_WALL_STAIRS = registerBlock("dungeon_mossy_wall_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_MOSSY_WALL_WALL = registerBlock("dungeon_mossy_wall_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_STONE_FLOOR = registerBlock("dungeon_stone_floor",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_FLOOR_BUTTON = registerBlock("dungeon_stone_floor_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_STONE_FLOOR_PLATE = registerBlock("dungeon_stone_floor_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_STONE_FLOOR_SLAB = registerBlock("dungeon_stone_floor_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_FLOOR_STAIRS = registerBlock("dungeon_stone_floor_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_FLOOR_WALL = registerBlock("dungeon_stone_floor_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_STONE_ANDESITE = registerBlock("dungeon_stone_andesite",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_ANDESITE_BUTTON = registerBlock("dungeon_stone_andesite_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_STONE_ANDESITE_PLATE = registerBlock("dungeon_stone_andesite_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_STONE_ANDESITE_SLAB = registerBlock("dungeon_stone_andesite_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_ANDESITE_STAIRS = registerBlock("dungeon_stone_andesite_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_ANDESITE_WALL = registerBlock("dungeon_stone_andesite_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_STONE_ANDESITE_PATH = registerBlock("dungeon_stone_andesite_path",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_ANDESITE_PATH_BUTTON = registerBlock("dungeon_stone_andesite_path_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_STONE_ANDESITE_PATH_PLATE = registerBlock("dungeon_stone_andesite_path_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_STONE_ANDESITE_PATH_SLAB = registerBlock("dungeon_stone_andesite_path_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_ANDESITE_PATH_STAIRS = registerBlock("dungeon_stone_andesite_path_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_ANDESITE_PATH_WALL = registerBlock("dungeon_stone_andesite_path_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_STONE_BRICKS = registerBlock("dungeon_stone_bricks",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_BRICKS_BUTTON = registerBlock("dungeon_stone_bricks_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_STONE_BRICKS_PLATE = registerBlock("dungeon_stone_bricks_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_STONE_BRICKS_SLAB = registerBlock("dungeon_stone_bricks_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_BRICKS_STAIRS = registerBlock("dungeon_stone_bricks_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_BRICKS_WALL = registerBlock("dungeon_stone_bricks_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_STONE_CRACKS = registerBlock("dungeon_stone_cracks",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_CRACKS_BUTTON = registerBlock("dungeon_stone_cracks_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_STONE_CRACKS_PLATE = registerBlock("dungeon_stone_cracks_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_STONE_CRACKS_SLAB = registerBlock("dungeon_stone_cracks_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_CRACKS_STAIRS = registerBlock("dungeon_stone_cracks_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_CRACKS_WALL = registerBlock("dungeon_stone_cracks_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_STONE_DARK_FLOOR = registerBlock("dungeon_stone_dark_floor",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_DARK_FLOOR_BUTTON = registerBlock("dungeon_stone_dark_floor_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_STONE_DARK_FLOOR_PLATE = registerBlock("dungeon_stone_dark_floor_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_STONE_DARK_FLOOR_SLAB = registerBlock("dungeon_stone_dark_floor_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_DARK_FLOOR_STAIRS = registerBlock("dungeon_stone_dark_floor_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_DARK_FLOOR_WALL = registerBlock("dungeon_stone_dark_floor_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_STONE_FLOOR_LIGHT = registerBlock("dungeon_stone_floor_light",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_FLOOR_LIGHT_BUTTON = registerBlock("dungeon_stone_floor_light_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_STONE_FLOOR_LIGHT_PLATE = registerBlock("dungeon_stone_floor_light_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_STONE_FLOOR_LIGHT_SLAB = registerBlock("dungeon_stone_floor_light_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_FLOOR_LIGHT_STAIRS = registerBlock("dungeon_stone_floor_light_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_FLOOR_LIGHT_WALL = registerBlock("dungeon_stone_floor_light_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_STONE_MOSSY_FLOOR = registerBlock("dungeon_stone_mossy_floor",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_MOSSY_FLOOR_BUTTON = registerBlock("dungeon_stone_mossy_floor_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_STONE_MOSSY_FLOOR_PLATE = registerBlock("dungeon_stone_mossy_floor_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_STONE_MOSSY_FLOOR_SLAB = registerBlock("dungeon_stone_mossy_floor_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_MOSSY_FLOOR_STAIRS = registerBlock("dungeon_stone_mossy_floor_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_MOSSY_FLOOR_WALL = registerBlock("dungeon_stone_mossy_floor_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_STONE_PEBBLES = registerBlock("dungeon_stone_pebbles",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_PEBBLES_BUTTON = registerBlock("dungeon_stone_pebbles_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_STONE_PEBBLES_PLATE = registerBlock("dungeon_stone_pebbles_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_STONE_PEBBLES_SLAB = registerBlock("dungeon_stone_pebbles_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_PEBBLES_STAIRS = registerBlock("dungeon_stone_pebbles_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONE_PEBBLES_WALL = registerBlock("dungeon_stone_pebbles_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_STONY_DIRT = registerBlock("dungeon_stony_dirt",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONY_DIRT_BUTTON = registerBlock("dungeon_stony_dirt_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_STONY_DIRT_PLATE = registerBlock("dungeon_stony_dirt_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_STONY_DIRT_SLAB = registerBlock("dungeon_stony_dirt_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONY_DIRT_STAIRS = registerBlock("dungeon_stony_dirt_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONY_DIRT_WALL = registerBlock("dungeon_stony_dirt_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //--
    public static final Block DUNGEON_STONY_GROUND = registerBlock("dungeon_stony_ground",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONY_GROUND_BUTTON = registerBlock("dungeon_stony_ground_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.BRICKS), BlockSetType.IRON, 40, true));
    public static final Block DUNGEON_STONY_GROUND_PLATE = registerBlock("dungeon_stony_ground_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final Block DUNGEON_STONY_GROUND_SLAB = registerBlock("dungeon_stony_ground_slab",
            new SlabBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONY_GROUND_STAIRS = registerBlock("dungeon_stony_ground_stairs",
            new StairsBlock(ModBlocks.BRICK_BLACK.getDefaultState(), FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    public static final Block DUNGEON_STONY_GROUND_WALL = registerBlock("dungeon_stony_ground_wall",
            new WallBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()
                    .sounds(BlockSoundGroup.STONE)));
    //END DUNGEON BLOCKS------------------------------------------------------------------------------------
    public static final Block GLASS_MOD = registerBlock("glass_mod",
            new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(1.0f).nonOpaque()));
    public static final Block GLASS_MOD_PANE = registerBlock("glass_mod_pane",
            new PaneBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(1.0f).nonOpaque()));
    public static final Block GLASS_MOD_BLUE = registerBlock("glass_mod_blue",
            new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(1.0f).nonOpaque()));
    public static final Block GLASS_MOD_BLUE_PANE = registerBlock("glass_mod_blue_pane",
            new PaneBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(1.0f).nonOpaque()));
    public static final Block GLASS_MOD_GREEN = registerBlock("glass_mod_green",
            new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(1.0f).nonOpaque()));
    public static final Block GLASS_MOD_GREEN_PANE = registerBlock("glass_mod_green_pane",
            new PaneBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(1.0f).nonOpaque()));
    public static final Block GLASS_MOD_LIGHT_BLUE = registerBlock("glass_mod_light_blue",
            new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(1.0f).nonOpaque()));
    public static final Block GLASS_MOD_LIGHT_BLUE_PANE = registerBlock("glass_mod_light_blue_pane",
            new PaneBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(1.0f).nonOpaque()));
    public static final Block GLASS_MOD_PURPLE = registerBlock("glass_mod_purple",
            new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(1.0f).nonOpaque()));
    public static final Block GLASS_MOD_PURPLE_PANE = registerBlock("glass_mod_purple_pane",
            new PaneBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(1.0f).nonOpaque()));
    public static final Block GLASS_MOD_WHITE = registerBlock("glass_mod_white",
            new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(1.0f).nonOpaque()));
    public static final Block GLASS_MOD_WHITE_PANE = registerBlock("glass_mod_white_pane",
            new PaneBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(1.0f).nonOpaque()));
    public static final Block GLASS_MOD_YELLOW = registerBlock("glass_mod_yellow",
            new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(1.0f).nonOpaque()));
    public static final Block GLASS_MOD_YELLOW_PANE = registerBlock("glass_mod_yellow_pane",
            new PaneBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(1.0f).nonOpaque()));
    public static final Block LAVA_BLOCK = registerBlock("lava_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block LAMP_BLOCK = registerBlock("lamp_block",
            new LampBlock(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.METAL).nonOpaque()
                    .luminance((state) -> state.get(LampBlock.CLICKED) ? 15 : 0)));
    public static final Block LETTUCE_CROP = Registry.register(Registries.BLOCK, new Identifier(Hillside.MOD_ID, "lettuce_crop"),
            new LettuceBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    public static final Block TACO_BELL = registerBlock("taco_bell",
            new TacoBellBlock(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.ANVIL)
                    .nonOpaque()));
    public static final Block TROLL_HEAD = registerBlock("troll_head",
            new TrollHeadBlock(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.BONE)
                    .nonOpaque()));
    public static final Block WINTER_WINDOW = registerBlock("winter_window",
            new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(1.0f).nonOpaque()));
    public static final Block WINTER_WINDOW_PANE = registerBlock("winter_window_pane",
            new PaneBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(1.0f).nonOpaque()));
    public static final Block XANTHE = registerBlock("xanthe", new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 10,
            FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));

    public static final Block XANTHE_POTTED = Registry.register(Registries.BLOCK, new Identifier(Hillside.MOD_ID, "xanthe_potted"),
            new FlowerPotBlock(XANTHE, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Hillside.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Hillside.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks() {
        Hillside.LOGGER.info("Registering ModBlocks for " + Hillside.MOD_ID);
    }
}
