package DungeonsOfLatserolf.component;

public enum TileComponent {
    BOARD('\u25A0'),
    WALL('#'),
    VERTICAL_WALL('║'),
    HORIZONTAL_WALL('═'),
    FLOOR('.'),
    SIMPLE_DOOR('D'), 
    MONSTER_DOOR('M'),
    OPEN_DOOR('d'),
    CHEST('C'),
    KEY_CHEST('K'),
    OPEN_CHEST('c'),
    START('S');

    private final char tileType;

    TileComponent(char tileType) {
        this.tileType = tileType;
    }

    public char getTileType() {
        return tileType;
    }
}