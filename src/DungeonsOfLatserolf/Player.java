package DungeonsOfLatserolf;

public class Player {
    private int health;
    private int attack;
    private int keysCollected;
    private int XP;
    private int level;
    private static int maxAttack;
    private static int minAttack;
    private static int maxHealth;

    public Player() {
        health = 100;
        attack = 5;
        keysCollected = 0;
        XP = 0;
        level = 1;
        maxHealth = 100;
        maxAttack = 30;
        minAttack = 5;
    }

    // getters
    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getKeysCollected() {
        return keysCollected;
    }

    public int getXP() {
        return XP;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getMaxAttack() {
        return maxAttack;
    }

    // setters
    public void setHealth(int health) {
        if (health > maxHealth) {
            this.health = maxHealth;
        } else if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }

    public void setAttack(int attack) {
        if (attack > maxAttack) {
            this.attack = maxAttack;
        } else if (attack < minAttack) {
            this.attack = minAttack;
        } else {
            this.attack = attack;
        }
    }

    public void setKeysCollected(int keysCollected) {
        this.keysCollected = keysCollected;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // adders
    public void addHealth(int health) {
        if (this.health + health > maxHealth) {
            this.health = maxHealth;
        } else {
            this.health += health;
        }
    }

    public void addAttack(int attack) {
        if (this.attack + attack > maxAttack) {
            this.attack = maxAttack;
        } else {
            this.attack += attack;
        }
    }

    public void addKeysCollected(int keysCollected) {
        this.keysCollected += keysCollected;
    }

    public void addXP(int XP) {
        this.XP += XP;
    }

    public void addLevel(int level) {
        this.level += level;
    }

    // subtractors
    public void subtractHealth(int health) {
        if (this.health - health < 0) {
            this.health = 0; // player dies
        } else {
            this.health -= health;
        }
    }

    public void subtractAttack(int attack) {
        if (this.attack - attack < minAttack) {
            this.attack = minAttack;
        } else {
            this.attack -= attack;
        }
    }

    // other methods

    public void levelUp() {
        addLevel(1);
        setAttack(minAttack);
        setHealth(maxHealth);
        setKeysCollected(0);
    }

    public void reset() {
        setAttack(minAttack);
        setHealth(maxHealth);
        setKeysCollected(0);
        setXP(0);
        setLevel(1);
    }

    public void printStats() {
        System.out.println("Health: " + getHealth());
        System.out.println("Attack: " + getAttack());
        System.out.println("Keys Collected: " + getKeysCollected());
        System.out.println("XP: " + getXP());
        System.out.println("Level: " + getLevel());
    }

    // moving methods

    
}