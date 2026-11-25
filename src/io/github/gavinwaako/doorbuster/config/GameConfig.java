package io.github.gavinwaako.doorbuster.config;

public class GameConfig {

    // Constructor
    private GameConfig() { }

    // Game constants
    public static final String WINDOW_TITLE = "Door Buster";

    public static final int GRID_SIZE = 10; // cells per side (Model uses this)
    public static final int CELL_SIZE = 40; // pixels per cell (View uses this)
    public static final int WINDOW_PIXELS = GRID_SIZE * CELL_SIZE;
}
