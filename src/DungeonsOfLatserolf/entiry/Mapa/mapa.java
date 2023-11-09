package DungeonsOfLatserolf.entiry.Mapa;

import DungeonsOfLatserolf.entiry.parteMapa.PartesMapa;

public class mapa {
    private PartesMapa[][] dungeonMapa;
    private int larguraX;
    private int alturaY;
    private int keys;

    public mapa(int larguraX, int alturaY) {
        this.larguraX = larguraX;
        this.alturaY = alturaY;
        this.dungeonMapa = new PartesMapa[larguraX][alturaY];
        this.keys = 0;
    }

    public boolean gerarMapa(){
        // gerador do mapa
        return false;
    } 

    public boolean movimento(int x, int y){
        if (0 > x || x > larguraX || 0 > y || y > alturaY)
            return false;

        if (dungeonMapa[x][y].isSafe())
            return true;

        return false;
    }

}
