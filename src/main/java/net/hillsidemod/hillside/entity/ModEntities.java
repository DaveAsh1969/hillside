package net.hillsidemod.hillside.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.entity.custom.ChristmasTreeEntity;
import net.hillsidemod.hillside.entity.custom.DecayingZombieEntity;
import net.hillsidemod.hillside.entity.custom.ZombiePillagerEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<ChristmasTreeEntity> CHRISTMAS_TREE = Registry.register(Registries.ENTITY_TYPE,
                      new Identifier(Hillside.MOD_ID, "christmas_tree"),
                        FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ChristmasTreeEntity::new)
                                .dimensions(EntityDimensions.fixed(1f, 3f)).build());

    public static final EntityType<DecayingZombieEntity> DECAYING_ZOMBIE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Hillside.MOD_ID, "decaying_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, DecayingZombieEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 2f)).build());

    public static final EntityType<ZombiePillagerEntity> ZOMBIE_PILLAGER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Hillside.MOD_ID, "zombie_pillager"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ZombiePillagerEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 2f)).build());
    public static void registerModEntities() {
        Hillside.LOGGER.info("Registering Entities for " + Hillside.MOD_ID);
    }
}