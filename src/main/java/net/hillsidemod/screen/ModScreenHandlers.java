package net.hillsidemod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.hillsidemod.hillside.Hillside;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<BrickOvenScreenHandler20> BRICK_OVEN_SCREEN_HANDLER20 = Registry.register(Registries.SCREEN_HANDLER,
            new Identifier(Hillside.MOD_ID, "brick_oven_screen_handler20"), new ExtendedScreenHandlerType<>(BrickOvenScreenHandler20::new));


    public static void registerAllScreenHandlers() {

    }


}
