import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import DungeonsOfLatserolf.display.InterfaceFrame;
import DungeonsOfLatserolf.display.components.Game;
import DungeonsOfLatserolf.entity.player.PlayerEntity;
import DungeonsOfLatserolf.entity.player.components.PlayerController;
import DungeonsOfLatserolf.graphics.AssetLibrary;
import DungeonsOfLatserolf.map.MapEntity;
import DungeonsOfLatserolf.system.GameSystem;
import TestDungeonsOfLatserolf.TesteMovimento;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();

        AssetLibrary assetLibrary = new AssetLibrary();
        MapEntity mapEntity = new MapEntity(assetLibrary);
        PlayerEntity player = new PlayerEntity(mapEntity.getMapData().getStartPosition());
        GameSystem game = new GameSystem(assetLibrary, mapEntity, player);

        game.startGame();
        
        PlayerController playerController = new PlayerController(game);

        SwingUtilities.invokeLater(() -> new InterfaceFrame(mapEntity, player, playerController, game));

    }
}
