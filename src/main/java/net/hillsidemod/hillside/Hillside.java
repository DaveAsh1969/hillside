package net.hillsidemod.hillside;

import net.fabricmc.api.ModInitializer;

import net.hillsidemod.hillside.item.ModItemGroup;
import net.hillsidemod.hillside.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hillside implements ModInitializer {
    public static final String MOD_ID = "hillsidemod";
    public static final Logger LOGGER = LoggerFactory.getLogger("hillside");

    @Override
    public void onInitialize() {
        ModItemGroup.registerItemGroups();
        ModItems.registerModItems();
    }
}