package DungeonsOfLatserolf.entity;

import DungeonsOfLatserolf.component.TileComponent;

public class DoorEntity extends TileTypeEntity {
    private boolean isOpenDoor;
    private boolean isMonsterDoor;

    public DoorEntity() {
        super(TileComponent.SIMPLE_DOOR);
        this.isOpenDoor = false;
        this.isMonsterDoor = false;
    }

    public boolean isOpenDoor() {
        return isOpenDoor;
    }

    public void setOpenDoor(boolean isOpenDoor) {
        this.isOpenDoor = isOpenDoor;
    }

    public boolean isMonsterDoor() {
        return isMonsterDoor;
    }

    public void setMonsterDoor(boolean isMonsterDoor) {
        this.isMonsterDoor = isMonsterDoor;
    }

    @Override
    public boolean isWalkable() {
        if (this.isOpenDoor) {
            return true;
        }

        return false;
    }

    @Override
    public boolean isInteractable() {
        if (this.isOpenDoor) {
            return false;
        }
        return true;
    }
}
