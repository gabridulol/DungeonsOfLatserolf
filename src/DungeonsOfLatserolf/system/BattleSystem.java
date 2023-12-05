package DungeonsOfLatserolf.system;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import javax.swing.*;
import javax.swing.text.html.parser.Entity;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public boolean startBattle() {
        int healthPlayer = player.getHealth();

        int pInitiative = rollIniciative(player.getAttack(), player.getDefense());
        int mInitiative = rollIniciative(monster.getAttack(), monster.getDefense());
        boolean first = pInitiative >= mInitiative;

        BattleFrame battleFrame = new BattleFrame(first ? "Você começa atacando" : "O monstro começa atacando");

        // Adiciona o botão "Continuar" após cada movimento

        battleFrame.setVisible(true);

        // battleFrame.revalidate();
        // battleFrame.repaint();
        // Exibe a janela de batalha

        battleFrame.waitForContinue();

        // battleFrame.setVisible(true);

        // Remove o botão para a próxima iteração
        // battleFrame.remove(continueButton);
        // battleFrame.revalidate();
        // battleFrame.repaint();

        while (monster.getHealth() > 0 || healthPlayer > 0) {
            int dado;

            battleFrame.setBattleInfoTextArea(
                    "Sua vida: " + healthPlayer + "\n" + "Vida do " + monster.getName() + ": " + monster.getHealth());

            if (first) {
                dado = rollDice();

                if (rollAttack(player.getAttack(), dado) > monster.getDefense()) {
                    monster.setHealth(attackP(dado));
                    battleFrame.setBattleInfoTextArea(
                            "Você desferiu " + attackP(dado) + " de dano no " + monster.getName());
                } else {
                    battleFrame.setBattleInfoTextArea("Você errou o ataque!");
                }

                // battleFrame.add(continueButton);
                // Aguarda a resposta do usuário antes de continuar
                battleFrame.waitForContinue();

                dado = rollDice();

                if (rollAttack(monster.getAttack(), dado) > player.getDefense()) {
                    healthPlayer -= attackM(dado);
                    battleFrame.setBattleInfoTextArea("Você sofreu " + attackM(dado) + " de dano");
                } else {
                    battleFrame.setBattleInfoTextArea("O monstro errou o ataque!");
                }
            } else {
                dado = rollDice();

                if (rollAttack(monster.getAttack(), dado) > player.getDefense()) {
                    healthPlayer -= attackM(dado);
                    battleFrame.setBattleInfoTextArea("Você sofreu " + attackM(dado) + " de dano");
                } else {
                    battleFrame.setBattleInfoTextArea("O monstro errou o ataque!");
                }

                // battleFrame.add(continueButton);
                // Aguarda a resposta do usuário antes de continuar
                battleFrame.waitForContinue();

                dado = rollDice();

                if (rollAttack(player.getAttack(), dado) > monster.getDefense()) {
                    monster.setHealth(attackP(dado));
                    battleFrame.setBattleInfoTextArea(
                            "Você desferiu " + attackP(dado) + " de dano no " + monster.getName());
                } else {
                    battleFrame.setBattleInfoTextArea("Você errou o ataque!");
                }
            }

            // battleFrame.add(continueButton);
            // Aguarda a resposta do usuário antes de continuar
            battleFrame.waitForContinue();

            if (monster.getHealth() <= 0) {
                battleFrame.setBattleInfoTextArea("Você venceu a batalha!");
                battleFrame.waitForContinue();
                battleFrame.dispose();
                return true;
            }

            if (healthPlayer <= 0) {
                battleFrame.setBattleInfoTextArea("Você perdeu a batalha!");
                battleFrame.waitForContinue();
                battleFrame.dispose();
                return false;
            }
        }
        return false;
    }

    public static void applyDarkTheme() {
        Font defaultFont = new Font("JetBrainsMono", Font.PLAIN, 20);
        UIManager.put("OptionPane.messageFont", defaultFont);
        UIManager.put("OptionPane.buttonFont", defaultFont);
        UIManager.put("Label.font", defaultFont);
        UIManager.put("TextArea.font", defaultFont);
        UIManager.put("OptionPane.background", Color.DARK_GRAY);
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        UIManager.put("Panel.background", Color.DARK_GRAY);
        UIManager.put("Button.background", Color.gray);
        UIManager.put("Button.foreground", Color.WHITE);
    }

    public boolean acceptBattle() {
        MonsterEntity monster = getMonster();
        applyDarkTheme();

        JTextArea battleInfoTextArea = new JTextArea(
                "Você se depara com " + monster.getName() + "\n\n" + monster.getDescription());
        configureTextArea(battleInfoTextArea);

        JLabel questionLabel = new JLabel("Deseja batalhar?");
        configureLabel(questionLabel);

        // Painel personalizado com layout BoxLayout
        JPanel customPanel = new JPanel();
        customPanel.setLayout(new BoxLayout(customPanel, BoxLayout.Y_AXIS));
        customPanel.add(battleInfoTextArea);

        customPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        customPanel.add(questionLabel);

        customPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        Object[] options = { "Sim", "Não" };
        int choice = JOptionPane.showOptionDialog(
                null,
                customPanel,
                "Batalha",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);

        return choice == JOptionPane.YES_OPTION;
    }

    private static void configureTextArea(JTextArea textArea) {
        // textArea.setEditable(false);
        textArea.setForeground(Color.white);
        textArea.setBackground(Color.DARK_GRAY);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(400, 250)); // Ajuste conforme necessário
    }

    private static void configureLabel(JLabel label) {
        label.setForeground(Color.white);
    }

    public MonsterEntity getMonster() {
        return monster;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    // printRoll

    // BattleDialog battleDialog = new BattleDialog(null, "Batalha", "Você se depara
    // com " + monster.getName() + "\n" + monster.getDescription(), "Sua vida: " +
    // healthPlayer + "\n" + "Vida do " + monster.getName() + ": " +
    // monster.getHealth(), first ? "Você começa atacando" : "O monstro começa
    // atacando");

    // while (monster.getHealth() > 0 || healthPlayer > 0) {
    // int dado;

    // battleDialog.setBattleInfoTextArea("Sua vida: " + healthPlayer + "\n" + "Vida
    // do " + monster.getName() + ": " + monster.getHealth());

    // battleDialog.setVisible(true);

    // // printLife(healthPlayer);
    // // printRollDice();

    // if (first) {

    // dado = rollDice();

    // if (rollAttack(player.getAttack(), dado) > monster.getDefense()) {
    // monster.setHealth(attackP(dado));
    // battleDialog.setBattleInfoTextArea("Voce desferiu " + attackP(dado) + " de
    // dano no " + monster.getName());
    // battleDialog.setVisible(true);

    // System.out.printf("Voce desferiu %d de dano no %s\n", attackP(dado),
    // monster.getName());
    // } else{
    // battleDialog.setBattleInfoTextArea("Voce errou o ataque!");
    // battleDialog.setVisible(true);

    // System.out.println("Voce errou o ataque!");
    // }

    // // printRollDice();

    // dado = rollDice();

    // if (rollAttack(monster.getAttack(), rollDice()) > player.getDefense()) {
    // healthPlayer -= attackM(dado);
    // battleDialog.setBattleInfoTextArea("Voce sofreu " + attackM(dado) + " de
    // dano");
    // battleDialog.setVisible(true);

    // System.out.printf("Voce sofreu %d de dano\n", attackM(dado));
    // } else{
    // battleDialog.setBattleInfoTextArea("O monstro errou o ataque!");
    // battleDialog.setVisible(true);

    // System.out.println("O monstro errou o ataque!");
    // }
    // }

    // else {

    // dado = rollDice();

    // if (rollAttack(monster.getAttack(), rollDice()) > player.getDefense()) {
    // healthPlayer -= attackM(dado);
    // battleDialog.setBattleInfoTextArea("Voce sofreu " + attackM(dado) + " de
    // dano");
    // battleDialog.setVisible(true);

    // System.out.printf("Voce sofreu %d de dano\n", attackM(dado));
    // } else{
    // battleDialog.setBattleInfoTextArea("O monstro errou o ataque!");
    // battleDialog.setVisible(true);

    // System.out.println("O monstro errou o ataque!");
    // }

    // // printRollDice();

    // dado = rollDice();

    // if (rollAttack(player.getAttack(), dado) > monster.getDefense()) {
    // monster.setHealth(attackP(dado));
    // battleDialog.setBattleInfoTextArea("Voce desferiu " + attackP(dado) + " de
    // dano no " + monster.getName());
    // battleDialog.setVisible(true);

    // System.out.printf("Voce desferiu %d de dano no %s\n", attackP(dado),
    // monster.getName());
    // } else{
    // battleDialog.setBattleInfoTextArea("Voce errou o ataque!");
    // battleDialog.setVisible(true);

    // System.out.println("Voce errou o ataque!");
    // }
    // }

    // if (monster.getHealth() <= 0) {
    // battleDialog.setBattleInfoTextArea("Voce venceu a batalha!");
    // battleDialog.setVisible(true);

    // System.out.println("Voce venceu a batalha!");
    // return true;
    // }

    // if (healthPlayer <= 0) {
    // battleDialog.setBattleInfoTextArea("Voce perdeu a batalha!");
    // battleDialog.setVisible(true);

    // System.out.println("Voce perdeu a batalha!");
    // return false;
    // }
    // }
    // return false;
    // }

}
