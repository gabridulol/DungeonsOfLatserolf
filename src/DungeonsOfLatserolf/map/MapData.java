package DungeonsOfLatserolf.map;

public class MapData {
    private boolean isCompleted;
    private int[] sizeMap = new int[2];
    private int[] startPosition = new int[2];
    private int keysMap;
    private double doorProbability;
    private double monsterProbability;
    private double chestProbability;
    private int level;

    public MapData(int width, int height, int keysMap, int level) {
        isCompleted = false;
        this.sizeMap[0] = width;
        this.sizeMap[1] = height;
        startPosition[0] = width / 2;
        startPosition[1] = height / 2;
        this.keysMap = keysMap;
        doorProbability = 0.2;
        monsterProbability = 0.8;
        chestProbability = 0.1;
        this.level = level;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void completedMap() {
        isCompleted = true;
    }

    public int[] getSizeMap() {
        return sizeMap;
    }

    public void setSizeMap(int[] sizeMap) {
        this.sizeMap = sizeMap;
    }

    public int[] getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int[] startPosition) {
        this.startPosition = startPosition;
    }

    public int getKeysMap() {
        return keysMap;
    }

    public void setKeysMap(int keysMap) {
        this.keysMap = keysMap;
    }

    public double getDoorProbability() {
        return doorProbability;
    }

    public void setDoorProbability(double doorProbability) {
        this.doorProbability = doorProbability;
    }

    public double getMonsterProbability() {
        return monsterProbability;
    }

    public void setMonsterProbability(double monsterProbability) {
        this.monsterProbability = monsterProbability;
    }

    public double getChestProbability() {
        return chestProbability;
    }

    public void setChestProbability(double chestProbability) {
        this.chestProbability = chestProbability;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
