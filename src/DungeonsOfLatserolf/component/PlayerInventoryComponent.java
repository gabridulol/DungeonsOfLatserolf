package DungeonsOfLatserolf.component;

public class PlayerInventoryComponent {
    private int totalGoldPieces;
    private int totalKeys;

    public PlayerInventoryComponent() {
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
