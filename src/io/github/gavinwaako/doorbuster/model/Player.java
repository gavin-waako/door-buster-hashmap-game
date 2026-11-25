package io.github.gavinwaako.doorbuster.model;

public class Player {

    // Instance variables
    private int x;
    private int y;
    // Start game with player facing the East (or the right)
    private Direction facing = Direction.EAST;

    // Parameterized constructor
    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    // Setters
    public void setPosition(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    // Set player position
    public void face(Direction direction) {
        this.facing = direction;
    }

    // Getters
    // Return x coordinate of player position
    public int getX() {
        return x;
    }

    // Return y coordinate of player position
    public int getY() {
        return y;
    }

    // return current direction player is facing
    public Direction getFacing() {
        return facing;
    }
}










