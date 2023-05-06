package net.hillsidemod.hillside.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hillsidemod.hillside.Hillside;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks
{
    private static Item registerBlockItem(String name, Block block, ItemGroup group)
    {
        Item item = Registry.register(Registries.ITEM, new Identifier(Hillside.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerModBlocks() {
        Hillside.LOGGER.info("Registering ModBlocks for " + Hillside.MOD_ID);
    }
}
