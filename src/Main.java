import javax.swing.SwingUtilities;

import DungeonsOfLatserolf.display.Display;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Display();
            }
        });
    }
}
