package DungeonsOfLatserolf.entity.player.components;

import java.util.ArrayList;

public class PlayerComponent {
    private int score;
    private int totalKeys;
    private ArrayList<int[]> positionPlayer;
    private int health;
    private int attack;
    private int defense;

    // Para iniciar com um valor padrão
    public PlayerComponent() {
        this.score = 0;
        this.totalKeys = 0;
        this.positionPlayer = new ArrayList<int[]>();
        this.health = 100;
        this.attack = 10;
        this.defense = 10;
    }

    // Para inicar com um valor específico
    public PlayerComponent(int level, int score, int totalKeys, ArrayList<int[]> positionPlayer, int health, int attack, int defense) {
        this.score = score;
        this.totalKeys = totalKeys;
        this.positionPlayer = positionPlayer;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public void addScore(int score){
        this.score += score;
    }

    public void addTotalKeys(){
        this.totalKeys++;
    }

    public void upLevel(){
        this.attack += 10;
        this.defense += 10;
        this.health += 10;
        this.score += 100;
    }

    public void resetFight(int attack, int defense, int health){
        this.attack = attack;
        this.defense = defense;
        this.health = health;
    }

    public ArrayList<int[]> getPositionPlayer() {
        return positionPlayer;
    }

    public void setPositionPlayer(ArrayList<int[]> positionPlayer) {
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
