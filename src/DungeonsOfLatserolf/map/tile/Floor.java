package DungeonsOfLatserolf.map.tile;

import DungeonsOfLatserolf.graphics.AssetImage;

public class Floor extends TileTypeEntity{
    public Floor(AssetImage assetImage) {
        super(assetImage, null);
    }

    @Override
    public AssetImage getAssetImage(){
        return getAsset();
    }

    @Override
    public boolean isWalkable() {
        return true;
    }

    @Override
    public boolean isInteractable(){
        return false;
    }
}
