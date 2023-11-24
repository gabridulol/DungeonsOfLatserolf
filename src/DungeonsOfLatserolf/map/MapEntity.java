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

    public void setMap(TileTypeEntity[][] map) {
        this.map = map;
    }

    public void buildMap() {
        mapSystem.buildDungeon(map);
    }

    // public boolean 

}
