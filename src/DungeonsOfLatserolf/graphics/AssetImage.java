package DungeonsOfLatserolf.graphics;

import java.awt.image.BufferedImage;

public class AssetImage {
    private BufferedImage asset;

    public AssetImage(AssetLibrary assetLibrary, String assetName) {
        this.asset = assetLibrary.getImage(assetName);
    }

    public BufferedImage getAsset() {
        return asset;
    }

    public void setAsset(BufferedImage asset) {
        this.asset = asset;
    }
}
