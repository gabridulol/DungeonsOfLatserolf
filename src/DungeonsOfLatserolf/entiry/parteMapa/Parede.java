package DungeonsOfLatserolf.entiry.parteMapa;

public class Parede extends PartesMapa{

    public Parede(int x, int y) {
        super('#', x, y);
    }

    @Override
    public boolean verificaTile() {
        return true;
    }

    @Override
    public boolean isSafe() {
        return false;
    }

    @Override
    public boolean podeInteragir(){
        return false;
    }
}
