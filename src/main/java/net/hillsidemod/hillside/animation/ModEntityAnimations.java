package net.hillsidemod.hillside.animation;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import software.bernie.geckolib.core.animation.RawAnimation;
@Environment(EnvType.CLIENT)
//animation list for all entities. Code is easier to read and less typing errors through this class.
public final class ModEntityAnimations {
    public static final RawAnimation DECAYING_ZOMBIE_ATTACK = RawAnimation.begin().thenPlay("animation.decaying_zombie.attack");
    public static final RawAnimation DECAYING_ZOMBIE_IDLE = RawAnimation.begin().thenPlay("animation.decaying_zombie.idle");
    public static final RawAnimation DECAYING_ZOMBIE_WALK = RawAnimation.begin().thenPlay("animation.decaying_zombie.walk");
    public static final RawAnimation ZOMBIE_PILLAGER_ATTACK = RawAnimation.begin().thenPlay("animation.zombie_pillager.attack");
    public static final RawAnimation ZOMBIE_PILLAGER_IDLE = RawAnimation.begin().thenPlay("animation.zombie_pillager.idle1");
    public static final RawAnimation ZOMBIE_PILLAGER_STRETCH = RawAnimation.begin().thenPlay("animation.zombie_pillager.stretch");
    public static final RawAnimation ZOMBIE_PILLAGER_STILL = RawAnimation.begin().thenPlay("animation.zombie_pillager.still");
    public static final RawAnimation ZOMBIE_PILLAGER_WALK = RawAnimation.begin().thenPlay("animation.zombie_pillager.walk");
    public static final RawAnimation TROLL_WALK = RawAnimation.begin().thenPlay("animation.troll.walk");
    public static final RawAnimation TROLL_NOD = RawAnimation.begin().thenPlay("animation.troll.nod");
    public static final RawAnimation TROLL_YAWN = RawAnimation.begin().thenPlay("animation.troll.yawn");
    public static final RawAnimation TROLL_FOOTTAP = RawAnimation.begin().thenPlay("animation.troll.foottap");
    public static final RawAnimation TROLL_ATTACK = RawAnimation.begin().thenPlay("animation.troll.attack");
    public static final RawAnimation TROLL_POUND = RawAnimation.begin().thenPlay("animation.troll.pound");
    public static final RawAnimation TROLL_ARMTAP = RawAnimation.begin().thenPlay("animation.troll.armtap");
    public static final RawAnimation TROLL_CLUBTOSS = RawAnimation.begin().thenPlay("animation.troll.nod");
    public static final RawAnimation TROLL_BREATHE = RawAnimation.begin().thenPlay("animation.troll.breathe");
}
