package DungeonsOfLatserolf.map.tile;

import DungeonsOfLatserolf.graphics.AssetImage;

public class Chest extends TileTypeEntity {
    private boolean openChest;
    private boolean keyChest;
    private int goldPieces;

    public Chest(int goldPieces, AssetImage asset, AssetImage assetOpen) {
        super(asset, assetOpen);
        this.openChest = false;
        this.keyChest = false;
        this.goldPieces = goldPieces;
    }

    public Chest (boolean keyChest,AssetImage assetImage, AssetImage assetImageOpen) {
        super(assetImage, assetImageOpen);
        this.openChest = false;
        this.keyChest = keyChest;
        this.goldPieces = 0;
    }

    public boolean getOpenChest() { // ver se esta aberto
        return openChest;
    }

    public void setOpenChest(boolean openChest) { // abrir o baú
        this.openChest = openChest;
    }

    public boolean getKeyChest() { // ver se tem chave
        return keyChest;
    }

    public void setKeyChest(boolean keyChest) { // pegar a chave
        this.keyChest = keyChest;
    }

    public int getGoldPieces() { // ver quantas moedas tem
        return goldPieces;
    }

    public void setGoldPieces(int goldPieces) { // pegar as moedas
        this.goldPieces = goldPieces;
    }

    @Override
    public AssetImage getAssetImage(){
        if (this.openChest) {
            return getAssetOpen();
        }
        return getAsset();
    }

    @Override
    public boolean isWalkable() {
        return true;
    }

    @Override
    public boolean isInteractable() {
        if (this.openChest) {
            return false;
        }
        return true;
    }
}
