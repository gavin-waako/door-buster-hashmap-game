import io.github.gavinwaako.doorbuster.view.GameFrame;
import io.github.gavinwaako.doorbuster.view.GameView;

import javax.swing.*;

// Build and runs the game
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameView view = new GameView();
            new GameFrame(view);
        });
    }
}