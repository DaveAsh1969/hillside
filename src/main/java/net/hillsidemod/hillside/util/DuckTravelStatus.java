package net.hillsidemod.hillside.util;

import java.util.Arrays;
import java.util.Comparator;

public enum DuckTravelStatus {
    LAND(0),
    GETTING_IN_WATER(1),
    WATER(2),
    GETTING_ON_LAND(3),
    AIR(4);

    private static final DuckTravelStatus[] BY_ID =
            Arrays.stream(values()).sorted(Comparator.comparingInt(DuckTravelStatus::getId)).toArray(DuckTravelStatus[]::new);
    private final int id;

    DuckTravelStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static DuckTravelStatus byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
