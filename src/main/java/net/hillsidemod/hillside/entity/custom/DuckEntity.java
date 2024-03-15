package net.hillsidemod.hillside.entity.custom;

import net.hillsidemod.hillside.animation.ModEntityAnimations;
import net.hillsidemod.hillside.entity.ModEntities;
import net.hillsidemod.hillside.entity.variant.DuckVariant;
import net.hillsidemod.hillside.item.ModItems;
import net.hillsidemod.hillside.sound.ModSounds;
import net.hillsidemod.hillside.util.DuckTravelStatus;
import net.hillsidemod.hillside.util.HillsideUtils;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.JukeboxBlockEntity;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;

//TODO: Handle flying duck (if it is falling)

public class DuckEntity extends AnimalEntity implements GeoEntity {
    private static final Ingredient BREEDING_INGREDIENT;
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(DuckEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> DUCK_TRAVEL_STATUS =
            DataTracker.registerData(DuckEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> DUCK_ID_ADULT_VARIANT =
            DataTracker.registerData(DuckEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Boolean> DUCK_DANCE =
            DataTracker.registerData(DuckEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public int eggLayTime;
    public boolean isDancing = false;
    private boolean isOnLand = true;
    private boolean isInWater = false;
    private boolean isInAir = false;

    public DuckEntity(EntityType<? extends AnimalEntity> entityType, World world)
    {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.WATER, 0.0f);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.4));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(3, new TemptGoal(this, 1.0, BREEDING_INGREDIENT, false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.1));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createDuckAttributes()
    {
        return AnimalEntity.createLivingAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 4D)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.5D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.29D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35D);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(DATA_ID_TYPE_VARIANT, 5);
        this.dataTracker.startTracking(DUCK_TRAVEL_STATUS, 0);
        this.dataTracker.startTracking(DUCK_ID_ADULT_VARIANT, 5);
        this.dataTracker.startTracking(DUCK_DANCE, false);
    }

