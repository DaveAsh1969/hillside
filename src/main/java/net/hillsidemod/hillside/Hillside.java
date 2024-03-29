package net.hillsidemod.hillside;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.hillsidemod.hillside.block.ModBlocks;
import net.hillsidemod.hillside.block.entity.ModBlockEntities;
import net.hillsidemod.hillside.entity.ModEntities;
import net.hillsidemod.hillside.entity.custom.*;
import net.hillsidemod.hillside.item.ModItemGroup;
import net.hillsidemod.hillside.item.ModItems;
import net.hillsidemod.hillside.particle.ModParticles;
import net.hillsidemod.hillside.recipe.ModRecipes;
import net.hillsidemod.hillside.sound.ModSounds;
import net.hillsidemod.hillside.util.ModLootTableModifiers;
import net.hillsidemod.hillside.screen.ModScreenHandlers;
import net.hillsidemod.hillside.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hillside implements ModInitializer {
    public static final String MOD_ID = "hillside";
    public static final Logger LOGGER = LoggerFactory.getLogger("hillside");

    @Override
    public void onInitialize() {
        ModItemGroup.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModBlockEntities.registerBlockEntities();
        ModScreenHandlers.registerAllScreenHandlers();
        ModRecipes.registerRecipes();
        ModLootTableModifiers.modifyLootTables();
        ModEntities.registerModEntities();
        ModSounds.registerSounds();
        ModParticles.registerParticles();
        ModWorldGeneration.generateModWorldGen();
        FabricDefaultAttributeRegistry.register(ModEntities.CHRISTMAS_TREE, ChristmasTreeEntity.createChristmasTreeAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.DECAYING_ZOMBIE, DecayingZombieEntity.createDecayingZombieAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.ZOMBIE_PILLAGER, ZombiePillagerEntity.createZombiePillagerAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.TROLL_ENTITY, TrollEntity.createTrollAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.DUCK, DuckEntity.createDuckAttributes());

    }
}