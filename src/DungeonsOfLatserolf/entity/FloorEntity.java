package DungeonsOfLatserolf.entity;

import DungeonsOfLatserolf.component.TileComponent;

public class FloorEntity extends TileTypeEntity{
    public FloorEntity() {
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
