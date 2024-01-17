package net.hillsidemod.hillside.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.hillsidemod.hillside.Hillside;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModParticles {
    public static final DefaultParticleType TELEPORT_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(Hillside.MOD_ID, "teleport_particle"), TELEPORT_PARTICLE);
    }
}
