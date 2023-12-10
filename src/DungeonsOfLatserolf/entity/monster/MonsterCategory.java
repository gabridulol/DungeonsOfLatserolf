package DungeonsOfLatserolf.entity.monster;

import java.awt.image.BufferedImage;

public class MonsterCategory {
    private String name;
    private String description;
    private int power;
    private double probability;
    private BufferedImage monsterImage;

    public MonsterCategory(String name, String description, int power, double probability, BufferedImage monsterImage) {
        this.name = name;
        this.description = description;
        this.power = power;
        this.probability = probability;
        this.monsterImage = monsterImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public BufferedImage getMonsterImage() {
        return monsterImage;
    }

    public void setMonsterImage(BufferedImage monsterImage) {
        this.monsterImage = monsterImage;
    }
}
