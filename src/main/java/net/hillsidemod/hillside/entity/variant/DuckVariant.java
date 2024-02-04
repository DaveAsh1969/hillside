package net.hillsidemod.hillside.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum DuckVariant {
    MALLARD(0),
    TAN(1),
    BLUE(2),
    BROWN(3),
    BABY(4);

    private static final DuckVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(DuckVariant::getId)).toArray(DuckVariant[]::new);
    private final int id;

    DuckVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static DuckVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
