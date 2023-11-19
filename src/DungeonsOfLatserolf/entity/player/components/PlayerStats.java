package DungeonsOfLatserolf.entity.player.components;

public class PlayerStats {
    private int level;
    private int score;
    private int health;
    private int attack;
    private int defense;

    public PlayerStats() {
        this.level = 0;
        this.score = 0;
        this.health = 0;
        this.attack = 0;
        this.defense = 0;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
