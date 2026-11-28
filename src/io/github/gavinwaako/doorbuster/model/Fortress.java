package io.github.gavinwaako.doorbuster.model;

import io.github.gavinwaako.doorbuster.config.GameSettings;

import java.util.ArrayList;
import java.util.List;

public class Fortress {

    // Instance variables
    private static final int MAX = GameSettings.GRID_SIZE - 1;
    private final Player player;
    private final World world;

    private final List<FortressListener> listeners = new ArrayList<>();

    // Constructor
    public Fortress() {

        //
        player = new Player(GameSettings.PLAYER_START_X, GameSettings.PLAYER_START_Y);
        world = WorldFactory.createDefaultWorld();    // NEW 2: inside the constructor
    }

    public void move(Direction direction) {
        player.face(direction);

        int targetX = player.getX() + direction.dx;
        int targetY = player.getY() + direction.dy;

        if (isInsideGrid(targetX, targetY)) {
            // Normal step inside the chamber
            player.setPosition(targetX, targetY);
        } else {
            Chamber current = world.getCurrentChamber();
            if (current.hasExit(direction) && isStandingInDoorway(direction)) {
                world.setCurrentRoom(current.getExit(direction));
                placePlayerAtEntrance(direction);
            }
        }

        notifyListeners();   // tells the view to repaint
    }

    //
    private boolean isInsideGrid(int x, int y) {
        return x >= 0 && x <= MAX && y >= 0 && y <= MAX;
    }

    private boolean isStandingInDoorway(Direction direction) {
        int alongWall = direction.isHorizontal() ? player.getY() : player.getX();
         return alongWall >= GameSettings.DOOR_START
             && alongWall < GameSettings.DOOR_START + GameSettings.DOOR_SPAN;
    }

    private void placePlayerAtEntrance(Direction travelled) {
         switch (travelled) {
             case EAST:  player.setPosition(0,   player.getY()); break;
             case WEST:  player.setPosition(MAX, player.getY()); break;
             case NORTH: player.setPosition(player.getX(), MAX); break;
             case SOUTH: player.setPosition(player.getX(), 0);   break;
         }
    }

    //
    public Player getPlayer() {
        return player;
    }

    //
    public void addListener(FortressListener listener) {
         listeners.add(listener);
    }

    //
    private void notifyListeners() {
         for (FortressListener listener : listeners) {
             listener.onFortressChanged();
         }
    }

    //
    public Chamber getCurrentChamber() {              // NEW 3: getter, at the bottom
        return world.getCurrentChamber();
    }
}







