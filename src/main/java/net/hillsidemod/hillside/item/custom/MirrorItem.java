package net.hillsidemod.hillside.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

import java.awt.*;

public class MirrorItem extends Item {
    public MirrorItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if(world.isClient()) {
            //world.playSound(user, user.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0f, 1.0f);
            world.playSound(user, user.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0f, 1.0f);
        }

        if(!world.isClient) {

            user.sendMessage(Text.literal("You have returned home"));
            DimensionType d = user.getWorld().getDimension();
            ServerPlayerEntity spe = (ServerPlayerEntity) user;
            BlockPos playerWorldSpawn = user.getWorld().getSpawnPos();
            BlockPos currentPlayerSpawnpoint = spe.getSpawnPointPosition();

            if(currentPlayerSpawnpoint != null && d.respawnAnchorWorks())
            {
                user.teleport(currentPlayerSpawnpoint.getX(), currentPlayerSpawnpoint.getY(), currentPlayerSpawnpoint.getZ());
            }
            else
                user.teleport(playerWorldSpawn.getX(), playerWorldSpawn.getY(), playerWorldSpawn.getZ());
        }

        return super.use(world, user, hand);
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        super.usageTick(world, user, stack, remainingUseTicks);
    }


}
