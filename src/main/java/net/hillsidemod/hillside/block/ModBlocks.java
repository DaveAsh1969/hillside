package net.hillsidemod.hillside.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.block.custom.*;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks
{
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
    public static final Block DUNGEON_DOOR = registerBlock("dungeon_door",
            new DungeonDoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR), BlockSetType.OAK));
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
