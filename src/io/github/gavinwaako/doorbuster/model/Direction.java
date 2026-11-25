package io.github.gavinwaako.doorbuster.model;

public enum Direction {
    NORTH(0, -1), SOUTH(0, 1), EAST(1, 0), WEST(-1, 0);

    public final int dx;
    public final int dy;

    // Parameterized constructor
    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    //
    public Direction opposite() {
        switch (this) {
            case NORTH: return SOUTH;
            case SOUTH: return NORTH;
            case EAST:  return WEST;
            default:    return EAST;
        }
    }

    //
    public boolean isHorizontal() {
        return this == EAST || this == WEST;
    }
}