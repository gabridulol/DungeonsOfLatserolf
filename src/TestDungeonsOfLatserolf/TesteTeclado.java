package TestDungeonsOfLatserolf;

import javax.swing.JFrame;
import DungeonsOfLatserolf.entity.player.components.PlayerController;;

public class TesteTeclado {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        PlayerController playerController = new PlayerController();

        // Registra o PlayerController como um KeyListener no JFrame
        frame.addKeyListener(playerController);

        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
