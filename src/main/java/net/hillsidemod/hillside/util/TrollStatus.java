package net.hillsidemod.hillside.util;

import java.util.Arrays;
import java.util.Comparator;

public enum TrollStatus {
    MOVING(0),
    IDLE(1),
    ATTACKING(2),
    IN_ATTACK_RANGE(3),
    IN_WATER(4),
    IN_LAVA(5),
    FALLING(6),
    SLAM(7);

    private static final TrollStatus[] BY_ID =
            Arrays.stream(values()).sorted(Comparator.comparingInt(TrollStatus::getId)).toArray(TrollStatus[]::new);
    private final int id;

    TrollStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static TrollStatus byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
