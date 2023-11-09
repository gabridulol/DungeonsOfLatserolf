package DungeonsOfLatserolf.entiry.parteMapa;

public class Porta extends PartesMapa{
    
    private boolean monster;
    private boolean open;

    public Porta(boolean monster, int x, int y) {
        super('P', x, y);
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
    public boolean verificaTile() {
        return true;
    }

    @Override
    public boolean isSafe() {
        if (this.open) {
            return true;
        }

        return false;
    }

    @Override
    public boolean podeInteragir(){
        if (this.open) {
            return false;
        }
        return true;
    }
}
