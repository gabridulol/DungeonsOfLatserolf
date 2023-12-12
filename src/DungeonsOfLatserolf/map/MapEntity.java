package DungeonsOfLatserolf.map;

import DungeonsOfLatserolf.graphics.AssetLibrary;
import DungeonsOfLatserolf.map.tile.TileTypeEntity;

public class MapEntity {
    private MapGeneratorSystem mapSystem;
    private TileTypeEntity[][] map;

    public MapEntity(AssetLibrary imagens) {
        mapSystem = new MapGeneratorSystem(imagens);
    }

    public MapGeneratorSystem getMapSystem() {
        return mapSystem;
    }

    public void setMapSystem(MapGeneratorSystem mapSystem) {
        this.mapSystem = mapSystem;
    }

    public TileTypeEntity[][] getMap() {
        return map;
    }

    public MapData getMapData() {
        return mapSystem.getMapData();
    }

    public void setMap(TileTypeEntity[][] map) {
        this.map = map;
    }

    public void buildMap() {
        map = mapSystem.buildDungeon(map);
    }
}
