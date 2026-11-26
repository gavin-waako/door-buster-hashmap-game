import io.github.gavinwaako.doorbuster.controller.KeyboardController;
import io.github.gavinwaako.doorbuster.model.Fortress;
import io.github.gavinwaako.doorbuster.model.FortressListener;
import io.github.gavinwaako.doorbuster.view.GameWindow;
import io.github.gavinwaako.doorbuster.view.Room;

import javax.swing.*;

// Build and runs the game
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Fortress model = new Fortress();
            Room view = new Room(model);
            KeyboardController controller = new KeyboardController(model);

            model.addListener((FortressListener) view);            // M -> V  (observer)
            view.addKeyListener(controller);    // keyboard -> C
            new GameWindow(view);
        });
    }
}

