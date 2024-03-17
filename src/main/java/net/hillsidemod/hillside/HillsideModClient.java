package net.hillsidemod.hillside;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.hillsidemod.hillside.block.ModBlocks;
import net.hillsidemod.hillside.block.entity.ModBlockEntities;
import net.hillsidemod.hillside.block.entity.client.TacoBellRenderer;
import net.hillsidemod.hillside.block.entity.client.TrollHeadRenderer;
import net.hillsidemod.hillside.entity.ModEntities;
import net.hillsidemod.hillside.entity.client.*;
import net.hillsidemod.hillside.particle.ModParticles;
import net.hillsidemod.hillside.particle.custom.*;
import net.hillsidemod.hillside.screen.BrickOvenScreen;
import net.hillsidemod.hillside.screen.ModScreenHandlers;
import net.hillsidemod.hillside.util.ModModelPredicateProvider;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class HillsideModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        HandledScreens.register(ModScreenHandlers.BRICK_OVEN_SCREEN_HANDLER, BrickOvenScreen::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_LIGHT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BOP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BOP_POTTED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLASS_MOD, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLASS_MOD_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLASS_MOD_BLUE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLASS_MOD_BLUE_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLASS_MOD_GREEN, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLASS_MOD_GREEN_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLASS_MOD_LIGHT_BLUE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLASS_MOD_LIGHT_BLUE_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLASS_MOD_PURPLE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLASS_MOD_PURPLE_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLASS_MOD_WHITE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLASS_MOD_WHITE_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLASS_MOD_YELLOW, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLASS_MOD_YELLOW_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LAMP_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WINTER_WINDOW, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WINTER_WINDOW_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.XANTHE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.XANTHE_POTTED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LETTUCE_CROP, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.CHRISTMAS_TREE, ChristmasTreeRenderer::new);
        EntityRendererRegistry.register(ModEntities.DECAYING_ZOMBIE, DecayingZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.DUCK, DuckEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.DUCK_EGG, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.ZOMBIE_PILLAGER, ZombiePillagerRenderer::new);
        EntityRendererRegistry.register(ModEntities.TROLL_ENTITY, TrollRenderer::new);

        BlockEntityRendererFactories.register(ModBlockEntities.TACO_BELL_ENTITY, TacoBellRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.TROLL_HEAD_ENTITY, TrollHeadRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CHRISTMAS_TREE, ChristmasTreeModel::getTexturedModelData);
        ParticleFactoryRegistry.getInstance().register(ModParticles.TELEPORT_PARTICLE, TeleportParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.TELEPORT_PARTICLE_SMALL, TeleportParticleSmall.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.NETHER_TELEPORT_PARTICLE, NetherTeleportParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.END_TELEPORT_PARTICLE, EndTeleportParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.DUCK_EGG_BREAK, EggBreakingParticle.Factory::new);
        ModModelPredicateProvider.init();
    }
}
