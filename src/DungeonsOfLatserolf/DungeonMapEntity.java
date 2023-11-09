package DungeonsOfLatserolf;

public class DungeonMapEntity {
    private boolean isCompleted;
    private MapComponent dungeonMap;

    public boolean isCompleted() {
        return isCompleted;
    }
    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
    public MapComponent getMapComponent() {
        return mapComponent;
    }
    public void setMapComponent(MapComponent mapComponent) {
        this.mapComponent = mapComponent;
    }
    
}
