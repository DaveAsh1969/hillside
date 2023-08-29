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
            new Identifier(Hillside.MOD_ID, "hillside"),
            FabricItemGroup.builder().displayName(Text.literal("Hillside"))
                    .icon(() -> new ItemStack(ModItems.STAR_COMPASS)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.BRICK_BLACK);
                        entries.add(ModBlocks.BRICK_BLACK_BUTTON);
                        entries.add(ModBlocks.BRICK_BLACK_PLATE);
                        entries.add(ModBlocks.BRICK_BLACK_SLAB);
                        entries.add(ModBlocks.BRICK_BLACK_SMEAR);
                        entries.add(ModBlocks.BRICK_BLACK_STAIRS);
                        entries.add(ModBlocks.BRICK_BLACK_WALL);
                        entries.add(ModBlocks.BRICK_BROWN);
                        entries.add(ModBlocks.BRICK_BROWN_SMEAR);
                        entries.add(ModBlocks.BRICK_MULTICOLORED);
                        entries.add(ModBlocks.BRICK_MULTICOLORED_SMEAR);
                        entries.add(ModBlocks.BRICK_OVEN20);
                        entries.add(ModBlocks.BRICK_PINK);
                        entries.add(ModBlocks.BRICK_PINK_SMEAR);
                        entries.add(ModBlocks.BRICK_SMEAR);
                        entries.add(ModBlocks.BRICK_TAN);
                        entries.add(ModBlocks.BRICK_TAN_SMEAR);
                        entries.add(ModBlocks.BRICK_WHITE);
                        entries.add(ModBlocks.BRICK_WHITE_SMEAR);
                        entries.add(ModBlocks.LAMP_BLOCK);
                        entries.add(ModItems.DOWSINGROD_COAL_COPPER);
                        entries.add(ModItems.DOWSINGROD_DIAMOND_LAPIS);
                        entries.add(ModItems.DOWSINGROD_IRON_GOLD);
                        entries.add(ModItems.MIRROR);
                        entries.add(ModItems.STAR_COMPASS);


                    }).build());


    public static void registerItemGroups() {
        Hillside.LOGGER.info("Registering Item Groups for " + Hillside.MOD_ID);
    }


    //public static final RegistryKey<ItemGroup> HILLSIDE = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(Hillside.MOD_ID, "hillside"));

    /*public static void registerItemGroups() {
        HILLSIDE = FabricItemGroup.builder(new Identifier(Hillside.MOD_ID, "hillside"))
                .displayName(Text.literal("Hillside"))
                .icon(() -> new ItemStack((ModItems.STAR_COMPASS))).build();
        Registry.register(Registries.ITEM_GROUP, HILLSIDE, FabricItemGroup.builder()
                .displayName(Text.literal("hillside"))
                .icon(() -> new ItemStack((ModItems.STAR_COMPASS)).entries((displayContext, entries) -> {
                    entries.add(ModItems.RUBY);
                    entries.add(ModBlocks.RUBY_STAIRS);
                    entries.add(ModBlocks.RUBY_SLAB);
                    entries.add(ModBlocks.RUBY_FENCE);
                    entries.add(ModBlocks.RUBY_FENCE_GATE);
                    entries.add(ModBlocks.RUBY_WALL);
                    entries.add(ModBlocks.RUBY_BUTTON);
                    entries.add(ModBlocks.RUBY_PRESSURE_PLATE);
                    entries.add(ModBlocks.RUBY_DOOR);
                    entries.add(ModBlocks.RUBY_TRAPDOOR);


                }).build());

        public static final ItemGroup HILLSIDE = Registry.register(Registries.ITEM_GROUP,
                new Identifier(TutorialMod.MOD_ID, "ruby"),
                FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                        .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
                            entries.add(ModItems.RUBY);
                            entries.add(ModItems.RAW_RUBY);

                            entries.add(ModItems.METAL_DETECTOR);

                            entries.add(Items.DIAMOND);

                            entries.add(ModItems.TOMATO);
                            entries.add(ModItems.COAL_BRIQUETTE);

                            entries.add(ModBlocks.RUBY_BLOCK);
                            entries.add(ModBlocks.RAW_RUBY_BLOCK);

                            entries.add(ModBlocks.RUBY_ORE);
                            entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                            entries.add(ModBlocks.NETHER_RUBY_ORE);
                            entries.add(ModBlocks.END_STONE_RUBY_ORE);

                            entries.add(ModBlocks.SOUND_BLOCK);

                            entries.add(ModBlocks.RUBY_STAIRS);
                            entries.add(ModBlocks.RUBY_SLAB);
                            entries.add(ModBlocks.RUBY_FENCE);
                            entries.add(ModBlocks.RUBY_FENCE_GATE);
                            entries.add(ModBlocks.RUBY_WALL);
                            entries.add(ModBlocks.RUBY_BUTTON);
                            entries.add(ModBlocks.RUBY_PRESSURE_PLATE);
                            entries.add(ModBlocks.RUBY_DOOR);
                            entries.add(ModBlocks.RUBY_TRAPDOOR);


                        }).build());

    }*/
}
