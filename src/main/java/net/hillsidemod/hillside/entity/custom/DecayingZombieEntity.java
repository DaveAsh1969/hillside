package net.hillsidemod.hillside.entity.custom;

import net.hillsidemod.hillside.animation.ModEntityAnimations;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;

public class DecayingZombieEntity extends ZombieEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    public DecayingZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);

    }

    public static DefaultAttributeContainer.Builder createDecayingZombieAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8.3D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.2f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35f)
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, 0.5f)
                .add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(2, new ZombieAttackGoal(this, 1.1D, false));
        this.goalSelector.add(6, new MoveThroughVillageGoal(this, 1.0, true, 4, this::canBreakDoors));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0));
        this.targetSelector.add(1, new RevengeGoal(this, new Class[0]).setGroupRevenge(PillagerEntity.class));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, MerchantEntity.class, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, PillagerEntity.class, true));
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_DOLPHIN_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_DOLPHIN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ZOMBIE_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15f, 1.0f);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this,"controller", 0, this::characterPredicate));
    }
    private <T extends GeoAnimatable> PlayState characterPredicate(AnimationState<T> tAnimationState) {
        //INTERRUPT ANIMATIONS BASED ON STATE----
        //if this is attacking and the state isn't stopped and the attack animation isn't playing,
        //immediately stop the state so the main code can take effect
        if(this.handSwinging &&
                tAnimationState.getController().getAnimationState() != AnimationController.State.STOPPED &&
                !tAnimationState.isCurrentAnimation(ModEntityAnimations.DECAYING_ZOMBIE_ATTACK))
            return PlayState.STOP;

        //if the player is in the middle of an idle animation and is not attacking, but starts moving,
        // stop the state so the main code below can take effect.
        if(!this.handSwinging &&
                !tAnimationState.isCurrentAnimation(ModEntityAnimations.DECAYING_ZOMBIE_WALK) &&
                tAnimationState.isMoving() &&
                tAnimationState.getController().getAnimationState() != AnimationController.State.STOPPED)
            return PlayState.STOP;

        //if the walking animation is playing but the zombie is idle and not attacking, stop the animation
        //for the main code to take effect
        if(!tAnimationState.isMoving()
                && tAnimationState.isCurrentAnimation(ModEntityAnimations.DECAYING_ZOMBIE_WALK)
                && !tAnimationState.isCurrentAnimation(ModEntityAnimations.DECAYING_ZOMBIE_ATTACK)
                && tAnimationState.getController().getAnimationState() != AnimationController.State.STOPPED)
            return PlayState.STOP;

        //MAIN ANIMATION CODE----
        if (tAnimationState.getController().hasAnimationFinished() || tAnimationState.getController().getAnimationState() == AnimationController.State.STOPPED)
        {
            //reset the animation queue
            tAnimationState.getController().forceAnimationReset();

            //this defaults to attack animation if the entity is moving and attacking at the same time.
            if (tAnimationState.isMoving() && this.handSwinging)
            {
                tAnimationState.getController().setAnimation(ModEntityAnimations.DECAYING_ZOMBIE_ATTACK);
            }
            //entity will also play attack animation if not moving and attacking.
            else if (!tAnimationState.isMoving() && this.handSwinging)
            {
                tAnimationState.getController().setAnimation(ModEntityAnimations.DECAYING_ZOMBIE_ATTACK);
            }
            //if the entity is just moving, play walking animation
            else if (tAnimationState.isMoving())
                tAnimationState.getController().setAnimation(ModEntityAnimations.DECAYING_ZOMBIE_WALK);
            //otherwise, play idle animation
            else
                tAnimationState.getController().setAnimation(ModEntityAnimations.DECAYING_ZOMBIE_IDLE);
        }
            //start the selected animation
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
