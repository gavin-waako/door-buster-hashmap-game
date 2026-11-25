package io.github.gavinwaako.doorbuster.view;

import javax.swing.*;

import static io.github.gavinwaako.doorbuster.config.GameSettings.WINDOW_TITLE;

// The window that receives and holds the view
public class GameWindow extends JFrame {
    public GameWindow(Room view) {

        // Sets window title
        setTitle(WINDOW_TITLE);

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