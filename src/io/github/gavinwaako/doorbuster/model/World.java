package io.github.gavinwaako.doorbuster.model;

import java.util.HashMap;
import java.util.Map;

public class World {
    private final Map<String, Chamber> chambers = new HashMap<>();
    private Chamber currentChamber;

    public void addRoom(Chamber chamber) {
        if (chambers.containsKey(chamber.getName())) {
            throw new IllegalArgumentException("Duplicate room name: " + chamber.getName());
        }
        chambers.put(chamber.getName(), chamber);
    }

    public void connect(String fromName, Direction direction, String toName) {
        getChamber(fromName).addExit(direction, toName);
        getChamber(toName).addExit(direction.opposite(), fromName);
    }

    public Chamber getChamber(String name) {
        Chamber chamber = chambers.get(name);
         if (chamber == null) {
             throw new IllegalArgumentException("No chamber named: " + name);
         }
         return chamber;
    }

    public void setCurrentRoom(String name) {
        currentChamber = getChamber(name);
    }

    public Chamber getCurrentChamber() {
        return currentChamber;
    }
}
