package DungeonsOfLatserolf.map;

import DungeonsOfLatserolf.map.tile.*;

import java.util.Random;

import DungeonsOfLatserolf.graphics.AssetImage;
import DungeonsOfLatserolf.graphics.AssetLibrary;
import DungeonsOfLatserolf.map.MapData;

public class MapGeneratorSystem {
    private MapData mapData;
    private AssetLibrary imagens;

    public MapGeneratorSystem(AssetLibrary imagens) {
        this.mapData = new MapData(31, 31, 3, 1);
        this.imagens = imagens;
    }

    public MapData getMapData() {
        return mapData;
    }

    public void setMapData(MapData mapData) {
        this.mapData = mapData;
    }

    public AssetLibrary getImagemDoSistema() {
        return imagens;
    }

    private void
    // private TileTypeEntity[][]
    buildWallTileDungeon(TileTypeEntity dungeonMap[][]){
        int width = mapData.getSizeMap()[1];
        int height = mapData.getSizeMap()[0];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (x == 0 || x == width - 1 || y == 0 || y == height - 1) { //borda
                    if (x == 0 || x == width - 1)
                        dungeonMap[x][y] = new Wall(imagens.getImage("wall(1)"));
                    else
                        dungeonMap[x][y] = new Wall(imagens.getImage("wall(0)"));

                    // System.out.println("wall");
                } 

                else {
                    dungeonMap[x][y] = new Wall(imagens.getImage("wall(1)"));
                    // System.out.println("wall");
                }
            }
        }
        
        // return dungeonMap;

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

    private void 
    // private TileTypeEntity[][]
    buildTileDungeon(TileTypeEntity dungeonMap[][]) {
        int width = mapData.getSizeMap()[1];
        int height = mapData.getSizeMap()[0];
        Random random = new Random();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (dungeonMap[x][y] instanceof Floor) {
                    boolean surroundedByWalls = false;

                    if ((x > 0 && x < width - 1) && dungeonMap[x - 1][y] instanceof Wall && dungeonMap[x + 1][y] instanceof Wall) {
                        surroundedByWalls = true;
                    }
                    
                    if ((y > 0 && y < height - 1) && dungeonMap[x][y - 1] instanceof Wall && dungeonMap[x][y + 1] instanceof Wall) {
                        surroundedByWalls = true;
                    }

                    if (surroundedByWalls) {
                        if (Math.random() < mapData.getDoorProbability()) {
                            dungeonMap[x][y] = new Door(null, imagens.getImage("door(0)"), imagens.getImage("door(1)"));
                        }
                    }
                }

                if (dungeonMap[x][y] instanceof Floor) {
                    if (Math.random() < mapData.getChestProbability()) {
                        dungeonMap[x][y] = new Chest(imagens.getImage("chest(0)"), imagens.getImage("chest(1)"));
                    }
                }
            }
        }

        // dungeonMap[mapData.getStartPosition()[0]][mapData.getStartPosition()[1]] = new Start(imagens.getImage("start(0)"), null);

        int exitX, exitY;
        do {
            exitX = random.nextInt(width);
            exitY = random.nextInt(height);
        } while (!(dungeonMap[exitY][exitX] instanceof Floor));

        dungeonMap[exitY][exitX] = new Start(imagens.getImage("start(0)"), null); // End

        // return dungeonMap;

    }

    private void
    // private TileTypeEntity[][] 
    buildVerticalWall(TileTypeEntity dungeonMap[][]){

        int width = mapData.getSizeMap()[1];
        int height = mapData.getSizeMap()[0];

        for (int x = 1; x < width-1; x++) {
            for (int y = 1; y < height-1; y++) {
                if (dungeonMap[x][y] instanceof Wall) {
                    if (!(dungeonMap[x][y+1] instanceof Wall))
                        if (dungeonMap[x + 1][y] instanceof Wall || dungeonMap[x - 1][y] instanceof Wall)
                            dungeonMap[x][y] = new Wall(imagens.getImage("wall(0)"));
                }
            }
        }

    }

    private void 
    // private TileTypeEntity[][]
    buildBacktrackingDungeon(TileTypeEntity dungeonMap[][], int x, int y){
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        int[] directions = { 0, 1, 2, 3 };
        shuffleArray(directions);
        for (int dir : directions) {
            int nx = x + dx[dir] * 2;
            int ny = y + dy[dir] * 2;

            if (nx >= 0 && nx < dungeonMap[0].length && ny >= 0 && ny < dungeonMap.length && dungeonMap[ny][nx] instanceof Wall) {
                dungeonMap[y + dy[dir]][x + dx[dir]] = new Floor(imagens.getImage("floor(0)"));
                dungeonMap[ny][nx] = new Floor(imagens.getImage("floor(0)"));
                buildBacktrackingDungeon(dungeonMap, nx, ny);
            }
        }
        // return dungeonMap;
    }


    public TileTypeEntity[][] buildDungeon(TileTypeEntity dungeonMap[][]) {
        // buildDungeonComponent(mapData.getSizeMap()[0], mapData.getSizeMap()[1]);
        dungeonMap = new TileTypeEntity [mapData.getSizeMap()[0]][mapData.getSizeMap()[1]];
        // dungeonMap = 
        buildWallTileDungeon(dungeonMap);
        // dungeonMap = 
        buildBacktrackingDungeon(dungeonMap, mapData.getStartPosition()[0], mapData.getStartPosition()[1]);
        // dungeonMap = 
        buildTileDungeon(dungeonMap);
        // dungeonMap = 
        buildVerticalWall(dungeonMap);


        return dungeonMap;
    }
}

