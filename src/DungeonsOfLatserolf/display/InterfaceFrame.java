package DungeonsOfLatserolf.display;

import java.awt.Font;

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

        // Set up the JFrame

        JLabel label = new JLabel("Dungeons of Latserolf");
        label.setText("Score:" + player.getScore());
        add(label);

        addKeyListener(playerController);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dungeon Display");
        setResizable(false);
        getContentPane().add(dungeonPanel);
        pack();
        setLocationRelativeTo(null); // Center the JFrame on the screen
        setVisible(true);
        game.setDungeonPanel(dungeonPanel);
    }

}