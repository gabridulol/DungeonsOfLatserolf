package DungeonsOfLatserolf.entity.player;

import java.util.ArrayList;
import java.awt.image.BufferedImage;

import DungeonsOfLatserolf.map.tile.Chest;
import javafx.geometry.Pos;
import DungeonsOfLatserolf.database.UserEntity;
import DungeonsOfLatserolf.entity.monster.MonsterEntity;
import DungeonsOfLatserolf.entity.player.components.PlayerComponent;
import DungeonsOfLatserolf.entity.player.components.PlayerController;

public class PlayerEntity {

    private PlayerComponent playerStats;
    private UserEntity user;
    private BufferedImage[] playerImages;

    // Para iniciar com um valor padrão
    public PlayerEntity(int[] positionPlayer) {
        this.playerStats = new PlayerComponent(positionPlayer);
    }

    // Para iniciar com um valor específico
    public PlayerEntity(int level, int score, int totalKeys, int[] positionPlayer, int health, int attack,
            int defense) {
        this.playerStats = new PlayerComponent(level, score, totalKeys, positionPlayer, health, attack, defense);
    }

    public int[] getPositionPlayer() {
        return playerStats.getPositionPlayer();
    }

    public void setPositionPlayer(int[] positionPlayer) {
        this.playerStats.setPositionPlayer(positionPlayer);
    }

    public int getAttack() {
        return this.playerStats.getAttack();
    }

    public int getDefense() {
        return this.playerStats.getDefense();
    }

    public int getHealth() {
        return this.playerStats.getHealth();
    }

    public void addScore(int score) {
        this.playerStats.setScore(this.playerStats.getScore() + score);
    }

    public void addTotalKeys(int totalKeys) {
        this.playerStats.setTotalKeys(this.playerStats.getTotalKeys() + totalKeys);
    }

    public void upLevel() {
        this.playerStats.setAttack(this.playerStats.getAttack() + 1);
        this.playerStats.setDefense(this.playerStats.getDefense() + 1);
        this.playerStats.setHealth(this.playerStats.getHealth() + 6);
        this.playerStats.setScore(this.playerStats.getScore() + 100);
    }

    public void resetFight(int health) {
        this.playerStats.setHealth(health);
    }

    public void resetPlayer() {
        this.playerStats.setScore(0);
        this.playerStats.setTotalKeys(0);
        this.playerStats.setPositionPlayer(new int[] { 0, 0 });
        this.playerStats.setHealth(100);
        this.playerStats.setAttack(10);
        this.playerStats.setDefense(10);
    }

    public void catchItems(Chest chest) {
        if (chest.getKeyChest()) {
            this.playerStats.setTotalKeys(this.playerStats.getTotalKeys() + 1);
        } else {
            this.playerStats.setScore(this.playerStats.getScore() + chest.getGoldPieces());
        }
    }

    public PlayerComponent getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(PlayerComponent playerStats) {
        this.playerStats = playerStats;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}