// package DungeonsOfLatserolf;

// import java.util.Random;

// public class DungeonLevelMap {
//     // Mapa
//     // private boolean isExplored;
//     // private TileComponent[][] DungeonComponent;

//     // Tileset do Mapa
//     private static final char BOARD = '\u25A0';
//     private static final char WALL = '#';
//     private static final char VERTICAL_WALL = '║';
//     private static final char HORIZONTAL_WALL = '═';
//     private static final char FLOOR = '.';
//     // private static final char DOOR = 'D';
//     private static final char CHEST = 'C';
//     private static final char MONSTER = 'M';
//     private static final char START = 'S';

//     // Propriedades do Mapa
//     private static final int WIDTH = 31;
//     private static final int HEIGHT = 31;
//     // private static final double DOOR_PROBABILITY = 0.1;
//     private static final double MONSTER_PROBABILITY = 0.1;
//     private static final double CHEST_PROBABILITY = 0.01;
//     private static final int START_X = WIDTH / 2;
//     private static final int START_Y = HEIGHT / 2;

//     // Mapa
//     private char DungeonComponent[][];

//     public DungeonLevelMap() {
//         this.DungeonComponent = new char[WIDTH][HEIGHT];
//         generateDungeonComponent(this.DungeonComponent, START_X, START_Y);

//     }

//     // REMOVER - Será usado somente para testes...
//     public void showDungeonComponent() {
//         for (int x = 0; x < WIDTH; x++) {
//             for (int y = 0; y < HEIGHT; y++) {
//                 System.out.printf("%c ", this.DungeonComponent[x][y]);
//             }
//             System.out.println();
//         }
//     }

//     private void generateDungeonComponent(char[][] DungeonComponent, int startX, int startY) {
//         buildDungeonComponent(DungeonComponent);
//         buildBacktrackingDungeonComponent(DungeonComponent, START_X, START_Y);
//         buildDoorDungeonComponent(DungeonComponent);
//         buildWallTileDungeonComponent(DungeonComponent);
//     }

//     private void buildDungeonComponent(char[][] DungeonComponent) {
//         for (int x = 0; x < WIDTH; x++) {
//             for (int y = 0; y < HEIGHT; y++) {
//                 if (x == 0 || x == WIDTH - 1 || y == 0 || y == HEIGHT - 1) {
//                     DungeonComponent[x][y] = BOARD;
//                 } else {
//                     DungeonComponent[x][y] = WALL;
//                 }
//             }
//         }
//         DungeonComponent[START_X][START_Y] = START;
//     }

