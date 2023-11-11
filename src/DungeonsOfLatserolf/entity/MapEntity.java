package DungeonsOfLatserolf.entity;

import DungeonsOfLatserolf.component.MapDataComponent;

public class MapEntity {
    MapDataComponent mapData;
    
    public MapEntity(MapDataComponent mapData) {
        this.mapData = mapData;
    }

    public MapDataComponent getMapData() {
        return mapData;
    }

    public void setMapData(MapDataComponent mapData) {
        this.mapData = mapData;
    }
}
