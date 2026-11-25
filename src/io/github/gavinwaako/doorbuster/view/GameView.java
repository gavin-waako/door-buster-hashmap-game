package io.github.gavinwaako.doorbuster.view;

import javax.swing.JPanel;
import java.awt.Dimension;

// This is the drawing surface onto which game components are drawn
public class GameView extends JPanel {

    // Constructs the GameView
    public GameView() {
        // set size to 400 x 400 px
        setPreferredSize(new Dimension(400, 400));

        // For panel to be able to receive key presses later
        setFocusable(true);
    }
}
