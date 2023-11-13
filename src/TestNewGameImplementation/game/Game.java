package TestNewGameImplementation.game;

import java.util.ArrayList;
import java.util.List;

import TestNewGameImplementation.controller.PlayerController;
import TestNewGameImplementation.display.Display;
import TestNewGameImplementation.entity.GameObject;
import TestNewGameImplementation.entity.Player;
import TestNewGameImplementation.input.Input;

import java.awt.Rectangle;

public class Game {
    private Display display;

    private List<GameObject> gameObjects;

    private Input input;

    public Game(int width, int height) {
        input = new Input();
        display = new Display(width, height, input);
        gameObjects = new ArrayList<>();
        gameObjects.add(new Player(new PlayerController(input)));
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
