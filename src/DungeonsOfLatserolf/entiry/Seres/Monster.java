package DungeonsOfLatserolf.entiry.Seres;

import java.util.Random;

public class Monster {
    private String name;
    //private String descricao;
    private static int maxHealth;
    private int attack;
    private int health;
    // private int XP;
    // private int level;
    

    private String[] names = {"Galinha", "Goblin", "Esqueleto", "Lich", "Dragon"};
    Random rand = new Random();

    public Monster (){
        int random = rand.nextInt(names.length);
        name = names[random];
        
        maxHealth = rand.nextInt(10) + 5 + random*2;

        attack = (rand.nextInt(10) + 5 + random*2) / 3;

        health = maxHealth;
    }

}
