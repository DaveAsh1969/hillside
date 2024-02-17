package net.hillsidemod.hillside.mixin;

import net.hillsidemod.hillside.entity.custom.DecayingZombieEntity;
import net.hillsidemod.hillside.entity.custom.ZombiePillagerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PillagerEntity.class)
public abstract class PillagerAggro extends HostileEntity implements RangedAttackMob {

    protected PillagerAggro(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "initGoals", at = @At("RETURN"))
    protected void initGoals(CallbackInfo ci)
    {
        this.targetSelector.add(2, new ActiveTargetGoal<DecayingZombieEntity>((MobEntity) this, DecayingZombieEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<ZombiePillagerEntity>((MobEntity) this, ZombiePillagerEntity.class, true));
    }
}
