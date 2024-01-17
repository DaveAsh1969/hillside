package net.hillsidemod.hillside.item.custom;

import net.hillsidemod.hillside.sound.ModSounds;
import net.hillsidemod.hillside.util.HillsideUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.UnihexFont;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.SwordItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.awt.*;

/*
    TODO: Stop sound if user bails on teleport
    TODO: Stop sound if person moves
    TODO: Add particles for teleport load time
    TODO: Add tool tip
 */
public class MirrorItem extends Item {

    private boolean bHasTeleported = false;
    private double teleportLocX = 0;
    private double teleportLocY = 0;
    private double teleportLocZ = 0;

    private boolean charging = false;

    //public static final BooleanProperty CHARGING = BooleanProperty.of("charging");

    public MirrorItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 40;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        teleportLocX = user.getX();
        teleportLocY = user.getY();
        teleportLocZ = user.getZ();
        return ItemUsage.consumeHeldItem(world,user,hand);
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if(remainingUseTicks == 40)
        {
               world.playSound(null, user.getBlockPos(), ModSounds.TELEPORT_CHARGING, SoundCategory.BLOCKS);
               charging = true;
        }

        if(remainingUseTicks % 4 == 0)
        {

        }
        if(user.getX()!=teleportLocX && user.getY()!=teleportLocY && user.getZ() != teleportLocZ)
        {
            //stop sound
            //if(world.isClient())
            //    HillsideUtils.stopSound(ModSounds.TELEPORT_CHARGING,SoundCategory.BLOCKS);
            ((PlayerEntity)(user)).sendMessage(Text.literal("Stand still until you teleport"), true);
            user.stopUsingItem();
            return;
        }
        if(remainingUseTicks <= 0)
        {
            user.stopUsingItem();
            this.finishUsing(stack,world,user);
        }
    }
    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if(world.isClient()) {
            world.playSound(user, user.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0f, 1.0f);
        }

        if(!world.isClient && user.isPlayer()) {
            if (world.getDimensionKey().getValue().equals(DimensionTypes.THE_NETHER_ID) ||
                    world.getDimensionKey().getValue().equals(DimensionTypes.THE_END_ID))
            {
                ((PlayerEntity) user).sendMessage(Text.translatable("This mirror only works in the Overworld!"), true);
                return stack;
            }
            DimensionType d = user.getWorld().getDimension();
            ServerPlayerEntity spe = (ServerPlayerEntity) user;
            BlockPos playerWorldSpawn = user.getWorld().getSpawnPos();
            BlockPos currentPlayerSpawnpoint = spe.getSpawnPointPosition();

            if (currentPlayerSpawnpoint != null && d.bedWorks())
            {
                user.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
                user.teleport(currentPlayerSpawnpoint.getX(), currentPlayerSpawnpoint.getY(), currentPlayerSpawnpoint.getZ());
                ((PlayerEntity) user).sendMessage(Text.translatable("You have returned home."), true);
                user.getStackInHand(user.getActiveHand()).damage(2, user, (p) -> p.sendToolBreakStatus(p.getActiveHand()));
                bHasTeleported = true;

            }
            else if (d.bedWorks())
            {
                user.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
                user.teleport(playerWorldSpawn.getX(), playerWorldSpawn.getY(), playerWorldSpawn.getZ());
                user.getStackInHand(user.getActiveHand()).damage(2, user, (p) -> p.sendToolBreakStatus(p.getActiveHand()));
                ((PlayerEntity) user).sendMessage(Text.translatable("No spawn point. Returned to world spawn."), true);
                bHasTeleported = true;
            }
        }

        return stack;
    }
    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if(bHasTeleported && user.isPlayer())
        {
            ((PlayerEntity)(user)).getItemCooldownManager().set(this, 200);
            user.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
            bHasTeleported=false;
        }
        charging = false;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        if(this.charging)
            return true;
        else
            return false;
    }
}
