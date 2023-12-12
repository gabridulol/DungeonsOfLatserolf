package DungeonsOfLatserolf.entity.monster;

import java.util.Random;

public class MonsterEntity {
    private MonsterCategory monsterCategory;
    private int attack;
    private int defense;
    private int health;
    private int score;
    private int level;

    public MonsterEntity(MonsterCategory monsterCategory) {
        Random rand = new Random();

        this.monsterCategory = monsterCategory;

        int power = monsterCategory.getPower();

        health = (rand.nextInt(10) + 1) * power;
        attack = (rand.nextInt(power) + 1) + power;
        defense = (rand.nextInt(13) + 8) + power;
        score = (health + attack + defense) * 10;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setHealth(int health) {
        this.health -= health;
    }

    public void setXP(int xP) {
        score = xP;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getArtigo() {
        if (monsterCategory.getName() == "Galinha")
            return "uma";
        return "um";
    }

    public String getName() {
        return monsterCategory.getName();
    }

    public String getDescription() {
        return monsterCategory.getDescription();
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public int getXP() {
        return score;
    }

    public int getLevel() {
        return level;
    }

    public MonsterCategory getMonsterCategory() {
        return monsterCategory;
    }

    public void setMonsterCategory(MonsterCategory monsterCategory) {
        this.monsterCategory = monsterCategory;
    }
}
