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

    public BattleSystem(MonsterEntity monster, PlayerEntity player, AssetLibrary assetLibrary) {
        this.monster = monster;
        this.player = player;
        this.assetLibrary = assetLibrary;
        
    }

    public int rollDice() {
        Random rand = new Random();
        int dice = rand.nextInt(20) + 1;
        return dice;
    }

    public int rollAttack(int attack, int dice) {
        return (dice + attack);
    }

    public int rollInitiative(int attack, int defense) {
        return rollDice() + (defense / attack);
    }

    public int playerDamage(int dice) {
        if (dice == 20) {
            return player.getAttack() * 2;
        }
        return player.getAttack();
    }

    public int monsterDamage(int dice) {
        if (dice == 20) {
            return monster.getAttack() * 2;
        }
        return monster.getAttack();
    }

    public boolean startBattle(AtomicBoolean isBattle, JLabel labelScore) {
        int healthPlayer = player.getHealth();

        int pInitiative = rollInitiative(player.getAttack(), player.getDefense());
        int mInitiative = rollInitiative(monster.getAttack(), monster.getDefense());

        boolean first = pInitiative >= mInitiative;

        BufferedImage[][] map = new BufferedImage[7][6];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 0 || i == 5 || j == 0 || j == 5) { // borda
                    if (j == 0 || j == 5)
                        map[i][j] = assetLibrary.getImage("wall(1)");
                    else
                        map[i][j] = assetLibrary.getImage("wall(0)");

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
        if (monster.getName() == "Mímico") {
            map[6][1] = null;
            map[1][3] = monster.getMonsterCategory().getMonsterImage();
        } else {
            map[6][1] = monster.getMonsterCategory().getMonsterImage();
        }

        ArrayList<String> battleList = new ArrayList<>();
        ArrayList<String> battleInfo = new ArrayList<>();
        ArrayList<String> diceList = new ArrayList<>();

        battleList.add(first ? "Você começa atacando!" : "O monstro começa atacando!");
        diceList.add(" ");

        while (monster.getHealth() > 0 || healthPlayer > 0) {
            battleInfo.add("Sua vida: " + healthPlayer + "        " + "Vida do " + monster.getName() + ": "
                    + monster.getHealth());

            if (first) {
                playerDamage(battleList, battleInfo, diceList);
            }

            else {
                healthPlayer = monsterAttack(battleList, battleInfo, diceList, healthPlayer);
            }

            if (checkBattle(monster.getHealth(), healthPlayer)) {
                if (checkWin(monster.getHealth(), healthPlayer, isBattle, battleList, battleInfo, diceList,
                        map, labelScore)) {
                    battleList.add("");
                    battleInfo.add("");
                    diceList.add("");
                    return true;
                }

                else {
                    battleInfo.add("");
                    battleInfo.add("");
                    diceList.add("");
                    return false;
                }
            }
            first = !first;
        }
        return false;
    }

    public boolean checkBattle(int monsterHealth, int playerHealth) {
        if (monsterHealth <= 0 || playerHealth <= 0) {
            return true;
        }
        return false;
    }

    public boolean checkWin(int monsterHealth, int healthPlayer, AtomicBoolean i,
            ArrayList<String> battleList, ArrayList<String> battleInfo,
            ArrayList<String> diceList, BufferedImage[][] map, JLabel labelScore) {

        diceList.add(" ");

        if (monster.getHealth() <= 0) {
            battleList.add("Você venceu a batalha!");
            battleInfo.add("Sua vida: " + healthPlayer + "        " + "Vida do " + monster.getName() + ": " + 0);
            new BattleFrame(battleList, battleInfo, diceList, i, map, labelScore, monster.getXP());
            return true;
        }

        else {
            battleList.add("Você perdeu a batalha!");
            battleInfo
                    .add("Sua vida: " + 0 + "        " + "Vida do " + monster.getName() + ": " + monster.getHealth());
            new BattleFrame(battleList, battleInfo, diceList, i, map, labelScore, monster.getXP());
            return false;
        }
    }

    private void playerDamage(ArrayList<String> battleList, ArrayList<String> battleInfo,
            ArrayList<String> diceList) {
        int dado = rollDice();
        diceList.add("Seu dado: " + dado);

        if (rollAttack(player.getAttack(), dado) > monster.getDefense()) {
            monster.setHealth(playerDamage(dado));
            battleList.add("Você desferiu " + playerDamage(dado) + " de dano no " + monster.getName());
        }

        else {
            battleList.add("Você errou o ataque!");
        }
    }

    private int monsterAttack(ArrayList<String> battleList, ArrayList<String> battleInfo,
            ArrayList<String> diceList, int healthPlayer) {
        int dado = rollDice();
        diceList.add("Dado do monstro: " + dado);

        if (rollAttack(monster.getAttack(), dado) > player.getDefense()) {
            healthPlayer -= monsterDamage(dado);
            battleList.add("Você sofreu " + monsterDamage(dado) + " de dano");
        }

        else {
            battleList.add("O monstro errou o ataque!");
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

        JTextArea battleInfoTextArea = new JTextArea(
                "Você se depara com " + monster.getName() + "\n\n" + monster.getDescription());
        configureTextArea(battleInfoTextArea);

        JLabel questionLabel = new JLabel("Deseja batalhar?");
        configureLabel(questionLabel);

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
