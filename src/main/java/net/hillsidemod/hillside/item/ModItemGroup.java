package net.hillsidemod.hillside.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup HILLSIDE = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Hillside.MOD_ID, "hillsidemod"),
            FabricItemGroup.builder().displayName(Text.literal("Hillside"))
                    .icon(() -> new ItemStack(ModItems.STAR_COMPASS)).entries((displayContext, entries) -> {
                        entries.add(ModItems.CHEESE);
                        entries.add(ModItems.DECAYING_ZOMBIE_EGG);
                        entries.add(ModItems.DECAYING_FLESH);
                        entries.add(ModItems.DOWSINGROD_ANCIENT_DEBRIS);
                        entries.add(ModItems.DOWSINGROD_COAL_COPPER);
                        entries.add(ModItems.DOWSINGROD_DIAMOND_LAPIS);
                        entries.add(ModItems.DOWSINGROD_IRON_GOLD);
                        entries.add(ModItems.DUCK_COOKED);
                        entries.add(ModItems.DUCK_EGG);
                        entries.add(ModItems.DUCK_FEATHER);
                        entries.add(ModItems.DUCK_RAW);
                        entries.add(ModItems.DUCK_ENTITY_EGG);
                        entries.add(ModBlocks.DUNGEON_DOOR);
                        entries.add(ModItems.DUNGEON_KEY);
                        entries.add(ModItems.END_MIRROR);
                        entries.add(ModBlocks.LAMP_BLOCK);
                        entries.add(ModItems.LETTUCE);
                        entries.add(ModItems.LETTUCE_SEEDS);
                        entries.add(ModItems.MIRROR);
                        entries.add(ModItems.NETHER_MIRROR);
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RUBY_BOOTS);
                        entries.add(ModItems.RUBY_PICKAXE);
                        entries.add(ModItems.STAR_COMPASS);
                        entries.add(ModItems.TACO);
                        entries.add(ModItems.TACO_BELL_ITEM);
                        entries.add(ModItems.TROLL_HEAD_ITEM);
                        entries.add(ModItems.TORTILLA);
                        entries.add(ModItems.TROLL_EGG);
                        entries.add(ModBlocks.WINTER_WINDOW);
                        entries.add(ModBlocks.WINTER_WINDOW_PANE);
                        entries.add(ModItems.ZOMBIE_PILLAGER_EGG);
                        entries.add(ModBlocks.BOP);
                        entries.add(ModBlocks.XANTHE);

                        //standard blocks
                        entries.add(ModBlocks.LAVA_BLOCK);
                        entries.add(ModBlocks.BRICK_OVEN);
                        entries.add(ModBlocks.BRICK_BLACK);
                        entries.add(ModBlocks.BRICK_BLACK_SMEAR);
                        entries.add(ModBlocks.BRICK_BROWN);
                        entries.add(ModBlocks.BRICK_BROWN_SMEAR);
                        entries.add(ModBlocks.BRICK_MULTICOLORED);
                        entries.add(ModBlocks.BRICK_MULTICOLORED_SMEAR);
                        entries.add(ModBlocks.BRICK_PINK);
                        entries.add(ModBlocks.BRICK_PINK_SMEAR);
                        entries.add(ModBlocks.BRICK_SMEAR);
                        entries.add(ModBlocks.BRICK_TAN);
                        entries.add(ModBlocks.BRICK_TAN_SMEAR);
                        entries.add(ModBlocks.BRICK_WHITE);
                        entries.add(ModBlocks.BRICK_WHITE_SMEAR);
                        entries.add(ModBlocks.DUNGEON_ANDESITE_CRACKED);
                        entries.add(ModBlocks.DUNGEON_BLOOD_WALL);
                        entries.add(ModBlocks.DUNGEON_CEILING);
                        entries.add(ModBlocks.DUNGEON_CHISELED);
                        entries.add(ModBlocks.DUNGEON_COBBLESTONE_MOSSY);
                        entries.add(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_2);
                        entries.add(ModBlocks.DUNGEON_CRACKED_WALL);
                        entries.add(ModBlocks.DUNGEON_CRACKED_WALL_2);
                        entries.add(ModBlocks.DUNGEON_DARK_BRICK);
                        entries.add(ModBlocks.DUNGEON_DARK_PLANKS);
                        entries.add(ModBlocks.DUNGEON_DIORITE_CEILING);
                        entries.add(ModBlocks.DUNGEON_DIRT_CRACKED);
                        entries.add(ModBlocks.DUNGEON_GLOWING_STONE);
                        entries.add(ModBlocks.DUNGEON_MOSSY_WALL);
                        entries.add(ModBlocks.DUNGEON_STONE_FLOOR);
                        entries.add(ModBlocks.DUNGEON_STONE_ANDESITE);
                        entries.add(ModBlocks.DUNGEON_STONE_ANDESITE_PATH);
                        entries.add(ModBlocks.DUNGEON_STONE_BRICKS);
                        entries.add(ModBlocks.DUNGEON_STONE_CRACKS);
                        entries.add(ModBlocks.DUNGEON_STONE_DARK_FLOOR);
                        entries.add(ModBlocks.DUNGEON_STONE_FLOOR_LIGHT);
                        entries.add(ModBlocks.DUNGEON_STONE_MOSSY_FLOOR);
                        entries.add(ModBlocks.DUNGEON_STONE_PEBBLES);
                        entries.add(ModBlocks.DUNGEON_STONY_DIRT);
                        entries.add(ModBlocks.DUNGEON_STONY_GROUND);

                        //stairs
                        entries.add(ModBlocks.BRICK_BLACK_STAIRS);
                        entries.add(ModBlocks.BRICK_BROWN_STAIRS);
                        entries.add(ModBlocks.BRICK_MULTICOLORED_STAIRS);
                        entries.add(ModBlocks.BRICK_PINK_STAIRS);
                        entries.add(ModBlocks.BRICK_TAN_STAIRS);
                        entries.add(ModBlocks.BRICK_WHITE_STAIRS);
                        entries.add(ModBlocks.DUNGEON_ANDESITE_CRACKED_STAIRS);
                        entries.add(ModBlocks.DUNGEON_BLOOD_WALL_STAIRS);
                        entries.add(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_STAIRS);
                        entries.add(ModBlocks.DUNGEON_CEILING_STAIRS);
                        entries.add(ModBlocks.DUNGEON_CHISELED_STAIRS);
                        entries.add(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_2_STAIRS);
                        entries.add(ModBlocks.DUNGEON_CRACKED_WALL_STAIRS);
                        entries.add(ModBlocks.DUNGEON_CRACKED_WALL_2_STAIRS);
                        entries.add(ModBlocks.DUNGEON_DARK_BRICK_STAIRS);
                        entries.add(ModBlocks.DUNGEON_DARK_PLANKS_STAIRS);
                        entries.add(ModBlocks.DUNGEON_DIORITE_CEILING_STAIRS);
                        entries.add(ModBlocks.DUNGEON_DIRT_CRACKED_STAIRS);
                        entries.add(ModBlocks.DUNGEON_GLOWING_STONE_STAIRS);
                        entries.add(ModBlocks.DUNGEON_MOSSY_WALL_STAIRS);
                        entries.add(ModBlocks.DUNGEON_STONE_FLOOR_STAIRS);
                        entries.add(ModBlocks.DUNGEON_STONE_ANDESITE_STAIRS);
                        entries.add(ModBlocks.DUNGEON_STONE_ANDESITE_PATH_STAIRS);
                        entries.add(ModBlocks.DUNGEON_STONE_BRICKS_STAIRS);
                        entries.add(ModBlocks.DUNGEON_STONE_CRACKS_STAIRS);
                        entries.add(ModBlocks.DUNGEON_STONE_DARK_FLOOR_STAIRS);
                        entries.add(ModBlocks.DUNGEON_STONE_FLOOR_LIGHT_STAIRS);
                        entries.add(ModBlocks.DUNGEON_STONE_MOSSY_FLOOR_STAIRS);
                        entries.add(ModBlocks.DUNGEON_STONE_PEBBLES_STAIRS);
                        entries.add(ModBlocks.DUNGEON_STONY_DIRT_STAIRS);
                        entries.add(ModBlocks.DUNGEON_STONY_GROUND_STAIRS);

                        //slabs
                        entries.add(ModBlocks.BRICK_BLACK_SLAB);
                        entries.add(ModBlocks.BRICK_BROWN_SLAB);
                        entries.add(ModBlocks.BRICK_MULTICOLORED_SLAB);
                        entries.add(ModBlocks.BRICK_PINK_SLAB);
                        entries.add(ModBlocks.BRICK_TAN_SLAB);
                        entries.add(ModBlocks.BRICK_WHITE_SLAB);
                        entries.add(ModBlocks.DUNGEON_ANDESITE_CRACKED_SLAB);
                        entries.add(ModBlocks.DUNGEON_BLOOD_WALL_SLAB);
                        entries.add(ModBlocks.DUNGEON_CEILING_SLAB);
                        entries.add(ModBlocks.DUNGEON_CHISELED_SLAB);
                        entries.add(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_SLAB);
                        entries.add(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_2_SLAB);
                        entries.add(ModBlocks.DUNGEON_CRACKED_WALL_SLAB);
                        entries.add(ModBlocks.DUNGEON_CRACKED_WALL_2_SLAB);
                        entries.add(ModBlocks.DUNGEON_DARK_BRICK_SLAB);
                        entries.add(ModBlocks.DUNGEON_DARK_PLANKS_SLAB);
                        entries.add(ModBlocks.DUNGEON_DIORITE_CEILING_SLAB);
                        entries.add(ModBlocks.DUNGEON_DIRT_CRACKED_SLAB);
                        entries.add(ModBlocks.DUNGEON_GLOWING_STONE_SLAB);
                        entries.add(ModBlocks.DUNGEON_MOSSY_WALL_SLAB);
                        entries.add(ModBlocks.DUNGEON_STONE_FLOOR_SLAB);
                        entries.add(ModBlocks.DUNGEON_STONE_ANDESITE_SLAB);
                        entries.add(ModBlocks.DUNGEON_STONE_ANDESITE_PATH_SLAB);
                        entries.add(ModBlocks.DUNGEON_STONE_BRICKS_SLAB);
                        entries.add(ModBlocks.DUNGEON_STONE_CRACKS_SLAB);
                        entries.add(ModBlocks.DUNGEON_STONE_DARK_FLOOR_SLAB);
                        entries.add(ModBlocks.DUNGEON_STONE_FLOOR_LIGHT_SLAB);
                        entries.add(ModBlocks.DUNGEON_STONE_MOSSY_FLOOR_SLAB);
                        entries.add(ModBlocks.DUNGEON_STONE_PEBBLES_SLAB);
                        entries.add(ModBlocks.DUNGEON_STONY_DIRT_SLAB);
                        entries.add(ModBlocks.DUNGEON_STONY_GROUND_SLAB);

                        //walls
                        entries.add(ModBlocks.BRICK_BLACK_WALL);
                        entries.add(ModBlocks.BRICK_BROWN_WALL);
                        entries.add(ModBlocks.BRICK_MULTICOLORED_WALL);
                        entries.add(ModBlocks.BRICK_PINK_WALL);
                        entries.add(ModBlocks.BRICK_TAN_WALL);
                        entries.add(ModBlocks.BRICK_WHITE_WALL);
                        entries.add(ModBlocks.DUNGEON_ANDESITE_CRACKED_WALL);
                        entries.add(ModBlocks.DUNGEON_BLOOD_WALL_WALL);
                        entries.add(ModBlocks.DUNGEON_CEILING_WALL);
                        entries.add(ModBlocks.DUNGEON_CHISELED_WALL);
                        entries.add(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_WALL);
                        entries.add(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_2_WALL);
                        entries.add(ModBlocks.DUNGEON_CRACKED_WALL_WALL);
                        entries.add(ModBlocks.DUNGEON_CRACKED_WALL_2_WALL);
                        entries.add(ModBlocks.DUNGEON_DARK_BRICK_WALL);
                        entries.add(ModBlocks.DUNGEON_DARK_PLANKS_WALL);
                        entries.add(ModBlocks.DUNGEON_DIORITE_CEILING_WALL);
                        entries.add(ModBlocks.DUNGEON_DIRT_CRACKED_WALL);
                        entries.add(ModBlocks.DUNGEON_GLOWING_STONE_WALL);
                        entries.add(ModBlocks.DUNGEON_MOSSY_WALL_WALL);
                        entries.add(ModBlocks.DUNGEON_STONE_FLOOR_WALL);
                        entries.add(ModBlocks.DUNGEON_STONE_ANDESITE_WALL);
                        entries.add(ModBlocks.DUNGEON_STONE_ANDESITE_PATH_WALL);
                        entries.add(ModBlocks.DUNGEON_STONE_BRICKS_WALL);
                        entries.add(ModBlocks.DUNGEON_STONE_CRACKS_WALL);
                        entries.add(ModBlocks.DUNGEON_STONE_DARK_FLOOR_WALL);
                        entries.add(ModBlocks.DUNGEON_STONE_FLOOR_LIGHT_WALL);
                        entries.add(ModBlocks.DUNGEON_STONE_MOSSY_FLOOR_WALL);
                        entries.add(ModBlocks.DUNGEON_STONE_PEBBLES_WALL);
                        entries.add(ModBlocks.DUNGEON_STONY_DIRT_WALL);
                        entries.add(ModBlocks.DUNGEON_STONY_GROUND_WALL);

                        //pressure plates
                        entries.add(ModBlocks.BRICK_BLACK_PLATE);
                        entries.add(ModBlocks.BRICK_BROWN_PLATE);
                        entries.add(ModBlocks.BRICK_MULTICOLORED_PLATE);
                        entries.add(ModBlocks.BRICK_PINK_PLATE);
                        entries.add(ModBlocks.BRICK_TAN_PLATE);
                        entries.add(ModBlocks.BRICK_WHITE_PLATE);
                        entries.add(ModBlocks.DUNGEON_ANDESITE_CRACKED_PLATE);
                        entries.add(ModBlocks.DUNGEON_BLOOD_WALL_PLATE);
                        entries.add(ModBlocks.DUNGEON_CEILING_PLATE);
                        entries.add(ModBlocks.DUNGEON_CHISELED_PLATE);
                        entries.add(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_PLATE);
                        entries.add(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_2_PLATE);
                        entries.add(ModBlocks.DUNGEON_CRACKED_WALL_PLATE);
                        entries.add(ModBlocks.DUNGEON_CRACKED_WALL_2_PLATE);
                        entries.add(ModBlocks.DUNGEON_DARK_BRICK_PLATE);
                        entries.add(ModBlocks.DUNGEON_DARK_PLANKS_PLATE);
                        entries.add(ModBlocks.DUNGEON_DIORITE_CEILING_PLATE);
                        entries.add(ModBlocks.DUNGEON_DIRT_CRACKED_PLATE);
                        entries.add(ModBlocks.DUNGEON_GLOWING_STONE_PLATE);
                        entries.add(ModBlocks.DUNGEON_MOSSY_WALL_PLATE);
                        entries.add(ModBlocks.DUNGEON_STONE_FLOOR_PLATE);
                        entries.add(ModBlocks.DUNGEON_STONE_ANDESITE_PLATE);
                        entries.add(ModBlocks.DUNGEON_STONE_ANDESITE_PATH_PLATE);
                        entries.add(ModBlocks.DUNGEON_STONE_BRICKS_PLATE);
                        entries.add(ModBlocks.DUNGEON_STONE_CRACKS_PLATE);
                        entries.add(ModBlocks.DUNGEON_STONE_DARK_FLOOR_PLATE);
                        entries.add(ModBlocks.DUNGEON_STONE_FLOOR_LIGHT_PLATE);
                        entries.add(ModBlocks.DUNGEON_STONE_MOSSY_FLOOR_PLATE);
                        entries.add(ModBlocks.DUNGEON_STONE_PEBBLES_PLATE);
                        entries.add(ModBlocks.DUNGEON_STONY_DIRT_PLATE);
                        entries.add(ModBlocks.DUNGEON_STONY_GROUND_PLATE);

                        //buttons
                        entries.add(ModBlocks.BRICK_BLACK_BUTTON);
                        entries.add(ModBlocks.BRICK_BROWN_BUTTON);
                        entries.add(ModBlocks.BRICK_MULTICOLORED_BUTTON);
                        entries.add(ModBlocks.BRICK_PINK_BUTTON);
                        entries.add(ModBlocks.BRICK_TAN_BUTTON);
                        entries.add(ModBlocks.BRICK_WHITE_BUTTON);
                        entries.add(ModBlocks.DUNGEON_ANDESITE_CRACKED_BUTTON);
                        entries.add(ModBlocks.DUNGEON_BLOOD_WALL_BUTTON);
                        entries.add(ModBlocks.DUNGEON_CEILING_BUTTON);
                        entries.add(ModBlocks.DUNGEON_CHISELED_BUTTON);
                        entries.add(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_BUTTON);
                        entries.add(ModBlocks.DUNGEON_COBBLESTONE_MOSSY_2_BUTTON);
                        entries.add(ModBlocks.DUNGEON_CRACKED_WALL_BUTTON);
                        entries.add(ModBlocks.DUNGEON_CRACKED_WALL_2_BUTTON);
                        entries.add(ModBlocks.DUNGEON_DARK_BRICK_BUTTON);
                        entries.add(ModBlocks.DUNGEON_DARK_PLANKS_BUTTON);
                        entries.add(ModBlocks.DUNGEON_DIORITE_CEILING_BUTTON);
                        entries.add(ModBlocks.DUNGEON_DIRT_CRACKED_BUTTON);
                        entries.add(ModBlocks.DUNGEON_GLOWING_STONE_BUTTON);
                        entries.add(ModBlocks.DUNGEON_MOSSY_WALL_BUTTON);
                        entries.add(ModBlocks.DUNGEON_STONE_FLOOR_BUTTON);
                        entries.add(ModBlocks.DUNGEON_STONE_ANDESITE_BUTTON);
                        entries.add(ModBlocks.DUNGEON_STONE_ANDESITE_PATH_BUTTON);
                        entries.add(ModBlocks.DUNGEON_STONE_BRICKS_BUTTON);
                        entries.add(ModBlocks.DUNGEON_STONE_CRACKS_BUTTON);
                        entries.add(ModBlocks.DUNGEON_STONE_DARK_FLOOR_BUTTON);
                        entries.add(ModBlocks.DUNGEON_STONE_FLOOR_LIGHT_BUTTON);
                        entries.add(ModBlocks.DUNGEON_STONE_MOSSY_FLOOR_BUTTON);
                        entries.add(ModBlocks.DUNGEON_STONE_PEBBLES_BUTTON);
                        entries.add(ModBlocks.DUNGEON_STONY_DIRT_BUTTON);
                        entries.add(ModBlocks.DUNGEON_STONY_GROUND_BUTTON);
                    }).build());


    public static void registerItemGroups() {
        Hillside.LOGGER.info("Registering Item Groups for " + Hillside.MOD_ID);
    }

}
