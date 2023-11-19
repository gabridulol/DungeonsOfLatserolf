package DungeonsOfLatserolf.map.tile;

public class Door extends TileTypeEntity {
    private boolean isOpenDoor;
    private boolean isMonsterDoor;

    public Door() {
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
