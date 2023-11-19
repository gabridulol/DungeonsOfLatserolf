package DungeonsOfLatserolf.map.tile;

public class Floor extends TileTypeEntity{
    public Floor() {
        super(TileComponent.FLOOR);
    }

    @Override
    public boolean isWalkable() {
        return true;
    }

    @Override
    public boolean isInteractable(){
        return false;
    }
}
