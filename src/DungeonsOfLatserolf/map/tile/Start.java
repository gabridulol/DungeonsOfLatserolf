package DungeonsOfLatserolf.map.tile;

public class Start extends TileTypeEntity{
    public boolean isUnlocked;
    
    public Start(int x, int y) {
        super(TileComponent.START);
    }

    @Override
    public boolean isWalkable() {
        return true;
    }

    @Override
    public boolean isInteractable(){
        return true;
    }
}
