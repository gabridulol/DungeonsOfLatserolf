package DungeonsOfLatserolf.entity;

import DungeonsOfLatserolf.component.TileComponent;

public abstract class TileTypeEntity {
    private TileComponent tile;

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

    public boolean isWalkable(){
        return false;
    }

    public boolean isInteractable(){
        return false;
    }
}