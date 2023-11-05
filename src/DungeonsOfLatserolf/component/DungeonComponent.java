package DungeonsOfLatserolf.component;

import java.util.Random;

import DungeonsOfLatserolf.Main;

public class DungeonComponent {
    private static final int WIDTH = 31;
    private static final int HEIGHT = 31;
    private static final double DOOR_PROBABILITY = 0.1;
    private static final double MONSTER_PROBABILITY = 0.1;
    private static final double CHEST_PROBABILITY = 0.01;
    private static final char BOARD = 'O';
    private static final char WALL = '#';
    private static final char FLOOR = '.';
    private static final char DOOR = 'D';
    private static final char CHEST = 'C';
    private static final char MONSTER = 'M';
    private static final char START = 'S';
    private static final char EXIT = 'E';
    private char DungeonComponent[][];

    public DungeonComponent() {
        this.DungeonComponent = new char[WIDTH][HEIGHT];
    }

    public void showDungeonComponent() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                System.out.printf("%c ", this.DungeonComponent[x][y]);
            }
            System.out.println();
        }
    }

    public void generateDungeonComponent() {
        Random random = new Random();

        int startX = WIDTH / 2;
        int startY = HEIGHT / 2;
        System.out.println(startX);
        System.out.println(startY);

        int exitX = random.nextInt(WIDTH - 2) + 1;
        int exitY = random.nextInt(WIDTH - 2) + 1;

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (x == 0 || x == WIDTH - 1 || y == 0 || y == HEIGHT - 1) {
                    this.DungeonComponent[x][y] = BOARD;
                } else {
                    this.DungeonComponent[x][y] = WALL;
                }
            }
        }
        
        backtrackingDungeonComponent(this.DungeonComponent, startX, startY);

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (DungeonComponent[x][y] == FLOOR) {
                    if (Math.random() < MONSTER_PROBABILITY) {
                        DungeonComponent[x][y] = MONSTER;
                    }
                }
                if (DungeonComponent[x][y] == FLOOR) {
                    if (Math.random() < CHEST_PROBABILITY) {
                        DungeonComponent[x][y] = CHEST;
                    }
                }
            }
        }

        DungeonComponent[startX][startY] = START;
    }

    private void backtrackingDungeonComponent(char[][] DungeonComponent, int startX, int startY) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int[] directions = {0, 1, 2, 3};
        shuffleDirections(directions);
        for (int dir : directions) {
            int nx = startX + dx[dir] * 2;
            int ny = startY + dy[dir] * 2;
            if (nx >= 0 && nx < DungeonComponent[0].length && ny >= 0 && ny < DungeonComponent[0].length && DungeonComponent[nx][ny] == WALL) {
                DungeonComponent[startX + dx[dir]][startY + dy[dir]] = FLOOR;
                DungeonComponent[nx][ny] = FLOOR;
                backtrackingDungeonComponent(DungeonComponent, nx, ny);
            }
        }
    }

    private static void shuffleDirections(int[] directions) {
        Random random = new Random();
        for (int i = directions.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = directions[index];
            directions[index] = directions[i];
            directions[i] = temp;
        }
    }
}