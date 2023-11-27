package net.hillsidemod.hillside;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.hillsidemod.hillside.block.ModBlocks;
import net.hillsidemod.screen.BrickOvenScreen;
import net.hillsidemod.screen.ModScreenHandlers;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class HillsideModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        HandledScreens.register(ModScreenHandlers.BRICK_OVEN_SCREEN_HANDLER, BrickOvenScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BOP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BOP_POTTED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.XANTHE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.XANTHE_POTTED, RenderLayer.getCutout());
    }
}
