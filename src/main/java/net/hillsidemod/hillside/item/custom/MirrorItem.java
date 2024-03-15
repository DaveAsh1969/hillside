package net.hillsidemod.hillside.item.custom;

import net.hillsidemod.hillside.particle.ModParticles;
import net.hillsidemod.hillside.sound.ModSounds;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MirrorItem extends BowItem {

    //look at properties
    private boolean bHasTeleported = false;
    private double teleportLocX = 0;
    private double teleportLocY = 0;
    private double teleportLocZ = 0;
    private boolean charging = false;
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

    //get initial position of player and begin usage process
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient())
        {
            this.teleportLocX = user.getX();
            this.teleportLocY = user.getY();
            this.teleportLocZ = user.getZ();
        }

        return ItemUsage.consumeHeldItem(world,user,hand);
    }

    //if cooling down, exit, otherwise, play sound, particles, make sure player hasn't moved.
    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if(!world.isClient())
        {
            if(remainingUseTicks == 40)
            {
                world.playSound(null, user.getBlockPos(), ModSounds.TELEPORT_CHARGING, SoundCategory.BLOCKS);
                charging = true;
            }

            if(charging) {

                if(user.getX()!=this.teleportLocX || user.getY()!=this.teleportLocY || user.getZ() !=this.teleportLocZ)
                {
                    //if the player has moved, stop process.
                    ((PlayerEntity)(user)).sendMessage(Text.literal("Stand still until you teleport"), true);
                    user.stopUsingItem();
                    return;
                }
                if(remainingUseTicks <= 0)
                {
                    user.stopUsingItem();
                    //manually call finish using since it doesn't seem to be called. Need to figure out how that works with custom items.
                    this.finishUsing(stack,world,user);
                }
            }
        }
        if(remainingUseTicks % 2 == 0)
        {
            world.addParticle(ModParticles.TELEPORT_PARTICLE, user.getX(), user.getY() + 0.75d, user.getZ(),
                    MathHelper.cos(Random.create().nextBetween(0,100)) * 0.25d, 0.15,
                    MathHelper.sin(Random.create().nextBetween(0,100)) * 0.25d);
        }
        if(remainingUseTicks % 4 == 0)
        {
            world.addParticle(ModParticles.TELEPORT_PARTICLE_SMALL, user.getX() + Random.create().nextBetween(-1,1),
                    user.getY() + Random.create().nextBetween(0,2), user.getZ() + Random.create().nextBetween(-1,1),
                    0.01d,0.015d,0.02d);
        }
    }
    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if(!world.isClient())
        {
            //make sure the player is not in the Nether or End
            if(!world.isClient && user.isPlayer()) {
                if (!world.getDimensionKey().getValue().equals(DimensionTypes.OVERWORLD_ID) ||
                        world.getDimensionKey().getValue().equals(DimensionTypes.OVERWORLD_CAVES) ||
                                world.getDimensionKey().getValue().equals(DimensionTypes.OVERWORLD))
                {
                    ((PlayerEntity) user).sendMessage(Text.translatable("This mirror only works in the Overworld!"), true);
                    return stack;
                }

                //variables for teleport
                DimensionType d = user.getWorld().getDimension();
                ServerPlayerEntity spe = (ServerPlayerEntity) user;
                BlockPos playerWorldSpawn = user.getWorld().getSpawnPos();
                BlockPos currentPlayerSpawnpoint = spe.getSpawnPointPosition();

                //if the player has a spawn point and their bed works, teleport player to home.
                if (currentPlayerSpawnpoint != null && d.bedWorks())
                {
                    user.teleport(currentPlayerSpawnpoint.getX(), currentPlayerSpawnpoint.getY(), currentPlayerSpawnpoint.getZ());
                    ((PlayerEntity) user).sendMessage(Text.translatable("You have returned home."), true);
                    user.getStackInHand(user.getActiveHand()).damage(2, user, (p) -> p.sendToolBreakStatus(p.getActiveHand()));
                    bHasTeleported = true;

                }
                //if no spawnpoint, return to world spawn.
                else if (d.bedWorks())
                {
                    user.teleport(playerWorldSpawn.getX(), playerWorldSpawn.getY(), playerWorldSpawn.getZ());
                    user.getStackInHand(user.getActiveHand()).damage(2, user, (p) -> p.sendToolBreakStatus(p.getActiveHand()));
                    ((PlayerEntity) user).sendMessage(Text.translatable("No spawn point. Returned to world spawn."), true);
                    bHasTeleported = true;
                }
            }
            charging = false;
            ((PlayerEntity)(user)).getItemCooldownManager().set(this, 100);
        }
        return stack;
    }
    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if(!world.isClient())
        {
            if(bHasTeleported && user.isPlayer())
            {
                bHasTeleported=false;
            }
            ((PlayerEntity)(user)).getItemCooldownManager().set(this, 100);
            charging = false;
        }

    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown())
        {
            tooltip.add(Text.literal("Do not move while holding right click!"));
        }
        else
        {
            tooltip.add(Text.literal("Hold right click to teleport to your bed"));
        }
        super.appendTooltip(stack, world, tooltip,context);
    }
}
