package CocenptGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DungeonGame {
    private static int characterX;
    private static int characterY;

    private static int door = 0;

    private static float zoom = 2.0f; // Fixed zoom factor

    private static BufferedImage boardImage;
    private static BufferedImage floorImage;
    private static BufferedImage verticalWallImage;
    private static BufferedImage horizontalWallImage;
    private static BufferedImage startImage;
    private static BufferedImage exitImage;
    private static BufferedImage doorImage;
    private static BufferedImage openDoorImage;
    private static BufferedImage chestImage;
    private static BufferedImage openChestImage;
    private static BufferedImage[] characterWalkFrames;

    private static int currentAnimationFrame = 0;

    public static void main(String[] args) {
        int cellSize = 16; // Size of each cell in pixels

        int width = 31;
        int height = 31;
        char[][] dungeon = generateDungeon(width, height);

        try {
            boardImage = ImageIO.read(new File("./res/assets/board(0).png"));
            floorImage = ImageIO.read(new File("./res/assets/floor(0).png"));
            doorImage = ImageIO.read(new File("./res/assets/door(0).png"));
            openDoorImage = ImageIO.read(new File("./res/assets/door(1).png"));
            chestImage = ImageIO.read(new File("./res/assets/chest(0).png"));
            openChestImage = ImageIO.read(new File("./res/assets/chest(1).png"));
            verticalWallImage = ImageIO.read(new File("./res/assets/wall(1).png"));
            horizontalWallImage = ImageIO.read(new File("./res/assets/wall(0).png"));
            startImage = ImageIO.read(new File("./res/assets/start(0).png"));
            exitImage = ImageIO.read(new File("./res/assets/exit(0).png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            characterWalkFrames = new BufferedImage[12]; // Número de frames da animação
            characterWalkFrames[0] = ImageIO.read(new File("./res/assets/down(0).png"));
            characterWalkFrames[1] = ImageIO.read(new File("./res/assets/down(1).png"));
            characterWalkFrames[2] = ImageIO.read(new File("./res/assets/down(2).png"));
            characterWalkFrames[3] = ImageIO.read(new File("./res/assets/up(0).png"));
            characterWalkFrames[4] = ImageIO.read(new File("./res/assets/up(1).png"));
            characterWalkFrames[5] = ImageIO.read(new File("./res/assets/up(2).png"));
            characterWalkFrames[6] = ImageIO.read(new File("./res/assets/left(0).png"));
            characterWalkFrames[7] = ImageIO.read(new File("./res/assets/left(1).png"));
            characterWalkFrames[8] = ImageIO.read(new File("./res/assets/left(2).png"));
            characterWalkFrames[9] = ImageIO.read(new File("./res/assets/right(0).png"));
            characterWalkFrames[10] = ImageIO.read(new File("./res/assets/right(1).png"));
            characterWalkFrames[11] = ImageIO.read(new File("./res/assets/right(2).png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> createAndShowGUI(dungeon, cellSize));
    }

    public static char[][] generateDungeon(int width, int height) {
        Random random = new Random();

        // Tileset do Mapa
        final char BOARD = '\u25A0';
        final char WALL = '#';
        final char VERTICAL_WALL = '║';
        final char HORIZONTAL_WALL = '═';
        final char FLOOR = '.';
        final char DOOR = 'D';
        final char CHEST = 'C';
        final char START = 'S';
        final char EXIT = 'E';

        final double DOOR_PROBABILITY = 0.1;
        final double CHEST_PROBABILITY = 0.02;

        char[][] dungeon = new char[height][width];

        // Initialize the dungeon with walls
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x == 0 || x == width - 1 || y == 0 || y == width - 1) {
                    dungeon[x][y] = BOARD;
                } else {
                    dungeon[y][x] = WALL;
                }
            }
        }

        int startX = width / 2;
        int startY = height / 2;

        // Call the recursive backtracking algorithm to generate the maze
        recursiveBacktracking(dungeon, startX, startY);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (dungeon[x][y] == FLOOR) {
                    boolean surroundedByWalls = false;
                    if ((x > 0 && x < width - 1) && dungeon[x - 1][y] == WALL && dungeon[x + 1][y] == WALL) {
                        surroundedByWalls = true;
                    }
                    if ((y > 0 && y < height - 1) && dungeon[x][y - 1] == WALL && dungeon[x][y + 1] == WALL) {
                        surroundedByWalls = true;
                    }
                    if (surroundedByWalls) {
                        if (Math.random() < DOOR_PROBABILITY) {
                            dungeon[x][y] = DOOR;
                        }
                    }
                }
                if (dungeon[x][y] == FLOOR) {
                    if (Math.random() < CHEST_PROBABILITY) {
                        dungeon[x][y] = CHEST;
                    }
                }
            }
        }

        // Set the entrance and exit
        dungeon[startY][startX] = START; // Start

        int exitX, exitY;
        do {
            exitX = random.nextInt(width);
            exitY = random.nextInt(height);
        } while (dungeon[exitY][exitX] == WALL || dungeon[exitX][exitY] == START || dungeon[exitX][exitY] == DOOR
                || dungeon[exitX][exitY] == CHEST || dungeon[exitX][exitY] == BOARD);

        dungeon[exitY][exitX] = EXIT; // End

        // Set character's initial position to the entrance
        characterX = startX;
        characterY = startY;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (dungeon[x][y] == WALL) {
                    if (dungeon[x + 1][y] == WALL)
                        dungeon[x][y] = VERTICAL_WALL;

                    if (dungeon[x - 1][y] == WALL)
                        dungeon[x][y] = VERTICAL_WALL;

                    if (dungeon[x + 1][y] == BOARD)
                        dungeon[x][y] = VERTICAL_WALL;

                    if (dungeon[x + 1][y] == BOARD)
                        dungeon[x][y] = VERTICAL_WALL;
                }
            }
        }
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (dungeon[x][y] == WALL) {
                    dungeon[x][y] = HORIZONTAL_WALL;
                }
            }
        }

        return dungeon;
    }

    private static void recursiveBacktracking(char[][] dungeon, int x, int y) {
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        int[] directions = { 0, 1, 2, 3 };
        shuffleArray(directions);

        for (int dir : directions) {
            int nx = x + dx[dir] * 2;
            int ny = y + dy[dir] * 2;

            if (nx >= 0 && nx < dungeon[0].length && ny >= 0 && ny < dungeon.length && dungeon[ny][nx] == '#') {
                dungeon[y + dy[dir]][x + dx[dir]] = '.';
                dungeon[ny][nx] = '.';
                recursiveBacktracking(dungeon, nx, ny);
            }
        }
    }

    private static void shuffleArray(int[] arr) {
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    private static void createAndShowGUI(char[][] dungeon, int cellSize) {
        JFrame frame = new JFrame("Dungeons of Latserolf");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900, 600));
        frame.setResizable(false);
        frame.setLayout(new GridBagLayout());
        
        // Defina a cor de fundo do JFrame
        frame.getContentPane().setBackground(new Color(23, 17, 26)); // #17111a
    
        DungeonPanel dungeonPanel = new DungeonPanel(dungeon, cellSize, characterX, characterY);
    
        JLabel combatLabel = new JLabel("START");
        combatLabel.setBackground(new Color(23, 17, 26));
        combatLabel.setForeground(Color.WHITE);
        combatLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Font customFont = new Font("JetBrains Mono", Font.BOLD, 24);
        combatLabel.setFont(customFont);
    
        JLabel doorOpens = new JLabel("DOORS & CHESTS : " + door);
        doorOpens.setBackground(new Color(23, 17, 26));
        doorOpens.setForeground(Color.WHITE);
        doorOpens.setHorizontalAlignment(SwingConstants.CENTER);
        doorOpens.setFont(customFont);
    
        // Defina a cor de fundo dos JLabels
        combatLabel.setOpaque(true);
        doorOpens.setOpaque(true);
    
        // Set constraints for dungeonPanel
        GridBagConstraints gbcDungeonPanel = new GridBagConstraints();
        gbcDungeonPanel.gridx = 0;
        gbcDungeonPanel.gridy = 0;
        gbcDungeonPanel.weightx = 1.0;
        gbcDungeonPanel.weighty = 1.0;
        gbcDungeonPanel.fill = GridBagConstraints.BOTH;
        frame.add(dungeonPanel, gbcDungeonPanel);
    
        // Set constraints for combatLabel
        GridBagConstraints gbcCombatLabel = new GridBagConstraints();
        gbcCombatLabel.gridx = 0;
        gbcCombatLabel.gridy = 1;
        gbcCombatLabel.weightx = 1.0;
        gbcCombatLabel.fill = GridBagConstraints.HORIZONTAL;
        frame.add(combatLabel, gbcCombatLabel);
    
        // Set constraints for doorOpens
        GridBagConstraints gbcDoorOpens = new GridBagConstraints();
        gbcDoorOpens.gridx = 0;
        gbcDoorOpens.gridy = 2;
        gbcDoorOpens.weightx = 1.0;
        gbcDoorOpens.fill = GridBagConstraints.HORIZONTAL;
        frame.add(doorOpens, gbcDoorOpens);
    
        frame.pack();
        frame.setVisible(true);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                if (keyCode == KeyEvent.VK_A) {
                    moveCharacter(-1, 0, dungeonPanel, cellSize, combatLabel, doorOpens);
                } else if (keyCode == KeyEvent.VK_D) {
                    moveCharacter(1, 0, dungeonPanel, cellSize, combatLabel, doorOpens);
                } else if (keyCode == KeyEvent.VK_W) {
                    moveCharacter(0, -1, dungeonPanel, cellSize, combatLabel, doorOpens);
                } else if (keyCode == KeyEvent.VK_S) {
                    moveCharacter(0, 1, dungeonPanel, cellSize, combatLabel, doorOpens);
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // Not needed for this example
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Not needed for this example
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);
        frame.requestFocusInWindow();
    }

    static class DungeonPanel extends JPanel {
        private final char[][] dungeon;
        private final int cellSize;
        private int characterX;
        private int characterY;

        DungeonPanel(char[][] dungeon, int cellSize, int characterX, int characterY) {
            this.dungeon = dungeon;
            this.cellSize = cellSize;
            this.characterX = dungeon[0].length / 2;
            this.characterY = dungeon[0].length / 2;

            int panelWidth = (int) (dungeon[0].length * cellSize * zoom);
            int panelHeight = (int) (dungeon.length * cellSize * zoom);
            setPreferredSize(new Dimension(panelHeight, panelWidth));
        }

        void setCharacterPosition(int characterX, int characterY) {
            this.characterX = characterX;
            this.characterY = characterY;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int panelWidth = getWidth();
            int panelHeight = getHeight();

            int dungeonWidth = (int) (dungeon[0].length * cellSize * zoom);
            int dungeonHeight = (int) (dungeon.length * cellSize * zoom);

            int halfPanelWidth = panelWidth / 2;
            int halfPanelHeight = panelHeight / 2;

            // Calculate the camera offset based on the character's position
            int xOffset = (int) Math.max(0,
                    Math.min(characterX * cellSize * zoom - halfPanelWidth, dungeonWidth - panelWidth));
            int yOffset = (int) Math.max(0,
                    Math.min(characterY * cellSize * zoom - halfPanelHeight, dungeonHeight - panelHeight));

            Graphics2D g2d = (Graphics2D) g;
            g2d.scale(zoom, zoom);

            for (int y = 0; y < dungeon.length; y++) {
                for (int x = 0; x < dungeon[0].length; x++) {
                    int cellX = (int) (x * cellSize - xOffset / zoom);
                    int cellY = (int) (y * cellSize - yOffset / zoom);

                    char cell = dungeon[y][x];
                    BufferedImage image = null;

                    switch (cell) {
                        case 'C':
                            image = chestImage;
                            break;
                        case '\u25A0':
                            image = boardImage;
                            break;
                        case '║':
                            image = verticalWallImage;
                            break;
                        case '═':
                            image = horizontalWallImage;
                            break;
                        case 'S':
                            image = startImage;
                            break;
                        case 'E':
                            image = exitImage;
                            break;
                        case 'D':
                            image = doorImage;
                            break;
                        case 'O':
                            image = openDoorImage;
                            break;
                        case '.':
                            image = floorImage;
                            break;
                        case 'I':
                            image = openChestImage;
                            break;
                    }

                    if (image != null) {
                        g2d.drawImage(image, cellX, cellY, this);
                    }
                }
            }

            int characterXPosition = (int) ((characterX * cellSize) - xOffset / zoom);
            int characterYPosition = (int) ((characterY * cellSize) - yOffset / zoom);
            g2d.drawImage(characterWalkFrames[currentAnimationFrame], characterXPosition, characterYPosition, this);
        }
    }

    private static void moveCharacter(int dx, int dy, DungeonPanel dungeonPanel, int cellSize, JLabel combatLabel,
            JLabel doorOpens) {
        int newCharacterX = characterX + dx;
        int newCharacterY = characterY + dy;

        if (isValidMove(newCharacterX, newCharacterY, dungeonPanel.dungeon)) {
            if (dx > 0) {
                currentAnimationFrame = (currentAnimationFrame + 1) % 3 + 9; // Direita
            } else if (dx < 0) {
                currentAnimationFrame = (currentAnimationFrame + 1) % 3 + 6; // Esquerda
            } else if (dy > 0) {
                currentAnimationFrame = (currentAnimationFrame + 1) % 3; // Baixo
            } else if (dy < 0) {
                currentAnimationFrame = (currentAnimationFrame + 1) % 3 + 3; // Cima
            }

            if (dungeonPanel.dungeon[newCharacterY][newCharacterX] == 'S') {
                combatLabel.setText("START");
            } else if (dungeonPanel.dungeon[newCharacterY][newCharacterX] == 'E') {
                combatLabel.setText("EXIT");
            } else if (dungeonPanel.dungeon[newCharacterY][newCharacterX] == 'D') {
                door++;
                combatLabel.setText("DOOR");
                dungeonPanel.dungeon[newCharacterY][newCharacterX] = 'O';
                doorOpens.setText("DOORS & CHESTS : " + door);
            } else if (dungeonPanel.dungeon[newCharacterY][newCharacterX] == 'C') {
                door++;
                combatLabel.setText("CHEST");
                dungeonPanel.dungeon[newCharacterY][newCharacterX] = 'I';
                doorOpens.setText("DOORS & CHESTS : " + door);
            } else {
                combatLabel.setText("ADVENTURE");
            }

            characterX = newCharacterX;
            characterY = newCharacterY;
            dungeonPanel.setCharacterPosition(characterX, characterY); // Atualizar a posição no painel
        }
    }

    private static boolean isValidMove(int x, int y, char[][] dungeon) {
        return x >= 0 && x < dungeon[0].length && y >= 0 && y < dungeon.length
                && (dungeon[y][x] != '║' && dungeon[y][x] != '═' && dungeon[y][x] != '\u25A0');
    }
}
