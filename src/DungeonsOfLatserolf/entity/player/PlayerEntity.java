package DungeonsOfLatserolf.entity.player;

import java.util.ArrayList;

import DungeonsOfLatserolf.entity.player.components.PlayerController;
import DungeonsOfLatserolf.entity.player.components.PlayerComponent;
import DungeonsOfLatserolf.graphics.AssetImage;

public class PlayerEntity {
    
    private ArrayList<AssetImage> sprite;
    private PlayerComponent stats;
    private PlayerController controller;

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