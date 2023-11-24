package DungeonsOfLatserolf.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.Random;

import DungeonsOfLatserolf.display.Display;
import DungeonsOfLatserolf.entity.player.PlayerEntity;
import DungeonsOfLatserolf.graphics.AssetLibrary;
import DungeonsOfLatserolf.map.MapEntity;

// + createAndShowGUI()

// + paintComponent( g: Graphics): void

// + detectKey():void


public class GameSystem {
    // private static final int cellSize = 16; // 16x16 pixels
    // private static final double zoom = 5.0f; // 5x zoom

    private AssetLibrary assetLibrary;
    private MapEntity mapEntity;
    private PlayerEntity player;
    private Display display;

    private float zoom;
    private int cellSize;

    public GameSystem(){
        assetLibrary = new AssetLibrary();
        mapEntity = new MapEntity();
        player = new PlayerEntity();
        display = new Display();
        zoom = 1.0f;
        cellSize = 32;
    }

    public void createAndShowGUI(){
        // this.dungeon = dungeon;
        // this.cellSize = cellSize;
        // this.characterX = dungeon[0].length / 2;
        // this.characterY = dungeon[0].length / 2;

        // int panelWidth = (int) (dungeon[0].length * cellSize * zoom);
        // int panelHeight = (int) (dungeon.length * cellSize * zoom);
        // setPreferredSize(new Dimension(panelHeight, panelWidth));
    }

    public void paintComponent( Graphics g){
        
    }

    public void detectKey(){
        
    }
    
}
