package DungeonsOfLatserolf.system;

import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JLabel;

import DungeonsOfLatserolf.display.InterfaceFrame;
import DungeonsOfLatserolf.display.components.Dungeon;
import DungeonsOfLatserolf.entity.player.PlayerEntity;
import DungeonsOfLatserolf.graphics.AssetLibrary;
import DungeonsOfLatserolf.map.MapEntity;
import DungeonsOfLatserolf.map.tile.Chest;
import DungeonsOfLatserolf.map.tile.Door;
import DungeonsOfLatserolf.map.tile.Start;
import DungeonsOfLatserolf.map.tile.TileTypeEntity;

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
    private JLabel labelChest;
    private JLabel labelKey;

    private BattleSystem battleSystem;
    private AtomicBoolean batalhando;

    public GameSystem(AssetLibrary assetLibrary, MapEntity mapEntity, PlayerEntity player) {
        this.assetLibrary = assetLibrary;
        this.mapEntity = mapEntity;
        this.player = player;
        this.batalhando = new AtomicBoolean(false);
        // display = new Display();
    }

    public MapEntity getMapEntity() {
        return mapEntity;
    }

    public PlayerEntity getPlayerEntity() {
        return player;
    }

    public void startGame() {
        mapEntity.buildMap();
    }

    public void setDungeonPanel(Dungeon dungeonPanel) {
        this.dungeonPanel = dungeonPanel;
    }

    public Dungeon getDungeonPanel() {
        return dungeonPanel;
    }

    public void setInterfaceFrame(InterfaceFrame interfaceFrame) {
        this.interfaceFrame = interfaceFrame;
    }

    public void setLabels(JLabel labelChest, JLabel labelKey) {
        this.labelChest = labelChest;
        this.labelKey = labelKey;
    }

    private void chestInterated(Chest chest){
        if (chest.isInteractable()) {
            player.catchItems(chest);
            chest.setChestEmpty();
            labelChest.setText("Score: " + player.getScore());
            labelKey.setText("Keys: " + player.getTotalKeys());
        }
    }

    private void doorInterated(Door door){
        if (door.isInteractable()) {
            if (door.getMonsterDoor() != null) {
                battleSystem = new BattleSystem(door.getMonsterDoor(), player, assetLibrary);
                if (battleSystem.acceptBattle() != false) {
                    batalhando.set(true);

                    if (battleSystem.startBattle(batalhando) == false) {
                        // fecha o jogo

                    } 
                    
                    else {
                        // batalhando = false;
                        door.setDoorEmpty();
                    }
                }
            } 
            
            else {
                door.setDoorEmpty();
            }
        }
    }

    private void interated(TileTypeEntity tileTypeEntity){
        if (tileTypeEntity instanceof Chest)
            chestInterated((Chest) tileTypeEntity);

        else if (tileTypeEntity instanceof Door)
            doorInterated((Door) tileTypeEntity);
    }

    private void exitInterated(Start start){
        System.out.println("tentar");
        start.canBeOpened(player.getTotalKeys());

        if (start.getOpenOutput()) {
            // mapEntity.buildMap();
            // player.setPositionPlayer(new int[] { 1, 1 });
            // dungeonPanel.repaint();
            System.out.println("Fim de jogo");
            System.exit(0);
        }
    }

    public void moveCharacter(int[] movimento) {

        if (batalhando.get())
            return;

        int[] positionPlayer = player.getPositionPlayer();
        int[] newPositionPlayer = new int[] { positionPlayer[0] + movimento[0], positionPlayer[1] + movimento[1] };

        if (movimento[0] == 0 && movimento[1] == 0) {
            if (mapEntity.getMap()[positionPlayer[0]][positionPlayer[1]] instanceof Start)
                exitInterated((Start) mapEntity.getMap()[positionPlayer[0]][positionPlayer[1]]);

            else if (dungeonPanel.getPlayerDirection() == "down")
                interated(mapEntity.getMap()[positionPlayer[0]][positionPlayer[1] + 1]);

            else if (dungeonPanel.getPlayerDirection() == "up")
                interated(mapEntity.getMap()[positionPlayer[0]][positionPlayer[1] - 1]);

            else if (dungeonPanel.getPlayerDirection() == "left")
                interated(mapEntity.getMap()[positionPlayer[0] - 1][positionPlayer[1]]);

            else if (dungeonPanel.getPlayerDirection() == "right")
                interated(mapEntity.getMap()[positionPlayer[0] + 1][positionPlayer[1]]);
        }

        else if (mapEntity.getMap()[newPositionPlayer[0]][newPositionPlayer[1]].isWalkable()) {
            player.setPositionPlayer(newPositionPlayer);
        }

        if (batalhando.get() == false)
            dungeonPanel.repaint();
    }

}
