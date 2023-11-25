package net.hillsidemod.hillside.block.entity;

import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.hillsidemod.hillside.block.custom.BrickOvenBlock;
import net.hillsidemod.hillside.recipe.BrickOvenRecipe;
import net.hillsidemod.screen.BrickOvenScreenHandler;
import net.minecraft.SharedConstants;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class BrickOvenBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(5, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 0;
    private int fuelTime = 0;
    private int maxFuelTime = 0;
    private int isInitialized = 0;
    private int hasFire = 0;

    private static final int DYE_SLOT = 0;
    private static final int MEAL_SLOT = 1;
    private static final int BRICK_SLOT = 2;
    private static final int FUEL_SLOT = 3;
    private static final int OUTPUT_SLOT = 4;

    public BrickOvenBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BRICK_OVEN, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch(index) {
                    case 0: return BrickOvenBlockEntity.this.progress;
                    case 1: return BrickOvenBlockEntity.this.maxProgress;
                    case 2: return BrickOvenBlockEntity.this.fuelTime;
                    case 3: return BrickOvenBlockEntity.this.maxFuelTime;
                    case 4: return BrickOvenBlockEntity.this.isInitialized;
                    case 5: return BrickOvenBlockEntity.this.hasFire;
                    default: return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch(index) {
                    case 0: BrickOvenBlockEntity.this.progress = value; break;
                    case 1: BrickOvenBlockEntity.this.maxProgress = value; break;
                    case 2: BrickOvenBlockEntity.this.fuelTime = value; break;
                    case 3: BrickOvenBlockEntity.this.maxFuelTime = value; break;
                    case 4: BrickOvenBlockEntity.this.isInitialized = value; break;
                    case 5: BrickOvenBlockEntity.this.hasFire = value; break;
                }
            }

            @Override
            public int size() {
                return 6;
            }
        };

    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("brick_oven_progress", progress);
        nbt.putInt("brick_oven_max_progress", maxProgress);
        nbt.putInt("brick_oven_fuel", fuelTime);
        nbt.putInt("brick_oven_max_fuel", maxFuelTime);
        nbt.putInt("brick_oven_isburning", hasFire);
        nbt.putInt("brick_oven_isinitialized", isInitialized);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("brick_oven_progress");
        maxProgress = nbt.getInt("brick_oven_max_progress");
        fuelTime = nbt.getInt("brick_oven_fuel");
        maxFuelTime = nbt.getInt("brick_oven_max_fuel");
        hasFire = nbt.getInt("brick_oven_isburning");
        isInitialized = nbt.getInt("brick_oven_isinitialized");

        this.propertyDelegate.set(0, progress);
        this.propertyDelegate.set(1,maxProgress);
        this.propertyDelegate.set(2, fuelTime);
        this.propertyDelegate.set(3, maxFuelTime);
        this.propertyDelegate.set(4, hasFire);
        this.propertyDelegate.set(5, isInitialized);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Brick Oven");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {

        return new BrickOvenScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    private static void craftItem(BrickOvenBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for(int i=0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<BrickOvenRecipe> recipe = entity.getWorld().getRecipeManager()
                .getFirstMatch(BrickOvenRecipe.Type.INSTANCE, inventory, entity.getWorld());

        if(hasRecipe(entity)) {
            entity.removeStack(0, 1);
            entity.removeStack(1, 1);
            entity.removeStack(2, 1);
            entity.setStack(3, new ItemStack(recipe.get().getOutput(entity.getWorld().getRegistryManager()).getItem(), entity.getStack(3).getCount()+1));
            //   entity.setStack(3, new ItemStack(recipe.get().getOutput(entity.getWorld().getRegistryManager())).getItem(),
            //     entity.getStack(3).getCount() +1));

            entity.resetProgress();
            resetRecipe(entity);
        }
    }

    private static void resetRecipe(BrickOvenBlockEntity entity) {
        entity.maxProgress = 0;
        entity.isInitialized = 0;
    }

    public void tick(World world, BlockPos blockPos, BlockState state) {
        if(world.isClient()) {
            return;
        }

        manageFuel(this);
        if(hasRecipe(this) && this.hasFire == 1) {
            state = (BlockState)state.with(BrickOvenBlock.LIT, this.fuelTime > 0);
            world.setBlockState(blockPos, state, Block.NOTIFY_ALL);
            this.progress++;
            markDirty(world, blockPos, state);
            if(this.progress >= this.maxProgress) {
                craftItem(this);
            }
        }
        else {
            this.resetProgress();
            resetRecipe(this);
            state = (BlockState)state.with(BrickOvenBlock.LIT, this.fuelTime > 0);
            markDirty(world, blockPos, state);
            world.setBlockState(blockPos, state, Block.NOTIFY_ALL);
        }

        if(this.fuelTime > 0)
            this.fuelTime--;
    }

    private static void manageFuel(BrickOvenBlockEntity entity) {
        if(entity.fuelTime <= 0)
            initializeFuel(entity);
    }

    protected int getFuelTime(ItemStack fuel) {
        if (fuel.isEmpty()) {
            return 0;
        }
        Item item = fuel.getItem();
        return BrickOvenBlockEntity.createFuelTimeMap().getOrDefault(item, 0);
    }

    private static void initializeFuel(BrickOvenBlockEntity entity) {
        ItemStack fuelSlot = entity.getStack(4);
        if(!fuelSlot.isEmpty()) {
            if(canUseAsFuel(fuelSlot) && hasRecipe(entity)) {
                entity.fuelTime = entity.getFuelTime(fuelSlot);
                entity.maxFuelTime = entity.fuelTime;
                entity.removeStack(4,1);
                entity.hasFire = 1;
            }
            else {
                entity.fuelTime = 0;
                entity.hasFire = 0;
            }
        }
        else {
            entity.fuelTime = 0;
            entity.hasFire = 0;
        }
    }

    public static boolean canUseAsFuel(ItemStack stack) {
        return BrickOvenBlockEntity.createFuelTimeMap().containsKey(stack.getItem());
    }

    private static boolean hasRecipe(BrickOvenBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for(int i=0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<BrickOvenRecipe> match = entity.getWorld().getRecipeManager().getFirstMatch(BrickOvenRecipe.Type.INSTANCE, inventory, entity.getWorld());
        if(!match.isEmpty() && entity.isInitialized != 1)
            initializeRecipe(match.get(), entity);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput(entity.getWorld().getRegistryManager()).getItem());
    }

    private static void initializeRecipe(BrickOvenRecipe brickOvenRecipe, BrickOvenBlockEntity entity) {
        entity.maxProgress = brickOvenRecipe.getCookingTime();
        entity.isInitialized = 1;
    }
    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(3).getItem() == output || inventory.getStack(3).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(3).getMaxCount() > inventory.getStack(3).getCount();
    }
    private void resetProgress() {
        this.progress = 0;
    }
    public static Map<Item, Integer> createFuelTimeMap() {
        LinkedHashMap<Item, Integer> map = Maps.newLinkedHashMap();
        BrickOvenBlockEntity.addFuel(map, Items.LAVA_BUCKET, 20000);
        BrickOvenBlockEntity.addFuel(map, Blocks.COAL_BLOCK, 16000);
        BrickOvenBlockEntity.addFuel(map, Items.BLAZE_ROD, 2400);
        BrickOvenBlockEntity.addFuel(map, Items.COAL, 1600);
        BrickOvenBlockEntity.addFuel(map, Items.CHARCOAL, 1600);
        BrickOvenBlockEntity.addFuel(map, ItemTags.LOGS, 300);
        BrickOvenBlockEntity.addFuel(map, ItemTags.BAMBOO_BLOCKS, 300);
        BrickOvenBlockEntity.addFuel(map, ItemTags.PLANKS, 300);
        BrickOvenBlockEntity.addFuel(map, Blocks.BAMBOO_MOSAIC, 300);
        BrickOvenBlockEntity.addFuel(map, ItemTags.WOODEN_STAIRS, 300);
        BrickOvenBlockEntity.addFuel(map, Blocks.BAMBOO_MOSAIC_STAIRS, 300);
        BrickOvenBlockEntity.addFuel(map, ItemTags.WOODEN_SLABS, 150);
        BrickOvenBlockEntity.addFuel(map, Blocks.BAMBOO_MOSAIC_SLAB, 150);
        BrickOvenBlockEntity.addFuel(map, ItemTags.WOODEN_TRAPDOORS, 300);
        BrickOvenBlockEntity.addFuel(map, ItemTags.WOODEN_PRESSURE_PLATES, 300);
        BrickOvenBlockEntity.addFuel(map, ItemTags.WOODEN_FENCES, 300);
        BrickOvenBlockEntity.addFuel(map, ItemTags.FENCE_GATES, 300);
        BrickOvenBlockEntity.addFuel(map, Blocks.NOTE_BLOCK, 300);
        BrickOvenBlockEntity.addFuel(map, Blocks.BOOKSHELF, 300);
        BrickOvenBlockEntity.addFuel(map, Blocks.CHISELED_BOOKSHELF, 300);
        BrickOvenBlockEntity.addFuel(map, Blocks.LECTERN, 300);
        BrickOvenBlockEntity.addFuel(map, Blocks.JUKEBOX, 300);
        BrickOvenBlockEntity.addFuel(map, Blocks.CHEST, 300);
        BrickOvenBlockEntity.addFuel(map, Blocks.TRAPPED_CHEST, 300);
        BrickOvenBlockEntity.addFuel(map, Blocks.CRAFTING_TABLE, 300);
        BrickOvenBlockEntity.addFuel(map, Blocks.DAYLIGHT_DETECTOR, 300);
        BrickOvenBlockEntity.addFuel(map, ItemTags.BANNERS, 300);
        BrickOvenBlockEntity.addFuel(map, Items.BOW, 300);
        BrickOvenBlockEntity.addFuel(map, Items.FISHING_ROD, 300);
        BrickOvenBlockEntity.addFuel(map, Blocks.LADDER, 300);
        BrickOvenBlockEntity.addFuel(map, ItemTags.SIGNS, 200);
        BrickOvenBlockEntity.addFuel(map, ItemTags.HANGING_SIGNS, 800);
        BrickOvenBlockEntity.addFuel(map, Items.WOODEN_SHOVEL, 200);
        BrickOvenBlockEntity.addFuel(map, Items.WOODEN_SWORD, 200);
        BrickOvenBlockEntity.addFuel(map, Items.WOODEN_HOE, 200);
        BrickOvenBlockEntity.addFuel(map, Items.WOODEN_AXE, 200);
        BrickOvenBlockEntity.addFuel(map, Items.WOODEN_PICKAXE, 200);
        BrickOvenBlockEntity.addFuel(map, ItemTags.WOODEN_DOORS, 200);
        BrickOvenBlockEntity.addFuel(map, ItemTags.BOATS, 1200);
        BrickOvenBlockEntity.addFuel(map, ItemTags.WOOL, 100);
        BrickOvenBlockEntity.addFuel(map, ItemTags.WOODEN_BUTTONS, 100);
        BrickOvenBlockEntity.addFuel(map, Items.STICK, 100);
        BrickOvenBlockEntity.addFuel(map, ItemTags.SAPLINGS, 100);
        BrickOvenBlockEntity.addFuel(map, Items.BOWL, 100);
        BrickOvenBlockEntity.addFuel(map, ItemTags.WOOL_CARPETS, 67);
        BrickOvenBlockEntity.addFuel(map, Blocks.DRIED_KELP_BLOCK, 4001);
        BrickOvenBlockEntity.addFuel(map, Items.CROSSBOW, 300);
        BrickOvenBlockEntity.addFuel(map, Blocks.BAMBOO, 50);
        BrickOvenBlockEntity.addFuel(map, Blocks.DEAD_BUSH, 100);
        BrickOvenBlockEntity.addFuel(map, Blocks.SCAFFOLDING, 50);
        BrickOvenBlockEntity.addFuel(map, Blocks.LOOM, 300);
        BrickOvenBlockEntity.addFuel(map, Blocks.BARREL, 300);
        BrickOvenBlockEntity.addFuel(map, Blocks.CARTOGRAPHY_TABLE, 300);
        BrickOvenBlockEntity.addFuel(map, Blocks.FLETCHING_TABLE, 300);
        BrickOvenBlockEntity.addFuel(map, Blocks.SMITHING_TABLE, 300);
        BrickOvenBlockEntity.addFuel(map, Blocks.COMPOSTER, 300);
        BrickOvenBlockEntity.addFuel(map, Blocks.AZALEA, 100);
        BrickOvenBlockEntity.addFuel(map, Blocks.FLOWERING_AZALEA, 100);
        BrickOvenBlockEntity.addFuel(map, Blocks.MANGROVE_ROOTS, 300);
        return map;
    }

    private static void addFuel(Map<Item, Integer> fuelTimes, TagKey<Item> tag, int fuelTime) {
        Iterator var3 = Registries.ITEM.iterateEntries(tag).iterator();

        while(var3.hasNext()) {
            RegistryEntry<Item> registryEntry = (RegistryEntry)var3.next();
            if (!BrickOvenBlockEntity.isNonFlammableWood((Item)registryEntry.value())) {
                fuelTimes.put((Item)registryEntry.value(), fuelTime);
            }
        }
    }

    private static void addFuel(Map<Item, Integer> fuelTimes, ItemConvertible item, int fuelTime) {
        Item item2 = item.asItem();
        if (isNonFlammableWood(item2)) {
            if (SharedConstants.isDevelopment) {
                throw (IllegalStateException) Util.throwOrPause(new IllegalStateException("A developer tried to explicitly make fire resistant item " + item2.getName((ItemStack)null).getString() + " a furnace fuel. That will not work!"));
            }
        } else {
            fuelTimes.put(item2, fuelTime);
        }
    }

    private static boolean isNonFlammableWood(Item item) {
        return item.getRegistryEntry().isIn(ItemTags.NON_FLAMMABLE_WOOD);
    }

}
