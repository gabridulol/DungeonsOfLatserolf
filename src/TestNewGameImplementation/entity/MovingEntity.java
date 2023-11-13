package TestNewGameImplementation.entity;

import TestNewGameImplementation.controller.Controller;
import TestNewGameImplementation.core.Movement;
import TestNewGameImplementation.gfx.AnimationManager;
import TestNewGameImplementation.gfx.SpriteLibrary;

import java.awt.Image;

public abstract class MovingEntity extends GameObject {
    private Controller controller;
    private Movement movement;
    private AnimationManager animationManager;

    public MovingEntity(Controller controller, SpriteLibrary spriteLibrary) {
        super();
        this.controller = controller;
        this.movement = new Movement(2);
        this.animationManager = new AnimationManager(spriteLibrary.getUnit("finn"));
    }

    @Override
    public void update() {
        movement.update(controller);
        position.apply(movement);
        animationManager.update();
    }

    @Override
    public Image getSprite() {
        return animationManager.getSprite();
    }
    
}
