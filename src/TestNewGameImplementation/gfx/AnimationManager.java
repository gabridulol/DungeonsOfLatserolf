package TestNewGameImplementation.gfx;

import java.awt.Image;
import java.awt.image.BufferedImage;

import TestNewGameImplementation.game.Game;


public class AnimationManager {
    private SpriteSet spriteSet;
    private BufferedImage currentAnimationSheet;

    private int updatePerFrame;
    private int currentFrameTime;
    private int frameIndex;

    public AnimationManager(SpriteSet spriteSet) {
        this.spriteSet = spriteSet;
        this.updatePerFrame = 20;
        this.frameIndex = 0;
        this.currentFrameTime = 0;
        playAnimation("movement");
    }

    public Image getSprite() {
        return currentAnimationSheet.getSubimage(
            frameIndex * Game.SPRITE_SIZE,
            0,
            Game.SPRITE_SIZE,
            Game.SPRITE_SIZE
        );
    }

    public void update() {
        currentFrameTime++;

        if (currentFrameTime >= updatePerFrame) {
            currentFrameTime = 0;
            frameIndex++;

            if (frameIndex >= currentAnimationSheet.getWidth() / Game.SPRITE_SIZE) {
                frameIndex = 0;
            }
        }
    }

    public void playAnimation(String name) {
        this.currentAnimationSheet = (BufferedImage) spriteSet.get(name);
    }
}
