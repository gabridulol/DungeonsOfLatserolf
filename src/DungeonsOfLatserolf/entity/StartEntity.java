package DungeonsOfLatserolf.entity;

import DungeonsOfLatserolf.component.TileComponent;

public class StartEntity extends TileTypeEntity{
    public boolean isUnlocked;
    
    public StartEntity(int x, int y) {
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
