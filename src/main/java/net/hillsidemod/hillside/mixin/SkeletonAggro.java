package net.hillsidemod.hillside.mixin;

import net.hillsidemod.hillside.entity.custom.TrollEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractSkeletonEntity.class)
public abstract class SkeletonAggro extends HostileEntity
        implements RangedAttackMob {


    protected SkeletonAggro(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "initGoals", at = @At("RETURN"))
    protected void initGoals(CallbackInfo ci)
    {
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, TrollEntity.class, true));
    }
}