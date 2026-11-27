package io.github.gavinwaako.doorbuster.view;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Theme {
    private static final Color DEFAULT_FLOOR = new Color(60, 63, 65);
    private final Map<String, Color> floorColors = new HashMap<>();

    public Theme() {
        // Create BG color palette for the different rooms
        floorColors.put("Start Room", new Color(60, 63, 65));
        floorColors.put("Gold Room", new Color(212, 175, 55));
        floorColors.put("Food Room", new Color(20, 57, 200));
    }

    public Color floorColorFor(String roomName) {
        return floorColors.getOrDefault(roomName, DEFAULT_FLOOR);
    }
}
