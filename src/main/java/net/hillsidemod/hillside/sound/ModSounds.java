package net.hillsidemod.hillside.sound;

import net.hillsidemod.hillside.Hillside;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent TELEPORT_CHARGING = registerSoundEvent("teleport_charging");
    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Hillside.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        Hillside.LOGGER.info("Registering Sounds for " + Hillside.MOD_ID);
    }
}
