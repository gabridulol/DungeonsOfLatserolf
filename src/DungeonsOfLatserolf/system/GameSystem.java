package DungeonsOfLatserolf.system;

import DungeonsOfLatserolf.database.UserEntity;
import DungeonsOfLatserolf.display.Display;
import DungeonsOfLatserolf.entity.player.PlayerEntity;
import DungeonsOfLatserolf.graphics.AssetLibrary;
import DungeonsOfLatserolf.map.MapEntity;

public class GameSystem {
    private static final int cellSize = 16; // 16x16 pixels
    private static final double zoom = 5.0f; // 5x zoom

    private AssetLibrary assetLibrary;

    private PlayerEntity playerEntity;

    private UserEntity userEntity;

    private MapEntity mapEntity;

    private Display display;
}
