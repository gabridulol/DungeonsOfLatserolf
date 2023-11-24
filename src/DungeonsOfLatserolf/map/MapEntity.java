package DungeonsOfLatserolf.map;

import DungeonsOfLatserolf.map.tile.TileTypeEntity;

public class MapEntity {
    private MapData mapData;
    private TileTypeEntity[][] map;
    
    public MapEntity(MapData mapData) {
        this.mapData = mapData;
        this.map = new TileTypeEntity[mapData.getWidth()][mapData.getHeight()];
    }

    public MapData getMapData() {
        return mapData;
    }

    public void setMapData(MapData mapData) {
        this.mapData = mapData;
    }

    public TileTypeEntity[][] getMap() {
        return map;
    }

    public void setMap(TileTypeEntity[][] map) {
        this.map = map;
    }

    // public boolean 

}
