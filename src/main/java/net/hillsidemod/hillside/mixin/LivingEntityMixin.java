package net.hillsidemod.hillside.mixin;

import net.hillsidemod.hillside.item.ModItems;
import net.hillsidemod.hillside.item.custom.ModRubyBootsItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.hillsidemod.hillside.item.custom.ModRubyBootsItem;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity
{
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "canWalkOnFluid", at = @At("HEAD"), cancellable = true)
    private void canWalkOnFluid(FluidState state, CallbackInfoReturnable<Boolean> cir)
    {

        if(state.isOf(Fluids.LAVA) && state.isStill())
        {
            if(((LivingEntity)(Object)this).getEquippedStack(EquipmentSlot.FEET).isOf(ModItems.RUBY_BOOTS))
            {
                cir.setReturnValue(true);
            }
        }
    }
}
