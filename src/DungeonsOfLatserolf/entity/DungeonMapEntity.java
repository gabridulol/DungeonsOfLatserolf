package DungeonsOfLatserolf.entity;

public class DungeonMapEntity {
    private boolean isCompleted;
    private MapComponent ;

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