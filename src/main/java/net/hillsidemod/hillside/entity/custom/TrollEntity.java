package net.hillsidemod.hillside.entity.custom;

import net.hillsidemod.hillside.animation.ModEntityAnimations;
import net.hillsidemod.hillside.entity.goal.hsAttackGoal;
import net.hillsidemod.hillside.sound.ModSounds;
import net.hillsidemod.hillside.util.TrollStatus;
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
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
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
import java.util.Objects;
import java.util.function.Predicate;

public class TrollEntity extends HostileEntity implements GeoEntity {
    private static final Predicate<Entity> IS_NOT_TROLL = entity -> entity.isAlive() && !(entity instanceof TrollEntity);
    private static final TrackedData<Integer> TROLL_STATUS = DataTracker.registerData(TrollEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final double MOVEMENT_DELTA = 0.65;
    private static final double ATTACK_RANGE = 9;
    private static final double SLAM_DELAY = 6;
    private static final int SLAM_TICK_BASE = 80;
    private static final int HEAL_DELAY = 200; //in ticks
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private BlockPos lastBlockPos;
    private int slamTick;
    private int slamDelay;
    private int heartTick;
    //private boolean roarCalled=false;
    private static final TrackedData<Boolean> IN_RANGE = DataTracker.registerData(TrollEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Integer> SLAM_TICK = DataTracker.registerData(TrollEntity.class, TrackedDataHandlerRegistry.INTEGER);
    public TrollEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        resetSlamTick();
        resetHeartTick();
        lastBlockPos = this.getBlockPos();
        slamDelay = 0;
    }

    public static DefaultAttributeContainer.Builder createTrollAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 80.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 20.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4f)
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, 1.5f)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 12.0f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 30f);
    }

    @Override
    protected void initGoals() {
        //this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.add(1, new hsAttackGoal(this, 1.0D));
        //this.goalSelector.add(2, new SwimGoal(this));
        //this.goalSelector.add(4, new LookAroundGoal(this));
        //this.goalSelector.add(3, new RevengeGoal(this, TrollEntity.class));
        //this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0));
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
        this.dataTracker.startTracking(TROLL_STATUS, TrollStatus.IDLE.getId());
    }

    @Override
    public void tick() {
        super.tick();
        if(!this.getWorld().isClient())
        {
            //check to see if this has a target
            if(this.getTarget() != null)
            {
                //check to see if this is in range to attack
                if(isTargetInAttackRange(getTarget().getBlockPos()))
                {
                    //check for slam
                    if(slamTick <= SLAM_DELAY || slamDelay > 0)
                    {
                        this.dataTracker.set(TROLL_STATUS, TrollStatus.SLAM.getId());
                        if(slamDelay <= SLAM_DELAY)
                        {
                            slamDelay++;
                        }
                        else if(slamDelay >= SLAM_DELAY)
                        {
                            this.roar();
                            resetSlamTick();
                            slamDelay=0;
                        }
                    }
                    else
                        //attack target
                        this.dataTracker.set(TROLL_STATUS, TrollStatus.IN_ATTACK_RANGE.getId());
                }
                else
                {
                    //attack target
                    this.dataTracker.set(TROLL_STATUS, TrollStatus.ATTACKING.getId());

                }
                //update slam
                slamTick--;
            }
            else
            {
                //check to see if this isn't moving. moving animation is set client side
                if(hasMovedHorizontally(lastBlockPos))
                    this.dataTracker.set(TROLL_STATUS, TrollStatus.MOVING.getId());
                else
                    this.dataTracker.set(TROLL_STATUS, TrollStatus.IDLE.getId());


                //troll slowly heals when peaceful if injured.
                if(heartTick <= 0)
                {
                    if(this.getHealth() < this.getMaxHealth())
                    {
                        this.setHealth(this.getHealth() + 2.0f);
                        resetHeartTick();
                    }
                }
                heartTick--;
            }
            lastBlockPos = this.getBlockPos();
        }
    }

    private int setSlamTick(int slamticker)
    {
        this.dataTracker.set(SLAM_TICK, slamticker);
        return slamticker;
    }

    private void resetSlamTick()
    {
        slamTick = SLAM_TICK_BASE + Random.create().nextBetween(1,100);
    }

    private void resetHeartTick()
    {
        heartTick = HEAL_DELAY + Random.create().nextBetween(1,100);
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
        controllers.add(new AnimationController<>(this, "troll_moving_controller", 3, this::characterGeckoPredicate));
        controllers.add(new AnimationController<>(this, "troll_status_controller", 3, this::characterMovingPredicate));
    }

    private <T extends GeoAnimatable>PlayState characterGeckoPredicate(AnimationState<T> tAnimationState)
    {
        if (tAnimationState.getController().hasAnimationFinished()
                || tAnimationState.getController().getAnimationState() == AnimationController.State.STOPPED)
        {
            tAnimationState.getController().forceAnimationReset();
            if(tAnimationState.isMoving()
                    && dataTracker.get(TROLL_STATUS)!=TrollStatus.IN_ATTACK_RANGE.getId()
                    && dataTracker.get(TROLL_STATUS)!=TrollStatus.ATTACKING.getId()
                    && dataTracker.get(TROLL_STATUS)!=TrollStatus.SLAM.getId())
            {
                tAnimationState.getController().setAnimation(ModEntityAnimations.TROLL_WALK);
            }
            else if(!tAnimationState.isMoving()
                    && dataTracker.get(TROLL_STATUS)!=TrollStatus.IN_ATTACK_RANGE.getId()
                    && dataTracker.get(TROLL_STATUS)!=TrollStatus.ATTACKING.getId()
                    && dataTracker.get(TROLL_STATUS)!=TrollStatus.SLAM.getId())
            {
                tAnimationState.getController().setAnimation(getIdleAnimation());
                if (tAnimationState.getController().getCurrentRawAnimation() == ModEntityAnimations.TROLL_YAWN)
                    this.getWorld().playSound(this.getX(), this.getY(), this.getZ(), ModSounds.TROLL_SAY, SoundCategory.HOSTILE, 0.7f, 1f, true);
            }
        }
        return PlayState.CONTINUE;
    }
    private <T extends GeoAnimatable>PlayState characterMovingPredicate(AnimationState<T> tAnimationState)
    {
        //INTERRUPTING PLAYSTATE CODE--------------------------------------------------------
        if(dataTracker.get(TROLL_STATUS) == TrollStatus.SLAM.getId()
                && tAnimationState.isCurrentAnimation(ModEntityAnimations.TROLL_ATTACK))
        {
            tAnimationState.getController().forceAnimationReset();
            tAnimationState.getController().setAnimation(ModEntityAnimations.TROLL_POUND);
            return PlayState.CONTINUE;
        }

        //MAIN ANIMATION SET CODE------------------------------------------------------------
        if (tAnimationState.getController().hasAnimationFinished()
                || tAnimationState.getController().getAnimationState() == AnimationController.State.STOPPED)
        {
            tAnimationState.getController().forceAnimationReset();

            if(dataTracker.get(TROLL_STATUS) == TrollStatus.ATTACKING.getId())
            {
                tAnimationState.getController().setAnimation(ModEntityAnimations.TROLL_WALK);
            }
            else if(dataTracker.get(TROLL_STATUS) == TrollStatus.IN_ATTACK_RANGE.getId())
            {
                tAnimationState.getController().setAnimation(ModEntityAnimations.TROLL_ATTACK);
            }
            else if(dataTracker.get(TROLL_STATUS) == TrollStatus.SLAM.getId())
            {
                tAnimationState.getController().setAnimation(ModEntityAnimations.TROLL_POUND);
            }
        }

        //Objects.requireNonNull(getWorld().getClosestPlayer(this, 100)).sendMessage(Text.literal(dataTracker.get(TROLL_STATUS).toString()));
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

    private boolean hasMovedHorizontally(BlockPos previousTickPos)
    {
        double xDelta = this.getX() - previousTickPos.getX();
        double zDelta = this.getZ() - previousTickPos.getZ();
        return Math.abs(xDelta) > MOVEMENT_DELTA || Math.abs(zDelta) > MOVEMENT_DELTA;
    }

    private boolean isTargetInAttackRange (BlockPos targetBlockPos)
    {
        double xDelta = this.getX() - targetBlockPos.getX();
        double yDelta = this.getY() - targetBlockPos.getY();
        double zDelta = this.getZ() - targetBlockPos.getZ();
        return Math.abs(xDelta) <= ATTACK_RANGE && Math.abs(yDelta) <= ATTACK_RANGE && Math.abs(zDelta) <= ATTACK_RANGE;
    }
}
