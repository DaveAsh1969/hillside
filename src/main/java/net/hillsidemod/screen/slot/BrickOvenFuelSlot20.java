package net.hillsidemod.screen.slot;

import net.hillsidemod.screen.BrickOvenScreenHandler;
import net.hillsidemod.screen.BrickOvenScreenHandler20;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;

public class BrickOvenFuelSlot20 extends Slot {
    private final BrickOvenScreenHandler20 handler;

    public BrickOvenFuelSlot20(BrickOvenScreenHandler20 handler, Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
        this.handler = handler;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return this.handler.isFuel(stack) || BrickOvenFuelSlot20.isBucket(stack);
    }

    @Override
    public int getMaxItemCount(ItemStack stack) {
        return BrickOvenFuelSlot20.isBucket(stack) ? 1 : super.getMaxItemCount(stack);
    }

    public static boolean isBucket(ItemStack stack) {
        return stack.isOf(Items.BUCKET);
    }
}
