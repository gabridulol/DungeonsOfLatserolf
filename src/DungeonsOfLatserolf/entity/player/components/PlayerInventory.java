package DungeonsOfLatserolf.entity.player.components;

public class PlayerInventory {
    private int totalGoldPieces;
    private int totalKeys;

    public PlayerInventory() {
        this.totalGoldPieces = 0;
        this.totalKeys = 0;
    }

    public int getTotalGoldPieces() {
        return totalGoldPieces;
    }

    public void setTotalGoldPieces(int totalGoldPieces) {
        this.totalGoldPieces = totalGoldPieces;
    }

    public int getTotalKeys() {
        return totalKeys;
    }

    public void setTotalKeys(int totalKeys) {
        this.totalKeys = totalKeys;
    }
}
