package net.hillsidemod.screen;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<BrickOvenScreenHandler> BRICK_OVEN_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
       BRICK_OVEN_SCREEN_HANDLER = new ScreenHandlerType<>(BrickOvenScreenHandler::new, FeatureSet.empty());

    }


}
