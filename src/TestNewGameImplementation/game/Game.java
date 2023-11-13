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
    private Display display;

    private List<GameObject> gameObjects;

    private Input input;

    private SpriteLibrary spriteLibrary;

    public Game(int width, int height) {
        input = new Input();
        display = new Display(width, height, input);
        gameObjects = new ArrayList<>();
        gameObjects.add(new Player(new PlayerController(input)));
        spriteLibrary = new SpriteLibrary();
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