    public void readCustomDataFromNbt(NbtCompound nbt)
    {
        super.readCustomDataFromNbt(nbt);
        this.eggLayTime = nbt.getInt("EggLayTime");
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, nbt.getInt("DataIDTypeVariant"));
        this.dataTracker.set(DUCK_TRAVEL_STATUS, nbt.getInt("DuckTravelStatus"));
        this.dataTracker.set(DUCK_ID_ADULT_VARIANT, nbt.getInt("DuckAdultVariantID"));
        this.dataTracker.set(DUCK_DANCE, nbt.getBoolean("Dancing"));
        this.setVariant(this.dataTracker.get(DATA_ID_TYPE_VARIANT));
    }

    public void writeCustomDataToNbt(NbtCompound nbt)
    {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("EggLayTime", this.eggLayTime);
        nbt.putInt("Variant", this.getVariant().getId());
        nbt.putInt("DuckTravelStatus", this.dataTracker.get(DUCK_TRAVEL_STATUS));
        nbt.putInt("DuckAdultVariantID", this.dataTracker.get(DUCK_ID_ADULT_VARIANT));
        nbt.putInt("DataIDTypeVariant", this.dataTracker.get(DATA_ID_TYPE_VARIANT));
        nbt.putBoolean("Dancing", this.dataTracker.get(DUCK_DANCE));
    }

    @Override
    public void tick()
    {
        super.tick();
        if (!getWorld().isClient())
        {
            //manage the three navigations for ducks.-----------------
            //if it's in water
            if (this.isTouchingWater()) {
                if (isInWater)
                {
                    this.dataTracker.set(DUCK_TRAVEL_STATUS, DuckTravelStatus.WATER.getId());
                }
                else if (isOnLand || isInAir)
                {
                    this.dataTracker.set(DUCK_TRAVEL_STATUS, DuckTravelStatus.GETTING_IN_WATER.getId());
                    this.getWorld().playSound(this, this.getBlockPos(),SoundEvents.ENTITY_GENERIC_SPLASH,
                            SoundCategory.HOSTILE, 1.0f, 1.0f);
                }
                isOnLand = false;
                isInAir = false;
                isInWater = true;
            }
            //manage if it's in the air
            else if (!this.isTouchingWater() && !this.isInLava() && !this.isOnGround())
            {
                this.dataTracker.set(DUCK_TRAVEL_STATUS, DuckTravelStatus.AIR.getId());

                isOnLand = false;
                isInAir = true;
                isInWater = false;

                Vec3d vec3d = this.getVelocity();
                if (vec3d.y < 0.0)
                {
                    this.setVelocity(vec3d.multiply(1.0, 0.6, 1.0));
                }
            }
            //manage if it's on the ground
            else if (this.isOnGround())
            {
                if (!isOnLand)
                {
                    this.dataTracker.set(DUCK_TRAVEL_STATUS, DuckTravelStatus.GETTING_ON_LAND.getId());

                }
                else
                {
                    this.dataTracker.set(DUCK_TRAVEL_STATUS, DuckTravelStatus.LAND.getId());
                }
                isOnLand = true;
                isInAir = false;
                isInWater = false;

                if(!this.isBaby())
                {
                    //set the egg lay time only on land (don't lay an egg in the air or water)
                    if (--eggLayTime <= 0)
                    {
                        this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0f, (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.0f);
                        this.dropItem(ModItems.DUCK_EGG);
                        this.emitGameEvent(GameEvent.ENTITY_PLACE);
                        this.eggLayTime = this.random.nextInt(6000) + 6000;
                    }
                }
            }

            if(this.canHearMusic())
            {
                isDancing = true;
            }
            else
            {
                isDancing = false;
            }
            this.dataTracker.set(DUCK_DANCE, isDancing);

        }
    }

   @Override
    public void travel(Vec3d movementInput)
   {
        if (this.canMoveVoluntarily() && this.isTouchingWater())
        {
          this.updateVelocity(this.getMovementSpeed(), movementInput);
          this.move(MovementType.SELF, this.getVelocity());
          this.setVelocity(this.getVelocity().multiply(0.7D));

          if (this.getTarget() == null)
          {
                this.setVelocity(this.getVelocity().add(0.0, -0.005, 0.0));
          }
        }
        else
        {
            super.travel(movementInput);
        }
   }

    @Override
    public boolean canWalkOnFluid(FluidState state) {
        return state.isOf(Fluids.WATER);
    }

    private RawAnimation isBobbingForFish()
    {
        int randomIdlePlayNumber = Random.create().nextBetween(0, 300);
        if(randomIdlePlayNumber < 11 && randomIdlePlayNumber > 5)
        {
            return ModEntityAnimations.DUCK_BOB;
        }
        else
            return ModEntityAnimations.DUCK_WATER_IDLE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this,"controller", 0, this::duckPredicate));
        controllers.add(new AnimationController<>(this,"duck_status", 0, this::duckStatusPredicate));
        controllers.add(new AnimationController<>(this,"duck_dance", 0, this::duckDancePredicate));
    }

    private <T extends GeoAnimatable> PlayState duckPredicate(AnimationState<T> tAnimationState)
    {
        //main animation code----
        if (tAnimationState.getController().hasAnimationFinished() || tAnimationState.getController().getAnimationState() == AnimationController.State.STOPPED)
        {
            //reset the animation queue
            tAnimationState.getController().forceAnimationReset();

            //play moving or still animation
            if(tAnimationState.isMoving())
            {
                if(this.isTouchingWater())
                    tAnimationState.getController().setAnimation(ModEntityAnimations.DUCK_WATER_SWIM);
                else
                    tAnimationState.getController().setAnimation(ModEntityAnimations.DUCK_WALK);
            }
            else //idle animation
            {
                if(this.isTouchingWater())
                {
                    tAnimationState.getController().setAnimation(isBobbingForFish());
                }
                else
                    tAnimationState.getController().setAnimation(ModEntityAnimations.DUCK_IDLE);
            }
        }
        return PlayState.CONTINUE;
    }

    public boolean canHearMusic() {
       int searchRadius = 10;
       World world = this.getWorld();
        BlockPos pos = this.getBlockPos();

        for (BlockPos curPos: BlockPos.iterateOutwards(pos, searchRadius, searchRadius, searchRadius)) {
            if (world.getBlockEntity(curPos) instanceof JukeboxBlockEntity) {
                JukeboxBlockEntity entity = (JukeboxBlockEntity) world.getBlockEntity(curPos);
                if(entity.isPlayingRecord())
                {
                    return true;
                }
            }
        }
        return false;
    }

    private <T extends GeoAnimatable> PlayState duckDancePredicate(AnimationState<T> tAnimationState) {
        if (tAnimationState.getController().hasAnimationFinished() ||
                tAnimationState.getController().getAnimationState() == AnimationController.State.STOPPED)
        {
            if(this.dataTracker.get(DUCK_DANCE))
            {
                tAnimationState.getController().forceAnimationReset();
                tAnimationState.getController().setAnimation(ModEntityAnimations.DUCK_DANCE);
            }
        }
        return PlayState.CONTINUE;
    }

    private <T extends GeoAnimatable> PlayState duckStatusPredicate(AnimationState<T> tAnimationState)
    {
        if (tAnimationState.getController().hasAnimationFinished() ||
                tAnimationState.getController().getAnimationState() == AnimationController.State.STOPPED)
        {
            //reset the animation queue
            tAnimationState.getController().forceAnimationReset();

            if (dataTracker.get(DUCK_TRAVEL_STATUS) == DuckTravelStatus.GETTING_IN_WATER.getId())
            {
                tAnimationState.getController().setAnimation(ModEntityAnimations.DUCK_FLYING);
                this.getWorld().playSound(this, this.getBlockPos(),SoundEvents.ENTITY_DOLPHIN_SPLASH,
                        SoundCategory.HOSTILE, 1.0f, 1.0f);
            }
            else if (dataTracker.get(DUCK_TRAVEL_STATUS) == DuckTravelStatus.GETTING_ON_LAND.getId())
            {
                tAnimationState.getController().setAnimation(ModEntityAnimations.DUCK_FLAP);
            }
            else if (dataTracker.get(DUCK_TRAVEL_STATUS) == DuckTravelStatus.AIR.getId())
            {
                tAnimationState.getController().setAnimation(ModEntityAnimations.DUCK_FLYING);
            }
        }
        return PlayState.CONTINUE;
    }

    @Override
    protected SoundEvent getAmbientSound() {
       if(!this.isBaby())
       {
          int selector = Random.create().nextBetween(0, 3);
          switch (selector)
          {
              case 0: return ModSounds.DUCK_QUACK_ONE;
              case 1: return ModSounds.DUCK_QUACK;
              case 2: return ModSounds.DUCK_QUACK_TWO;
              case 3: return ModSounds.DUCK_QUACK_THREE;
          }
       }
       else
           return ModSounds.DUCK_BABY;
        return null;
    }

    @Override
    public float getSoundPitch() {
        if (this.isBaby()) {
            return (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.5f;
        }
        return (this.random.nextFloat() - this.random.nextFloat()) * 0.1f + 1.0f;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
       if(!this.isBaby())
            return ModSounds.DUCK_HURT;
       else
           return ModSounds.DUCK_BABY;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
       if(!this.isBaby())
            return ModSounds.DUCK_HURT;
       else
            return ModSounds.DUCK_BABY;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state)
    {
        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache()
    {
        return cache;
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity)
    {
        DuckEntity duck = ModEntities.DUCK.create(world);
        if(duck != null)
        {
            duck.setVariant(DuckVariant.BABY.getId());
            duck.dataTracker.set(DUCK_ID_ADULT_VARIANT, this.getVariant().getId());
        }

        return duck;
    }

    @Override
    protected void onGrowUp()
    {
        super.onGrowUp();
        //set skin to adult skin
        if(!this.isBaby() && this.dataTracker.get(DUCK_ID_ADULT_VARIANT) != 5)
        {
            setVariant(this.dataTracker.get(DUCK_ID_ADULT_VARIANT));
        }
        else if(!isBaby())
        {
            createVariant();
        }
        this.eggLayTime = this.random.nextInt(6000) + 6000;
    }

    static
    {
        BREEDING_INGREDIENT = Ingredient.ofItems(Items.WHEAT_SEEDS,
                                                    Items.MELON_SEEDS,
                                                    Items.PUMPKIN_SEEDS,
                                                    Items.BEETROOT_SEEDS,
                                                    Items.TORCHFLOWER_SEEDS,
                                                    ModItems.LETTUCE_SEEDS,
                                                    Items.PITCHER_POD);
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData,
                                 @Nullable NbtCompound entityNbt)
    {
        createVariant();
        this.eggLayTime = this.random.nextInt(6000) + 6000;
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    private void createVariant()
    {
        DuckVariant variant = HillsideUtils.getRandom(DuckVariant.values(), this.random);
        setVariant(variant.getId());
    }

    public DuckVariant getVariant()
    {
        int duckID = this.dataTracker.get(DATA_ID_TYPE_VARIANT);
        return DuckVariant.byId(duckID);
    }

    private void setVariant(int variantID)
    {
        if(variantID != 5)
            this.dataTracker.set(DATA_ID_TYPE_VARIANT, variantID);
        else
        {
            DuckVariant variant = HillsideUtils.getRandom(DuckVariant.values(), this.random);
            this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId());
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack)
    {
        return BREEDING_INGREDIENT.test(stack);
    }
}