package DungeonsOfLatserolf.map;

import DungeonsOfLatserolf.map.tile.*;

import java.util.Random;

import DungeonsOfLatserolf.entity.monster.MonsterGenerator;
import DungeonsOfLatserolf.graphics.AssetLibrary;

public class MapGeneratorSystem {
    private MapData mapData;
    private AssetLibrary imagens;
    private MonsterGenerator monsterGenerator;

    public MapGeneratorSystem(AssetLibrary imagens) {
        // Passar nível para o construtor
        // Gerar níveis de tamanho aleatório - Não implementado
        monsterGenerator = new MonsterGenerator(imagens);
        this.imagens = imagens;

        Random rand = new Random();

        int size = gerarPrimo();
        // size = 7;
        int keys = rand.nextInt(5) + size/5 + 1;

        this.mapData = new MapData(size, size, keys, 1);
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int gerarPrimo(){
        Random rand = new Random();
        int primo = rand.nextInt(101) + 7;
        while(!isPrime(primo)){
            primo = rand.nextInt(101) + 7;
        }
        return primo;
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

    private void buildWallTileDungeon(TileTypeEntity dungeonMap[][]) {
        int width = mapData.getSizeMap()[1];
        int height = mapData.getSizeMap()[0];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (x == 0 || x == width - 1 || y == 0 || y == height - 1) { // borda
                    if (x == 0 || x == width - 1) {
                        dungeonMap[x][y] = new Wall(imagens.getImage("wall(1)"));
                    } else {
                        dungeonMap[x][y] = new Wall(imagens.getImage("wall(0)"));
                    }
                } else {
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
                if (mapData.getStartPosition()[0] != x && mapData.getStartPosition()[1] != y) {
                    if (dungeonMap[x][y] instanceof Floor) {
                        boolean surroundedByWalls = false;

                        if ((x > 0 && x < width - 1) && dungeonMap[x - 1][y] instanceof Wall
                                && dungeonMap[x + 1][y] instanceof Wall) {
                            surroundedByWalls = true;
                        }

                        if ((y > 0 && y < height - 1) && dungeonMap[x][y - 1] instanceof Wall
                                && dungeonMap[x][y + 1] instanceof Wall) {
                            surroundedByWalls = true;
                        }

                        if (surroundedByWalls) {
                            if (Math.random() < mapData.getDoorProbability()) {
                                dungeonMap[x][y] = new Door(monsterGenerator.generateMonster(),
                                        imagens.getImage("door(0)"),
                                        imagens.getImage("door(1)"));
                            }
                        }
                    }

                    if (dungeonMap[x][y] instanceof Floor) {
                        if (Math.random() < mapData.getChestProbability()) {
                            dungeonMap[x][y] = new Chest((random.nextInt(20) + 1) * 10, imagens.getImage("chest(0)"),
                                    imagens.getImage("chest(1)"));
                        }
                    }
                }
            }
        }

        int exitX, exitY;
        do {
            exitX = random.nextInt(width);
            exitY = random.nextInt(height);
        } while (!(dungeonMap[exitY][exitX] instanceof Floor && exitX != mapData.getStartPosition()[0]
                && exitY != mapData.getStartPosition()[1]));

        dungeonMap[exitY][exitX] = new Exit(imagens.getImage("exit(0)"), null, mapData.getKeysMap());
        dungeonMap[mapData.getStartPosition()[1]][mapData.getStartPosition()[0]] = new Floor(
                imagens.getImage("start(0)"));
    }

    private void buildVerticalWall(TileTypeEntity dungeonMap[][]) {

        int width = mapData.getSizeMap()[1];
        int height = mapData.getSizeMap()[0];

        for (int x = 1; x < width - 1; x++) {
            for (int y = 1; y < height - 1; y++) {
                if (dungeonMap[x][y] instanceof Wall) {
                    if (!(dungeonMap[x][y + 1] instanceof Wall))
                        if (dungeonMap[x + 1][y] instanceof Wall || dungeonMap[x - 1][y] instanceof Wall)
                            dungeonMap[x][y] = new Wall(imagens.getImage("wall(0)"));
                }
            }
        }

    }

    private void buildBacktrackingDungeon(TileTypeEntity dungeonMap[][], int x, int y) {
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        int[] directions = { 0, 1, 2, 3 };
        shuffleArray(directions);
        for (int dir : directions) {
            int nx = x + dx[dir] * 2;
            int ny = y + dy[dir] * 2;

            if (nx > 0 && nx < dungeonMap[0].length-1 && ny > 0 && ny < dungeonMap.length-1
                    && dungeonMap[ny][nx] instanceof Wall) {
                dungeonMap[y + dy[dir]][x + dx[dir]] = new Floor(imagens.getImage("floor(0)"));
                dungeonMap[ny][nx] = new Floor(imagens.getImage("floor(0)"));
                buildBacktrackingDungeon(dungeonMap, nx, ny);
            }
        }
    }

    private void buildChestKey(TileTypeEntity dungeonMap[][]) {
        Random random = new Random();
        int keys = 0;

        

        while (keys < mapData.getKeysMap()) {
            int x = random.nextInt(mapData.getSizeMap()[1]);
            int y = random.nextInt(mapData.getSizeMap()[0]);

            if (dungeonMap[y][x] instanceof Floor && !(mapData.getStartPosition()[0] == x
                    && mapData.getStartPosition()[1] == y)) {
                dungeonMap[y][x] = new Chest(imagens.getImage("chest(0)"), imagens.getImage("chest(1)"));
                keys++;
            }
        }
    }

    public TileTypeEntity[][] buildDungeon(TileTypeEntity dungeonMap[][]) {
        dungeonMap = new TileTypeEntity[mapData.getSizeMap()[0]][mapData.getSizeMap()[1]];
        buildWallTileDungeon(dungeonMap);
        buildBacktrackingDungeon(dungeonMap, mapData.getStartPosition()[0], mapData.getStartPosition()[1]);
        buildTileDungeon(dungeonMap);
        buildChestKey(dungeonMap);
        buildVerticalWall(dungeonMap);

        return dungeonMap;
    }
}
