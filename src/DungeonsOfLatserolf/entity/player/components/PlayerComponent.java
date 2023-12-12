package DungeonsOfLatserolf.entity.player.components;

public class PlayerComponent {
    private int score;
    private int totalKeys;
    private int[] positionPlayer;
    private int health;
    private int attack;
    private int defense;

    public PlayerComponent(int[] positionPlayer) {
        this.score = 0;
        this.totalKeys = 0;
        this.positionPlayer = positionPlayer;
        this.health = 12;
        this.attack = 5;
        this.defense = 12;
    }

    public PlayerComponent(int level, int score, int totalKeys, int[] positionPlayer, int health, int attack,
            int defense) {
        this.score = score;
        this.totalKeys = totalKeys;
        this.positionPlayer = positionPlayer;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public int[] getPositionPlayer() {
        return positionPlayer;
    }

    public void setPositionPlayer(int[] positionPlayer) {
        this.positionPlayer = positionPlayer;
    }

    public int getTotalKeys() {
        return totalKeys;
    }

    public void setTotalKeys(int totalKeys) {
        this.totalKeys = totalKeys;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
