import javax.swing.SwingUtilities;

import DungeonsOfLatserolf.display.GameInterface;
import DungeonsOfLatserolf.entity.player.PlayerEntity;
import DungeonsOfLatserolf.entity.player.components.PlayerController;
import DungeonsOfLatserolf.graphics.AssetLibrary;
import DungeonsOfLatserolf.map.MapEntity;
import DungeonsOfLatserolf.system.GameSystem;

public class Main {
    public static void main(String[] args) {
        AssetLibrary assetLibrary = new AssetLibrary();
        MapEntity mapEntity = new MapEntity(assetLibrary);
        PlayerEntity player = new PlayerEntity(mapEntity.getMapData().getStartPosition());
        GameSystem game = new GameSystem(assetLibrary, mapEntity, player);
        PlayerController playerController = new PlayerController(game);

        game.startGame();

        SwingUtilities.invokeLater(() -> new GameInterface(mapEntity, player, playerController, game));
    }
}
