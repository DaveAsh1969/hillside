package net.hillsidemod.hillside.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.hillsidemod.hillside.block.ModBlocks;
import net.hillsidemod.hillside.block.custom.LettuceBlock;
import net.hillsidemod.hillside.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BOP);
        addPottedPlantDrops(ModBlocks.BOP_POTTED);
        addDrop(ModBlocks.BRICK_BLACK);
        addDrop(ModBlocks.BRICK_BLACK_SMEAR);
        addDrop(ModBlocks.BRICK_BLACK_STAIRS);
        addDrop(ModBlocks.BRICK_BLACK_WALL);
        addDrop(ModBlocks.BRICK_BLACK_BUTTON);
        addDrop(ModBlocks.BRICK_BLACK_PLATE);
        addDrop(ModBlocks.BRICK_BLACK_SLAB, slabDrops(ModBlocks.BRICK_BLACK_SLAB));
        addDrop(ModBlocks.BRICK_BROWN);
        addDrop(ModBlocks.BRICK_BROWN_SMEAR);
        addDrop(ModBlocks.BRICK_BROWN_STAIRS);
        addDrop(ModBlocks.BRICK_BROWN_WALL);
        addDrop(ModBlocks.BRICK_BROWN_BUTTON);
        addDrop(ModBlocks.BRICK_BROWN_PLATE);
        addDrop(ModBlocks.BRICK_BROWN_SLAB, slabDrops(ModBlocks.BRICK_BROWN_SLAB));
        addDrop(ModBlocks.BRICK_MULTICOLORED);
        addDrop(ModBlocks.BRICK_MULTICOLORED_SMEAR);
        addDrop(ModBlocks.BRICK_MULTICOLORED_STAIRS);
        addDrop(ModBlocks.BRICK_MULTICOLORED_WALL);
        addDrop(ModBlocks.BRICK_MULTICOLORED_BUTTON);
        addDrop(ModBlocks.BRICK_MULTICOLORED_PLATE);
        addDrop(ModBlocks.BRICK_MULTICOLORED_SLAB, slabDrops(ModBlocks.BRICK_MULTICOLORED_SLAB));
        addDrop(ModBlocks.BRICK_LAVENDER);
        addDrop(ModBlocks.BRICK_LAVENDER_SMEAR);
        addDrop(ModBlocks.BRICK_LAVENDER_STAIRS);
        addDrop(ModBlocks.BRICK_LAVENDER_WALL);
        addDrop(ModBlocks.BRICK_LAVENDER_BUTTON);
        addDrop(ModBlocks.BRICK_LAVENDER_PLATE);
        addDrop(ModBlocks.BRICK_LAVENDER_SLAB, slabDrops(ModBlocks.BRICK_LAVENDER_SLAB));
        addDrop(ModBlocks.BRICK_PINK);
        addDrop(ModBlocks.BRICK_PINK_SMEAR);
        addDrop(ModBlocks.BRICK_PINK_STAIRS);
        addDrop(ModBlocks.BRICK_PINK_WALL);
        addDrop(ModBlocks.BRICK_PINK_BUTTON);
        addDrop(ModBlocks.BRICK_PINK_PLATE);
        addDrop(ModBlocks.BRICK_PINK_SLAB, slabDrops(ModBlocks.BRICK_PINK_SLAB));
        addDrop(ModBlocks.BRICK_SMEAR);
        addDrop(ModBlocks.BRICK_TAN);
        addDrop(ModBlocks.BRICK_TAN_SMEAR);
        addDrop(ModBlocks.BRICK_TAN_STAIRS);
        addDrop(ModBlocks.BRICK_TAN_WALL);
        addDrop(ModBlocks.BRICK_TAN_BUTTON);
        addDrop(ModBlocks.BRICK_TAN_PLATE);
        addDrop(ModBlocks.BRICK_TAN_SLAB, slabDrops(ModBlocks.BRICK_TAN_SLAB));
        addDrop(ModBlocks.BRICK_WHITE);
        addDrop(ModBlocks.BRICK_WHITE_SMEAR);
        addDrop(ModBlocks.BRICK_WHITE_STAIRS);
        addDrop(ModBlocks.BRICK_WHITE_WALL);
        addDrop(ModBlocks.BRICK_WHITE_BUTTON);
        addDrop(ModBlocks.BRICK_WHITE_PLATE);
        addDrop(ModBlocks.BRICK_WHITE_SLAB, slabDrops(ModBlocks.BRICK_WHITE_SLAB));
        //dungeon drops
        addDrop(ModBlocks.DUNGEON_ANDESITE_CRACKED);
        addDrop(ModBlocks.DUNGEON_ANDESITE_CRACKED_BUTTON);
        addDrop(ModBlocks.DUNGEON_ANDESITE_CRACKED_PLATE);
        addDrop(ModBlocks.DUNGEON_ANDESITE_CRACKED_SLAB, slabDrops(ModBlocks.DUNGEON_ANDESITE_CRACKED_SLAB));
        addDrop(ModBlocks.DUNGEON_ANDESITE_CRACKED_STAIRS);
        addDrop(ModBlocks.DUNGEON_ANDESITE_CRACKED_WALL);

        addDrop(ModBlocks.DUNGEON_BLOOD_WALL);
        addDrop(ModBlocks.DUNGEON_BLOOD_WALL_BUTTON);
        addDrop(ModBlocks.DUNGEON_BLOOD_WALL_PLATE);
        addDrop(ModBlocks.DUNGEON_BLOOD_WALL_SLAB, slabDrops(ModBlocks.DUNGEON_BLOOD_WALL_SLAB));
        addDrop(ModBlocks.DUNGEON_BLOOD_WALL_STAIRS);
        addDrop(ModBlocks.DUNGEON_BLOOD_WALL_WALL);

        addDrop(ModBlocks.DUNGEON_CEILING);
        addDrop(ModBlocks.DUNGEON_CEILING_BUTTON);
        addDrop(ModBlocks.DUNGEON_CEILING_PLATE);
        addDrop(ModBlocks.DUNGEON_CEILING_SLAB, slabDrops(ModBlocks.DUNGEON_CEILING_SLAB));
        addDrop(ModBlocks.DUNGEON_CEILING_STAIRS);
        addDrop(ModBlocks.DUNGEON_CEILING_WALL);

        addDrop(ModBlocks.DUNGEON_CHISELED);
        addDrop(ModBlocks.DUNGEON_CHISELED_BUTTON);
        addDrop(ModBlocks.DUNGEON_CHISELED_PLATE);
        addDrop(ModBlocks.DUNGEON_CHISELED_SLAB, slabDrops(ModBlocks.DUNGEON_CHISELED_SLAB));
        addDrop(ModBlocks.DUNGEON_CHISELED_STAIRS);
        addDrop(ModBlocks.DUNGEON_CHISELED_WALL);

        addDrop(ModBlocks.DUNGEON_COBBLESTONE_MOSSY);
        addDrop(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_BUTTON);
        addDrop(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_PLATE);
        addDrop(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_SLAB, slabDrops(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_SLAB));
        addDrop(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_STAIRS);
        addDrop(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_WALL);

        addDrop(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_2);
        addDrop(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_2_BUTTON);
        addDrop(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_2_PLATE);
        addDrop(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_2_SLAB, slabDrops(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_2_SLAB));
        addDrop(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_2_STAIRS);
        addDrop(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_2_WALL);

        addDrop(ModBlocks.DUNGEON_CRACKED_WALL);
        addDrop(ModBlocks.DUNGEON_CRACKED_WALL_BUTTON);
        addDrop(ModBlocks.DUNGEON_CRACKED_WALL_PLATE);
        addDrop(ModBlocks.DUNGEON_CRACKED_WALL_SLAB, slabDrops(ModBlocks.DUNGEON_CRACKED_WALL_SLAB));
        addDrop(ModBlocks.DUNGEON_CRACKED_WALL_STAIRS);
        addDrop(ModBlocks.DUNGEON_CRACKED_WALL_WALL);

        addDrop(ModBlocks.DUNGEON_CRACKED_WALL_2);
        addDrop(ModBlocks.DUNGEON_CRACKED_WALL_2_BUTTON);
        addDrop(ModBlocks.DUNGEON_CRACKED_WALL_2_PLATE);
        addDrop(ModBlocks.DUNGEON_CRACKED_WALL_2_SLAB, slabDrops(ModBlocks.DUNGEON_CRACKED_WALL_2_SLAB));
        addDrop(ModBlocks.DUNGEON_CRACKED_WALL_2_STAIRS);
        addDrop(ModBlocks.DUNGEON_CRACKED_WALL_2_WALL);

        addDrop(ModBlocks.DUNGEON_DARK_BRICK);
        addDrop(ModBlocks.DUNGEON_DARK_BRICK_BUTTON);
        addDrop(ModBlocks.DUNGEON_DARK_BRICK_PLATE);
        addDrop(ModBlocks.DUNGEON_DARK_BRICK_SLAB, slabDrops(ModBlocks.DUNGEON_DARK_BRICK_SLAB));
        addDrop(ModBlocks.DUNGEON_DARK_BRICK_STAIRS);
        addDrop(ModBlocks.DUNGEON_DARK_BRICK_WALL);

        addDrop(ModBlocks.DUNGEON_DARK_PLANKS);
        addDrop(ModBlocks.DUNGEON_DARK_PLANKS_BUTTON);
        addDrop(ModBlocks.DUNGEON_DARK_PLANKS_PLATE);
        addDrop(ModBlocks.DUNGEON_DARK_PLANKS_SLAB, slabDrops(ModBlocks.DUNGEON_DARK_PLANKS_SLAB));
        addDrop(ModBlocks.DUNGEON_DARK_PLANKS_STAIRS);
        addDrop(ModBlocks.DUNGEON_DARK_PLANKS_WALL);

        addDrop(ModBlocks.DUNGEON_DIORITE_CEILING);
        addDrop(ModBlocks.DUNGEON_DIORITE_CEILING_BUTTON);
        addDrop(ModBlocks.DUNGEON_DIORITE_CEILING_PLATE);
        addDrop(ModBlocks.DUNGEON_DIORITE_CEILING_SLAB, slabDrops(ModBlocks.DUNGEON_DIORITE_CEILING_SLAB));
        addDrop(ModBlocks.DUNGEON_DIORITE_CEILING_STAIRS);
        addDrop(ModBlocks.DUNGEON_DIORITE_CEILING_WALL);

        addDrop(ModBlocks.DUNGEON_DIRT_CRACKED);
        addDrop(ModBlocks.DUNGEON_DIRT_CRACKED_BUTTON);
        addDrop(ModBlocks.DUNGEON_DIRT_CRACKED_PLATE);
        addDrop(ModBlocks.DUNGEON_DIRT_CRACKED_SLAB, slabDrops(ModBlocks.DUNGEON_DIRT_CRACKED_SLAB));
        addDrop(ModBlocks.DUNGEON_DIRT_CRACKED_STAIRS);
        addDrop(ModBlocks.DUNGEON_DIRT_CRACKED_WALL);

        addDrop(ModBlocks.DUNGEON_DOOR, doorDrops(ModBlocks.DUNGEON_DOOR));

        addDrop(ModBlocks.DUNGEON_GLOWING_STONE);
        addDrop(ModBlocks.DUNGEON_GLOWING_STONE_BUTTON);
        addDrop(ModBlocks.DUNGEON_GLOWING_STONE_PLATE);
        addDrop(ModBlocks.DUNGEON_GLOWING_STONE_SLAB, slabDrops(ModBlocks.DUNGEON_GLOWING_STONE_SLAB));
        addDrop(ModBlocks.DUNGEON_GLOWING_STONE_STAIRS);
        addDrop(ModBlocks.DUNGEON_GLOWING_STONE_WALL);

        addDrop(ModBlocks.DUNGEON_MOSSY_WALL);
        addDrop(ModBlocks.DUNGEON_MOSSY_WALL_BUTTON);
        addDrop(ModBlocks.DUNGEON_MOSSY_WALL_PLATE);
        addDrop(ModBlocks.DUNGEON_MOSSY_WALL_SLAB, slabDrops(ModBlocks.DUNGEON_MOSSY_WALL_SLAB));
        addDrop(ModBlocks.DUNGEON_MOSSY_WALL_STAIRS);
        addDrop(ModBlocks.DUNGEON_MOSSY_WALL_WALL);

        addDrop(ModBlocks.DUNGEON_STONE_FLOOR);
        addDrop(ModBlocks.DUNGEON_STONE_FLOOR_BUTTON);
        addDrop(ModBlocks.DUNGEON_STONE_FLOOR_PLATE);
        addDrop(ModBlocks.DUNGEON_STONE_FLOOR_SLAB, slabDrops(ModBlocks.DUNGEON_STONE_FLOOR_SLAB));
        addDrop(ModBlocks.DUNGEON_STONE_FLOOR_STAIRS);
        addDrop(ModBlocks.DUNGEON_STONE_FLOOR_WALL);

        addDrop(ModBlocks.DUNGEON_STONE_ANDESITE);
        addDrop(ModBlocks.DUNGEON_STONE_ANDESITE_BUTTON);
        addDrop(ModBlocks.DUNGEON_STONE_ANDESITE_PLATE);
        addDrop(ModBlocks.DUNGEON_STONE_ANDESITE_SLAB, slabDrops(ModBlocks.DUNGEON_STONE_ANDESITE_SLAB));
        addDrop(ModBlocks.DUNGEON_STONE_ANDESITE_STAIRS);
        addDrop(ModBlocks.DUNGEON_STONE_ANDESITE_WALL);

        addDrop(ModBlocks.DUNGEON_STONE_ANDESITE_PATH);
        addDrop(ModBlocks.DUNGEON_STONE_ANDESITE_PATH_BUTTON);
        addDrop(ModBlocks.DUNGEON_STONE_ANDESITE_PATH_PLATE);
        addDrop(ModBlocks.DUNGEON_STONE_ANDESITE_PATH_SLAB, slabDrops(ModBlocks.DUNGEON_STONE_ANDESITE_PATH_SLAB));
        addDrop(ModBlocks.DUNGEON_STONE_ANDESITE_PATH_STAIRS);
        addDrop(ModBlocks.DUNGEON_STONE_ANDESITE_PATH_WALL);

        addDrop(ModBlocks.DUNGEON_STONE_BRICKS);
        addDrop(ModBlocks.DUNGEON_STONE_BRICKS_BUTTON);
        addDrop(ModBlocks.DUNGEON_STONE_BRICKS_PLATE);
        addDrop(ModBlocks.DUNGEON_STONE_BRICKS_SLAB, slabDrops(ModBlocks.DUNGEON_STONE_BRICKS_SLAB));
        addDrop(ModBlocks.DUNGEON_STONE_BRICKS_STAIRS);
        addDrop(ModBlocks.DUNGEON_STONE_BRICKS_WALL);

        addDrop(ModBlocks.DUNGEON_STONE_CRACKS);
        addDrop(ModBlocks.DUNGEON_STONE_CRACKS_BUTTON);
        addDrop(ModBlocks.DUNGEON_STONE_CRACKS_PLATE);
        addDrop(ModBlocks.DUNGEON_STONE_CRACKS_SLAB, slabDrops(ModBlocks.DUNGEON_STONE_CRACKS_SLAB));
        addDrop(ModBlocks.DUNGEON_STONE_CRACKS_STAIRS);
        addDrop(ModBlocks.DUNGEON_STONE_CRACKS_WALL);

        addDrop(ModBlocks.DUNGEON_STONE_DARK_FLOOR);
        addDrop(ModBlocks.DUNGEON_STONE_DARK_FLOOR_BUTTON);
        addDrop(ModBlocks.DUNGEON_STONE_DARK_FLOOR_PLATE);
        addDrop(ModBlocks.DUNGEON_STONE_DARK_FLOOR_SLAB, slabDrops(ModBlocks.DUNGEON_STONE_DARK_FLOOR_SLAB));
        addDrop(ModBlocks.DUNGEON_STONE_DARK_FLOOR_STAIRS);
        addDrop(ModBlocks.DUNGEON_STONE_DARK_FLOOR_WALL);

        addDrop(ModBlocks.DUNGEON_STONE_FLOOR_LIGHT);
        addDrop(ModBlocks.DUNGEON_STONE_FLOOR_LIGHT_BUTTON);
        addDrop(ModBlocks.DUNGEON_STONE_FLOOR_LIGHT_PLATE);
        addDrop(ModBlocks.DUNGEON_STONE_FLOOR_LIGHT_SLAB, slabDrops(ModBlocks.DUNGEON_STONE_FLOOR_LIGHT_SLAB));
        addDrop(ModBlocks.DUNGEON_STONE_FLOOR_LIGHT_STAIRS);
        addDrop(ModBlocks.DUNGEON_STONE_FLOOR_LIGHT_WALL);

        addDrop(ModBlocks.DUNGEON_STONE_MOSSY_FLOOR);
        addDrop(ModBlocks.DUNGEON_STONE_MOSSY_FLOOR_BUTTON);
        addDrop(ModBlocks.DUNGEON_STONE_MOSSY_FLOOR_PLATE);
        addDrop(ModBlocks.DUNGEON_STONE_MOSSY_FLOOR_SLAB, slabDrops(ModBlocks.DUNGEON_STONE_MOSSY_FLOOR_SLAB));
        addDrop(ModBlocks.DUNGEON_STONE_MOSSY_FLOOR_STAIRS);
        addDrop(ModBlocks.DUNGEON_STONE_MOSSY_FLOOR_WALL);

        addDrop(ModBlocks.DUNGEON_STONE_PEBBLES);
        addDrop(ModBlocks.DUNGEON_STONE_PEBBLES_BUTTON);
        addDrop(ModBlocks.DUNGEON_STONE_PEBBLES_PLATE);
        addDrop(ModBlocks.DUNGEON_STONE_PEBBLES_SLAB, slabDrops(ModBlocks.DUNGEON_STONE_PEBBLES_SLAB));
        addDrop(ModBlocks.DUNGEON_STONE_PEBBLES_STAIRS);
        addDrop(ModBlocks.DUNGEON_STONE_PEBBLES_WALL);

        addDrop(ModBlocks.DUNGEON_STONY_DIRT);
        addDrop(ModBlocks.DUNGEON_STONY_DIRT_BUTTON);
        addDrop(ModBlocks.DUNGEON_STONY_DIRT_PLATE);
        addDrop(ModBlocks.DUNGEON_STONY_DIRT_SLAB, slabDrops(ModBlocks.DUNGEON_STONY_DIRT_SLAB));
        addDrop(ModBlocks.DUNGEON_STONY_DIRT_STAIRS);
        addDrop(ModBlocks.DUNGEON_STONY_DIRT_WALL);

        addDrop(ModBlocks.DUNGEON_STONY_GROUND);
        addDrop(ModBlocks.DUNGEON_STONY_GROUND_BUTTON);
        addDrop(ModBlocks.DUNGEON_STONY_GROUND_STAIRS);
        addDrop(ModBlocks.DUNGEON_STONY_GROUND_SLAB, slabDrops(ModBlocks.DUNGEON_STONY_GROUND_SLAB));
        addDrop(ModBlocks.DUNGEON_STONY_GROUND_WALL);

        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.LETTUCE_CROP)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(LettuceBlock.AGE, 4));

        addDrop(ModBlocks.LETTUCE_CROP, cropDrops(ModBlocks.LETTUCE_CROP, ModItems.LETTUCE, ModItems.LETTUCE_SEEDS, builder));

        addDrop(ModBlocks.LAVA_BLOCK);
        addDrop(ModBlocks.OCEAN_MARBLE);
        addDrop(ModBlocks.TACO_BELL);
        addDrop(ModBlocks.TROLL_HEAD);
        addDrop(ModBlocks.XANTHE);
        addPottedPlantDrops(ModBlocks.XANTHE_POTTED);
    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(2.0f, 5.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
