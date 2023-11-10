package DungeonsOfLatserolf.entity;

import DungeonsOfLatserolf.component.TileComponent;

public class WallEntity extends TileTypeEntity{

    public WallEntity() {
        super(TileComponent.WALL);
    }

    // @Override
    // public boolean verificaTile() {
    //     return true;
    // }

    @Override
    public boolean isWalkable() {
        return false;
    }

    @Override
    public boolean isInteractable(){
        return false;
    }
}
