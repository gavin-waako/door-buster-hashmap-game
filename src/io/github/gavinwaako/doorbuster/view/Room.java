package io.github.gavinwaako.doorbuster.view;

import io.github.gavinwaako.doorbuster.config.GameSettings;
import io.github.gavinwaako.doorbuster.model.Fortress;
import io.github.gavinwaako.doorbuster.model.Player;
import io.github.gavinwaako.doorbuster.model.FortressListener;

import javax.swing.JPanel;
import java.awt.*;

// This is the drawing surface onto which game components are drawn
public class Room extends JPanel implements FortressListener {

    private final Fortress fortress;

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
        drawPlayer(g2, fortress.getPlayer());   // NEW
    }

    private void drawFloor(Graphics2D g) {
        g.setColor(new Color(60, 63, 65));
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
        g.setColor(Color.CYAN);
        g.fillRect(p.getX() * cell + 5, p.getY() * cell + 5, cell - 10, cell - 10);
    }
}








