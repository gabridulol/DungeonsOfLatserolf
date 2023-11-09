package DungeonsOfLatserolf.entiry.parteMapa;

public abstract class PartesMapa {
    private char tiel;
    private int posicaoX;
    private int posicaoY;

    public PartesMapa(char tiel, int posicaoX, int posicaoY) {
        this.tiel = tiel;
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
    }

    public boolean verificaTile(){
            return false;
    }

    public char getTiel() {
        return tiel;
    }

    public void setTiel(char tiel) {
        this.tiel = tiel;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }
}
