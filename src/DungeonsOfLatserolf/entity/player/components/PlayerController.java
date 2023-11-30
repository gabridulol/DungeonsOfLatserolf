package DungeonsOfLatserolf.entity.player.components;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import DungeonsOfLatserolf.system.BattleSystem;
import DungeonsOfLatserolf.system.GameSystem;

public class PlayerController implements KeyListener {

    GameSystem game;

    public PlayerController(GameSystem game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
            // System.out.println("A");
            game.moveCharacter(new int[]{-1, 0});
        }

        else if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
            // System.out.println("D");
            game.moveCharacter(new int[]{1, 0});
        }

        else if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
            // System.out.println("W");
            game.moveCharacter(new int[]{0, -1});
        }
        
        else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
            // System.out.println("S");
            game.moveCharacter(new int[]{0, 1});
        }
        
        else if (keyCode == KeyEvent.VK_E){
            // System.out.println("E");
            game.moveCharacter(new int[]{0, 0});
        }
        
        // else if (keyCode == KeyEvent.VK_ENTER)
            // System.out.println("ENTER");
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