package net.hillsidemod.hillside.block.entity;

import net.hillsidemod.hillside.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import static net.hillsidemod.hillside.block.custom.TacoBellBlock.GIVE_TACO;

public class TacoBellBlockEntity extends BlockEntity implements GeoBlockEntity {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);


    public Direction lastSideHit;
    public boolean ringing;
    public ringType ringDirection;

    public enum ringType {
        NORTH,
        SOUTH
    }

    public TacoBellBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TACO_BELL_ENTITY, pos, state);
        ringing=false;
        ringDirection = ringType.SOUTH;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController(this, "controller", 0, this::predicate));

    }

    private PlayState predicate(AnimationState animationState) {
        if(ringing)
        {
            if(ringDirection == ringType.NORTH)
                animationState.getController().setAnimation(RawAnimation.begin().then("animation.taco_bell.ring_north", Animation.LoopType.PLAY_ONCE));
            else if(ringDirection == ringType.SOUTH)
                animationState.getController().setAnimation(RawAnimation.begin().then("animation.taco_bell.ring_south", Animation.LoopType.PLAY_ONCE));

            if(animationState.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
                ringing=false;
            }
            return PlayState.CONTINUE;
        }

        animationState.getController().setAnimation(RawAnimation.begin().then("animation.taco_bell.idle", Animation.LoopType.LOOP));

        return PlayState.CONTINUE;
    }

    public void activate(Direction direction, PlayerEntity player, Direction facing) {
        BlockPos blockPos = this.getPos();
        double xDiff = this.getPos().getX() - player.getX();
        double zDiff = this.getPos().getZ() - player.getZ();
        this.lastSideHit = direction;
        int x = lastSideHit.getVector().getX();
        int z = lastSideHit.getVector().getZ();

        if(x != 0 && xDiff > 0 && facing.getName()=="east") {
            ringDirection = ringType.NORTH;
        }
        else if(x != 0 && xDiff > 0 && facing.getName()=="west") {
            ringDirection = ringType.SOUTH;
        }
        else if(x != 0 && xDiff < 0 && facing.getName()=="east") {
            ringDirection = ringType.SOUTH;
        }
        else if(x != 0 && xDiff < 0 && facing.getName()=="west") {
            ringDirection = ringType.NORTH;
        }
        else if(z != 0 && zDiff > 0 && facing.getName()=="north") {
            ringDirection = ringType.SOUTH;
        }
        else if(z != 0 && zDiff > 0 && facing.getName()=="south") {
            ringDirection = ringType.NORTH;
        }
        else if(z != 0 && zDiff < 0 && facing.getName()=="north") {
            ringDirection = ringType.NORTH;
        }
        else if(z != 0 && zDiff < 0 && facing.getName()=="south") {
            ringDirection = ringType.SOUTH;
        }

        this.ringing = true;
        if(!world.isClient())
        {
            if(world.getBlockState(blockPos).get(GIVE_TACO)) {

                player.giveItemStack(new ItemStack(ModItems.TACO));
                player.sendMessage(Text.literal("Enjoy your taco! Come back tomorrow!"), true);
                world.setBlockState(blockPos, world.getBlockState(blockPos).with(GIVE_TACO, false));
            }
        }
    }
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    public static void tick(World world, BlockPos pos, BlockState state, TacoBellBlockEntity entity) {
        if(!world.isClient())
        {
            if(world.getTimeOfDay() > 6000 & world.getTimeOfDay() < 6010 && !world.getBlockState(pos).get(GIVE_TACO))
            {
                world.setBlockState(pos, state.with(GIVE_TACO,true));
            }
        }
    }
}