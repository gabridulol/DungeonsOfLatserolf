package DungeonsOfLatserolf.system;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DungeonsOfLatserolf.entity.monster.MonsterEntity;
import DungeonsOfLatserolf.entity.player.PlayerEntity;
import DungeonsOfLatserolf.display.components.BattleDialog;
import DungeonsOfLatserolf.display.components.BattleFrame;

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
        return (dado + (attack / 4));
    }

    public int rollIniciative(int attack, int defense) {
        return rollDice() + (attack / defense);
    }

    public int attackP(int dado) {
        if (dado == 20) {
            System.out.println("Voce acertou um critico");
            return player.getAttack() * 2;
        }
        return player.getAttack();
    }

    public int attackM(int dado) {
        if (dado == 20) {
            System.out.printf("%s acertou um critico\n", monster.getName());
            return monster.getAttack() * 2;
        }
        return monster.getAttack();
    }

    public boolean startBattle(){
        int healthPlayer = player.getHealth();

        int pInitiative = rollIniciative(player.getAttack(), player.getDefense());
        int mInitiative = rollIniciative(monster.getAttack(), monster.getDefense());
        boolean first = pInitiative >= mInitiative;

        // if (first) {
        //     System.out.println("Você começa atacando");
        // } else {
        //     System.out.println("O monstro começa atacando");
        // }
        BattleFrame battleFrame = new BattleFrame("Você se depara com " + monster.getName() + "\n" + monster.getDescription(), "Sua vida: " + healthPlayer + "\n" + "Vida do " + monster.getName() + ": " + monster.getHealth(), first ? "Você começa atacando" : "O monstro começa atacando");

        while (monster.getHealth() > 0 || healthPlayer > 0) {
            int dado;

            battleFrame.setBattleInfoTextArea("Sua vida: " + healthPlayer + "\n" + "Vida do " + monster.getName() + ": " + monster.getHealth());
            
            battleFrame.setVisible(true);

            // printLife(healthPlayer);
            // printRollDice();

            if (first) {

                dado = rollDice();
                
                if (rollAttack(player.getAttack(), dado) > monster.getDefense()) {
                    monster.setHealth(attackP(dado));
                    battleFrame.setBattleInfoTextArea("Voce desferiu " + attackP(dado) + " de dano no " + monster.getName());
                    battleFrame.setVisible(true);

                    System.out.printf("Voce desferiu %d de dano no %s\n", attackP(dado), monster.getName());
                } else{
                    battleFrame.setBattleInfoTextArea("Voce errou o ataque!");
                    battleFrame.setVisible(true);

                    System.out.println("Voce errou o ataque!");
                }

                // printRollDice();
                
                dado = rollDice();

                if (rollAttack(monster.getAttack(), rollDice()) > player.getDefense()) {
                    healthPlayer -= attackM(dado);
                    battleFrame.setBattleInfoTextArea("Voce sofreu " + attackM(dado) + " de dano");
                    battleFrame.setVisible(true);

                    System.out.printf("Voce sofreu %d de dano\n", attackM(dado));
                } else{
                    battleFrame.setBattleInfoTextArea("O monstro errou o ataque!");
                    battleFrame.setVisible(true);

                    System.out.println("O monstro errou o ataque!");
                }
            }

            else {

                dado = rollDice();

                if (rollAttack(monster.getAttack(), rollDice()) > player.getDefense()) {
                    healthPlayer -= attackM(dado);
                    battleFrame.setBattleInfoTextArea("Voce sofreu " + attackM(dado) + " de dano");
                    battleFrame.setVisible(true);

                    System.out.printf("Voce sofreu %d de dano\n", attackM(dado));
                } else{
                    battleFrame.setBattleInfoTextArea("O monstro errou o ataque!");
                    battleFrame.setVisible(true);
                    
                    System.out.println("O monstro errou o ataque!");
                }

                // printRollDice();

                dado = rollDice();

                if (rollAttack(player.getAttack(), dado) > monster.getDefense()) {
                    monster.setHealth(attackP(dado));
                    battleFrame.setBattleInfoTextArea("Voce desferiu " + attackP(dado) + " de dano no " + monster.getName());
                    battleFrame.setVisible(true);

                    System.out.printf("Voce desferiu %d de dano no %s\n", attackP(dado), monster.getName());
                } else{
                    battleFrame.setBattleInfoTextArea("Voce errou o ataque!");
                    battleFrame.setVisible(true);

                    System.out.println("Voce errou o ataque!");
                }
            }

            if (monster.getHealth() <= 0) {
                battleFrame.setBattleInfoTextArea("Voce venceu a batalha!");
                battleFrame.setVisible(true);

                System.out.println("Voce venceu a batalha!");
                return true;
            }

            if (healthPlayer <= 0) {
                battleFrame.setBattleInfoTextArea("Voce perdeu a batalha!");
                battleFrame.setVisible(true);

                System.out.println("Voce perdeu a batalha!");
                return false;
            }
        }
        return false;
    }


                // printRoll

    //     BattleDialog battleDialog = new BattleDialog(null, "Batalha", "Você se depara com " + monster.getName() + "\n" + monster.getDescription(), "Sua vida: " + healthPlayer + "\n" + "Vida do " + monster.getName() + ": " + monster.getHealth(), first ? "Você começa atacando" : "O monstro começa atacando");

    //     while (monster.getHealth() > 0 || healthPlayer > 0) {
    //         int dado;

    //         battleDialog.setBattleInfoTextArea("Sua vida: " + healthPlayer + "\n" + "Vida do " + monster.getName() + ": " + monster.getHealth());
            
    //         battleDialog.setVisible(true);

    //         // printLife(healthPlayer);
    //         // printRollDice();

    //         if (first) {

    //             dado = rollDice();
                
    //             if (rollAttack(player.getAttack(), dado) > monster.getDefense()) {
    //                 monster.setHealth(attackP(dado));
    //                 battleDialog.setBattleInfoTextArea("Voce desferiu " + attackP(dado) + " de dano no " + monster.getName());
    //                 battleDialog.setVisible(true);

    //                 System.out.printf("Voce desferiu %d de dano no %s\n", attackP(dado), monster.getName());
    //             } else{
    //                 battleDialog.setBattleInfoTextArea("Voce errou o ataque!");
    //                 battleDialog.setVisible(true);

    //                 System.out.println("Voce errou o ataque!");
    //             }

    //             // printRollDice();
                
    //             dado = rollDice();

    //             if (rollAttack(monster.getAttack(), rollDice()) > player.getDefense()) {
    //                 healthPlayer -= attackM(dado);
    //                 battleDialog.setBattleInfoTextArea("Voce sofreu " + attackM(dado) + " de dano");
    //                 battleDialog.setVisible(true);

    //                 System.out.printf("Voce sofreu %d de dano\n", attackM(dado));
    //             } else{
    //                 battleDialog.setBattleInfoTextArea("O monstro errou o ataque!");
    //                 battleDialog.setVisible(true);

    //                 System.out.println("O monstro errou o ataque!");
    //             }
    //         }

    //         else {

    //             dado = rollDice();

    //             if (rollAttack(monster.getAttack(), rollDice()) > player.getDefense()) {
    //                 healthPlayer -= attackM(dado);
    //                 battleDialog.setBattleInfoTextArea("Voce sofreu " + attackM(dado) + " de dano");
    //                 battleDialog.setVisible(true);

    //                 System.out.printf("Voce sofreu %d de dano\n", attackM(dado));
    //             } else{
    //                 battleDialog.setBattleInfoTextArea("O monstro errou o ataque!");
    //                 battleDialog.setVisible(true);
                    
    //                 System.out.println("O monstro errou o ataque!");
    //             }

    //             // printRollDice();
                
    //             dado = rollDice();

    //             if (rollAttack(player.getAttack(), dado) > monster.getDefense()) {
    //                 monster.setHealth(attackP(dado));
    //                 battleDialog.setBattleInfoTextArea("Voce desferiu " + attackP(dado) + " de dano no " + monster.getName());
    //                 battleDialog.setVisible(true);

    //                 System.out.printf("Voce desferiu %d de dano no %s\n", attackP(dado), monster.getName());
    //             } else{
    //                 battleDialog.setBattleInfoTextArea("Voce errou o ataque!");
    //                 battleDialog.setVisible(true);

    //                 System.out.println("Voce errou o ataque!");
    //             }
    //         }
            
    //         if (monster.getHealth() <= 0) {
    //             battleDialog.setBattleInfoTextArea("Voce venceu a batalha!");
    //             battleDialog.setVisible(true);

    //             System.out.println("Voce venceu a batalha!");
    //             return true;
    //         }

    //         if (healthPlayer <= 0) {
    //             battleDialog.setBattleInfoTextArea("Voce perdeu a batalha!");
    //             battleDialog.setVisible(true);

    //             System.out.println("Voce perdeu a batalha!");
    //             return false;
    //         }
    //     }
    //     return false;
    // }

    public boolean acceptBattle() {
        BattleDialog battleDialog = new BattleDialog(null, "Batalha", "Você se depara com " + monster.getName() + "\n" + monster.getDescription(), "Sua vida: " + player.getHealth() + "\n" + "Vida do " + monster.getName() + ": " + monster.getHealth(), "Você encontrou um monstro, deseja batalhar?");
        return battleDialog.acceptBattle();
    }


    public MonsterEntity getMonster() {
        return monster;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public void printLife(int healthPlayer) {
        System.out.printf("\nVida do %s: %d\n", monster.getName(), monster.getHealth());
        System.out.printf("Sua vida: %d\n", healthPlayer);
    }

    public void printRollDice(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAperte enter para rolar o dado");
        scanner.nextLine();
    }
}
