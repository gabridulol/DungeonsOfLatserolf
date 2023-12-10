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
import java.util.concurrent.atomic.AtomicBoolean;

import DungeonsOfLatserolf.display.Interface;
import DungeonsOfLatserolf.display.InterfaceFrame;
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
    private InterfaceFrame interfaceFrame;
    private BattleSystem battleSystem;
    private AtomicBoolean batalhando;


    public GameSystem(AssetLibrary assetLibrary, MapEntity mapEntity, PlayerEntity player){
        this.assetLibrary = assetLibrary;
        this.mapEntity = mapEntity;
        this.player = player;
        this.batalhando = new AtomicBoolean(false);
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

        if (batalhando.get()) return;

        int[] positionPlayer = player.getPositionPlayer();
        int[] newPositionPlayer = new int[]{positionPlayer[0] + movimento[0], positionPlayer[1] + movimento[1]};

        if (movimento[0] == 0 && movimento[1] == 0) {
            for (int i = -1; i < 2; i+=2){
                if (mapEntity.getMap()[newPositionPlayer[0] + i][newPositionPlayer[1]] instanceof Chest){ 
                    Chest chest = (Chest) mapEntity.getMap()[newPositionPlayer[0]+i][newPositionPlayer[1]];
                    if(chest.isInteractable()){
                        player.catchItems(chest);
                        chest.setChestEmpty();
                        System.out.println("Score: " + player.getScore());
                        break;
                    }
                    // dungeonPanel.setPlayerDirection("up");
                }

                if(mapEntity.getMap()[newPositionPlayer[0]][newPositionPlayer[1]+i] instanceof Chest){ 
                    Chest chest = (Chest) mapEntity.getMap()[newPositionPlayer[0]][newPositionPlayer[1]+i];
                    if(chest.isInteractable()){
                        player.catchItems(chest);
                        chest.setChestEmpty();
                        System.out.println("Score: " + player.getScore());
                        break;
                    }
                    // dungeonPanel.setPlayerDirection("left");
                }

                if(mapEntity.getMap()[newPositionPlayer[0] + i][newPositionPlayer[1]] instanceof Door){
                    Door door = (Door) mapEntity.getMap()[newPositionPlayer[0]+i][newPositionPlayer[1]];
                    if(door.isInteractable()){
                        if(door.getMonsterDoor()!=null){ 
                            battleSystem = new BattleSystem(door.getMonsterDoor(), player, assetLibrary);
                            if(battleSystem.acceptBattle() != false){
                                batalhando.set(true);

                                if(battleSystem.startBattle(batalhando) == false){
                                    // fecha o jogo

                                } else{
                                    // batalhando = false;
                                    door.setDoorEmpty();
                                }
                            }                        
                        } else{
                            door.setDoorEmpty();
                        }
                        break;
                    }
                }

                if(mapEntity.getMap()[newPositionPlayer[0]][newPositionPlayer[1]+i] instanceof Door){
                    Door door = (Door) mapEntity.getMap()[newPositionPlayer[0]][newPositionPlayer[1]+i];
                    if(door.isInteractable()){
                        if(door.getMonsterDoor()!=null){ 
                            battleSystem = new BattleSystem(door.getMonsterDoor(), player, assetLibrary);
                            if(battleSystem.acceptBattle() != false){
                                batalhando.set(true);
                                if(battleSystem.startBattle(batalhando) == false){
                                    System.out.println("Fim de jogo");
                                    System.exit(0);
                                } else{
                                    door.setDoorEmpty();
                                }
                            }
                        } 
                        
                        else{
                            door.setDoorEmpty();
                        }
                        break;
                    }
                    // dungeonPanel.setPlayerDirection("right");
                }
            }
        }

        else if(mapEntity.getMap()[newPositionPlayer[0]][newPositionPlayer[1]].isWalkable()){
            player.setPositionPlayer(newPositionPlayer);
        }
        
        if(batalhando.get() == false)
            dungeonPanel.repaint();
    }
    
}
