package net.hillsidemod.hillside.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.hillsidemod.hillside.Hillside;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup HILLSIDE;

    public static void registerItemGroups() {
        HILLSIDE = FabricItemGroup.builder(new Identifier(Hillside.MOD_ID, "hillside"))
                .displayName(Text.literal("Hillside"))
                .icon(() -> new ItemStack((ModItems.STAR_COMPASS))).build();
    }
}
