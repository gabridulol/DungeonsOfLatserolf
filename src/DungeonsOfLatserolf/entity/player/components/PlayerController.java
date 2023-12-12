package DungeonsOfLatserolf.entity.player.components;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import DungeonsOfLatserolf.system.BattleSystem;
import DungeonsOfLatserolf.system.GameSystem;

public class PlayerController implements KeyListener {

    GameSystem game;
    BattleSystem battleSystem;

    public PlayerController(GameSystem game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
            game.moveCharacter(new int[] { -1, 0 });
            if (game.getDungeonPanel().getPlayerDirection() != "left") {
                game.getDungeonPanel().setPlayerDirection("left");
                game.getDungeonPanel().setPlayerDirectionNum(0);
            } else {
                game.getDungeonPanel().setPlayerDirectionNum((game.getDungeonPanel().getPlayerDirectionNum() + 1) % 3);
            }
        }

        else if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
            game.moveCharacter(new int[] { 1, 0 });
            if (game.getDungeonPanel().getPlayerDirection() != "right") {
                game.getDungeonPanel().setPlayerDirection("right");
                game.getDungeonPanel().setPlayerDirectionNum(0);
            } else {
                game.getDungeonPanel().setPlayerDirectionNum((game.getDungeonPanel().getPlayerDirectionNum() + 1) % 3);
            }
        }

        else if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
            game.moveCharacter(new int[] { 0, -1 });
            if (game.getDungeonPanel().getPlayerDirection() != "up") {
                game.getDungeonPanel().setPlayerDirection("up");
                game.getDungeonPanel().setPlayerDirectionNum(0);
            } else {
                game.getDungeonPanel().setPlayerDirectionNum((game.getDungeonPanel().getPlayerDirectionNum() + 1) % 3);
            }
        }

        else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
            game.moveCharacter(new int[] { 0, 1 });
            if (game.getDungeonPanel().getPlayerDirection() != "down") {
                game.getDungeonPanel().setPlayerDirection("down");
                game.getDungeonPanel().setPlayerDirectionNum(0);
            } else {
                game.getDungeonPanel().setPlayerDirectionNum((game.getDungeonPanel().getPlayerDirectionNum() + 1) % 3);
            }
        }

        else if (keyCode == KeyEvent.VK_E) {
            game.moveCharacter(new int[] { 0, 0 });
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