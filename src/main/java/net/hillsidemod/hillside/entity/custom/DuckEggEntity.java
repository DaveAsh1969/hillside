package net.hillsidemod.hillside.entity.custom;

import net.hillsidemod.hillside.entity.ModEntities;
import net.hillsidemod.hillside.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.EggEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class DuckEggEntity extends EggEntity {

    public DuckEggEntity(World world, LivingEntity owner) {
        super(world, owner);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        //super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            if (this.random.nextInt(8) == 0) {
                int i = 1;
                if (this.random.nextInt(32) == 0) {
                    i = 4;
                }

                for(int j = 0; j < i; ++j) {
                    DuckEntity duckEntity = ModEntities.DUCK.create(this.getWorld());
                    duckEntity.setBreedingAge(-24000);

                    duckEntity.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.getYaw(), 0.0F);
                    this.getWorld().spawnEntity(duckEntity);
                }
            }

            this.getWorld().sendEntityStatus(this, (byte)3);
            this.discard();
        }
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.DUCK_EGG;
    }
}
