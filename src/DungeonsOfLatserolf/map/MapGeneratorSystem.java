package DungeonsOfLatserolf.map;

import DungeonsOfLatserolf.map.tile.*;

import java.util.Random;

import DungeonsOfLatserolf.entity.monster.MonsterGenerator;
import DungeonsOfLatserolf.graphics.AssetLibrary;
import DungeonsOfLatserolf.map.MapData;

public class MapGeneratorSystem {
    private MapData mapData;
    private AssetLibrary imagens;
    private MonsterGenerator monsterGenerator;

    public MapGeneratorSystem(AssetLibrary imagens) {
        this.mapData = new MapData(31, 31, 3, 1);
        this.imagens = imagens;
        monsterGenerator = new MonsterGenerator();
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

    private void buildWallTileDungeon(TileTypeEntity dungeonMap[][]){
        int width = mapData.getSizeMap()[1];
        int height = mapData.getSizeMap()[0];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (x == 0 || x == width - 1 || y == 0 || y == height - 1) { //borda
                    if (x == 0 || x == width - 1)
                        dungeonMap[x][y] = new Wall(imagens.getImage("wall(1)"));
                    else
                        dungeonMap[x][y] = new Wall(imagens.getImage("wall(0)"));

                } 

                else {
                    dungeonMap[x][y] = new Wall(imagens.getImage("wall(1)"));
                }
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

    private void buildTileDungeon(TileTypeEntity dungeonMap[][]) {
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
                            dungeonMap[x][y] = new Door(monsterGenerator.generateMonster(), imagens.getImage("door(0)"), imagens.getImage("door(1)"));
                            // System.out.println("Door");
                            // System.out.println(((Door) dungeonMap[x][y]).getMonsterDoor().getName());
                            // System.out.println(((Door) dungeonMap[x][y]).getMonsterDoor().getDescription());
                            // System.out.println(((Door) dungeonMap[x][y]).getMonsterDoor().getAttack());
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

    }

    private void buildVerticalWall(TileTypeEntity dungeonMap[][]){

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

    private void buildBacktrackingDungeon(TileTypeEntity dungeonMap[][], int x, int y){
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
    }


    public TileTypeEntity[][] buildDungeon(TileTypeEntity dungeonMap[][]) {
        // buildDungeonComponent(mapData.getSizeMap()[0], mapData.getSizeMap()[1]);
        dungeonMap = new TileTypeEntity [mapData.getSizeMap()[0]][mapData.getSizeMap()[1]];
        buildWallTileDungeon(dungeonMap);
        buildBacktrackingDungeon(dungeonMap, mapData.getStartPosition()[0], mapData.getStartPosition()[1]);
        buildTileDungeon(dungeonMap);
        buildVerticalWall(dungeonMap);


        return dungeonMap;
    }
}
