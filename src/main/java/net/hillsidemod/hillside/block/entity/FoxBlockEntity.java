package net.hillsidemod.hillside.block.entity;

import net.hillsidemod.hillside.animation.ModEntityAnimations;
import net.hillsidemod.hillside.block.ModBlocks;
import net.hillsidemod.hillside.block.custom.FoxBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;

public class FoxBlockEntity extends BlockEntity implements GeoBlockEntity {

    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    public FoxBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FOX_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController(this, "controller", 0, this::predicate));

    }
    private PlayState predicate(AnimationState animationState)
    {
        animationState.getController().setAnimation(ModEntityAnimations.FOX_HEAD_SPIN);
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    public void tick(World world, BlockPos blockPos, BlockState state)
    {

    }
}