//     private void buildBacktrackingDungeonComponent(char[][] DungeonComponent, int startX, int startY) {
//         int[] dx = { 1, -1, 0, 0 };
//         int[] dy = { 0, 0, 1, -1 };
//         int[] directions = { 0, 1, 2, 3 };
//         shuffleDirections(directions);
//         for (int dir : directions) {
//             int nx = startX + dx[dir] * 2;
//             int ny = startY + dy[dir] * 2;
//             if (nx >= 0 && nx < DungeonComponent[0].length && ny >= 0 && ny < DungeonComponent[0].length
//                     && DungeonComponent[nx][ny] == WALL) {
//                 DungeonComponent[startX + dx[dir]][startY + dy[dir]] = FLOOR;
//                 DungeonComponent[nx][ny] = FLOOR;
//                 buildBacktrackingDungeonComponent(DungeonComponent, nx, ny);
//             }
//         }
//     }

//     private void shuffleDirections(int[] directions) {
//         Random random = new Random();
//         for (int i = directions.length - 1; i > 0; i--) {
//             int index = random.nextInt(i + 1);
//             int temp = directions[index];
//             directions[index] = directions[i];
//             directions[i] = temp;
//         }
//     }

//     // UPDATE - Precisa ser melhor elaborado
//     private void buildDoorDungeonComponent(char[][] DungeonComponent) {
//         for (int x = 0; x < WIDTH; x++) {
//             for (int y = 0; y < HEIGHT; y++) {
//                 if (DungeonComponent[x][y] == FLOOR) {
//                     boolean surroundedByWalls = false;
//                     if ((x > 0 && x < WIDTH - 1) && DungeonComponent[x - 1][y] == WALL && DungeonComponent[x + 1][y] == WALL) {
//                         surroundedByWalls = true;
//                     }
//                     if ((y > 0 && y < HEIGHT - 1) && DungeonComponent[x][y - 1] == WALL && DungeonComponent[x][y + 1] == WALL) {
//                         surroundedByWalls = true;
//                     }
//                     if (surroundedByWalls) {
//                         if (Math.random() < MONSTER_PROBABILITY) {
//                             DungeonComponent[x][y] = MONSTER;
//                         }
//                     }
//                 }
//                 if (DungeonComponent[x][y] == FLOOR) {
//                     if (Math.random() < CHEST_PROBABILITY) {
//                         DungeonComponent[x][y] = CHEST;
//                     }
//                 }
//             }
//         }
//     }

//     // UPDATE - Precisa ser melhor elaborado para os tiles que serão utilizados...são utilizados 16 tiles
//     private void buildWallTileDungeonComponent(char[][] DungeonComponent) {
//         for (int x = 0; x < WIDTH; x++) {
//             for (int y = 0; y < HEIGHT; y++) {
//                 if (DungeonComponent[x][y] == WALL) {

//                     if (DungeonComponent[x + 1][y] == WALL)
//                         DungeonComponent[x][y] = VERTICAL_WALL;
                    
//                     if (DungeonComponent[x - 1][y] == WALL)
//                         DungeonComponent[x][y] = VERTICAL_WALL;
                        
//                     if (DungeonComponent[x + 1][y] == BOARD)
//                         DungeonComponent[x][y] = VERTICAL_WALL;
            
//                     if (DungeonComponent[x + 1][y] == BOARD)
//                         DungeonComponent[x][y] = VERTICAL_WALL;
//                 }
//             }
//         }
//         for (int x = 0; x < WIDTH; x++) {
//             for (int y = 0; y < HEIGHT; y++) {
//                 if (DungeonComponent[x][y] == WALL) {
//                     DungeonComponent[x][y] = HORIZONTAL_WALL;
//                 }
//             }
//         }
//     }
// }