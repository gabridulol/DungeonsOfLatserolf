package DungeonsOfLatserolf.component;

import java.util.ArrayList;

public class DataDungeonLevelMapComponent {
    private int level;
    private ArrayList<Integer> size;
    private int totalKeys;
    private boolean isCompleted;

    public DataDungeonLevelMapComponent(int level, int width, int height, int totalKeys, boolean isCompleted) {
        this.level = level;
        this.size = new ArrayList<Integer>(2);
        this.size.add(width);
        this.size.add(height);
        this.totalKeys = totalKeys;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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