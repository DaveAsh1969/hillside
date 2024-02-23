package net.hillsidemod.hillside.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.s2c.play.StopSoundS2CPacket;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.random.Random;

public class HillsideUtils {
    @Environment(EnvType.CLIENT)
    public static void stopSound(SoundEvent sound, SoundCategory category) {
        MinecraftClient.getInstance().runTasks(() -> {
            MinecraftClient.getInstance().getNetworkHandler().onStopSound(new StopSoundS2CPacket(sound.getId(), category));
            return true;
        });
    }

    //replaces getRandom from main code. In entities, always set baby texture as last and baby texture will be excluded
    // in getting texture variations
    public static <T> T getRandom(T[] array, Random random) {
        //subtract 2 from the array length to exclude the baby skin and none
        return array[random.nextInt(array.length-2)];
    }
}
