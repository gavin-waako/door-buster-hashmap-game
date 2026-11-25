package io.github.gavinwaako.doorbuster.view;

import io.github.gavinwaako.doorbuster.config.GameSettings;

import javax.swing.JPanel;
import java.awt.*;

// This is the drawing surface onto which game components are drawn
public class Room extends JPanel {

    // Constructs the GameView
    public Room() {
        // set size to 400 x 400 px
        setPreferredSize(new Dimension(400, 400));

        // For panel to be able to receive key presses later
        setFocusable(true);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawFloor(g2);
        drawGrid(g2);
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
}
