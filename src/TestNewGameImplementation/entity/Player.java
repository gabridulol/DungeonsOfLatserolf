package TestNewGameImplementation.entity;

import TestNewGameImplementation.controller.Controller;
import TestNewGameImplementation.gfx.SpriteLibrary;

public class Player extends MovingEntity {
    public Player(Controller controller, SpriteLibrary spriteLibrary) {
        super(controller, spriteLibrary);
    }

    @Override
    public void update() {
        super.update();
    }
}