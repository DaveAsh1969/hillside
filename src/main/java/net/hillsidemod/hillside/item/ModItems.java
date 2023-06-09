package net.hillsidemod.hillside.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.item.custom.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item DOWSINGROD_COAL_COPPER = registerItem("dowsing_rod_coal_copper",
            new DowsingRodItem_Coal_Copper(new FabricItemSettings().maxDamage(155)));
    public static final Item DOWSINGROD_DIAMOND_LAPIS = registerItem("dowsing_rod_diamond_lapis",
            new DowsingRodItem_Diamond_Lapis(new FabricItemSettings().maxDamage(300)));
    public static final Item DOWSINGROD_IRON_GOLD = registerItem("dowsing_rod_iron_gold",
            new DowsingRodItem_Iron_Gold(new FabricItemSettings().maxDamage(255)));
    public static final Item MIRROR = registerItem("mirror",
            new MirrorItem(new FabricItemSettings()));
    public static final Item STAR_COMPASS = registerItem("star_compass",
            new StarCompassItem(new FabricItemSettings().maxDamage(300)));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Hillside.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.HILLSIDE, DOWSINGROD_COAL_COPPER);
        addToItemGroup(ModItemGroup.HILLSIDE, DOWSINGROD_DIAMOND_LAPIS);
        addToItemGroup(ModItemGroup.HILLSIDE, DOWSINGROD_IRON_GOLD);
        addToItemGroup(ModItemGroup.HILLSIDE, MIRROR);
        addToItemGroup(ModItemGroup.HILLSIDE, STAR_COMPASS);
    }

    private static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerModItems() {
        Hillside.LOGGER.info("Registering Items");
        addItemsToItemGroup();
    }
}
