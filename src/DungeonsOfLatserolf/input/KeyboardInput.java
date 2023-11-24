package DungeonsOfLatserolf.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {
    private boolean[] pressed;

    public KeyboardInput() {
        pressed = new boolean[255];
    }

    public boolean isPressed(int keyCode) {
        return pressed[keyCode];
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        pressed[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressed[e.getKeyCode()] = false;
    }
}
