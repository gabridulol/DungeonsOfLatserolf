package DungeonsOfLatserolf.map.tile;

import java.awt.image.BufferedImage;

public class Floor extends TileTypeEntity {
    public Floor(BufferedImage assetImage) {
        super(assetImage, null);
    }

    @Override
    public BufferedImage getAssetImage() {
        return getAsset();
    }

    @Override
    public boolean isWalkable() {
        return true;
    }

    @Override
    public boolean isInteractable() {
        return false;
    }
}
