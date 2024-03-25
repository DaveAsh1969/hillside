package net.hillsidemod.hillside.entity.goal;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.Hand;

import java.util.EnumSet;

public class hsAttackGoal extends Goal
{
    protected final PathAwareEntity mob;
    private final double speed;
    private Path path;
    private double targetX;
    private double targetY;
    private double targetZ;
    private int cooldown;
    private final int attackIntervalTicks = 20;
    public hsAttackGoal(PathAwareEntity mob, double speed)
    {
        this.mob = mob;
        this.speed = speed;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }
    @Override
    public boolean canStart() {
        //get the target
        LivingEntity livingEntity = this.mob.getTarget();

        //if no target can't start.
        if (livingEntity == null || !livingEntity.isAlive()) {
            return false;
        }

        this.path = mob.getNavigation().findPathTo(livingEntity, 50);

        return false;
    }

    @Override
    public boolean shouldContinue() {
        return super.shouldContinue();
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public boolean shouldRunEveryTick() {
        return super.shouldRunEveryTick();
    }

    @Override
    public void tick() {
        super.tick();
    }

    protected double getSquaredMaxAttackDistance(LivingEntity entity) {
        return this.mob.getWidth() * 2.0f * (this.mob.getWidth() * 2.0f) + entity.getWidth();
    }
    /**
    //the entity controlled
    protected final PathAwareEntity mob;

    //entity speed
    private final double speed;

    //check for idle entity, where does this change?
    private final boolean pauseWhenMobIdle;

    //path to the target
    private Path path;
    private double targetX;
    private double targetY;
    private double targetZ;

    //TODO: not sure if the countdown is for how long the goal lasts
    private int updateCountdownTicks;

    //TODO: does anything else determine the cooldown ticks.
    private int cooldown;
    //TODO: Does this determine an actual attack
    private final int attackIntervalTicks = 20;
    //TODO: ?
    private long lastUpdateTime;

    //Constructor, sets, mob, speed, pause...
    //TODO:What function does the enum do?
    public hsAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle)
    {
        this.mob = mob;
        this.speed = speed;
        this.pauseWhenMobIdle = pauseWhenMobIdle;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        //get the world time
        long l = this.mob.getWorld().getTime();

        //if it's been less than a second, don't start.
        if (l - this.lastUpdateTime < 20L) {
            return false;
        }

        //reset the last update time if greater than 20 clicks (1 second)
        this.lastUpdateTime = l;

        //get the target
        LivingEntity livingEntity = this.mob.getTarget();

        //if no target can't start.
        if (livingEntity == null) {
            return false;
        }
        //if the entity is dead can't start
        if (!livingEntity.isAlive()) {
            return false;
        }

        //build the path (not sure if this is causing the pathing hesitation)
        this.path = this.mob.getNavigation().findPathTo(livingEntity, 0);

        //the path could return null. If there's a path, then return true.
        if (this.path != null) {
            return true;
        }

        //
        return this.getSquaredMaxAttackDistance(livingEntity) >= this.mob.squaredDistanceTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
    }

    @Override
    public boolean shouldContinue() {
        //living entity is the current target
        LivingEntity livingEntity = this.mob.getTarget();

        //don't continue if no target
        if (livingEntity == null) {
            return false;
        }

        //don't continue if target is dead
        if (!livingEntity.isAlive()) {
            return false;
        }

        //if there is no target and no pause for an idle entity, then return false if pauseWhenMobIdle is false
        if (!this.pauseWhenMobIdle) {
            return !this.mob.getNavigation().isIdle();
        }
        //if the target is out of range, don't continue.
        if (!this.mob.isInWalkTargetRange(livingEntity.getBlockPos())) {
            return false;
        }
        //if not a player or not a player in spectator or not creative, don't continue
        return !(livingEntity instanceof PlayerEntity) || !livingEntity.isSpectator() && !((PlayerEntity)livingEntity).isCreative();
    }

    @Override
    public void start() {
        //start navigation, attacking, reset countdown ticks and cooldown.
        this.mob.getNavigation().startMovingAlong(this.path, this.speed);
        this.mob.setAttacking(true);
        this.updateCountdownTicks = 0;
        this.cooldown = 0;
    }

    @Override
    public void stop() {
        //get the target.
        LivingEntity livingEntity = this.mob.getTarget();
        //if the target is not a player in creative or spectator mode, no target.
        if (!EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(livingEntity)) {
            this.mob.setTarget(null);
        }
        //don't attack and stop navigation.
        this.mob.setAttacking(false);
        this.mob.getNavigation().stop();
    }

    //runs every tick, not every other.
    @Override
    public boolean shouldRunEveryTick() {
        return true;
    }

    @Override
    public void tick() {
        //get target
        LivingEntity livingEntity = this.mob.getTarget();
        //return if no target
        if (livingEntity == null) {
            return;
        }
        //look at target
        this.mob.getLookControl().lookAt(livingEntity, 30.0f, 30.0f);

        //get the distance to the target.
        double d = this.mob.getSquaredDistanceToAttackPosOf(livingEntity);
        //return the greater of zero and the current value of updateCountdownTicks - 1.
        this.updateCountdownTicks = Math.max(this.updateCountdownTicks - 1, 0);

        //if the entity can pause or the entity can see the target AND countdownticks < 0
        //AND target's xyz=0 or distance >= 1 or random float < .05.
        if ((this.pauseWhenMobIdle || this.mob.getVisibilityCache().canSee(livingEntity))
                && this.updateCountdownTicks <= 0 && (this.targetX == 0.0
                && this.targetY == 0.0 && this.targetZ == 0.0
                || livingEntity.squaredDistanceTo(this.targetX, this.targetY, this.targetZ) >= 1.0
                || this.mob.getRandom().nextFloat() < 0.05f))
        {
            //set target xyz.
            this.targetX = livingEntity.getX();
            this.targetY = livingEntity.getY();
            this.targetZ = livingEntity.getZ();
            //reset the updateCountdownTicks
            this.updateCountdownTicks = 4 + this.mob.getRandom().nextInt(7);

            //distance to target check
            if (d > 1024.0) {
                //add to countdownTicks
                this.updateCountdownTicks += 10;
            }
            //if the distance is closer (256)
            else if (d > 256.0) {
                //add to countdown ticks
                this.updateCountdownTicks += 5;
            }
            //if the mob is not moving to the target
            if (!this.mob.getNavigation().startMovingTo(livingEntity, this.speed)) {
                //add more time
                this.updateCountdownTicks += 15;
            }
            //TODO: not sure what this does.
            this.updateCountdownTicks = this.getTickCount(this.updateCountdownTicks);
        }
        //gets the greater value of zero or cooldown-1
        this.cooldown = Math.max(this.cooldown - 1, 0);
        this.attack(livingEntity, d);
    }

    protected void attack(LivingEntity target, double squaredDistance) {
        //get the current distance from target
        double d = this.getSquaredMaxAttackDistance(target);
        //if the distance is in range and the cooldown is zero or less
        if (squaredDistance <= d && this.cooldown <= 0) {
            //reset the cooldown var
            this.resetCooldown();
            //do the attack
            this.mob.swingHand(Hand.MAIN_HAND);
            this.mob.tryAttack(target);
        }
    }

    protected void resetCooldown() {
        this.cooldown = this.getTickCount(20);
    }

    protected boolean isCooledDown() {
        return this.cooldown <= 0;
    }

    protected int getCooldown() {
        return this.cooldown;
    }

    protected int getMaxCooldown() {
        return this.getTickCount(20);
    }

    //double the mob width doubled + the target's width to get the max attack range.
    protected double getSquaredMaxAttackDistance(LivingEntity entity) {
        return this.mob.getWidth() * 2.0f * (this.mob.getWidth() * 2.0f) + entity.getWidth();
    }
     */
}

