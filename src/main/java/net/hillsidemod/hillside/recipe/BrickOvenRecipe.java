package net.hillsidemod.hillside.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class BrickOvenRecipe implements Recipe<SimpleInventory> {
    private final Identifier id;
    private final ItemStack output;
    private final DefaultedList<Ingredient> recipeItems;

    private final Integer cookingTime;

    public BrickOvenRecipe(Identifier id, ItemStack output, DefaultedList<Ingredient> recipeItems, Integer cookingTime) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        this.cookingTime = cookingTime;
    }
    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if(world.isClient()) {
            return false;
        }
        //testing the slot on the form vs the recipe array
        boolean testSlot0 = recipeItems.get(0).test(inventory.getStack(0));
        boolean testSlot1 = recipeItems.get(1).test(inventory.getStack(1));
        boolean testSlot2 = recipeItems.get(2).test(inventory.getStack(2));

        if(testSlot0 && testSlot1 && testSlot2)
            return true;
        else
            return false;

    }

    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
        return output;
    }

    //@Override
    //public ItemStack craft(SimpleInventory inventory) {
    //    return output;
    //}

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return output.copy();
    }

   //@Override
   // public ItemStack getOutput() {
   //     return output.copy();
   // }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public Integer getCookingTime() {
        return this.cookingTime;
    }

    public static class Type implements RecipeType<BrickOvenRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "brick_oven";
    }

    public static class Serializer implements RecipeSerializer<BrickOvenRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "brick_oven";

        //reading the json file
        @Override
        public BrickOvenRecipe read(Identifier id, JsonObject json) {
            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));
            Integer cookingTime = JsonHelper.getInt(json, "cookingtime");
            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");

            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(3, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new BrickOvenRecipe(id, output, inputs, cookingTime);
        }

        //networking read/write
        @Override
        public BrickOvenRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }

            Integer cookingTime = buf.readInt();
            ItemStack output = buf.readItemStack();
            return new BrickOvenRecipe(id, output, inputs, cookingTime);
        }

        @Override
        public void write(PacketByteBuf buf, BrickOvenRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }

            buf.writeInt(recipe.cookingTime);
            buf.writeItemStack(recipe.output);
        }
    }
}
