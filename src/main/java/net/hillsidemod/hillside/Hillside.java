package net.hillsidemod.hillside;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.hillsidemod.hillside.block.ModBlocks;
import net.hillsidemod.hillside.block.entity.ModBlockEntities;
import net.hillsidemod.hillside.entity.ModEntities;
import net.hillsidemod.hillside.entity.client.ChristmasTreeRenderer;
import net.hillsidemod.hillside.entity.custom.ChristmasTreeEntity;
import net.hillsidemod.hillside.entity.custom.DecayingZombieEntity;
import net.hillsidemod.hillside.entity.custom.ZombiePillagerEntity;
import net.hillsidemod.hillside.item.ModItemGroup;
import net.hillsidemod.hillside.item.ModItems;
import net.hillsidemod.hillside.particle.ModParticles;
import net.hillsidemod.hillside.recipe.ModRecipes;
import net.hillsidemod.hillside.sound.ModSounds;
import net.hillsidemod.hillside.util.ModLootTableModifiers;
import net.hillsidemod.screen.ModScreenHandlers;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.hillsidemod.hillside.particle.ModParticles.TELEPORT_PARTICLE;

public class Hillside implements ModInitializer {
    public static final String MOD_ID = "hillsidemod";
    public static final Logger LOGGER = LoggerFactory.getLogger("hillsidemod");

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
        FabricDefaultAttributeRegistry.register(ModEntities.CHRISTMAS_TREE, ChristmasTreeEntity.createChristmasTreeAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.DECAYING_ZOMBIE, DecayingZombieEntity.createDecayingZombieAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.ZOMBIE_PILLAGER, ZombiePillagerEntity.createZombiePillagerAttributes());

    }
}