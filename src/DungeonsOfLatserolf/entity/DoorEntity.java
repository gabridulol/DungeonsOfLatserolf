package DungeonsOfLatserolf.entity;

import DungeonsOfLatserolf.component.TileComponent;

public class DoorEntity extends TileTypeEntity{
    
    private boolean monster;
    private boolean open;

    public DoorEntity(boolean monster) {
        super(TileComponent.SIMPLE_DOOR);
        this.monster = monster;
        this.open = false;
    }

    public boolean verificaAbertura() {
        return this.open;
    }

    public boolean getMonster() {
        return monster;
    }

    public void setMonster(boolean monster) {
        this.monster = monster;
    }

    public boolean getOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public boolean isWalkable() {
        if (this.open) {
            return true;
        }

        return false;
    }

    @Override
    public boolean isInteractable(){
        if (this.open) {
            return false;
        }
        return true;
    }
}
