package io.github.gavinwaako.doorbuster.model;

import io.github.gavinwaako.doorbuster.config.GameSettings;

public final class WorldFactory {
     private WorldFactory() { }

     public static World createDefaultWorld() {
         World world = new World();
         world.addRoom(new Chamber("Start Room"));
         world.addRoom(new Chamber("Gold Room"));
         world.addRoom(new Chamber("Food Room"));
         world.connect("Start Room", Direction.WEST, "Gold Room");
         world.connect("Gold Room",  Direction.WEST, "Food Room");
         world.setCurrentRoom(GameSettings.START_ROOM);
         return world;
     }
 }