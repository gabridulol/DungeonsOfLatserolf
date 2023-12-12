package DungeonsOfLatserolf.system;

import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JLabel;
import DungeonsOfLatserolf.display.components.DungeonFrame;
import DungeonsOfLatserolf.entity.player.PlayerEntity;
import DungeonsOfLatserolf.graphics.AssetLibrary;
import DungeonsOfLatserolf.map.MapEntity;
import DungeonsOfLatserolf.map.tile.Chest;
import DungeonsOfLatserolf.map.tile.Door;
import DungeonsOfLatserolf.map.tile.Exit;
import DungeonsOfLatserolf.map.tile.TileTypeEntity;

public class GameSystem {
    private AssetLibrary assetLibrary;
    private MapEntity mapEntity;
    private PlayerEntity player;
    private DungeonFrame dungeonPanel;

    private JLabel labelChest;
    private JLabel labelKey;

    private BattleSystem battleSystem;
    private AtomicBoolean isBattle;

    public GameSystem(AssetLibrary assetLibrary, MapEntity mapEntity, PlayerEntity player) {
        this.assetLibrary = assetLibrary;
        this.mapEntity = mapEntity;
        this.player = player;
        this.isBattle = new AtomicBoolean(false);
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

    public void setDungeonPanel(DungeonFrame dungeonPanel) {
        this.dungeonPanel = dungeonPanel;
    }

    public DungeonFrame getDungeonPanel() {
        return dungeonPanel;
    }

    public void setLabels(JLabel labelChest, JLabel labelKey) {
        this.labelChest = labelChest;
        this.labelKey = labelKey;
    }

    private void chestInteract(Chest chest) {
        if (chest.isInteractable()) {
            if (chest.getKeyChest()) {
                player.upLevel();
            }
            player.catchItems(chest);
            chest.setChestEmpty();
            labelChest.setText("Score: " + player.getScore());
            labelKey.setText("Keys: " + player.getTotalKeys() + "/" + mapEntity.getMapData().getKeysMap());
        }
    }

    private void doorInteract(Door door) {
        if (door.isInteractable()) {
            if (door.getMonsterDoor() != null) {
                battleSystem = new BattleSystem(door.getMonsterDoor(), player, assetLibrary);
                if (battleSystem.acceptBattle() != false) {
                    isBattle.set(true);
                    battleSystem.startBattle(isBattle, labelChest);
                    player.addScore(door.getMonsterDoor().getXP());
                    door.setDoorEmpty();
                }
            } else {
                door.setDoorEmpty();
            }
        }
    }

    private void interact(TileTypeEntity tileTypeEntity) {
        if (tileTypeEntity instanceof Chest)
            chestInteract((Chest) tileTypeEntity);

        else if (tileTypeEntity instanceof Door)
            doorInteract((Door) tileTypeEntity);
    }

    private void exitInteract(Exit start) {
        start.canBeOpened(player.getTotalKeys());
        if (start.getOpenOutput()) {
            System.exit(0);
        }
    }

    public void moveCharacter(int[] movimento) {

        if (isBattle.get()) {
            return;
        }

        int[] positionPlayer = player.getPositionPlayer();
        int[] newPositionPlayer = new int[] { positionPlayer[0] + movimento[0], positionPlayer[1] + movimento[1] };

        if (movimento[0] == 0 && movimento[1] == 0) {
            if (mapEntity.getMap()[positionPlayer[0]][positionPlayer[1]] instanceof Exit)
                exitInteract((Exit) mapEntity.getMap()[positionPlayer[0]][positionPlayer[1]]);

            if (dungeonPanel.getPlayerDirection() == "down")
                interact(mapEntity.getMap()[positionPlayer[0]][positionPlayer[1] + 1]);

            if (dungeonPanel.getPlayerDirection() == "up")
                interact(mapEntity.getMap()[positionPlayer[0]][positionPlayer[1] - 1]);

            if (dungeonPanel.getPlayerDirection() == "left")
                interact(mapEntity.getMap()[positionPlayer[0] - 1][positionPlayer[1]]);

            if (dungeonPanel.getPlayerDirection() == "right")
                interact(mapEntity.getMap()[positionPlayer[0] + 1][positionPlayer[1]]);
        } else if (mapEntity.getMap()[newPositionPlayer[0]][newPositionPlayer[1]].isWalkable()) {
            player.setPositionPlayer(newPositionPlayer);
        }

        if (isBattle.get() == false) {
            dungeonPanel.repaint();
        }
    }
}
