package DungeonsOfLatserolf.map.tile;

import DungeonsOfLatserolf.graphics.AssetImage;

public abstract class TileTypeEntity {
    private AssetImage assetImage;
    private AssetImage assetOpen;

    public TileTypeEntity(AssetImage asset, AssetImage assetOpen) {
        this.assetImage = asset;
        this.assetOpen = assetOpen;
    }

    public AssetImage getAsset() {
        return assetImage;
    }

    public AssetImage getAssetOpen() {
        return assetOpen;
    }

    public abstract AssetImage getAssetImage();
    
    public abstract boolean isWalkable();

    public abstract boolean isInteractable();
}