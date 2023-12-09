package DungeonsOfLatserolf.display.components;

import java.util.ArrayList;

import javax.swing.JFrame;

import DungeonsOfLatserolf.graphics.AssetLibrary;

public class Inicia extends JFrame{
    public Inicia (ArrayList<String> listaBatalha, AssetLibrary assetLibrary){
        BattleFrame battleFrame = new BattleFrame(listaBatalha, assetLibrary);

        // Set up the JFrame
        // addKeyListener(playerController);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("batalha");
        setResizable(false);
        getContentPane().add(battleFrame);
        pack();
        setLocationRelativeTo(null); // Center the JFrame on the screen
        setVisible(true);
        // game.setDungeonPanel(dungeonPanel);
    }
}
