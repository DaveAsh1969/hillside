package net.hillsidemod.hillside.mixin;

import net.hillsidemod.hillside.entity.custom.TrollEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SpiderEntity.class)
public abstract class SpiderAggro extends HostileEntity
{
    protected SpiderAggro(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "initGoals", at = @At("RETURN"))
    protected void initGoals(CallbackInfo ci)
    {
        this.targetSelector.add(2, new ActiveTargetGoal<TrollEntity>((MobEntity) this, TrollEntity.class, true));
    }
}
