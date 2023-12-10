package DungeonsOfLatserolf.map.tile;

import java.awt.image.BufferedImage;

public class Wall extends TileTypeEntity {
    public Wall(BufferedImage assetImage) {
        super(assetImage, null);
    }

    @Override
    public BufferedImage getAssetImage() {
        return getAsset();
    }

    @Override
    public boolean isWalkable() {
        return false;
    }

    @Override
    public boolean isInteractable() {
        return false;
    }
}
