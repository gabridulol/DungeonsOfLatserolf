package DungeonsOfLatserolf.entity.monster;

public class MonsterCategory {
    private String name;
    private String description;
    private int power;
    private double probability;

    public MonsterCategory(String name, String description, int power, double probability) {
        this.name = name;
        this.description = description;
        this.power = power;
        this.probability = probability;
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
}
