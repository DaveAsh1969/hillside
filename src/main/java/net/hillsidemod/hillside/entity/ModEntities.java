package net.hillsidemod.hillside.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.entity.custom.ChristmasTreeEntity;
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

    public static void registerModEntities() {
        Hillside.LOGGER.info("Registering Entities for " + Hillside.MOD_ID);
    }
}