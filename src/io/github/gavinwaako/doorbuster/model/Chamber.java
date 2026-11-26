package io.github.gavinwaako.doorbuster.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Chamber {
    private final String name;
    private final Map<Direction, String> exits = new HashMap<>();

    public Chamber(String name) {
        this.name = name;
    }

    public void addExit(Direction direction, String neighborName) {
        exits.put(direction, neighborName);
    }

    public boolean hasExit(Direction direction) {
       return exits.containsKey(direction);
    }

    public String getExit(Direction direction) {
        return exits.get(direction);
    }

    public Set<Direction> getExitDirections() {
        return Collections.unmodifiableSet(exits.keySet());
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " exits=" + exits;
    }
}
