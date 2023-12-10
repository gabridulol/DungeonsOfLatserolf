package DungeonsOfLatserolf.map.tile;

import java.awt.image.BufferedImage;

import DungeonsOfLatserolf.entity.monster.MonsterEntity;

public class Door extends TileTypeEntity {
    private boolean openDoor;
    private MonsterEntity monsterDoor;

    public Door(MonsterEntity monsterDoor, BufferedImage assetImage, BufferedImage assetImageOpen) {
        super(assetImage, assetImageOpen);
        this.openDoor = false;
        this.monsterDoor = monsterDoor;
    }

    public boolean getOpenDoor() { // ver se a porta esta aberta
        return openDoor;
    }

    public void setOpenDoor(boolean openDoor) { // abrir a porta
        this.openDoor = openDoor;
    }

    public MonsterEntity getMonsterDoor() { // ver se tem um monstro e qual é
        return monsterDoor;
    }

    public void setMonsterDoor(MonsterEntity monsterDoor) { // destroi o monstro
        this.monsterDoor = monsterDoor;
    }

    public void setDoorEmpty() {
        this.openDoor = true;
        this.monsterDoor = null;
    }

    @Override
    public BufferedImage getAssetImage() {
        if (this.openDoor) {
            return getAssetOpen();
        }
        return getAsset();
    }

    @Override
    public boolean isWalkable() {
        if (this.openDoor) {
            return true;
        }

        return false;
    }

    @Override
    public boolean isInteractable() {
        if (this.openDoor) {
            return false;
        }
        return true;
    }
}
