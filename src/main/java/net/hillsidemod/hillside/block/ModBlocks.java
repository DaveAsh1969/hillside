package net.hillsidemod.hillside.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.block.custom.BrickOvenBlock20;
import net.hillsidemod.hillside.block.custom.LampBlock;
import net.hillsidemod.hillside.item.ModItemGroup;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks
{
    public static final Block BRICK_BLACK = registerBlock("brick_black",
            //new Block(FabricBlockSettings.of(Blocks.STONE).strength(1.0f).requiresTool()), ModItemGroup.HILLSIDE);
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

    public static final Block BRICK_BROWN_SMEAR = registerBlock("brick_brown_smeared",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block BRICK_MULTICOLORED = registerBlock("brick_multicolored",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block BRICK_MULTICOLORED_SMEAR = registerBlock("brick_multicolored_smeared",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block BRICK_OVEN20 = registerBlock("brick_oven20",
            new BrickOvenBlock20(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE).nonOpaque()
                    .luminance((state) -> state.get(BrickOvenBlock20.LIT) ? 15 : 0 )));

    public static final Block BRICK_PINK = registerBlock("brick_pink",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block BRICK_PINK_SMEAR = registerBlock("brick_pink_smeared",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block BRICK_SMEAR = registerBlock("brick_smeared",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block BRICK_TAN = registerBlock("brick_tan",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block BRICK_TAN_SMEAR = registerBlock("brick_tan_smeared",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block BRICK_WHITE = registerBlock("brick_white",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block BRICK_WHITE_SMEAR = registerBlock("brick_white_smeared",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block LAMP_BLOCK = registerBlock("lamp_block",
            new LampBlock(FabricBlockSettings.create().strength(1.0f).requiresTool().sounds(BlockSoundGroup.METAL).nonOpaque()
                    .luminance((state) -> state.get(LampBlock.CLICKED) ? 15 : 0)));

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
