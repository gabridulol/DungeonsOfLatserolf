package DungeonsOfLatserolf.entiry.parteMapa;

public class Saida extends PartesMapa{
    
    public Saida(int x, int y) {
        super('S', x, y);
    }

    // public verificaAbertura

    @Override
    public boolean verificaTile() {
        return true;
    }
}
