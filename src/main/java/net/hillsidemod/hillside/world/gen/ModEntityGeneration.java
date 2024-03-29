package net.hillsidemod.hillside.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.hillsidemod.hillside.entity.ModEntities;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntityGeneration {
    public static void addSpawns()
    {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SAVANNA, BiomeKeys.FOREST, BiomeKeys.PLAINS, BiomeKeys.DESERT), SpawnGroup.MONSTER,
                ModEntities.DECAYING_ZOMBIE, 40, 2, 4);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FOREST), SpawnGroup.MONSTER,
                ModEntities.ZOMBIE_PILLAGER, 40, 2, 4);

        //BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DESERT), SpawnGroup.MONSTER,
        //        ModEntities.TROLL_ENTITY, 1, 1, 1);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.BEACH, BiomeKeys.SNOWY_BEACH, BiomeKeys.RIVER), SpawnGroup.CREATURE,
                ModEntities.DUCK, 60, 2, 4);

        SpawnRestriction.register(ModEntities.DECAYING_ZOMBIE, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);

        SpawnRestriction.register(ModEntities.ZOMBIE_PILLAGER, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);

        //SpawnRestriction.register(ModEntities.TROLL_ENTITY, SpawnRestriction.Location.ON_GROUND,
        //        Heightmap.Type.WORLD_SURFACE, HostileEntity::canSpawnIgnoreLightLevel);

        SpawnRestriction.register(ModEntities.DUCK, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.WORLD_SURFACE, AnimalEntity::canMobSpawn);
    }
}
