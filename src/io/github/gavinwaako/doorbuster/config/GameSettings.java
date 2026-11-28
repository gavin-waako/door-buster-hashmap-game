package io.github.gavinwaako.doorbuster.config;

public class GameSettings {

    // Instance variables
    public static final int PLAYER_START_X = 4;   // starting column
    public static final int PLAYER_START_Y = 4;   // starting row
    public static final String START_ROOM = "Gold Room";
    public static final String IMG_PLAYER = "player";
    public static final String IMG_DOOR = "door";

    // Defines cells where door begins and ends
    public static final int DOOR_START = 4;
    public static final int DOOR_SPAN = 2;

    // Constructor
    private GameSettings() { }

    // Game constants
    public static final String WINDOW_TITLE = "Door Buster";

    public static final int GRID_SIZE = 10; // cells per side (Model uses this)
    public static final int CELL_SIZE = 40; // pixels per cell (View uses this)
    public static final int WINDOW_PIXELS = GRID_SIZE * CELL_SIZE;
}
