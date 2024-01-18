package net.hillsidemod.hillside.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class NetherMirrorItem extends Item {
    private final NbtCompound NetherMirrorNBT = new NbtCompound();
    private boolean usedOnBlock = false;

    public NetherMirrorItem(Settings settings) {
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
        NetherMirrorNBT.putInt("netherMirrorx", context.getBlockPos().getX());
        NetherMirrorNBT.putInt("netherMirrory", context.getBlockPos().getY());
        NetherMirrorNBT.putInt("netherMirrorz", context.getBlockPos().getZ());
        context.getPlayer().sendMessage(Text.literal("Block coordinate set"), true);

        usedOnBlock = true;
        if(context.getWorld().isClient())
        {
            context.getPlayer().playSound(SoundEvents.BLOCK_AMETHYST_CLUSTER_STEP, 1.0f, 1.0f);
        }
        usedOnBlock=true;
        return ActionResult.PASS;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        if(!world.isClient()) {
            if (NetherMirrorNBT.contains("netherMirrorx") && !usedOnBlock)
            {
                user.teleport(NetherMirrorNBT.getInt("netherMirrorx"), NetherMirrorNBT.getInt("netherMirrory")+1,
                        NetherMirrorNBT.getInt("netherMirrorz"));
            }
        }
        usedOnBlock=false;
        //ended here.
        return ItemUsage.consumeHeldItem(world, user, hand);
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if(world.isClient())
            user.sendMessage(Text.literal("usageTick Called"));
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if(!world.isClient()) {
            if (NetherMirrorNBT.contains("netherMirrorx") && !usedOnBlock && user.isPlayer())
                user.teleport(NetherMirrorNBT.getInt("netherMirrorx"), NetherMirrorNBT.getInt("netherMirrory")+1,
                        NetherMirrorNBT.getInt("netherMirrorz"));
        }
        usedOnBlock=false;
        return stack;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }


}
