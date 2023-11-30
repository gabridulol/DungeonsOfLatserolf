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

    public int rollAttack(int attack, int dado) {
            return (dado  + (attack / 4));
    }

    public int rollIniciative(int attack, int defense){
        return rollDice() + (attack/defense);
    }

    public int attackP(int dado){
        if(dado == 20){
            System.out.println("Voce acertou um critico");
            return player.getAttack()*2;
        }
         return player.getAttack();
    }

     public int attackM(int dado){
        if(dado == 20){
            System.out.printf("%s acertou um critico\n", monster.getName());
            return monster.getAttack()*2;
        }
         return monster.getAttack();
    }

    public boolean battle(){
        int healthPlayer = player.getHealth();
        
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
            System.out.println("O monstro começa atacando");
            first = false;
        }


        while(monster.getHealth()>0 || healthPlayer > 0){
            int dado;
            if(first){
                dado = rollDice();
                if(rollAttack(player.getAttack(),dado) > monster.getDefense()){
                    monster.setHealth(attackP(dado));
                    System.out.printf("Voce desferiu %d de dano no %s\n", attackP(dado), monster.getName());
                }else System.out.println("Voce errou o ataque!");
                
                dado = rollDice();
                if(rollAttack(monster.getAttack(), rollDice()) > player.getDefense()){
                    healthPlayer -= attackM(dado);
                    System.out.printf("Voce sofreu %d de dano\n", attackM(dado));
                }else System.out.println("O monstro errou o ataque!");
            }

            else{
                dado = rollDice();
                if(rollAttack(monster.getAttack(), rollDice()) > player.getDefense()){
                    healthPlayer -= attackM(dado);
                    System.out.printf("Voce sofreu %d de dano\n", attackM(dado));
                }else System.out.println("O monstro errou o ataque!");

                dado = rollDice();
                if(rollAttack(player.getAttack(),dado) > monster.getDefense()){
                    monster.setHealth(attackP(dado));
                    System.out.printf("Voce desferiu %d de dano no %s\n", attackP(dado), monster.getName());
                }else System.out.println("Voce errou o ataque!");
        } 
        }
        if(healthPlayer==0) {
            System.out.println("Voce foi derrotado");
            return false;
        }

        else{
            System.out.println("Voce derrotou " + monster.getName());
            return true;
        }
     }
}
