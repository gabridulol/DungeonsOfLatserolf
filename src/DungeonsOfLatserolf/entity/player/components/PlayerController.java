package DungeonsOfLatserolf.entity.player.components;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_A) {
            // moveCharacter(-1, 0, dungeonPanel, cellSize, combatLabel, doorOpens);
            System.err.println("A");
        } else if (keyCode == KeyEvent.VK_D) {
            // moveCharacter(1, 0, dungeonPanel, cellSize, combatLabel, doorOpens);
            System.out.println("D");
        } else if (keyCode == KeyEvent.VK_W) {
            // moveCharacter(0, -1, dungeonPanel, cellSize, combatLabel, doorOpens);
            System.out.println("W");
        } else if (keyCode == KeyEvent.VK_S) {
            // moveCharacter(0, 1, dungeonPanel, cellSize, combatLabel, doorOpens);
            System.out.println("S");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not needed for this example
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not needed for this example
    }
}