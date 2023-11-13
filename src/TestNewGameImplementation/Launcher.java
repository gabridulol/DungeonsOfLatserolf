package TestNewGameImplementation;

import TestNewGameImplementation.game.Game;
import TestNewGameImplementation.game.GameLoop;

public class Launcher {
    public static void main(String[] args) {
        new Thread(new GameLoop(new Game(800, 600))).start();
    }
}
