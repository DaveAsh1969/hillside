package net.hillsidemod.hillside;

import net.fabricmc.api.ClientModInitializer;
import net.hillsidemod.screen.BrickOvenScreen;
import net.hillsidemod.screen.ModScreenHandlers;
import net.hillsidemod.screen.slot.BrickOvenScreen20;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class HillsideModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.BRICK_OVEN_SCREEN_HANDLER, BrickOvenScreen::new);
        HandledScreens.register(ModScreenHandlers.BRICK_OVEN_SCREEN_HANDLER20, BrickOvenScreen20::new);
    }
}
