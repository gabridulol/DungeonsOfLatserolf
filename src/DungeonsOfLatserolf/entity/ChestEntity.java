package DungeonsOfLatserolf.entity;

import DungeonsOfLatserolf.component.TileComponent;

public class ChestEntity extends TileTypeEntity{
    private boolean isOpenChest;
    private boolean isKeyChest;
    private int chestDrop;

    public ChestEntity(boolean isKeyChest, int chestDrop) {
        super(TileComponent.CHEST);
        this.isKeyChest = isKeyChest;
        this.chestDrop = chestDrop;
        this.isOpenChest = false;
    }

    public boolean getKeyChest() {
        return isKeyChest;
    }

    public void setKeyChest(boolean isKeyChest) {
        this.isKeyChest = isKeyChest;
    }

    public int getChestDrop() {
        return chestDrop;
    }

    public void setChestDrop(int chestDrop) {
        this.chestDrop = chestDrop;
    }

    public void setOpenChest(boolean isOpenChest) {
        this.isOpenChest = isOpenChest;
    }

    @Override
    public boolean isWalkable() {
        if (this.isOpenChest) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean isInteractable(){
        if (this.isOpenChest) {
            return false;
        }
        return true;
    }
}
