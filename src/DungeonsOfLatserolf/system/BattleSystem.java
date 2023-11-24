package DungeonsOfLatserolf.system;

import java.util.Random;

import DungeonsOfLatserolf.entity.monster.MonsterEntity;
import DungeonsOfLatserolf.entity.player.PlayerEntity;

public class BattleSystem {
    private MonsterEntity monster;
    private PlayerEntity player;

    Random rand = new Random();

    public BattleSystem(MonsterEntity monster, PlayerEntity player) {
        this.monster = monster;
        this.player = player;
    }

    public int rollDice() {
        Random rand = new Random();
        return rand.nextInt(20) + 1;
    }

    public int rollAttack(int attack) {
        int dado = rollDice();
        if(dado == 20){
            System.out.println("Voce acertou um ataque critico!!");
            return (dado  + (attack / 4))*2;
        }
        return dado + (attack / 4);
    }

    public int rollIniciative(int attack, int defense){
        return rollDice() + (attack/defense);
    }

    public boolean battle(){
        int maxHealth = player.getHealth();
        
        System.out.println("Você se depara com " + monster.getName());
        System.out.println(monster.getDescription());

        int pIciative = rollIniciative(player.getAttack(), player.getDefense());
        int mIciative = rollIniciative(monster.getAttack(), monster.getDefense());
        boolean first;

        if(pIciative >= mIciative){
                System.out.println("Voce começa atacando");
                first =  true;
            }
        else{
            
        }


        while(monster.getHealth()>0 || player.getHealth()>0){
            if(first){
                
            }


        }
    }
}
