package DungeonsOfLatserolf.entity;

import DungeonsOfLatserolf.component.MapDataComponent;

public class MapEntity {
    MapDataComponent mapDataComponent;

    public MapEntity() {
        this.mapDataComponent = new MapDataComponent();
    }

    public MapEntity(MapDataComponent mapDataComponent) {
        this.mapDataComponent = mapDataComponent;
    }

    public MapDataComponent getMapDataComponent() {
        return mapDataComponent;
    }

    public void setMapDataComponent(MapDataComponent mapDataComponent) {
        this.mapDataComponent = mapDataComponent;
    }
}
