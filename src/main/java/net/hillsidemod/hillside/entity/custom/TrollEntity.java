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
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
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
import java.util.Objects;
import java.util.function.Predicate;

public class TrollEntity extends HostileEntity implements GeoEntity {
    private static final Predicate<Entity> IS_NOT_TROLL = entity -> entity.isAlive() && !(entity instanceof TrollEntity);
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    private int slamTick;
    private int heartTick;
    private boolean roarCalled=false;

    private static final TrackedData<Boolean> IN_RANGE = DataTracker.registerData(TrollEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Integer> SLAM_TICK = DataTracker.registerData(TrollEntity.class, TrackedDataHandlerRegistry.INTEGER);
    public TrollEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        resetSlamTick();
        resetHeartTick();
    }

    public static DefaultAttributeContainer.Builder createTrollAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 80.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 20.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4f)
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, 1.5f)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 12.0f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20f);
    }

    /*@Override
    public void checkDespawn() {
        if (this.getWorld().getDifficulty() == Difficulty.PEACEFUL && this.isDisallowedInPeaceful()) {
            this.discard();
            return;
        }
        if(this.isAlive())
            this.despawnCounter = 0;
        else
            this.discard();
    }*/

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.75f, 1));
        this.goalSelector.add(3, new SwimGoal(this));
        //this.goalSelector.add(4, new LookAroundGoal(this));
        this.goalSelector.add(3, new RevengeGoal(this, TrollEntity.class));
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
        this.dataTracker.startTracking(SLAM_TICK, 100);
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
            else if(isAttacking() && this.dataTracker.get(SLAM_TICK) > 9)
                    dataTracker.set(SLAM_TICK, setSlamTick(slamTick--));

            else if(isAttacking() && this.dataTracker.get(SLAM_TICK) < 10)
            {
                this.roar();
                resetSlamTick();
            }


            //every 30ish seconds not attacking, it gains 2 health.
            if(heartTick <= 0)
            {
                if(this.getHealth() < this.getMaxHealth())
                {
                    this.setHealth(this.getHealth() + 2.0f);
                    resetHeartTick();
                }
            }
        }
    }

    private int setSlamTick(int slamticker)
    {
        this.dataTracker.set(SLAM_TICK, slamticker);
        return slamticker;
    }

    private void resetSlamTick()
    {
        slamTick = 80 + Random.create().nextBetween(1,100);
        this.dataTracker.set(SLAM_TICK, slamTick);
    }
    public boolean getTargetInRange()
    {
        return this.dataTracker.get(IN_RANGE);
    }

    private void resetHeartTick()
    {
        heartTick = 200 + Random.create().nextBetween(1,100);
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
        return ModSounds.TROLL_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.TROLL_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.TROLL_HURT;
    }

    private void roar() {
        if (this.isAlive()) {
            int particles = 0;
            List<Entity> list = this.getWorld().getEntitiesByClass(Entity.class, this.getBoundingBox().expand(12.0), IS_NOT_TROLL);
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
            roarCalled=true;
        }
    }

    private void knockBack(Entity entity) {
        double d = entity.getX() - this.getX();
        double e = entity.getZ() - this.getZ();
        double f = Math.max(d * d + e * e, 0.001);
        entity.addVelocity(d / f * 2.5, 1.4, e / f * 2.5);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "troll_controller", 3, this::characterPredicate));
    }

    private <T extends GeoAnimatable>PlayState characterPredicate(AnimationState<T> tAnimationState)
    {
        tAnimationState.getController().setAnimationSpeed(0.6D);

        //-------------------------------------------------------------------------------------------------------------------------
        //-----animations that interrupt playing animations or finish before interruption, this routine assumes no animation loops.
        //-------------------------------------------------------------------------------------------------------------------------

        //if attack or pound animations are playing, continue until finished.
        if(tAnimationState.isCurrentAnimation(ModEntityAnimations.TROLL_ATTACK) &&
                !tAnimationState.getController().getAnimationState().equals(AnimationController.State.STOPPED))
            return PlayState.CONTINUE;

        else if(tAnimationState.isCurrentAnimation(ModEntityAnimations.TROLL_POUND) &&
                !tAnimationState.getController().getAnimationState().equals(AnimationController.State.STOPPED))
            return PlayState.CONTINUE;

        //if this is attacking and the state is not stopped and the attack animation isn't playing, immediately stop the state so the main code can take effect
        //if(getTargetInRange() &&
        if(this.isAttacking() &&
                tAnimationState.getController().getAnimationState() != AnimationController.State.STOPPED &&
                !tAnimationState.isCurrentAnimation(ModEntityAnimations.TROLL_ATTACK))
        {
            tAnimationState.getController().forceAnimationReset();
            return PlayState.STOP;
        }

        //if the player is in the middle of an idle animation and is not attacking, but starts moving, stop the state so the main code below can take effect.
        //if(!getTargetInRange() &&
        if(!this.isAttacking() &&
                !tAnimationState.isCurrentAnimation(ModEntityAnimations.TROLL_WALK) &&
                tAnimationState.isMoving() &&
                tAnimationState.getController().getAnimationState() != AnimationController.State.STOPPED)
        {
            tAnimationState.getController().forceAnimationReset();
            return PlayState.STOP;
        }

        //if the walking animation is playing but the troll is idle and not attacking, stop the animation
        //for the main code to take effect
        if(!tAnimationState.isMoving()
                && tAnimationState.isCurrentAnimation(ModEntityAnimations.TROLL_WALK)
                && !tAnimationState.isCurrentAnimation(ModEntityAnimations.TROLL_ATTACK)
                && tAnimationState.getController().getAnimationState() != AnimationController.State.STOPPED)
            return PlayState.STOP;

        //------------------------------
        //-----Main Animation Logic-----
        //------------------------------
        //if animations is complete or stopped, play new animation
        if (tAnimationState.getController().hasAnimationFinished() || tAnimationState.getController().getAnimationState() == AnimationController.State.STOPPED)
        {
            //reset the animation queue
            tAnimationState.getController().forceAnimationReset();

            //debug code
            //this.getWorld().getClosestPlayer(this.getX(), this.getY(), this.getZ(),
            //        100D, false).sendMessage(Text.literal(dataTracker.get(SLAM_TICK).toString()));

            if(dataTracker.get(SLAM_TICK) < 10)
            {
                //this.roar();
                tAnimationState.getController().setAnimation(ModEntityAnimations.TROLL_POUND);
                //dataTracker.set(SLAM_TICK, 100 + Random.create().nextBetween(1,100));
                return PlayState.CONTINUE;
            }

            //this defaults to attack if attacking.
            if(this.handSwinging || this.isAttacking()) //getTargetInRange() ||
            {
                tAnimationState.getController().setAnimation(ModEntityAnimations.TROLL_ATTACK);
                slamTick--;
            }

            else if(tAnimationState.isMoving()) // || this.isAttacking())
                tAnimationState.getController().setAnimation(ModEntityAnimations.TROLL_WALK);

            //if nothing is happening, the entity is idle
            else
            {
                tAnimationState.getController().setAnimation(getIdleAnimation());

                //if animation is yawn, play growl sound
                if(tAnimationState.getController().getCurrentAnimation() != null)
                    if (tAnimationState.getController().getCurrentRawAnimation() == ModEntityAnimations.TROLL_YAWN)
                        this.getWorld().playSound(this.getX(), this.getY(), this.getZ(), ModSounds.TROLL_SAY, SoundCategory.HOSTILE, 0.7f, 1f, true);
            }
        }
        return PlayState.CONTINUE;
    }

    private RawAnimation getIdleAnimation()
    {
        //random number determines idle animation. Breathe almost all the time, but varies.
        int randomIdlePlayNumber = Random.create().nextBetween(0, 1000);
        if (randomIdlePlayNumber > 200 && randomIdlePlayNumber < 225)
            return ModEntityAnimations.TROLL_CLUBTOSS;
        else if(randomIdlePlayNumber > 300 && randomIdlePlayNumber <325)
            return ModEntityAnimations.TROLL_FOOTTAP;
        else if(randomIdlePlayNumber > 400 && randomIdlePlayNumber <425)
            return ModEntityAnimations.TROLL_NOD;
        else if(randomIdlePlayNumber > 500 && randomIdlePlayNumber <525)
            return ModEntityAnimations.TROLL_YAWN;
        else if(randomIdlePlayNumber > 600 && randomIdlePlayNumber <625)
            return ModEntityAnimations.TROLL_ARMTAP;
        else
            return ModEntityAnimations.TROLL_BREATHE;
    }
}
