package DungeonsOfLatserolf.map.tile;

import java.awt.image.BufferedImage;

public class Exit extends TileTypeEntity {
    public boolean openOutput;

    public Exit(BufferedImage assetImage, BufferedImage assetImageOpen) {
        super(assetImage, assetImageOpen);
        this.openOutput = false;
    }

    public boolean getOpenOutput() {
        return openOutput;
    }

    public void setOpenOutput(boolean openOutput) {
        this.openOutput = openOutput;
    }

    public void canBeOpened(int keys) {
        if (keys == 3)
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
