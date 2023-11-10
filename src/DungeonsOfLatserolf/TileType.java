package DungeonsOfLatserolf;

 public abstract class TileType {
// public class TileType {
    TileComponent tileType;

    public TileType(TileComponent tileType) {
        this.tileType = tileType;
    }

    public TileComponent getTileType() {
        return tileType;
    }
    
    public char getCharTileType() {
        return tileType.getTileType();
    }

    public void setTileType(TileComponent tileType) {
        this.tileType = tileType;
    }
}