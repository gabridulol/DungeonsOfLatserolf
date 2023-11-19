package DungeonsOfLatserolf.map.tile;

public class Wall extends TileTypeEntity{
    public Wall() {
        super(TileComponent.WALL);
    }
    
    @Override
    public boolean isWalkable() {
        return false;
    }

    @Override
    public boolean isInteractable(){
        return false;
    }
}
