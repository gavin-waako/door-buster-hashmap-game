package io.github.gavinwaako.doorbuster.model;

public class ModelTest {
    public static void main(String[] args) {
        Fortress m = new Fortress();
        for (int i = 0; i < 20; i++) m.move(Direction.WEST);
        System.out.println(m.getPlayer().getX() + "," + m.getPlayer().getY());

         for (int i = 0; i < 20; i++) m.move(Direction.NORTH);
         System.out.println(m.getPlayer().getX() + "," + m.getPlayer().getY());

         for (int i = 0; i < 20; i++) m.move(Direction.EAST);
         System.out.println(m.getPlayer().getX() + "," + m.getPlayer().getY());

         for (int i = 0; i < 20; i++) m.move(Direction.SOUTH);
         System.out.println(m.getPlayer().getX() + "," + m.getPlayer().getY());
    }
}
