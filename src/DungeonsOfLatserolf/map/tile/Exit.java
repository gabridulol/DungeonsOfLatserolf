package DungeonsOfLatserolf.map.tile;

import java.awt.image.BufferedImage;

public class Exit extends TileTypeEntity {
    public boolean openOutput;
    private int necessaryKeys;

    public Exit(BufferedImage assetImage, BufferedImage assetImageOpen, int necessaryKeys) {
        super(assetImage, assetImageOpen);
        this.openOutput = false;
        this.necessaryKeys = necessaryKeys;
    }

    public boolean getOpenOutput() {
        return openOutput;
    }

    public void setOpenOutput(boolean openOutput) {
        this.openOutput = openOutput;
    }

    public void canBeOpened(int keys) {
        if (keys == necessaryKeys)
            this.openOutput = true;
    }

    @Override
    public BufferedImage getAssetImage() {
        if (this.openOutput) {
            return getAssetOpen();
        }
        return getAsset();
    }

    @Override
    public boolean isWalkable() {
        return true;
    }

    @Override
    public boolean isInteractable() {
        return true;
    }
}
