package DungeonsOfLatserolf.entiry.parteMapa;

public class Chao extends PartesMapa{

    public Chao(int x, int y) {
        super('C', x, y);
    }

    @Override
    public boolean verificaTile() {
        return true;
    }
}
