package net.hillsidemod.hillside.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
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
        if(!world.isClient) {
            user.sendMessage(Text.literal("You hit it!"));
            DimensionType d = user.getWorld().getDimension();
            ServerPlayerEntity spe = (ServerPlayerEntity) user;
            BlockPos playerWorldSpawn = world.getSpawnPos();
            BlockPos currentPlayerSpawnpoint = spe.getSpawnPointPosition();

            if(currentPlayerSpawnpoint != null)
            {
                user.teleport(currentPlayerSpawnpoint.getX(), currentPlayerSpawnpoint.getY(), currentPlayerSpawnpoint.getZ());
            }
            else
                user.teleport(playerWorldSpawn.getX(), playerWorldSpawn.getY(), playerWorldSpawn.getZ());
            //BlockPos spawnPoint = user.
            //user.spawnPointPosition user.spawnPointDimension

           // if(spawnPoint != null)
           //     user.teleport(spawnPoint.getX(), spawnPoint.getY(), spawnPoint.getZ(), true);
        }
        return super.use(world, user, hand);
    }
}
