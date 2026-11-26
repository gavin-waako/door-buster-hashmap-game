package io.github.gavinwaako.doorbuster.model;

import io.github.gavinwaako.doorbuster.config.GameSettings;

import java.util.ArrayList;
import java.util.List;

public class Fortress {

    // Instance variables
    private static final int MAX = GameSettings.GRID_SIZE - 1;
    private final Player player;

    private final List<FortressListener> listeners = new ArrayList<>();

    // Constructor
    public Fortress() {

        //
        player = new Player(GameSettings.PLAYER_START_X, GameSettings.PLAYER_START_Y);
    }

    public void move(Direction direction) {
        player.face(direction);

        int targetX = player.getX() + direction.dx;
        int targetY = player.getY() + direction.dy;

        if (isInsideGrid(targetX, targetY)) {
            player.setPosition(targetX, targetY);
        }

        notifyListeners();   // <-- add this: tells Room to repaint
    }

    //
    private boolean isInsideGrid(int x, int y) {
        return x >= 0 && x <= MAX && y >= 0 && y <= MAX;
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
}







