package io.github.gavinwaako.doorbuster.controller;

import io.github.gavinwaako.doorbuster.model.Direction;
import io.github.gavinwaako.doorbuster.model.Fortress;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyboardController extends KeyAdapter {
    private final Map<Integer, Direction> keyBindings = new HashMap<>();
    private final Fortress fortress;

    public KeyboardController(Fortress fortress) {
        this.fortress = fortress;
        bind(KeyEvent.VK_UP, Direction.NORTH);
        bind(KeyEvent.VK_DOWN,  Direction.SOUTH);
        bind(KeyEvent.VK_LEFT,  Direction.WEST);
        bind(KeyEvent.VK_RIGHT, Direction.EAST);
        bind(KeyEvent.VK_W, Direction.NORTH);
        bind(KeyEvent.VK_S, Direction.SOUTH);
        bind(KeyEvent.VK_A, Direction.WEST);
        bind(KeyEvent.VK_D, Direction.EAST);
    }

    public void bind(int keyCode, Direction direction) {
        keyBindings.put(keyCode, direction);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Direction direction = keyBindings.get(e.getKeyCode());
        if (direction != null) {
            fortress.move(direction);
        }
    }
}
