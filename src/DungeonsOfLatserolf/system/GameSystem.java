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
import DungeonsOfLatserolf.display.components.Dungeon;
import DungeonsOfLatserolf.entity.player.PlayerEntity;
import DungeonsOfLatserolf.graphics.AssetLibrary;
import DungeonsOfLatserolf.map.MapEntity;
import DungeonsOfLatserolf.map.tile.Chest;
import DungeonsOfLatserolf.map.tile.Door;

import DungeonsOfLatserolf.system.BattleSystem;

// + createAndShowGUI()

// + paintComponent( g: Graphics): void

// + detectKey():void


public class GameSystem {
    // private static final int cellSize = 16; // 16x16 pixels
    // private static final double zoom = 5.0f; // 5x zoom

    private AssetLibrary assetLibrary;
    private MapEntity mapEntity;
    private PlayerEntity player;
    private Dungeon dungeonPanel;
    private Display display;
    private BattleSystem battleSystem;


    public GameSystem(AssetLibrary assetLibrary, MapEntity mapEntity, PlayerEntity player){
        this.assetLibrary = assetLibrary;
        this.mapEntity = mapEntity;
        this.player = player;
        // display = new Display();
    }

    public MapEntity getMapEntity(){
        return mapEntity;
    }

    public PlayerEntity getPlayerEntity(){
        return player;
    }

    public void startGame(){
        mapEntity.buildMap();
        // display.createAndShowGUI();
        // display.detectKey();
    }

    public void setDungeonPanel(Dungeon dungeonPanel){
        this.dungeonPanel = dungeonPanel;
    }

    public Dungeon getDungeonPanel(){
        return dungeonPanel;
    }

    public void moveCharacter(int[] movimento){
        int[] positionPlayer = player.getPositionPlayer();
        int[] newPositionPlayer = new int[]{positionPlayer[0] + movimento[0], positionPlayer[1] + movimento[1]};

        if (movimento[0] == 0 && movimento[1] == 0) {
            for (int i = -1; i < 2; i++){
                if (mapEntity.getMap()[newPositionPlayer[0] + i][newPositionPlayer[1]] instanceof Chest){ 
                    Chest chest = (Chest) mapEntity.getMap()[newPositionPlayer[0]+i][newPositionPlayer[1]];
                    player.catchItems(chest);
                    chest.setChestEmpty();
                    // dungeonPanel.setPlayerDirection("up");
                }

                if(mapEntity.getMap()[newPositionPlayer[0]][newPositionPlayer[1]+i] instanceof Chest){ 
                    Chest chest = (Chest) mapEntity.getMap()[newPositionPlayer[0]][newPositionPlayer[1]+i];
                    player.catchItems(chest);
                    chest.setChestEmpty();
                    // dungeonPanel.setPlayerDirection("left");
                }

                if(mapEntity.getMap()[newPositionPlayer[0] + i][newPositionPlayer[1]] instanceof Door){
                    Door door = (Door) mapEntity.getMap()[newPositionPlayer[0]+i][newPositionPlayer[1]];
                    if(door.getMonsterDoor()!=null){ 
                        battleSystem = new BattleSystem(door.getMonsterDoor(), player);
                        if(battleSystem.startBattle() == false){
                            // fecha o jogo
                        }
                        
                    }
                     door.setDoorEmpty();
                }

                if(mapEntity.getMap()[newPositionPlayer[0]][newPositionPlayer[1]+i] instanceof Door){
                    Door door = (Door) mapEntity.getMap()[newPositionPlayer[0]][newPositionPlayer[1]+i];
                    if(door.getMonsterDoor()!=null){ 
                        battleSystem = new BattleSystem(door.getMonsterDoor(), player);
                        if(battleSystem.startBattle() == false){
                            // fecha o jogo
                        }
                    }
                     door.setDoorEmpty();
                    // dungeonPanel.setPlayerDirection("right");
                }
            }

        }

        else if(mapEntity.getMap()[newPositionPlayer[0]][newPositionPlayer[1]].isWalkable()){
            player.setPositionPlayer(newPositionPlayer);
        }

        dungeonPanel.repaint();
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
