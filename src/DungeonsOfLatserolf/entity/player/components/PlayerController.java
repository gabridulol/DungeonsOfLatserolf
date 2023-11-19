package DungeonsOfLatserolf.entity.player.components;

import java.awt.event.KeyEvent;

import DungeonsOfLatserolf.input.KeyboardInput;

public class PlayerController {
    private KeyboardInput input;

    public PlayerController(KeyboardInput input) {
        this.input = input;
    }

    public boolean isRequestingUp() {
        return input.isPressed(KeyEvent.VK_W);
    }

    public boolean isRequestingDown() {
        return input.isPressed(KeyEvent.VK_S);
    }

    public boolean isRequestingLeft() {
        return input.isPressed(KeyEvent.VK_A);
    }

    public boolean isRequestingRight() {
        return input.isPressed(KeyEvent.VK_D);
    }
}
