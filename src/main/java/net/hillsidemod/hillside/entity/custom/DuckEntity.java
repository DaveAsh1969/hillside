package net.hillsidemod.hillside.entity.custom;


import net.hillsidemod.hillside.entity.ModEntities;
import net.hillsidemod.hillside.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;

//TODO: EggLayTime tick to lay duck egg
//TODO: Baby Duck with baby texture, then set to adult texture when adult
//TODO: Variant textures based on 4 adult texture types
//TODO: Handle flying duck (if it is falling)
//TODO: Handle breeding (test)
//TODO: Animation controller
//TODO: Add variant to NBT

public class DuckEntity extends AnimalEntity implements GeoEntity {
    private static final Ingredient BREEDING_INGREDIENT;
    public int eggLayTime;
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

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
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.29D);
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("EggLayTime")) {
            this.eggLayTime = nbt.getInt("EggLayTime");
        }
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("EggLayTime", this.eggLayTime);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

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
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.DUCK.create(world);
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
}
