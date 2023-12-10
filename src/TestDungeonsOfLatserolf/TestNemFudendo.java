package TestDungeonsOfLatserolf;

import java.awt.Dimension;

import javax.swing.*;

import DungeonsOfLatserolf.display.components.Dungeon;
import DungeonsOfLatserolf.graphics.AssetLibrary;
import DungeonsOfLatserolf.map.MapEntity;

public class TestNemFudendo extends JFrame {

    public TestNemFudendo(MapEntity mapEntity) {
        // Create a new Dungeon panel
        Dungeon dungeonPanel = new Dungeon(mapEntity);

        // Set up the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dungeon Display");
        setResizable(false);
        getContentPane().add(dungeonPanel);
        pack();
        setLocationRelativeTo(null); // Center the JFrame on the screen
        setVisible(true);
    }

    public static void main(String[] args) {
        AssetLibrary assetLibrary = new AssetLibrary();
        // Create a MapEntity (you need to instantiate it according to your
        // implementation)
        MapEntity mapEntity = new MapEntity(assetLibrary);
        mapEntity.buildMap();

        System.out.println(mapEntity.getMap()[0].length);
        System.out.println(mapEntity.getMap().length);

        // Create the DungeonFrame with the MapEntity
        SwingUtilities.invokeLater(() -> new TestNemFudendo(mapEntity));
    }
}