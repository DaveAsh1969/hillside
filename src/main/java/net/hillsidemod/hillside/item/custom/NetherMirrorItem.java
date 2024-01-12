package net.hillsidemod.hillside.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class NetherMirrorItem extends Item {
    private final NbtCompound nMNBT = new NbtCompound();
    private boolean usedOnBlock = false;
    public NetherMirrorItem(Settings settings) {
        super(settings);
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        nMNBT.putInt("nMx", context.getBlockPos().getX());
        nMNBT.putInt("nMy", context.getBlockPos().getY());
        nMNBT.putInt("nMz", context.getBlockPos().getZ());
        context.getPlayer().sendMessage(Text.literal("Block coordinate set"), true);

        usedOnBlock = true;
        if(context.getWorld().isClient())
        {
            context.getPlayer().playSound(SoundEvents.BLOCK_AMETHYST_CLUSTER_STEP, 1.0f, 1.0f);
        }
        return ActionResult.PASS;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        if(!world.isClient()) {
            if (nMNBT.contains("nMx") && !usedOnBlock)
                user.teleport(nMNBT.getInt("nMx"), nMNBT.getInt("nMy")+1, nMNBT.getInt("nMz"));

        }
        usedOnBlock=false;
        //return super.use(world, user, hand);
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        user.sendMessage(Text.literal("StoppedUsing Fired"));
        return stack;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 10;
    }

}
