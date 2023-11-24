package DungeonsOfLatserolf.entity.player;

import java.util.ArrayList;

import DungeonsOfLatserolf.graphics.AssetImage;
import DungeonsOfLatserolf.map.tile.Chest;
import DungeonsOfLatserolf.database.UserEntity;
import DungeonsOfLatserolf.entity.monster.MonsterEntity;
import DungeonsOfLatserolf.entity.player.components.PlayerComponent;

public class PlayerEntity {
    
    private PlayerComponent playerStats;
    private UserEntity user;
    private AssetImage image;

    // Para iniciar com um valor padrão
    public PlayerEntity() {
        this.playerStats = new PlayerComponent();
        this.user = new UserEntity();
        this.image = new AssetImage("player.png");
    }

    // Para iniciar com um valor específico
    public PlayerEntity(int level, int score, int totalKeys, ArrayList<int[]> positionPlayer, int health, int attack, int defense) {
        this.playerStats = new PlayerComponent(level, score, totalKeys, positionPlayer, health, attack, defense);
        this.user = new UserEntity();
        this.image = new AssetImage("player.png");
    }

    public void addScore(int score){
        this.playerStats.setScore(this.playerStats.getScore() + score);
    }

    public void addTotalKeys(int totalKeys){
        this.playerStats.setTotalKeys(this.playerStats.getTotalKeys() + totalKeys);
    }

    public void upLevel(){
        this.playerStats.setAttack(this.playerStats.getAttack() + 10);
        this.playerStats.setDefense(this.playerStats.getDefense() + 10);
        this.playerStats.setHealth(this.playerStats.getHealth() + 10);
        this.playerStats.setScore(this.playerStats.getScore() + 100);
    }

    public void resetFight(int attack, int defense, int health){
        this.playerStats.setAttack(attack);
        this.playerStats.setDefense(defense);
        this.playerStats.setHealth(health);
    }

    public void resetPlayer(){
        this.playerStats.setScore(0);
        this.playerStats.setTotalKeys(0);
        this.playerStats.setPositionPlayer(new ArrayList<int[]>());
        this.playerStats.setHealth(100);
        this.playerStats.setAttack(10);
        this.playerStats.setDefense(10);
    }

    public void catchItems(Chest chest){
        if(chest.getKeyChest()){
            this.playerStats.setTotalKeys(this.playerStats.getTotalKeys() + 1);
        }
        else{
            this.playerStats.setScore(this.playerStats.getScore() + chest.getGoldPieces());
        }
    }

    // public PlayerEntity() {
    //     health = 100;
    //     attack = 5;
    //     keysCollected = 0;
    //     XP = 0;
    //     level = 1;
    //     maxHealth = 100;
    //     maxAttack = 30;
    //     minAttack = 5;
    // }

    // // getters
    // public int getHealth() {
    //     return health;
    // }

    // public int getAttack() {
    //     return attack;
    // }

    // public int getKeysCollected() {
    //     return keysCollected;
    // }

    // public int getXP() {
    //     return XP;
    // }

    // public int getLevel() {
    //     return level;
    // }

    // public int getMaxHealth() {
    //     return maxHealth;
    // }

    // public int getMaxAttack() {
    //     return maxAttack;
    // }

    // // setters
    // public void setHealth(int health) {
    //     if (health > maxHealth) {
    //         this.health = maxHealth;
    //     } else if (health < 0) {
    //         this.health = 0;
    //     } else {
    //         this.health = health;
    //     }
    // }

    // public void setAttack(int attack) {
    //     if (attack > maxAttack) {
    //         this.attack = maxAttack;
    //     } else if (attack < minAttack) {
    //         this.attack = minAttack;
    //     } else {
    //         this.attack = attack;
    //     }
    // }

    // public void setKeysCollected(int keysCollected) {
    //     this.keysCollected = keysCollected;
    // }

    // // adders
    // public void addHealth(int health) {
    //     if (this.health + health > maxHealth) {
    //         this.health = maxHealth;
    //     } else {
    //         this.health += health;
    //     }
    // }

    // public void addAttack(int attack) {
    //     if (this.attack + attack > maxAttack) {
    //         this.attack = maxAttack;
    //     } else {
    //         this.attack += attack;
    //     }
    // }

    // public void addKeysCollected(int keysCollected) {
    //     this.keysCollected += keysCollected;
    // }

    // public void addXP(int XP) {
    //     this.XP += XP;
    // }

    // public void addLevel(int level) {
    //     this.level += level;
    // }

    // // subtractors
    // public void subtractHealth(int health) {
    //     if (health < 0) {
    //         this.health = 0;
    //     } else {
    //         this.health -= health;
    //     }
    // }

    // public void subtractAttack(int attack) {
    //     if (attack < 0) {
    //         this.attack = 0;
    //     } else {
    //         this.attack -= attack;
    //     }
    // }

    // // other methods

    // public void levelUp() {
    //     level++;

    // }
}