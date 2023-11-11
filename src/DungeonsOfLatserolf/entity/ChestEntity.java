package DungeonsOfLatserolf.entity;

import DungeonsOfLatserolf.component.TileComponent;

public class ChestEntity extends TileTypeEntity {
    private boolean isOpenChest;
    private boolean isKeyChest;
    private int goldPieces;

    public ChestEntity() {
        super(TileComponent.CHEST);
        this.isOpenChest = false;
        this.isKeyChest = false;
        this.goldPieces = 0;
    }

    public boolean isOpenChest() {
        return isOpenChest;
    }

    public void setOpenChest(boolean isOpenChest) {
        this.isOpenChest = isOpenChest;
    }

    public boolean isKeyChest() {
        return isKeyChest;
    }

    public void setKeyChest(boolean isKeyChest) {
        this.isKeyChest = isKeyChest;
    }

    public int getGoldPieces() {
        return goldPieces;
    }

    public void setGoldPieces(int goldPieces) {
        this.goldPieces = goldPieces;
    }

    @Override
    public boolean isWalkable() {
        return true;
    }

    @Override
    public boolean isInteractable() {
        if (this.isOpenChest) {
            return false;
        }
        return true;
    }
}
