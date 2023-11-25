package net.hillsidemod.hillside;

import net.fabricmc.api.ModInitializer;

import net.hillsidemod.hillside.block.ModBlocks;
import net.hillsidemod.hillside.block.entity.ModBlockEntities;
import net.hillsidemod.hillside.item.ModItemGroup;
import net.hillsidemod.hillside.item.ModItems;
import net.hillsidemod.hillside.recipe.ModRecipes;
import net.hillsidemod.screen.ModScreenHandlers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hillside implements ModInitializer {
    public static final String MOD_ID = "hillsidemod";
    public static final Logger LOGGER = LoggerFactory.getLogger("hillsidemod");

    @Override
    public void onInitialize() {
        ModItemGroup.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModBlockEntities.registerBlockEntities();
        ModScreenHandlers.registerAllScreenHandlers();
        ModRecipes.registerRecipes();
    }
}