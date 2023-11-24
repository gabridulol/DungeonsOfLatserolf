package DungeonsOfLatserolf.map.tile;

import DungeonsOfLatserolf.graphics.AssetImage;
import java.util.ArrayList;

public abstract class TileTypeEntity {
    private ArrayList<AssetImage> arrayAsset;

    public TileTypeEntity(AssetImage asset, AssetImage assetOpen) {
        arrayAsset = new ArrayList<AssetImage>();
        arrayAsset.add(asset);
        arrayAsset.add(assetOpen);
    }

    public AssetImage getAsset() {
        return arrayAsset.get(0);
    }

    public AssetImage getAssetOpen() {
        return arrayAsset.get(1);
    }

    public abstract AssetImage getAssetImage();
    
    public abstract boolean isWalkable();

    public abstract boolean isInteractable();
}