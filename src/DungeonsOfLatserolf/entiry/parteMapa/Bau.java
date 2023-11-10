package DungeonsOfLatserolf.entiry.parteMapa;

public class Bau extends PartesMapa{

    private boolean key;
    private boolean open;

    public Bau(boolean key, int x, int y) {
        super('B', x, y);
        this.key = key;
        this.open = false;
    }

    public boolean getDrop() {
        return key;
    }

    public void setDrop(boolean key) {
        this.key = key;
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
