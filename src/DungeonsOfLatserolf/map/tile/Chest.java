package DungeonsOfLatserolf.map.tile;

import java.awt.image.BufferedImage;

public class Chest extends TileTypeEntity {
    private boolean openChest;
    private boolean keyChest;
    private int goldPieces;

    public Chest(int goldPieces, BufferedImage asset, BufferedImage assetOpen) {
        super(asset, assetOpen);
        this.openChest = false;
        this.keyChest = false;
        this.goldPieces = goldPieces;
    }

    public Chest(BufferedImage assetImage, BufferedImage assetImageOpen) {
        super(assetImage, assetImageOpen);
        this.openChest = false;
        this.keyChest = true;
        this.goldPieces = 0;
    }

    public boolean getOpenChest() {
        return openChest;
    }

    public void setOpenChest(boolean openChest) {
        this.openChest = openChest;
    }

    public boolean getKeyChest() {
        return keyChest;
    }

    public void setKeyChest(boolean keyChest) {
        this.keyChest = keyChest;
    }

    public int getGoldPieces() {
        return goldPieces;
    }

    public void setGoldPieces(int goldPieces) {
        this.goldPieces = goldPieces;
    }

    public void setChestEmpty() {
        this.openChest = true;
        this.keyChest = false;
        this.goldPieces = 0;
    }

    @Override
    public BufferedImage getAssetImage() {
        if (this.openChest) {
            return getAssetOpen();
        }
        return getAsset();
    }

    @Override
    public boolean isWalkable() {
        if (this.openChest) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isInteractable() {
        if (this.openChest) {
            return false;
        }
        return true;
    }
}
