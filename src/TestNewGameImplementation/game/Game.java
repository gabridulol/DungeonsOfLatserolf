package TestNewGameImplementation.game;

import java.util.ArrayList;
import java.util.List;

import TestNewGameImplementation.controller.PlayerController;
import TestNewGameImplementation.display.Display;
import TestNewGameImplementation.entity.GameObject;
import TestNewGameImplementation.entity.Player;
import TestNewGameImplementation.gfx.SpriteLibrary;
import TestNewGameImplementation.input.Input;

public class Game {
    public static final int SPRITE_SIZE = 16;

    private Display display;

    private List<GameObject> gameObjects;

    private Input input;

    private SpriteLibrary spriteLibrary;

    public Game(int width, int height) {
        display = new Display(width, height, input);
        gameObjects = new ArrayList<>();
        input = new Input();
        spriteLibrary = new SpriteLibrary();
        gameObjects.add(new Player(new PlayerController(input), spriteLibrary));
    }

    public void update() {
        gameObjects.forEach(gameObject -> gameObject.update());
    }

    public void render() {
        display.render(this);
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }
}
