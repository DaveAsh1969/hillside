package net.hillsidemod.hillside.recipe;

import net.hillsidemod.hillside.Hillside;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Hillside.MOD_ID, BrickOvenRecipe.Serializer.ID),
                BrickOvenRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Hillside.MOD_ID, BrickOvenRecipe.Type.ID),
                BrickOvenRecipe.Type.INSTANCE);
    }
}
