package DungeonsOfLatserolf.display;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Color;

import javax.swing.*;

import DungeonsOfLatserolf.display.components.Dungeon;
import DungeonsOfLatserolf.entity.player.PlayerEntity;
import DungeonsOfLatserolf.entity.player.components.PlayerController;
import DungeonsOfLatserolf.map.MapEntity;
import DungeonsOfLatserolf.system.GameSystem;

public class InterfaceFrame extends JFrame {

    public InterfaceFrame(MapEntity mapEntity, PlayerEntity player, PlayerController playerController,
            GameSystem game) {
        Dungeon dungeonPanel = new Dungeon(mapEntity, player);

        Color black = new Color(23, 17, 26);

        JLabel labelChest = new JLabel("Score: " + player.getScore());
        labelChest.setForeground(Color.WHITE); // Define a cor do texto
        labelChest.setHorizontalAlignment(JLabel.CENTER); // Centraliza o texto no JLabel

        JLabel labelKey = new JLabel("Keys: " + player.getTotalKeys());
        labelKey.setForeground(Color.WHITE); // Define a cor do texto
        labelKey.setHorizontalAlignment(JLabel.CENTER); // Centraliza o texto no JLabel

        JPanel labelPanel = new JPanel(new BorderLayout());

        labelPanel.setBackground(black);
        labelPanel.add(labelChest, BorderLayout.CENTER);
        labelPanel.add(labelKey, BorderLayout.EAST);

        add(labelPanel, BorderLayout.NORTH); // Adiciona o JPanel ao norte do JFrame

        addKeyListener(playerController);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dungeons of Latserolf");
        setResizable(false);
        getContentPane().add(dungeonPanel);
        pack();
        setLocationRelativeTo(null); // Center the JFrame on the screen
        setVisible(true);
        game.setDungeonPanel(dungeonPanel);
        game.setLabels(labelChest, labelKey);
    }
}