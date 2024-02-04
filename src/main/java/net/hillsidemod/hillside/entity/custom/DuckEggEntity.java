package net.hillsidemod.hillside.entity.custom;

import net.hillsidemod.hillside.entity.ModEntities;
import net.hillsidemod.hillside.item.ModItems;
import net.hillsidemod.hillside.particle.ModParticles;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class DuckEggEntity extends ThrownItemEntity {

    public DuckEggEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public DuckEggEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.DUCK_EGG, livingEntity, world);
    }

    @Override
    protected void onCollision(HitResult hitResult) {

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

            //this.getWorld().sendEntityStatus(this, (byte)3);
            this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
            this.discard();
        }
        this.getWorld().addParticle(ModParticles.DUCK_EGG_BREAK, true, hitResult.getPos().getX(),
                hitResult.getPos().getY(), hitResult.getPos().getZ(),
                0D, 0.2D, 0D);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.DUCK_EGG;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }
}
