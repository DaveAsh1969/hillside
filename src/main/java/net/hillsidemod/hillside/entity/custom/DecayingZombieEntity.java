package net.hillsidemod.hillside.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.passive.WanderingTraderEntity;
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
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(4, new FleeEntityGoal(this, CatEntity.class, 6.0F, 1.0, 1.2));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, VillagerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.add(4, new ActiveTargetGoal<>(this, WanderingTraderEntity.class, true));
        this.targetSelector.add(5, new ActiveTargetGoal<>(this, AbstractSkeletonEntity.class, true));
        //this.targetSelector.add(3, new ActiveTargetGoal<>(this, TrollEntity.class, true));
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
        controllers.add(new AnimationController<>(this,"controller", 0, this::attackPredicate));
    }
    private <T extends GeoAnimatable> PlayState attackPredicate(AnimationState<T> tAnimationState) {
        //if the zombie is attacking
        if(this.handSwinging)
        {
            return tAnimationState.setAndContinue(RawAnimation.begin().thenPlay("animation.decaying_zombie.attack"));
        }

        //if the attack is done, check to see if the entity is moving or idle then play animation.
        if(tAnimationState.getController().getAnimationState().equals(AnimationController.State.STOPPED))
            return tAnimationState.setAndContinue(tAnimationState.isMoving() ? RawAnimation.begin()
                            .then("animation.decaying_zombie.walk", Animation.LoopType.LOOP) :
                    RawAnimation.begin().thenPlay("animation.decaying_zombie.idle"));

        //if the entity has quit moving and the walk animation is playing, stop it from playing
        if(!tAnimationState.isMoving() &&
                tAnimationState.isCurrentAnimation(RawAnimation.begin().then("animation.decaying_zombie.walk", Animation.LoopType.LOOP)))
        {
            tAnimationState.getController().forceAnimationReset();
            return PlayState.STOP;
        }

        //default return
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
