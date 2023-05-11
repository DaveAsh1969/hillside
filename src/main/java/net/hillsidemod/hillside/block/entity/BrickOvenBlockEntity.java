package net.hillsidemod.hillside.block.entity;

import net.hillsidemod.hillside.block.ModBlocks;
import net.hillsidemod.hillside.recipe.BrickOvenRecipe;
import net.hillsidemod.screen.BrickOvenScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class BrickOvenBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
   // private int fuelTime = 0;
  //  private int maxFuelTime = 0;

    public BrickOvenBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BRICK_OVEN, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch(index) {
                    case 0: return BrickOvenBlockEntity.this.progress;
                    case 1: return BrickOvenBlockEntity.this.maxProgress;
                   // case 2: return BrickOvenBlockEntity.this.fuelTime;
                   // case 3: return BrickOvenBlockEntity.this.maxFuelTime;
                    default: return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch(index) {
                    case 0: BrickOvenBlockEntity.this.progress = value; break;
                    case 1: BrickOvenBlockEntity.this.maxProgress = value; break;
                    //case 2: BrickOvenBlockEntity.this.fuelTime = value; break;
                   // case 3: BrickOvenBlockEntity.this.maxFuelTime= value; break;
                }
            }

            @Override
            public int size() {
                return 3;
            }
        };
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Brick Oven");
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new BrickOvenScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("brick_oven_progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("brick_oven_progress");

    }

    public static void tick(World world, BlockPos blockPos, BlockState state, BrickOvenBlockEntity entity) {
        if(world.isClient()) {
            return;
        }

        if(hasRecipe(entity)) {
            entity.progress++;
            markDirty(world, blockPos, state);
            if(entity.progress >= entity.maxProgress) {
                craftItem(entity);
            }
        }
        else {
            entity.resetProgress();
            markDirty(world, blockPos, state);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        return ImplementedInventory.super.canInsert(slot, stack, side);
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        return ImplementedInventory.super.canExtract(slot, stack, side);
    }

    private static void craftItem(BrickOvenBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for(int i=0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<BrickOvenRecipe> recipe = entity.getWorld().getRecipeManager()
                .getFirstMatch(BrickOvenRecipe.Type.INSTANCE, inventory, entity.getWorld());

        if(hasRecipe(entity)) {
            entity.removeStack(1, 1);
            entity.setStack(2, new ItemStack(recipe.get().getOutput().getItem(),
                entity.getStack(2).getCount() +1));

            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(BrickOvenBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for(int i=0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        //boolean hasCobbleInFirstSlot = entity.getStack(1).getItem() == Items.COBBLESTONE;

        Optional<BrickOvenRecipe> match = entity.getWorld().getRecipeManager()
                .getFirstMatch(BrickOvenRecipe.Type.INSTANCE, inventory, entity.getWorld());

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput().getItem());
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(2).getItem() == output || inventory.getStack(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(2).getMaxCount() > inventory.getStack(2).getCount();
    }
}
