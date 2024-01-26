package net.hillsidemod.hillside.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.block.ModBlocks;
import net.hillsidemod.hillside.entity.ModEntities;
import net.hillsidemod.hillside.item.custom.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item DECAYING_ZOMBIE_EGG = registerItem("decaying_zombie_egg",
            new SpawnEggItem(ModEntities.DECAYING_ZOMBIE, 0x805e6a, 0x6f965c, new FabricItemSettings()));
    public static final Item DOWSINGROD_ANCIENT_DEBRIS = registerItem("dowsing_rod_ancient_debris",
            new DowsingRodItem_AncientDebris(new FabricItemSettings().maxDamage(300)));
    public static final Item DOWSINGROD_COAL_COPPER = registerItem("dowsing_rod_coal_copper",
            new DowsingRodItem_Coal_Copper(new FabricItemSettings().maxDamage(155)));
    public static final Item DOWSINGROD_DIAMOND_LAPIS = registerItem("dowsing_rod_diamond_lapis",
            new DowsingRodItem_Diamond_Lapis(new FabricItemSettings().maxDamage(300)));
    public static final Item DOWSINGROD_IRON_GOLD = registerItem("dowsing_rod_iron_gold",
            new DowsingRodItem_Iron_Gold(new FabricItemSettings().maxDamage(255)));
    public static final Item DUNGEON_KEY = registerItem("dungeon_key",
            new Item(new FabricItemSettings().maxCount(1)));
    public static final Item MIRROR = registerItem("mirror",
            new MirrorItem(new FabricItemSettings().maxDamage(50)));
    public static final Item NETHER_MIRROR = registerItem("nether_mirror",
            new NetherMirrorItem(new FabricItemSettings().maxDamage(50)));
    public static final Item END_MIRROR = registerItem("end_mirror",
            new EndMirrorItem(new FabricItemSettings().maxDamage(50)));
    public static final Item RUBY = registerItem("ruby",
            new Item(new FabricItemSettings()));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots",
            new ModRubyBootsItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS,
                    new FabricItemSettings()));
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe",
            new RubyPickaxeItem(ModToolMaterial.RUBY, 2, 2f, new FabricItemSettings()));
    public static final Item STAR_COMPASS = registerItem("star_compass",
            new StarCompassItem(new FabricItemSettings().maxDamage(300)));
    public static final Item TACO_BELL_ITEM = registerItem("taco_bell_item",
            new TacoBellItem(ModBlocks.TACO_BELL, new FabricItemSettings().maxCount(1)));
    public static final Item TROLL_EGG = registerItem("troll_egg",
            new SpawnEggItem(ModEntities.TROLL_ENTITY, 0xeed9ae, 0x7d7158, new FabricItemSettings()));
    public static final Item ZOMBIE_PILLAGER_EGG = registerItem("zombie_pillager_egg",
            new SpawnEggItem(ModEntities.ZOMBIE_PILLAGER, 0x4b8b08, 0x654503, new FabricItemSettings()));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Hillside.MOD_ID, name), item);
    }

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
    }
    private static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerModItems() {
        Hillside.LOGGER.info("Registering Items");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
