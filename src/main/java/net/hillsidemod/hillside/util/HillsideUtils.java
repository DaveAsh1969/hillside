package net.hillsidemod.hillside.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.s2c.play.StopSoundS2CPacket;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;

public class HillsideUtils {
    @Environment(EnvType.CLIENT)
    public static void stopSound(SoundEvent sound, SoundCategory category) {
        MinecraftClient.getInstance().runTasks(() -> {
            MinecraftClient.getInstance().getNetworkHandler().onStopSound(new StopSoundS2CPacket(sound.getId(), category));
            return true;
        });
    }
}
