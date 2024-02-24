package net.hillsidemod.hillside.entity.custom;

import net.hillsidemod.hillside.entity.ModEntities;
import net.hillsidemod.hillside.item.ModItems;
import net.hillsidemod.hillside.particle.ModParticles;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.*;
import net.minecraft.world.World;

public class DuckEggEntity extends ThrownItemEntity {
    private Vec3d pos;
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
                    i = 3;
                }

                for(int j = 0; j < i; ++j) {
                    DuckEntity duckEntity = ModEntities.DUCK.create(this.getWorld());
                    duckEntity.setBreedingAge(-24000);
                    Vec3i collisionVector = new Vec3i(this.getBlockX(), this.getBlockY(), this.getBlockZ());
                    Vec3d colPos = Vec3d.ofCenter(collisionVector);
                    duckEntity.refreshPositionAndAngles(colPos.x, this.getY(), colPos.z, this.getYaw(), 0.0F);
                    //duckEntity.refreshPositionAndAngles(hitResult.getPos().x, hitResult.getPos().y, hitResult.getPos().z, this.getYaw(), 0.0f);
                    this.getWorld().spawnEntity(duckEntity);
                }
            }
            this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
            this.discard();
        }
    }

    @Override
    public void handleStatus(byte status) {
        if(status == EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES)
            this.getWorld().addParticle(ModParticles.DUCK_EGG_BREAK, this.getX(), this.getY(), this.getZ(),
                    0.0, 0.0, 0.0);
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
    public void refreshPositionAndAngles(double x, double y, double z, float yaw, float pitch) {
        this.setPosition(x, y, z);
        //this.refreshPosition();
    }

    protected void refreshPosition() {
        this.setPosition(this.pos.x, this.pos.y, this.pos.z);
    }
    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

}
