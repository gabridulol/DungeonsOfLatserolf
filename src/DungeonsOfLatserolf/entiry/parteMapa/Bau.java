package DungeonsOfLatserolf.entiry.parteMapa;

public class Bau extends PartesMapa{

    private boolean key;

    public Bau(boolean key, int x, int y) {
        super('B', x, y);
        this.key = key;
    }

    public boolean getDrop() {
        return key;
    }

    public void setDrop(boolean key) {
        this.key = key;
    }
}
