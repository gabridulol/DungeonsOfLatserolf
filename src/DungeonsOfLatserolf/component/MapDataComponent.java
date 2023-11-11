package DungeonsOfLatserolf.component;

import java.util.ArrayList;

import DungeonsOfLatserolf.entity.TileTypeEntity;

public class MapDataComponent {
    private int level;
    private TileTypeEntity[][] map;
    private ArrayList<Integer> size;
    private int totalKeys;
    private boolean isCompleted;

    public MapDataComponent() {
        this.level = 0;
        this.map = new TileTypeEntity[0][0];
        this.size = new ArrayList<Integer>(2);
        this.totalKeys = 0;
        this.isCompleted = false;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public TileTypeEntity[][] getMap() {
        return map;
    }

    public void setMap(TileTypeEntity[][] map) {
        this.map = map;
    }

    public ArrayList<Integer> getSize() {
        return size;
    }

    public void setSize(ArrayList<Integer> size) {
        this.size = size;
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
