package DungeonsOfLatserolf.display.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.image.BufferedImage;

import DungeonsOfLatserolf.display.Display;
import DungeonsOfLatserolf.map.MapEntity;
import DungeonsOfLatserolf.map.tile.Wall;
import DungeonsOfLatserolf.entity.player.PlayerEntity;
import DungeonsOfLatserolf.map.tile.*;;


public class Dungeon extends JPanel {
    private MapEntity mapEntity;
    private PlayerEntity playerEntity;
    private boolean[][] visitados;

    private float zoom;
    private int cellSize;

    public Dungeon(MapEntity mapEntity, PlayerEntity playerEntity) {
        zoom = 4.0f;
        cellSize = 16;

        this.mapEntity = mapEntity;
        this.playerEntity = playerEntity;

        int dy = mapEntity.getMapData().getSizeMap()[0];
        int dx = mapEntity.getMapData().getSizeMap()[1];

        int panelWidth = (int) (dy * cellSize * zoom);
        int panelHeight = (int) (dx * cellSize * zoom);

        visitados = new boolean[dy][dx];
        
        setPreferredSize(new Dimension(panelHeight, panelWidth));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int dungeonWidth = panelWidth;
        int dungeonHeight = panelHeight;

        int halfPanelWidth = panelWidth / 2;
        int halfPanelHeight = panelHeight / 2;

        int dx = mapEntity.getMapData().getSizeMap()[0];
        int dy = mapEntity.getMapData().getSizeMap()[1];

        int characterX = playerEntity.getPositionPlayer()[0];
        int characterY = playerEntity.getPositionPlayer()[1];

        // Calculate the camera offset based on the character's position
        int xOffset = (int) Math.max(0,
                Math.min(characterX * cellSize * zoom - halfPanelWidth, dungeonWidth - panelWidth));
        int yOffset = (int) Math.max(0,
                Math.min(characterY * cellSize * zoom - halfPanelHeight, dungeonHeight - panelHeight));

        

        Graphics2D g2d = (Graphics2D) g;
        g2d.scale(zoom, zoom);

        for (int i = -1; i < 2; i++)
            for(int j = -1; j < 2; j++)
                visitados[i+playerEntity.getPositionPlayer()[0]][j+playerEntity.getPositionPlayer()[1]] = true;

        for (int x = 0; x < dx ; x++) {
            for (int y = 0; y < dy; y++) {
                int cellX = (int) (x * cellSize - xOffset / zoom);
                int cellY = (int) (y * cellSize - yOffset / zoom);

                BufferedImage image = mapEntity.getMap()[x][y].getAssetImage();

                if (image != null) {
                    if(visitados[x][y])
                        // g2d.drawImage(image, x * cellSize, y * cellSize, this);
                        g2d.drawImage(image, cellX, cellY, this);
                    else
                        // g2d.drawImage(mapEntity.getMapSystem().getImagemDoSistema().getImage("board(0)"), x * cellSize, y * cellSize, this);
                        g2d.drawImage(mapEntity.getMapSystem().getImagemDoSistema().getImage("board(0)"), cellX, cellY, this);
                }
            }
        }

        int characterXPosition = (int) ((characterX * cellSize) - xOffset / zoom);
        int characterYPosition = (int) ((characterY * cellSize) - yOffset / zoom);
        
        // g2d.drawImage(mapEntity.getMapSystem().getImagemDoSistema().getImage("down(0)"), characterX* cellSize, characterY* cellSize, this);
        g2d.drawImage(mapEntity.getMapSystem().getImagemDoSistema().getImage("down(0)"), characterXPosition, characterYPosition, this);
        
    }
}
