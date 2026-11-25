package io.github.gavinwaako.doorbuster.view;

import io.github.gavinwaako.doorbuster.config.GameConfig;

import javax.swing.JPanel;
import java.awt.*;

// This is the drawing surface onto which game components are drawn
public class GameView extends JPanel {

    // Constructs the GameView
    public GameView() {
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
        g.fillRect(0, 0, GameConfig.WINDOW_PIXELS, GameConfig.WINDOW_PIXELS);
    }

    private void drawGrid(Graphics2D g) {
        int cell = GameConfig.CELL_SIZE;
        int grid = GameConfig.GRID_SIZE;

        g.setColor(new Color(255, 255, 255, 30));

        for (int i = 0; i < grid; i++) {
            g.drawRect(i * cell, 0, cell, cell * grid);   // column i
            g.drawRect(0, i * cell, cell * grid, cell);   // row i
        }
    }
}
