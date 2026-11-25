package io.github.gavinwaako.doorbuster.view;

import javax.swing.*;

// The window that receives and holds the view
public class GameFrame extends JFrame {
    public GameFrame(GameView view) {

        // Sets window title
        setTitle("Door Buster");

        // Closes window if close button pressed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Makes the window unresizable
        setResizable(false);

        //
        add(view);

        //
        pack();

        // Centers the window on screen
        setLocationRelativeTo(null);

        // Makes window visible on screen
        setVisible(true);

        view.requestFocusInWindow();
    }
}