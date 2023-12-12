package DungeonsOfLatserolf.display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

import DungeonsOfLatserolf.display.components.DungeonFrame;
import DungeonsOfLatserolf.entity.player.PlayerEntity;
import DungeonsOfLatserolf.entity.player.components.PlayerController;
import DungeonsOfLatserolf.map.MapEntity;
import DungeonsOfLatserolf.system.GameSystem;

public class GameInterface extends JFrame {
    public GameInterface(MapEntity mapEntity,
            PlayerEntity player,
            PlayerController playerController,
            GameSystem game) {

        DungeonFrame dungeonPanel = new DungeonFrame(mapEntity, player);

        Color black = new Color(23, 17, 26);
        Font font = new Font("CooperBits", Font.PLAIN, 48);

        JLabel labelChest = new JLabel("Score: " + player.getScore());
        labelChest.setForeground(new Color(251, 97, 7));
        labelChest.setHorizontalAlignment(JLabel.LEFT);
        labelChest.setFont(font);

        JLabel labelKey = new JLabel("Keys: " + player.getTotalKeys() + "/" + mapEntity.getMapData().getKeysMap());
        labelKey.setForeground(new Color(251, 97, 7));
        labelKey.setHorizontalAlignment(JLabel.CENTER);
        labelKey.setFont(font);

        JPanel labelPanel = new JPanel(new BorderLayout());

        labelPanel.setBackground(black);
        labelPanel.add(labelChest, BorderLayout.CENTER);
        labelPanel.add(labelKey, BorderLayout.EAST);

        add(labelPanel, BorderLayout.NORTH);

        addKeyListener(playerController);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dungeons of Latserolf");
        setPreferredSize(new Dimension(1280, 720));
        setResizable(false);
        getContentPane().add(dungeonPanel);
        getContentPane().setBackground(black);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        game.setDungeonPanel(dungeonPanel);
        game.setLabels(labelChest, labelKey);
    }
}