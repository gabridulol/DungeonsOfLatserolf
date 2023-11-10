package DungeonsOfLatserolf.entity;

import DungeonsOfLatserolf.component.TileComponent;

public class StartEntity extends TileTypeEntity{
    
    public StartEntity(int x, int y) {
        super(TileComponent.START);
    }

    // public verificaAbertura

    // @Override
    // public boolean verificaTile() {
    //     return true;
    // }

    @Override
    public boolean isWalkable() {
        return true;
    }

    @Override
    public boolean isInteractable(){
        return true;
    }
}
