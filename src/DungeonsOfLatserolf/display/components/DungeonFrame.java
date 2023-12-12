package DungeonsOfLatserolf.display.components;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import DungeonsOfLatserolf.map.MapEntity;
import DungeonsOfLatserolf.entity.player.PlayerEntity;;

public class DungeonFrame extends JPanel {
    private MapEntity mapEntity;
    private PlayerEntity playerEntity;
    private boolean[][] visibleTiles;
    private String playerDirection = "down";
    private int playerDirectionNum = 0;

    private float zoom;
    private int cellSize;

    public DungeonFrame(MapEntity mapEntity, PlayerEntity playerEntity) {
        zoom = 5.0f;
        cellSize = 16;

        this.mapEntity = mapEntity;
        this.playerEntity = playerEntity;

        int dy = mapEntity.getMapData().getSizeMap()[0];
        int dx = mapEntity.getMapData().getSizeMap()[1];

        int panelWidth = (int) (dy * cellSize * zoom);
        int panelHeight = (int) (dx * cellSize * zoom);

        visibleTiles = new boolean[dy][dx];

        setBackground(new Color(23, 17, 26));
        setPreferredSize(new Dimension(panelHeight, panelWidth));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int dungeonWidth = (int) (mapEntity.getMapData().getSizeMap()[0] * cellSize * zoom);
        int dungeonHeight = (int) (mapEntity.getMapData().getSizeMap()[1] * cellSize * zoom);

        int halfPanelWidth = panelWidth / 2;
        int halfPanelHeight = panelHeight / 2;

        int dx = mapEntity.getMapData().getSizeMap()[0];
        int dy = mapEntity.getMapData().getSizeMap()[1];

        int characterX = playerEntity.getPositionPlayer()[0];
        int characterY = playerEntity.getPositionPlayer()[1];

        int xOffset = (int) (characterX * cellSize * zoom - halfPanelWidth);
        int yOffset = (int) (characterY * cellSize * zoom - halfPanelHeight);

        xOffset = Math.max(0, Math.min(xOffset, dungeonWidth - panelWidth));
        yOffset = Math.max(0, Math.min(yOffset, dungeonHeight - panelHeight));

        BufferedImage playerImage = getPlayerImage();

        Graphics2D g2d = (Graphics2D) g;
        g2d.scale(zoom - 0.3, zoom - 0.6);

        for (int i = -1; i < 2; i++)
            for (int j = -1; j < 2; j++)
                visibleTiles[i + playerEntity.getPositionPlayer()[0]][j + playerEntity.getPositionPlayer()[1]] = true;

        for (int x = 0; x < dx; x++) {
            for (int y = 0; y < dy; y++) {
                int cellX = (int) (x * cellSize - xOffset / zoom);
                int cellY = (int) (y * cellSize - yOffset / zoom);

                BufferedImage image = mapEntity.getMap()[x][y].getAssetImage();

                if (image != null) {
                    if (visibleTiles[x][y])
                        g2d.drawImage(image, cellX, cellY, this);
                    else
                        g2d.drawImage(mapEntity.getMapSystem().getImagemDoSistema().getImage("board(0)"), cellX, cellY,
                                this);
                }

                // g2d.drawImage(image, cellX, cellY, this);

            }
        }

        int characterXPosition = (int) ((characterX * cellSize) - xOffset / zoom);
        int characterYPosition = (int) ((characterY * cellSize) - yOffset / zoom);

        g2d.drawImage(playerImage, characterXPosition, characterYPosition, this);
    }

    protected BufferedImage getPlayerImage() {
        return mapEntity.getMapSystem().getImagemDoSistema().getImage(playerDirection + "(" + playerDirectionNum + ")");
    }

    public void setPlayerDirection(String playerDirection) {
        this.playerDirection = playerDirection;
    }

    public String getPlayerDirection() {
        return playerDirection;
    }

    public void setPlayerDirectionNum(int playerDirectionNum) {
        this.playerDirectionNum = playerDirectionNum;
    }

    public int getPlayerDirectionNum() {
        return playerDirectionNum;
    }
}
