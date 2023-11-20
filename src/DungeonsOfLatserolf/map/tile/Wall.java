package DungeonsOfLatserolf.map.tile;

import DungeonsOfLatserolf.graphics.AssetImage;

public class Wall extends TileTypeEntity{
    public Wall(AssetImage assetImage) {
        super(assetImage, null);
    }

    @Override
    public AssetImage getAssetImage(){
        return getAsset();
    }
    
    @Override
    public boolean isWalkable() {
        return false;
    }

    @Override
    public boolean isInteractable(){
        return false;
    }
}
