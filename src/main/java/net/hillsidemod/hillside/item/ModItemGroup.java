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
                        entries.add(ModBlocks.BOP);
                        entries.add(ModBlocks.BRICK_BLACK);
                        entries.add(ModBlocks.BRICK_BLACK_BUTTON);
                        entries.add(ModBlocks.BRICK_BLACK_PLATE);
                        entries.add(ModBlocks.BRICK_BLACK_SLAB);
                        entries.add(ModBlocks.BRICK_BLACK_SMEAR);
                        entries.add(ModBlocks.BRICK_BLACK_STAIRS);
                        entries.add(ModBlocks.BRICK_BLACK_WALL);
                        entries.add(ModBlocks.BRICK_BROWN);
                        entries.add(ModBlocks.BRICK_BROWN_BUTTON);
                        entries.add(ModBlocks.BRICK_BROWN_PLATE);
                        entries.add(ModBlocks.BRICK_BROWN_SLAB);
                        entries.add(ModBlocks.BRICK_BROWN_SMEAR);
                        entries.add(ModBlocks.BRICK_BROWN_STAIRS);
                        entries.add(ModBlocks.BRICK_BROWN_WALL);
                        entries.add(ModBlocks.BRICK_MULTICOLORED);
                        entries.add(ModBlocks.BRICK_MULTICOLORED_BUTTON);
                        entries.add(ModBlocks.BRICK_MULTICOLORED_PLATE);
                        entries.add(ModBlocks.BRICK_MULTICOLORED_SLAB);
                        entries.add(ModBlocks.BRICK_MULTICOLORED_SMEAR);
                        entries.add(ModBlocks.BRICK_MULTICOLORED_STAIRS);
                        entries.add(ModBlocks.BRICK_MULTICOLORED_WALL);
                        entries.add(ModBlocks.BRICK_OVEN);
                        entries.add(ModBlocks.BRICK_PINK);
                        entries.add(ModBlocks.BRICK_PINK_BUTTON);
                        entries.add(ModBlocks.BRICK_PINK_PLATE);
                        entries.add(ModBlocks.BRICK_PINK_SLAB);
                        entries.add(ModBlocks.BRICK_PINK_SMEAR);
                        entries.add(ModBlocks.BRICK_PINK_STAIRS);
                        entries.add(ModBlocks.BRICK_PINK_WALL);
                        entries.add(ModBlocks.BRICK_SMEAR);
                        entries.add(ModBlocks.BRICK_TAN);
                        entries.add(ModBlocks.BRICK_TAN_BUTTON);
                        entries.add(ModBlocks.BRICK_TAN_PLATE);
                        entries.add(ModBlocks.BRICK_TAN_SLAB);
                        entries.add(ModBlocks.BRICK_TAN_SMEAR);
                        entries.add(ModBlocks.BRICK_TAN_STAIRS);
                        entries.add(ModBlocks.BRICK_TAN_WALL);
                        entries.add(ModBlocks.BRICK_WHITE);
                        entries.add(ModBlocks.BRICK_WHITE_BUTTON);
                        entries.add(ModBlocks.BRICK_WHITE_PLATE);
                        entries.add(ModBlocks.BRICK_WHITE_SLAB);
                        entries.add(ModBlocks.BRICK_WHITE_SMEAR);
                        entries.add(ModBlocks.BRICK_WHITE_STAIRS);
                        entries.add(ModBlocks.BRICK_WHITE_WALL);
                        entries.add(ModItems.DECAYING_ZOMBIE_EGG);
                        entries.add(ModItems.DOWSINGROD_ANCIENT_DEBRIS);
                        entries.add(ModItems.DOWSINGROD_COAL_COPPER);
                        entries.add(ModItems.DOWSINGROD_DIAMOND_LAPIS);
                        entries.add(ModItems.DOWSINGROD_IRON_GOLD);
                        entries.add(ModBlocks.LAMP_BLOCK);
                        entries.add(ModBlocks.LAVA_BLOCK);
                        entries.add(ModItems.MIRROR);
                        entries.add(ModItems.NETHER_MIRROR);
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RUBY_BOOTS);
                        entries.add(ModItems.RUBY_PICKAXE);
                        entries.add(ModItems.STAR_COMPASS);
                        entries.add(ModBlocks.WINTER_WINDOW);
                        entries.add(ModBlocks.WINTER_WINDOW_PANE);
                        entries.add(ModBlocks.XANTHE);





                    }).build());


    public static void registerItemGroups() {
        Hillside.LOGGER.info("Registering Item Groups for " + Hillside.MOD_ID);
    }

}
