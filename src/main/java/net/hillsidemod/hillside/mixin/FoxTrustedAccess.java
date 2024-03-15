package net.hillsidemod.hillside.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mixin(FoxEntity.class)
public interface FoxTrustedAccess {
    @Invoker("getTrustedUuids")
    List<UUID> getTrustedIds();

    @Invoker("addTrustedUuid")
    void AddUuids(@Nullable UUID uuid);


}