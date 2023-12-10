package DungeonsOfLatserolf.system;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import DungeonsOfLatserolf.entity.monster.MonsterEntity;
import DungeonsOfLatserolf.entity.player.PlayerEntity;
import DungeonsOfLatserolf.graphics.AssetLibrary;
import DungeonsOfLatserolf.display.components.BattleFrame;

public class BattleSystem extends JFrame {
    private MonsterEntity monster;
    private PlayerEntity player;
    private AssetLibrary assetLibrary;

    Random rand = new Random();

    public BattleSystem(MonsterEntity monster, PlayerEntity player, AssetLibrary assetLibrary) {
        this.monster = monster;
        this.player = player;
        this.assetLibrary = assetLibrary;
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

    public boolean startBattle(AtomicBoolean batalhando) {
        int healthPlayer = player.getHealth();

        int pInitiative = rollIniciative(player.getAttack(), player.getDefense());
        int mInitiative = rollIniciative(monster.getAttack(), monster.getDefense());
        boolean first = pInitiative >= mInitiative;

        BufferedImage[][] map = new BufferedImage[7][6];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 0 || i == 5 || j == 0 || j == 5) { // borda
                    if (i == 0 || i == 5)
                        map[i][j] = assetLibrary.getImage("wall(0)");
                    else
                        map[i][j] = assetLibrary.getImage("wall(1)");

                }

                else {
                    map[i][j] = assetLibrary.getImage("floor(0)");
                }
            }
        }

        map[0][4] = assetLibrary.getImage("door(0)");
        map[1][3] = assetLibrary.getImage("chest(0)");
        map[5][1] = assetLibrary.getImage("door(1)");
        map[6][0] = assetLibrary.getImage("up(0)");
        map[6][1] = monster.getMonsterCategory().getMonsterImage();

        ArrayList<String> listaBatalha = new ArrayList<>();
        ArrayList<String> infoBatalha = new ArrayList<>();
        ArrayList<String> listaDado = new ArrayList<>();

        listaBatalha.add(first ? "Você começa atacando" : "O monstro começa atacando");

        while (monster.getHealth() > 0 || healthPlayer > 0) {
            infoBatalha.add("Sua vida: " + healthPlayer + "        " + "Vida do " + monster.getName() + ": "
                    + monster.getHealth());

            listaDado.add("");

            if (first) {
                playerAttack(listaBatalha, infoBatalha, listaDado);
            }

            else {
                healthPlayer = monsterAttack(listaBatalha, infoBatalha, listaDado, healthPlayer);
            }

            if (verificaBatalha(monster.getHealth(), healthPlayer)) {
                if (verificaGanhou(monster.getHealth(), healthPlayer, batalhando, listaBatalha, infoBatalha, listaDado,
                        map)) {
                    System.out.println("FGanhou");
                    return true;
                }

                else {
                    System.out.println("FPerdeu");
                    return false;
                }
            }
            first = !first;
        }
        return false;
    }

    public boolean verificaBatalha(int monsterHealth, int playerHealth) {
        if (monsterHealth <= 0 || playerHealth <= 0) {
            return true;
        }
        return false;
    }

    public boolean verificaGanhou(int monsterHealth, int healthPlayer, AtomicBoolean batalhando,
            ArrayList<String> listaBatalha, ArrayList<String> infoBatalha,
            ArrayList<String> listaDado, BufferedImage[][] map) {

        listaDado.add("");

        if (monster.getHealth() <= 0) {
            listaBatalha.add("Você venceu a batalha!");
            infoBatalha.add("Sua vida: " + healthPlayer + "        " + "Vida do " + monster.getName() + ": " + 0);
            System.out.println(batalhando.get());
            new BattleFrame(listaBatalha, infoBatalha, listaDado, batalhando, map);
            // batalhando.set(false);
            return true;
        } else {
            listaBatalha.add("Você perdeu a batalha!");
            infoBatalha
                    .add("Sua vida: " + 0 + "        " + "Vida do " + monster.getName() + ": " + monster.getHealth());
            new BattleFrame(listaBatalha, infoBatalha, listaDado, batalhando, map);
            return false;
        }
    }

    private void playerAttack(ArrayList<String> listaBatalha, ArrayList<String> infoBatalha,
            ArrayList<String> listaDado) {
        int dado = rollDice();
        listaDado.add("Seu dado: " + dado);

        if (rollAttack(player.getAttack(), dado) > monster.getDefense()) {
            monster.setHealth(attackP(dado));
            listaBatalha.add("Você desferiu " + attackP(dado) + " de dano no " + monster.getName());
        } else {
            listaBatalha.add("Você errou o ataque!");
        }
    }

    private int monsterAttack(ArrayList<String> listaBatalha, ArrayList<String> infoBatalha,
            ArrayList<String> listaDado, int healthPlayer) {
        int dado = rollDice();
        listaDado.add("Dado do monstro: " + dado);

        if (rollAttack(monster.getAttack(), dado) > player.getDefense()) {
            healthPlayer -= attackM(dado);
            listaBatalha.add("Você sofreu " + attackM(dado) + " de dano");
        } else {
            listaBatalha.add("O monstro errou o ataque!");
        }
        return healthPlayer;
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

        // Color black = new Color(23, 17, 26);
        // setBackground(black);

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
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(570, 360)); // Ajuste conforme necessário
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
}
