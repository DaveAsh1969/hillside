package net.hillsidemod.hillside.entity.custom;

import net.hillsidemod.hillside.animation.ModEntityAnimations;
import net.hillsidemod.hillside.sound.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;

import java.util.List;
import java.util.function.Predicate;

public class TrollEntity extends HostileEntity implements GeoEntity {
    private static final Predicate<Entity> IS_NOT_TROLL = entity -> entity.isAlive() && !(entity instanceof TrollEntity);
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    private int slamTick;
    private int heartTick;

    private static final TrackedData<Boolean> IN_RANGE = DataTracker.registerData(TrollEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public TrollEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        resetSlamTick();
        resetHeartTick();
    }

    public static DefaultAttributeContainer.Builder createTrollAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 90.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 30.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4f)
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, 1.5f)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 12.0f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 40f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.75f, 1));
        this.goalSelector.add(3, new SwimGoal(this));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, SkeletonEntity.class, true));
        this.targetSelector.add(4, new ActiveTargetGoal<>(this, SpiderEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, PillagerEntity.class, true));
        this.targetSelector.add(5, new ActiveTargetGoal<>(this, ZombieEntity.class, true));
        this.targetSelector.add(6, new ActiveTargetGoal<>(this, VillagerEntity.class, true));
        this.targetSelector.add(7, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(IN_RANGE, false);
    }

    @Override
    public void tick() {
        super.tick();
        if(!this.getWorld().isClient())
        {
            //set datatracker IN_RANGE
            setTargetInRange(this.getTarget());

            //if not attacking troll heals
            if(!isAttacking())
                this.heartTick--;

            //every 30ish seconds not attacking, it gains 2 health.
            if(heartTick <= 0)
            {
                if(this.getHealth() != this.getMaxHealth())
                {
                    this.setHealth(this.getHealth() + 2.0f);
                    resetHeartTick();
                }
            }
        }
    }

    private void resetSlamTick()
    {
        slamTick = 100 + Random.create().nextBetween(1,100);
    }
    public boolean getTargetInRange()
    {
        return this.dataTracker.get(IN_RANGE);
    }

    private void resetHeartTick()
    {
        heartTick = 600 + Random.create().nextBetween(1,100);
    }
    public void setTargetInRange(LivingEntity potentialTarget) {
        if(potentialTarget!=null)
        {
            if(this.isInAttackRange(potentialTarget))
            {
                this.dataTracker.set(IN_RANGE, true);
            }
            else
                this.dataTracker.set(IN_RANGE, false);
        }
        else
            this.dataTracker.set(IN_RANGE, false);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
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

    private void roar() {
        if (this.isAlive()) {
            int particles = 0;
            List<Entity> list = this.getWorld().getEntitiesByClass(Entity.class, this.getBoundingBox().expand(8.0), IS_NOT_TROLL);
            if(list.size() > 0) {
                for (Entity livingEntity : list) {
                    livingEntity.damage(livingEntity.getDamageSources().mobAttack(this), 6.0f );
                    this.knockBack(livingEntity);
                }
                Vec3d vec3d = this.getBoundingBox().getCenter();
                boolean bl = false;
                while (particles < 40) {
                    double d = this.random.nextGaussian() * 0.2;
                    double e = this.random.nextGaussian() * 0.2;
                    double f = this.random.nextGaussian() * 0.2;
                    this.getWorld().addParticle(ParticleTypes.POOF, vec3d.x, vec3d.y, vec3d.z, d, e, f);
                    ++particles;
                }
                this.emitGameEvent(GameEvent.ENTITY_ROAR);
            }
        }
    }

    private void knockBack(Entity entity) {
        double d = entity.getX() - this.getX();
        double e = entity.getZ() - this.getZ();
        double f = Math.max(d * d + e * e, 0.001);
        entity.addVelocity(d / f * 4.0, 0.2, e / f * 4.0);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "troll_controller", 3, this::characterPredicate));
    }

    private <T extends GeoAnimatable>PlayState characterPredicate(AnimationState<T> tAnimationState)
    {
        //-------------------------------------------------------------------------------------------------------------------------
        //-----animations that interrupt playing animations, this routine assumes no animation loops. -----------------------------
        //-------------------------------------------------------------------------------------------------------------------------
        //if this is attacking and the state is stopped and the attack animation isn't playing, immediately stop the state so the main code can take effect
        if(this.handSwinging &&
                tAnimationState.getController().getAnimationState() != AnimationController.State.STOPPED &&
                !tAnimationState.isCurrentAnimation(ModEntityAnimations.TROLL_ATTACK))
        {
            tAnimationState.getController().forceAnimationReset();
            return PlayState.STOP;
        }

        //if the player is in the middle of an idle animation and is not attacking, but starts moving, stop the state so the main code below can take effect.
        if(!this.handSwinging &&
                !tAnimationState.isCurrentAnimation(ModEntityAnimations.TROLL_WALK) &&
                tAnimationState.isMoving() &&
                tAnimationState.getController().getAnimationState() != AnimationController.State.STOPPED)
        {
            tAnimationState.getController().forceAnimationReset();
            return PlayState.STOP;
        }

        //------------------------------
        //-----Main Animation Logic-----
        //------------------------------
        //if animations is complete, play new animation
        if (tAnimationState.getController().hasAnimationFinished() || tAnimationState.getController().getAnimationState() == AnimationController.State.STOPPED)
        {
            //reset the animation queue
            tAnimationState.getController().forceAnimationReset();

            //this defaults to attack if the entity is moving but has the ability to attack.
            if(tAnimationState.isMoving() && getTargetInRange())
            {
                tAnimationState.getController().setAnimation(ModEntityAnimations.TROLL_ATTACK);
            }
            //if the entity is in range of the target that is acquired
            else if(!tAnimationState.isMoving() && getTargetInRange())
            {
                tAnimationState.getController().setAnimation(ModEntityAnimations.TROLL_ATTACK);
            }
            //if it's just moving
            else if(tAnimationState.isMoving())
                tAnimationState.getController().setAnimation(ModEntityAnimations.TROLL_WALK);
                //if nothing else is happening, the entity is idle
            else
                tAnimationState.getController().setAnimation(getIdleAnimation());
        }
        return PlayState.CONTINUE;
    }

    private RawAnimation getIdleAnimation()
    {
        //random number determines idle animation. Breathe almost all the time, but varies.
        int randomIdlePlayNumber = Random.create().nextBetween(0, 1000);
        if (randomIdlePlayNumber > 200 && randomIdlePlayNumber < 210)
            return ModEntityAnimations.TROLL_CLUBTOSS;
        else if(randomIdlePlayNumber > 300 && randomIdlePlayNumber <310)
            return ModEntityAnimations.TROLL_FOOTTAP;
        else if(randomIdlePlayNumber > 400 && randomIdlePlayNumber <410)
            return ModEntityAnimations.TROLL_NOD;
        else if(randomIdlePlayNumber > 500 && randomIdlePlayNumber <510)
            return ModEntityAnimations.TROLL_YAWN;
        else if(randomIdlePlayNumber > 600 && randomIdlePlayNumber <610)
            return ModEntityAnimations.TROLL_ARMTAP;
        else
            return ModEntityAnimations.TROLL_BREATHE;
    }

}
