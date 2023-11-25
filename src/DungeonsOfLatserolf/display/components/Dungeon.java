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
    // private PlayerEntity playerEntity;

    private float zoom;
    private int cellSize;

    public Dungeon(MapEntity mapEntity) {
        zoom = 3.0f;
        cellSize = 16;

        this.mapEntity = mapEntity;
        // this.playerEntity = playerEntity;

        int panelWidth = (int) (mapEntity.getMapData().getSizeMap()[0] * cellSize * zoom);
        int panelHeight = (int) (mapEntity.getMapData().getSizeMap()[1] * cellSize * zoom);
        
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

        // int characterX = playerEntity.getPositionPlayer()[0];
        // int characterY = playerEntity.getPositionPlayer()[1];

        // Calculate the camera offset based on the character's position
        // int xOffset = (int) Math.max(0,
        //         Math.min(characterX * cellSize * zoom - halfPanelWidth, dungeonWidth - panelWidth));
        // int yOffset = (int) Math.max(0,
        //         Math.min(characterY * cellSize * zoom - halfPanelHeight, dungeonHeight - panelHeight));

        Graphics2D g2d = (Graphics2D) g;
        g2d.scale(zoom, zoom);

        for (int x = 0; x < dx ; x++) {
            for (int y = 0; y < dy; y++) {
                // int cellX = (int) (x * cellSize - xOffset / zoom);
                // int cellY = (int) (y * cellSize - yOffset / zoom);
                // mapEntity.getMap()[x][y] = new Wall(mapEntity.getMapSystem().getImagemDoSistema().getImage("wall(0)"));
                // System.out.println("oi");
                // System.out.println(mapEntity.getMap()[x][y].getClass());

                // if (mapEntity.getMap()[x][y] instanceof Wall)
                //     System.out.println("wall");
                
                // if (mapEntity.getMap()[x][y] instanceof Floor)
                //     System.out.println("floor");

                // if (mapEntity.getMap()[x][y] instanceof Door)
                //     System.out.println("door");
                
                // if (mapEntity.getMap()[x][y] instanceof Chest)
                //     System.out.println("chest");
                
                // if (mapEntity.getMap()[x][y] instanceof Start)
                //     System.out.println("start");

                BufferedImage image = mapEntity.getMap()[x][y].getAssetImage();

                if (image != null) {
                    g2d.drawImage(image, x * cellSize, y * cellSize, this);
                }
            }
        }

        // int characterXPosition = (int) ((characterX * cellSize) - xOffset / zoom);
        // int characterYPosition = (int) ((characterY * cellSize) - yOffset / zoom);
        // Scanner sc = new Scanner(System.in);


        // for (int i = 0; i < mapEntity.getMapData().getSizeMap()[0]; i++) {
        //     for(int j = 0; j < mapEntity.getMapData().getSizeMap()[1]; j++) {
        //         if (mapEntity.getMap()[i][j] instanceof Wall) {
        //             System.out.printf("#"); 
        //             // g2d.drawImage(mapEntity.getMapSystem().getImagemDoSistema().getImage("wall(0)"), i, j , this);
        //             // System.out.printf("cont = %d", ((j+1) + ((i) * mapEntity.getMapData().getSizeMap()[0])));
        //         }
        //         if (mapEntity.getMap()[i][j] instanceof Floor) {
        //             System.out.printf("."); 
        //             // g2d.drawImage(mapEntity.getMapSystem().getImagemDoSistema().getImage("floor(0)"), i, j , this);
        //             // System.out.printf("cont = %d", ((j+1) + ((i) * mapEntity.getMapData().getSizeMap()[0])));
        //         }

        //         // }
        //     }
        //     System.out.println();
        // }

        g2d.drawImage(mapEntity.getMapSystem().getImagemDoSistema().getImage("down(0)"), dx/2* cellSize, dy/2* cellSize, this);
    }
}
