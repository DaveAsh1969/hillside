package net.hillsidemod.screen;

import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<BrickOvenScreenHandler> BRICK_OVEN_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        BRICK_OVEN_SCREEN_HANDLER = new ScreenHandlerType<>(BrickOvenScreenHandler::new);
    }
}
