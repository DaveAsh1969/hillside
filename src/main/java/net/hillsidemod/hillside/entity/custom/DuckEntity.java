package net.hillsidemod.hillside.entity.custom;

import net.hillsidemod.hillside.animation.ModEntityAnimations;
import net.hillsidemod.hillside.entity.ModEntities;
import net.hillsidemod.hillside.entity.variant.DuckVariant;
import net.hillsidemod.hillside.item.ModItems;
import net.hillsidemod.hillside.util.DuckTravelStatus;
import net.hillsidemod.hillside.util.HillsideUtils;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
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
import software.bernie.geckolib.core.object.PlayState;

import java.util.Arrays;
import java.util.Comparator;

//TODO: EggLayTime tick to lay duck egg
//Baby Duck with baby texture
//set to adult texture when adult
//Variant textures based on 4 adult texture types
//TODO: Handle flying duck (if it is falling)
//TODO: Add duck sounds
//Add duck egg entity
//TODO: When breeding, baby should take on variant of parent.
//Add variant to NBT

public class DuckEntity extends AnimalEntity implements GeoEntity {
    private static final Ingredient BREEDING_INGREDIENT;
    public int eggLayTime;
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(DuckEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> DUCK_TRAVEL_STATUS =
            DataTracker.registerData(DuckEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private boolean isOnLand = true;
    private boolean isInWater = false;
    private boolean isInAir = false;

    public DuckEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        this.eggLayTime = this.random.nextInt(6000) + 6000;
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
    public void setMovementSpeed(float movementSpeed) {
        if(this.isSwimming())
            super.setMovementSpeed(movementSpeed+12.0f);
        else
            super.setMovementSpeed(movementSpeed);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(DATA_ID_TYPE_VARIANT, 0);
        this.dataTracker.startTracking(DUCK_TRAVEL_STATUS, 0);
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.eggLayTime = nbt.getInt("EggLayTime");
        this.dataTracker.get(DATA_ID_TYPE_VARIANT);
        this.dataTracker.set(DUCK_TRAVEL_STATUS, nbt.getInt("DuckTravelStatus"));
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        if (nbt.contains("EggLayTime")) {
            nbt.putInt("EggLayTime", this.eggLayTime);
        }
        nbt.putInt("Variant", this.getTypeVariant());
        nbt.putInt("DuckTravelStatus", DUCK_TRAVEL_STATUS.getId());
    }

    @Override
    public void tickMovement() {
        super.tickMovement();

        if(!getWorld().isClient())
        {
            //set status for animation and change y velocity for flying ducks
            if(this.isSwimming())
            {
                if(isOnLand || isInAir) {
                    this.dataTracker.set(DUCK_TRAVEL_STATUS, DuckTravelStatus.GETTING_IN_WATER.getId());
                    //TODO:add splash sound
                } else
                {
                    this.dataTracker.set(DUCK_TRAVEL_STATUS, DuckTravelStatus.WATER.getId());
                    //TODO:add swim sound
                }
                isOnLand = false;
                isInAir = false;
                isInWater = true;
            }
            else if(!this.isOnGround() && !this.isSwimming())
            {
                this.dataTracker.set(DUCK_TRAVEL_STATUS, DuckTravelStatus.AIR.getId());
                //TODO:add flying sound
                isOnLand = false;
                isInAir = true;
                isInWater = false;

                Vec3d vec3d = this.getVelocity();
                if (vec3d.y < 0.0) {
                    this.setVelocity(vec3d.multiply(1.0, 0.6, 1.0));
                }
            }
            else
            {
                if(!isOnLand)
                {
                    this.dataTracker.set(DUCK_TRAVEL_STATUS, DuckTravelStatus.GETTING_ON_LAND.getId());
                    //TODO:add shake sound
                }
                else {
                    this.dataTracker.set(DUCK_TRAVEL_STATUS, DuckTravelStatus.LAND.getId());
                }
                isOnLand = true;
                isInAir = false;
                isInWater = false;
            }

            if(--eggLayTime <= 0)
            {
                this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0f, (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.0f);
                this.dropItem(ModItems.DUCK_EGG);
                this.emitGameEvent(GameEvent.ENTITY_PLACE);
                this.eggLayTime = this.random.nextInt(6000) + 6000;
            }
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this,"controller", 0, this::duckPredicate));
        controllers.add(new AnimationController<>(this,"duck_status", 0, this::duckStatusPredicate));
    }

    private <T extends GeoAnimatable> PlayState duckPredicate(AnimationState<T> tAnimationState)
    {
        //main animation code----
        if (tAnimationState.getController().hasAnimationFinished() || tAnimationState.getController().getAnimationState() == AnimationController.State.STOPPED)
        {
            //reset the animation queue
            tAnimationState.getController().forceAnimationReset();

            //play moving or still animation
            if(tAnimationState.isMoving() || this.isInWater)
            {
                tAnimationState.getController().setAnimation(ModEntityAnimations.DUCK_WALK);
            }
            else
            {
                tAnimationState.getController().setAnimation(ModEntityAnimations.DUCK_IDLE);
            }
        }
        return PlayState.CONTINUE;
    }

    private <T extends GeoAnimatable> PlayState duckStatusPredicate(AnimationState<T> tAnimationState)
    {
        if (tAnimationState.getController().hasAnimationFinished() ||
                tAnimationState.getController().getAnimationState() == AnimationController.State.STOPPED) {
            //reset the animation queue
            tAnimationState.getController().forceAnimationReset();

            if (dataTracker.get(DUCK_TRAVEL_STATUS) == DuckTravelStatus.GETTING_IN_WATER.getId())
            {
                tAnimationState.getController().setAnimation(ModEntityAnimations.DUCK_FLYING);
                dataTracker.set(DUCK_TRAVEL_STATUS, DuckTravelStatus.WATER.getId());
            }
            else if (dataTracker.get(DUCK_TRAVEL_STATUS) == DuckTravelStatus.GETTING_ON_LAND.getId())
            {
                tAnimationState.getController().setAnimation(ModEntityAnimations.DUCK_FLAP);
                dataTracker.set(DUCK_TRAVEL_STATUS, DuckTravelStatus.LAND.getId());
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
        return SoundEvents.ENTITY_CHICKEN_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_CHICKEN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CHICKEN_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity)
    {
        DuckEntity duck = ModEntities.DUCK.create(world);
        if(duck != null)
            duck.setVariant(DuckVariant.BABY);
        return duck;
    }

    @Override
    protected void onGrowUp() {
        super.onGrowUp();
        //set skin to adult skin
        if(!this.isBaby())
        {
            DuckVariant variant = HillsideUtils.getRandom(DuckVariant.values(), this.random);
            setVariant(variant);
        }
    }

    static {
        BREEDING_INGREDIENT = Ingredient.ofItems(Items.WHEAT_SEEDS,
                                                    Items.MELON_SEEDS,
                                                    Items.PUMPKIN_SEEDS,
                                                    Items.BEETROOT_SEEDS,
                                                    Items.TORCHFLOWER_SEEDS,
                                                    ModItems.LETTUCE_SEEDS,
                                                    Items.PITCHER_POD);
    }

    /*VARIANTS*/
    public DuckVariant getVariant()
    {
        return DuckVariant.byId(this.getTypeVariant() & 255);
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData,
                                 @Nullable NbtCompound entityNbt) {
        DuckVariant variant = HillsideUtils.getRandom(DuckVariant.values(), this.random);
        setVariant(variant);
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    private int getTypeVariant()
    {
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(DuckVariant variant)
    {
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return BREEDING_INGREDIENT.test(stack);
    }
}