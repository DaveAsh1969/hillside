package net.hillsidemod.hillside.item.custom;

import net.hillsidemod.hillside.particle.ModParticles;
import net.hillsidemod.hillside.sound.ModSounds;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionTypes;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class EndMirrorItem extends Item {
    private boolean bHasTeleported = false;
    private double teleportLocX = 0;
    private double teleportLocY = 0;
    private double teleportLocZ = 0;
    private double blockLocX = 0;
    private double blockLocY = 0;
    private double blockLocZ = 0;
    private boolean charging = false;
    public boolean usedOnBlock = false;
    public boolean blockFailed = true;

    public EndMirrorItem(Settings settings) {
        super(settings);
    }
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }
    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 40;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity user = context.getPlayer();
        if(!world.isClient()) {
            if (!world.getDimensionKey().getValue().equals(DimensionTypes.THE_END_ID))
            {
                user.sendMessage(Text.translatable("This mirror only works in the End!"), true);
                user.stopUsingItem();
                blockFailed = true;
                user.getItemCooldownManager().set(this,20);
                return ActionResult.FAIL;
            }
            else
            {
                ItemStack activeItemstack = context.getPlayer().getStackInHand(context.getPlayer().getActiveHand());

                NbtCompound nbtData = new NbtCompound();
                nbtData.putDouble("X", context.getBlockPos().getX());
                nbtData.putDouble("Y", context.getBlockPos().getY());
                nbtData.putDouble("Z", context.getBlockPos().getZ());
                nbtData.putBoolean("hasCoord", true);
                nbtData.putBoolean("charging", false);
                nbtData.putBoolean("hasTeleported", false);

                //set the teleport return point
                //blockLocX = context.getBlockPos().getX();
                //blockLocY = context.getBlockPos().getY();
                //blockLocZ = context.getBlockPos().getZ();

                context.getPlayer().sendMessage(Text.literal("Return coordinate set"), true);
                //usedOnBlock = true;
                blockFailed = false;

                activeItemstack.setNbt(nbtData);
                activeItemstack.writeNbt(nbtData);
            }
        }

        user.playSound(SoundEvents.BLOCK_AMETHYST_CLUSTER_STEP, 1.0f, 1.0f);
        return ActionResult.FAIL;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        if(!world.isClient())
        {
            ItemStack endMirrorItem = user.getStackInHand(hand);
            NbtCompound nbtData = endMirrorItem.getNbt();

            if (!world.getDimensionKey().getValue().equals(DimensionTypes.THE_END_ID))
            {
                user.sendMessage(Text.translatable("This mirror only works in the End!"), true);
                user.stopUsingItem();
                return TypedActionResult.success(user.getStackInHand(hand));
            }
           //nbtData.putBoolean("hasCoord", false);
           //usedOnBlock=false;
           //nbtData.putBoolean("hasTeleported", false);
           if(!nbtData.getBoolean("hasCoord"))
           {
               user.sendMessage(Text.translatable("Right click a block to set a location."), true);
               user.stopUsingItem();
               return TypedActionResult.fail(user.getStackInHand(hand));
           }
           teleportLocX = user.getX();
           teleportLocY = user.getY();
           teleportLocZ = user.getZ();
           endMirrorItem.setNbt(nbtData);
           endMirrorItem.writeNbt(nbtData);
        }
        return ItemUsage.consumeHeldItem(world, user, hand);
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {

        PlayerEntity player = (PlayerEntity) user;
        ItemStack endMirrorItem = user.getStackInHand(player.getActiveHand());
        NbtCompound nbtData = endMirrorItem.getNbt();
        if(remainingUseTicks == 40)
        {
            world.playSound(null, user.getBlockPos(), ModSounds.NETHER_TELEPORT_CHARGING, SoundCategory.BLOCKS);
            charging = true;
            nbtData.putBoolean("charging", true);
        }
        if(!world.isClient())
        {
            if(charging) {
                if(user.getX()!=teleportLocX || user.getY()!=teleportLocY || user.getZ() != teleportLocZ)
                {
                    //if the player has moved, stop process.
                    ((PlayerEntity)(user)).sendMessage(Text.literal("Stand still until you teleport"), true);
                    user.stopUsingItem();
                    charging = false;
                    nbtData.putBoolean("charging", false);
                    if(blockLocX != 0)
                        nbtData.putBoolean("hasCoord", true);
                    player.getItemCooldownManager().set(this,20);
                    return;
                }
                if(remainingUseTicks <= 0)
                {
                    user.stopUsingItem();
                    //manually call finish using since it doesn't seem to be called. Need to figure out how that works with custom items.
                    this.finishUsing(stack,world,user);
                }
            }
            endMirrorItem.setNbt(nbtData);
            endMirrorItem.writeNbt(nbtData);
        }
        if(remainingUseTicks % 2 == 0)
        {
            world.addParticle(ModParticles.END_TELEPORT_PARTICLE, user.getX() + 0.5d, user.getY() + 1.25d, user.getZ(),0, 0.85,0);
            world.addParticle(ModParticles.END_TELEPORT_PARTICLE, user.getX(), user.getY() + 1.25d, user.getZ()+0.5d,0, 0.85,0);
            world.addParticle(ModParticles.END_TELEPORT_PARTICLE, user.getX() - 0.5d, user.getY() + 1.25d, user.getZ(),0, 0.85,0);
            world.addParticle(ModParticles.END_TELEPORT_PARTICLE, user.getX(), user.getY() + 1.25d, user.getZ()-0.5d,0, 0.85,0);
        }
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if(!world.isClient())
        {
            //PlayerEntity player = (PlayerEntity) user;
            //ItemStack endMirrorItem = user.getStackInHand(player.getActiveHand());
            NbtCompound nbtData = stack.getNbt();

            //make sure the player is not in the Nether or Overworld
            if(!world.isClient && user.isPlayer()) {
                if (!world.getDimensionKey().getValue().equals(DimensionTypes.THE_END_ID))
                {
                    //alert the player and stop the process
                    ((PlayerEntity) user).sendMessage(Text.translatable("This mirror only works in the End!"), true);
                    user.stopUsingItem();
                    return stack;
                }

                //teleport player to set point.
                //    user.teleport(blockLocX, blockLocY+1, blockLocZ);
                //    ((PlayerEntity) user).sendMessage(Text.translatable("You have returned."), true);
                //    user.getStackInHand(user.getActiveHand()).damage(2, user, (p) -> p.sendToolBreakStatus(p.getActiveHand()));

                if(stack.hasNbt())
                {
                    NbtCompound getNbt = stack.getNbt();
                    user.teleport(getNbt.getDouble("X"), getNbt.getDouble("Y")+1, getNbt.getDouble("Z"));
                    ((PlayerEntity) user).sendMessage(Text.translatable("You have returned."), true);
                    user.getStackInHand(user.getActiveHand()).damage(2, user, (p) -> p.sendToolBreakStatus(p.getActiveHand()));

                    //clear nbt
                    nbtData.putDouble("X", 0);
                    nbtData.putDouble("Y", 0);
                    nbtData.putDouble("Z", 0);
                    nbtData.putBoolean("charging", false);
                    nbtData.putBoolean("hasCoord", false);
                    nbtData.putBoolean("hasTeleported", true);
                    stack.setNbt(getNbt);
                    stack.writeNbt(getNbt);
                }
                    //confirm teleport and clear data
                    //bHasTeleported = true;
                    //blockLocX = 0;
                    //blockLocY = 0;
                    //blockLocZ = 0;
            }
            //reset charging and set a cooldown time. This keeps player from teleporting too quickly
            charging = false;
            ((PlayerEntity)(user)).getItemCooldownManager().set(this, 100);
        }
        //reset used on block and return
        //usedOnBlock=false;
        return stack;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks)
    {
            NbtCompound nbtData = stack.getNbt();
            if(bHasTeleported && user.isPlayer())
            {
                bHasTeleported=false;
            }
            ((PlayerEntity)(user)).getItemCooldownManager().set(this, 100);
            charging = false;
            nbtData.putBoolean("charging", false);

            if(blockLocX != 0)
                usedOnBlock=true;
            stack.setNbt(nbtData);
            stack.writeNbt(nbtData);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown())
        {
            tooltip.add(Text.literal("Right click and hold to teleport"));
        }
        else
        {
            tooltip.add(Text.literal("Right click on block to set {SHIFT for more}"));
        }
        super.appendTooltip(stack, world, tooltip,context);
    }

    public float setItemTexture(ItemStack stack)
    {
        if(!stack.hasNbt())
            return 0.0f;
        if(stack.getNbt().getBoolean("charging"))
        {
            return 0.5f;
        }
        if(stack.getNbt().getBoolean("hasCoord"))
            return 1.0f;
        else
            return 0.0f;
    }
}
