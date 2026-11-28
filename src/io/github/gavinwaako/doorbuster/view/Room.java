package io.github.gavinwaako.doorbuster.view;

import io.github.gavinwaako.doorbuster.config.GameSettings;
import io.github.gavinwaako.doorbuster.model.Fortress;
import io.github.gavinwaako.doorbuster.model.Player;
import io.github.gavinwaako.doorbuster.model.FortressListener;
import io.github.gavinwaako.doorbuster.model.Chamber;
import io.github.gavinwaako.doorbuster.model.Direction;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import java.awt.*;

// This is the drawing surface onto which game components are drawn
public class Room extends JPanel implements FortressListener {

    private final Fortress fortress;
    private final Theme theme = new Theme();
    private final AssetManager assets = new AssetManager();

    public Room(Fortress fortress) {
        this.fortress = fortress;
        setPreferredSize(new Dimension(GameSettings.WINDOW_PIXELS, GameSettings.WINDOW_PIXELS));
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawFloor(g2);
        drawGrid(g2);
        drawDoors(g2, fortress.getCurrentChamber());
        drawPlayer(g2, fortress.getPlayer());
    }

    //
    private void drawFloor(Graphics2D g) {
        g.setColor(theme.floorColorFor(fortress.getCurrentChamber().getName()));
        g.fillRect(0, 0, GameSettings.WINDOW_PIXELS, GameSettings.WINDOW_PIXELS);
    }

    private void drawGrid(Graphics2D g) {
        int cell = GameSettings.CELL_SIZE;
        int grid = GameSettings.GRID_SIZE;

        g.setColor(new Color(255, 255, 255, 30));

        for (int i = 0; i < grid; i++) {
            g.drawRect(i * cell, 0, cell, cell * grid);   // column i
            g.drawRect(0, i * cell, cell * grid, cell);   // row i
        }
    }

    // Called by the Fortress after every move
    @Override
    public void onFortressChanged() {
        repaint();
    }

    private void drawPlayer(Graphics2D g, Player p) {
        int cell = GameSettings.CELL_SIZE;
        int px = p.getX() * cell;
        int py = p.getY() * cell;
        BufferedImage img = assets.getImage(GameSettings.IMG_PLAYER);
        if (img == null) {
            g.setColor(Color.CYAN);
            g.fillRect(px + 5, py + 5, cell - 10, cell - 10);
        } else {
            g.drawImage(img, px, py, cell, cell, null);
        }
    }

    private Rectangle doorBounds(Direction dir) {
     int cell = GameSettings.CELL_SIZE;
     int start = GameSettings.DOOR_START * cell;
     int length = GameSettings.DOOR_SPAN * cell;
     int far = (GameSettings.GRID_SIZE - 1) * cell;

     switch (dir) {
         case EAST:  return new Rectangle(far, start, cell, length);
         case WEST:  return new Rectangle(0,   start, cell, length);
         case NORTH: return new Rectangle(start, 0,   length, cell);
         default:    return new Rectangle(start, far, length, cell);
     }
 }

 private void drawDoors(Graphics2D g, Chamber chamber) {
        BufferedImage img = assets.getImage(GameSettings.IMG_DOOR);

         for (Direction dir : chamber.getExitDirections()) {
             Rectangle r = doorBounds(dir);
             if (img == null) {
                 g.setColor(new Color(139, 69, 19));
                 g.fillRect(r.x, r.y, r.width, r.height);
             } else if (dir == Direction.EAST) {
                 g.drawImage(img, r.x + r.width, r.y, -r.width, r.height, null);
             } else {
                 g.drawImage(img, r.x, r.y, r.width, r.height, null);
             }
         }
 }
}









