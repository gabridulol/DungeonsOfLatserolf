import javax.swing.SwingUtilities;

import DungeonsOfLatserolf.display.Display;
import DungeonsOfLatserolf.display.components.Game;
import DungeonsOfLatserolf.system.GameSystem;

public class Main {
    public static void main(String[] args) {
        GameSystem gameSystem = new GameSystem();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                gameSystem.getDisplay().setVisible(true);
            }
        });
    }
}
