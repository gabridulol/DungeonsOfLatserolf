package DungeonsOfLatserolf;

 public abstract class TileType {
    private TileComponent tile;

    public TileType(TileComponent tile) {
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
}