package DungeonsOfLatserolf.map.tile;

import DungeonsOfLatserolf.graphics.AssetImage;

public abstract class TileTypeEntity {
    private TileComponent tile;
    private AssetImage asset;

    public TileTypeEntity(TileComponent tile) {
        this.tile = tile;
    }

    public TileComponent getTileType() {
        return tile;
    }

    public char getCharTileType() {
        return tile.getTileType();
    }

    public void setTileType(TileComponent tile) {
        this.tile = tile;
    }

    public AssetImage getAsset() {
        return asset;
    }

    public void setAsset(AssetImage asset) {
        this.asset = asset;
    }

    public boolean isWalkable(){
        return false;
    }

    public boolean isInteractable(){
        return false;
    }
}