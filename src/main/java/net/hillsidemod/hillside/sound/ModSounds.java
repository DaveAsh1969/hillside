package net.hillsidemod.hillside.sound;

import net.hillsidemod.hillside.Hillside;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent DUCK_BABY = registerSoundEvent("quack_baby");
    public static final SoundEvent DUCK_FLAP = registerSoundEvent("duck_flap");
    public static final SoundEvent DUCK_HURT = registerSoundEvent("quack_hurt");
    public static final SoundEvent DUCK_QUACK = registerSoundEvent("quack");
    public static final SoundEvent DUCK_QUACK_ONE = registerSoundEvent("quack_one");
    public static final SoundEvent DUCK_QUACK_THREE = registerSoundEvent("quack_three");
    public static final SoundEvent DUCK_QUACK_TWO = registerSoundEvent("quack_two");
    public static final SoundEvent DUNGEON_DOOR_CLOSE = registerSoundEvent("dungeon_door_close");
    public static final SoundEvent DUNGEON_DOOR_LOCKED = registerSoundEvent("dungeon_door_locked");
    public static final SoundEvent DUNGEON_DOOR_OPEN = registerSoundEvent("dungeon_door_open");
    public static final SoundEvent NETHER_TELEPORT_CHARGING = registerSoundEvent("nether_teleport_charging");
    public static final SoundEvent TACO_BELL = registerSoundEvent("taco_bell");
    public static final SoundEvent TELEPORT_CHARGING = registerSoundEvent("teleport_charging");
    public static final SoundEvent TROLL_HURT = registerSoundEvent("troll_hurt");
    public static final SoundEvent TROLL_SAY = registerSoundEvent("troll_say");
    public static final SoundEvent ZOMBIE_PILLAGER_IDLE = registerSoundEvent("zombie_pillager_idle");
    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Hillside.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        Hillside.LOGGER.info("Registering Sounds for " + Hillside.MOD_ID);
    }
}
