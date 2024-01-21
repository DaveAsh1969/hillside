package net.hillsidemod.hillside.animation;

import software.bernie.geckolib.core.animation.RawAnimation;

public final class ModEntityAnimations {
    public static final RawAnimation DECAYING_ZOMBIE_ATTACK = RawAnimation.begin().thenPlay("animation.decaying_zombie.attack");
    public static final RawAnimation DECAYING_ZOMBIE_IDLE = RawAnimation.begin().thenPlay("animation.decaying_zombie.idle");
    public static final RawAnimation DECAYING_ZOMBIE_WALK = RawAnimation.begin().thenLoop("animation.decaying_zombie.walk");
    public static final RawAnimation ZOMBIE_PILLAGER_ATTACK = RawAnimation.begin().thenPlay("animation.zombie_pillager.attack");
    public static final RawAnimation ZOMBIE_PILLAGER_IDLE = RawAnimation.begin().thenPlay("animation.zombie_pillager.idle1");
    public static final RawAnimation ZOMBIE_PILLAGER_STRETCH = RawAnimation.begin().thenPlay("animation.zombie_pillager.stretch");
    public static final RawAnimation ZOMBIE_PILLAGER_STILL = RawAnimation.begin().thenPlay("animation.zombie_pillager.still");
    public static final RawAnimation ZOMBIE_PILLAGER_WALK = RawAnimation.begin().thenLoop("animation.zombie_pillager.walk");
}
