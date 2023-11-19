package DungeonsOfLatserolf.map;

public class MapEntity {
    MapData mapData;
    
    public MapEntity(MapData mapData) {
        this.mapData = mapData;
    }

    public MapData getMapData() {
        return mapData;
    }

    public void setMapData(MapData mapData) {
        this.mapData = mapData;
    }
}
