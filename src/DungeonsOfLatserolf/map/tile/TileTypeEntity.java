package DungeonsOfLatserolf.map.tile;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class TileTypeEntity {
    private ArrayList<BufferedImage> arrayAsset;

    public TileTypeEntity(BufferedImage asset, BufferedImage assetOpen) {
        arrayAsset.add(asset);
        arrayAsset.add(assetOpen);
    }

    public BufferedImage getAsset() {
        return arrayAsset.get(0);
    }

    public BufferedImage getAssetOpen() {
        return arrayAsset.get(1);
    }

    public abstract BufferedImage getAssetImage();
    
    public abstract boolean isWalkable();

    public abstract boolean isInteractable();
}