package TestDungeonsOfLatserolf;

import javax.swing.*;

import DungeonsOfLatserolf.entity.player.components.PlayerController;
import DungeonsOfLatserolf.graphics.AssetLibrary;
import DungeonsOfLatserolf.map.MapEntity;
import DungeonsOfLatserolf.display.components.Dungeon;
import DungeonsOfLatserolf.entity.player.PlayerEntity;

import DungeonsOfLatserolf.system.*;

public class TesteMovimento extends JFrame {
    public TesteMovimento(MapEntity mapEntity, PlayerEntity player, PlayerController playerController,
            GameSystem game) {
        // Create a new Dungeon panel
        Dungeon dungeonPanel = new Dungeon(mapEntity, player);

        // Set up the JFrame
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

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        AssetLibrary assetLibrary = new AssetLibrary();
        MapEntity mapEntity = new MapEntity(assetLibrary);
        PlayerEntity player = new PlayerEntity(mapEntity.getMapData().getStartPosition());
        GameSystem game = new GameSystem(assetLibrary, mapEntity, player);

        game.startGame();

        PlayerController playerController = new PlayerController(game);

        // frame.addKeyListener(playerController);

        // frame.setSize(300, 200);
        // frame.setVisible(true);

        // Create the DungeonFrame with the MapEntity
        SwingUtilities.invokeLater(() -> new TesteMovimento(mapEntity, player, playerController, game));

        // Registra o PlayerController como um KeyListener no JFrame
        // game.createAndShowGUI();
        // game.detectKey();
    }
}
