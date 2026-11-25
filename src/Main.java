import io.github.gavinwaako.doorbuster.view.GameWindow;
import io.github.gavinwaako.doorbuster.view.Room;

import javax.swing.*;

// Build and runs the game
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Room view = new Room();
            new GameWindow(view);
        });
    }
}