package net.hillsidemod.hillside.screen.slot;

import net.hillsidemod.hillside.screen.BrickOvenScreenHandler;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;

public class BrickOvenFuelSlot extends Slot {
    private final BrickOvenScreenHandler handler;

    public BrickOvenFuelSlot(BrickOvenScreenHandler handler, Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
        this.handler = handler;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return this.handler.isFuel(stack) || BrickOvenFuelSlot.isBucket(stack);
    }

    @Override
    public int getMaxItemCount(ItemStack stack) {
        return BrickOvenFuelSlot.isBucket(stack) ? 1 : super.getMaxItemCount(stack);
    }

    public static boolean isBucket(ItemStack stack) {
        return stack.isOf(Items.BUCKET);
    }
}
