package DungeonsOfLatserolf.map;


public class MapData {
    private int level;
    private int width;
    private int height;
    private int totalKeys;
    private boolean isCompleted;

    public MapData(int level, int width, int height, int totalKeys,
            boolean isCompleted) {
        this.level = level;
        this.width = width;
        this.height = height;
        this.totalKeys = totalKeys;
        this.isCompleted = isCompleted;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getTotalKeys() {
        return totalKeys;
    }

    public void setTotalKeys(int totalKeys) {
        this.totalKeys = totalKeys;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
}
