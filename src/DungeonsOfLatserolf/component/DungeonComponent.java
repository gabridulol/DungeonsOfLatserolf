package DungeonsOfLatserolf.component;

import java.util.Random;

public class DungeonComponent {
    // Tileset do Mapa
    private static final char BOARD = '\u25A0';
    private static final char WALL = '#';
    private static final char VERTICAL_WALL = '║';
    private static final char HORIZONTAL_WALL = '═';
    private static final char FLOOR = '.';
    // private static final char DOOR = 'D';
    private static final char CHEST = 'C';
    private static final char MONSTER = 'M';
    private static final char START = 'S';

    // Propriedades do Mapa
    private static final int WIDTH = 31;
    private static final int HEIGHT = 31;
    // private static final double DOOR_PROBABILITY = 0.1;
    private static final double MONSTER_PROBABILITY = 0.1;
    private static final double CHEST_PROBABILITY = 0.01;
    private static final int START_X = WIDTH / 2;
    private static final int START_Y = HEIGHT / 2;

    // Mapa
    private char DungeonComponent[][];

    public DungeonComponent() {
        this.DungeonComponent = new char[WIDTH][HEIGHT];
        generateDungeonComponent(this.DungeonComponent, START_X, START_Y);

    }

    // REMOVER - Será usado somente para testes...
    public void showDungeonComponent() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                System.out.printf("%c ", this.DungeonComponent[x][y]);
            }
            System.out.println();
        }
    }

    private void generateDungeonComponent(char[][] DungeonComponent, int startX, int startY) {
        buildDungeonComponent(DungeonComponent);
        buildBacktrackingDungeonComponent(DungeonComponent, START_X, START_Y);
        buildDoorDungeonComponent(DungeonComponent);
        buildWallTileDungeonComponent(DungeonComponent);
    }

    private void buildDungeonComponent(char[][] DungeonComponent) {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (x == 0 || x == WIDTH - 1 || y == 0 || y == HEIGHT - 1) {
                    DungeonComponent[x][y] = BOARD;
                } else {
                    DungeonComponent[x][y] = WALL;
                }
            }
        }
        DungeonComponent[START_X][START_Y] = START;
    }

    private void buildBacktrackingDungeonComponent(char[][] DungeonComponent, int startX, int startY) {
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        int[] directions = { 0, 1, 2, 3 };
        shuffleDirections(directions);
        for (int dir : directions) {
            int nx = startX + dx[dir] * 2;
            int ny = startY + dy[dir] * 2;
            if (nx >= 0 && nx < DungeonComponent[0].length && ny >= 0 && ny < DungeonComponent[0].length
                    && DungeonComponent[nx][ny] == WALL) {
                DungeonComponent[startX + dx[dir]][startY + dy[dir]] = FLOOR;
                DungeonComponent[nx][ny] = FLOOR;
                buildBacktrackingDungeonComponent(DungeonComponent, nx, ny);
            }
        }
    }

    private void shuffleDirections(int[] directions) {
        Random random = new Random();
        for (int i = directions.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = directions[index];
            directions[index] = directions[i];
            directions[i] = temp;
        }
    }

    // UPDATE - Precisa ser melhor elaborado
    private void buildDoorDungeonComponent(char[][] DungeonComponent) {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (DungeonComponent[x][y] == FLOOR) {
                    boolean surroundedByWalls = false;
                    if ((x > 0 && x < WIDTH - 1) && DungeonComponent[x - 1][y] == WALL && DungeonComponent[x + 1][y] == WALL) {
                        surroundedByWalls = true;
                    }
                    if ((y > 0 && y < HEIGHT - 1) && DungeonComponent[x][y - 1] == WALL && DungeonComponent[x][y + 1] == WALL) {
                        surroundedByWalls = true;
                    }
                    if (surroundedByWalls) {
                        if (Math.random() < MONSTER_PROBABILITY) {
                            DungeonComponent[x][y] = MONSTER;
                        }
                    }
                }
                if (DungeonComponent[x][y] == FLOOR) {
                    if (Math.random() < CHEST_PROBABILITY) {
                        DungeonComponent[x][y] = CHEST;
                    }
                }
            }
        }
    }

    // UPDATE - Precisa ser melhor elaborado para os tiles que serão utilizados...são utilizados 16 tiles
    private void buildWallTileDungeonComponent(char[][] DungeonComponent) {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (DungeonComponent[x][y] == WALL) {

                    if (DungeonComponent[x + 1][y] == WALL)
                        DungeonComponent[x][y] = VERTICAL_WALL;
                    
                    if (DungeonComponent[x - 1][y] == WALL)
                        DungeonComponent[x][y] = VERTICAL_WALL;
                    if (DungeonComponent[x + 1][y] == BOARD)
                        DungeonComponent[x][y] = VERTICAL_WALL;
            
                    if (DungeonComponent[x + 1][y] == BOARD)
                        DungeonComponent[x][y] = VERTICAL_WALL;
                }
            }
        }
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (DungeonComponent[x][y] == WALL) {
                    DungeonComponent[x][y] = HORIZONTAL_WALL;
                }
            }
        }
    }
}