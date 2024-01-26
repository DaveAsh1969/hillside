package net.hillsidemod.hillside.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.hillsidemod.hillside.block.ModBlocks;
import net.hillsidemod.hillside.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BOP);
        addPottedPlantDrops(ModBlocks.BOP_POTTED);
        addDrop(ModBlocks.BRICK_BLACK_STAIRS);
        addDrop(ModBlocks.BRICK_BLACK_WALL);
        addDrop(ModBlocks.BRICK_BLACK_BUTTON);
        addDrop(ModBlocks.BRICK_BLACK_PLATE);
        addDrop(ModBlocks.BRICK_BLACK_SLAB, slabDrops(ModBlocks.BRICK_BLACK_SLAB));
        addDrop(ModBlocks.BRICK_BROWN_STAIRS);
        addDrop(ModBlocks.BRICK_BROWN_WALL);
        addDrop(ModBlocks.BRICK_BROWN_BUTTON);
        addDrop(ModBlocks.BRICK_BROWN_PLATE);
        addDrop(ModBlocks.BRICK_BROWN_SLAB, slabDrops(ModBlocks.BRICK_BROWN_SLAB));
        addDrop(ModBlocks.BRICK_MULTICOLORED_STAIRS);
        addDrop(ModBlocks.BRICK_MULTICOLORED_WALL);
        addDrop(ModBlocks.BRICK_MULTICOLORED_BUTTON);
        addDrop(ModBlocks.BRICK_MULTICOLORED_PLATE);
        addDrop(ModBlocks.BRICK_MULTICOLORED_SLAB, slabDrops(ModBlocks.BRICK_MULTICOLORED_SLAB));
        addDrop(ModBlocks.BRICK_PINK_STAIRS);
        addDrop(ModBlocks.BRICK_PINK_WALL);
        addDrop(ModBlocks.BRICK_PINK_BUTTON);
        addDrop(ModBlocks.BRICK_PINK_PLATE);
        addDrop(ModBlocks.BRICK_PINK_SLAB, slabDrops(ModBlocks.BRICK_PINK_SLAB));
        addDrop(ModBlocks.BRICK_TAN_STAIRS);
        addDrop(ModBlocks.BRICK_TAN_WALL);
        addDrop(ModBlocks.BRICK_TAN_BUTTON);
        addDrop(ModBlocks.BRICK_TAN_PLATE);
        addDrop(ModBlocks.BRICK_TAN_SLAB, slabDrops(ModBlocks.BRICK_TAN_SLAB));
        addDrop(ModBlocks.BRICK_WHITE_STAIRS);
        addDrop(ModBlocks.BRICK_WHITE_WALL);
        addDrop(ModBlocks.BRICK_WHITE_BUTTON);
        addDrop(ModBlocks.BRICK_WHITE_PLATE);
        addDrop(ModBlocks.BRICK_WHITE_SLAB, slabDrops(ModBlocks.BRICK_WHITE_SLAB));
        addDrop(ModBlocks.DUNGEON_DOOR, doorDrops(ModBlocks.DUNGEON_DOOR));
        addDrop(ModBlocks.LAVA_BLOCK);
        addDrop(ModBlocks.TACO_BELL);
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
