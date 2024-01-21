package net.hillsidemod.hillside.entity.custom;

import net.hillsidemod.hillside.sound.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class ZombiePillagerEntity extends ZombieEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    public ZombiePillagerEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createZombiePillagerAttributes()
    {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8.3D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.2f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.45f)
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, 0.5f)
                .add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(2, new ZombieAttackGoal(this, 1.1D, false));
        this.goalSelector.add(6, new MoveThroughVillageGoal(this, 1.0, true, 4, this::canBreakDoors));
        this.goalSelector.add(8, new WanderAroundGoal(this, 0.6));
        this.goalSelector.add(9, new LookAtEntityGoal(this, PlayerEntity.class, 15.0f, 1.0f));
        this.goalSelector.add(10, new LookAtEntityGoal(this, MobEntity.class, 15.0f));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, MerchantEntity.class, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, PillagerEntity.class, true));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.ZOMBIE_PILLAGER_IDLE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_ZOMBIE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ZOMBIE_DEATH;
    }

    public boolean canBreakDoors() { return true; }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this,"zp_controller", 0, this::clientLoop));
    }

    private <T extends GeoAnimatable> PlayState clientLoop(AnimationState<T> tAnimationState) {
        //if the zombie is attacking
        if(this.handSwinging)
        {
            return tAnimationState.setAndContinue(RawAnimation.begin().thenPlay("animation.zombie_pillager.attack"));
        }

        //if the attack is done, check to see if the entity is moving or idle then play animation.
        if(tAnimationState.getController().getAnimationState().equals(AnimationController.State.STOPPED))
        {
            if(tAnimationState.isMoving())
            {
                tAnimationState.getController().setAnimation(RawAnimation.begin().thenPlay("animation.zombie_pillager.walk"));
                return PlayState.CONTINUE;
            }
            else if(tAnimationState.getController().getAnimationState().equals(AnimationController.State.STOPPED))
            {
                int randomIdlePlayNumber = Random.create().nextBetween(0, 10000);
                if (randomIdlePlayNumber > 200 && randomIdlePlayNumber < 202)
                {
                    tAnimationState.getController().setAnimation(RawAnimation.begin().thenLoop("animation.zombie_pillager.idle1"));

                    return PlayState.CONTINUE;
                }
                else if (randomIdlePlayNumber > 400 && randomIdlePlayNumber < 402)
                {
                    tAnimationState.getController().setAnimation(RawAnimation.begin().thenPlay("animation.zombie_pillager.stretch"));
                    return PlayState.CONTINUE;
                }
                else
                {
                    tAnimationState.getController().setAnimation(RawAnimation.begin().thenPlay("animation.zombie_pillager.still"));
                    return PlayState.CONTINUE;
                }
            }
        }
       if(tAnimationState.isMoving() &&
                (!tAnimationState.isCurrentAnimation(RawAnimation.begin().then("animation.zombie_pillager.walk", Animation.LoopType.LOOP))))
        {
            tAnimationState.getController().forceAnimationReset();
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.zombie_pillager.walk", Animation.LoopType.LOOP));
        }

        //if the entity has quit moving and the walk animation is playing, stop it from playing
        if(!tAnimationState.isMoving() &&
                tAnimationState.isCurrentAnimation(RawAnimation.begin().then("animation.zombie_pillager.walk", Animation.LoopType.LOOP)))
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
