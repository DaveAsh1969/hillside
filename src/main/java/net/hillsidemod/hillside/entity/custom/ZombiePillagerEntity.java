package net.hillsidemod.hillside.entity.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.hillsidemod.hillside.animation.ModEntityAnimations;
import net.hillsidemod.hillside.sound.ModSounds;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;

public class ZombiePillagerEntity extends ZombieEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private static final TrackedData<Boolean> HAS_TARGET = DataTracker.registerData(ZombiePillagerEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> IN_RANGE = DataTracker.registerData(ZombiePillagerEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

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
    public void tick() {
        super.tick();
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(2, new ZombieAttackGoal(this, 1.1D, false));
        this.goalSelector.add(6, new MoveThroughVillageGoal(this, 1.0, true, 4, this::canBreakDoors));
        this.goalSelector.add(8, new WanderAroundGoal(this, 0.6));
        //this.goalSelector.add(9, new LookAtEntityGoal(this, PlayerEntity.class, 15.0f, 1.0f));
        //this.goalSelector.add(10, new LookAtEntityGoal(this, MobEntity.class, 15.0f));

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
        controllers.add(new AnimationController<>(this,"controller", 3, this::characterPredicate));
        //controllers.add(new AnimationController<>(this,"attack_controller", 0, this::attackPredicate));
    }

    private <T extends GeoAnimatable> PlayState characterPredicate(AnimationState<T> tAnimationState) {
        //this will only work if entity isn't playing an animation.
        if(this.handSwinging &&
                tAnimationState.getController().getAnimationState() != AnimationController.State.STOPPED &&
                !tAnimationState.isCurrentAnimation(ModEntityAnimations.ZOMBIE_PILLAGER_ATTACK))
            return PlayState.STOP;

        if (tAnimationState.getController().hasAnimationFinished() || tAnimationState.getController().getAnimationState() == AnimationController.State.STOPPED)
       {
           tAnimationState.getController().forceAnimationReset();
           if(tAnimationState.isMoving() && this.handSwinging)
           {
               if(this.handSwinging)
                    tAnimationState.getController().setAnimation(ModEntityAnimations.ZOMBIE_PILLAGER_ATTACK);
               else
                   tAnimationState.getController().setAnimation(ModEntityAnimations.ZOMBIE_PILLAGER_WALK);
           }

           else if(!tAnimationState.isMoving() && this.handSwinging)
           {
               if(this.getTarget() != null)
                   MinecraftClient.getInstance().player.sendMessage(Text.literal("Target = " + this.getTarget().toString()));

               if(this.handSwinging)
                   tAnimationState.getController().setAnimation(ModEntityAnimations.ZOMBIE_PILLAGER_ATTACK);
               else
                   tAnimationState.getController().setAnimation(ModEntityAnimations.ZOMBIE_PILLAGER_WALK);
           }

           else if(tAnimationState.isMoving())
                tAnimationState.getController().setAnimation(ModEntityAnimations.ZOMBIE_PILLAGER_WALK);

           else
                tAnimationState.getController().setAnimation(getIdleAnimation());
           //MinecraftClient.getInstance().player.sendMessage(Text.literal("new animation"));
       }
        return PlayState.CONTINUE;
}

    @Environment(EnvType.CLIENT)
    private RawAnimation getIdleAnimation()
    {
        //random number determines idle animation.
        int randomIdlePlayNumber = Random.create().nextBetween(0, 1000);
        if (randomIdlePlayNumber > 200 && randomIdlePlayNumber < 314)
            return ModEntityAnimations.ZOMBIE_PILLAGER_STRETCH;
        else if(randomIdlePlayNumber > 400 && randomIdlePlayNumber <914)
            return ModEntityAnimations.ZOMBIE_PILLAGER_IDLE;
        else
            return ModEntityAnimations.ZOMBIE_PILLAGER_STILL;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
