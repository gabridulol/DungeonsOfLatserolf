package DungeonsOfLatserolf.entiry.parteMapa;

public class Parede extends PartesMapa{

    public Parede(int x, int y) {
        super('#', x, y);
    }

    @Override
    public boolean verificaTile() {
        return true;
    }
}
