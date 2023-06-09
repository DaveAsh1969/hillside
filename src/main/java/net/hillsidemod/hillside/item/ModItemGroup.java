package net.hillsidemod.hillside.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.hillsidemod.hillside.Hillside;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final RegistryKey<ItemGroup> HILLSIDE = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(Hillside.MOD_ID, "hillside"));

    public static void registerItemGroups() {
       /* HILLSIDE = FabricItemGroup.builder(new Identifier(Hillside.MOD_ID, "hillside"))
                .displayName(Text.literal("Hillside"))
                .icon(() -> new ItemStack((ModItems.STAR_COMPASS))).build();*/
        Registry.register(Registries.ITEM_GROUP, HILLSIDE, FabricItemGroup.builder()
                .displayName(Text.literal("hillside"))
                .icon(() -> new ItemStack((ModItems.STAR_COMPASS)))
                .build());
    }
}
