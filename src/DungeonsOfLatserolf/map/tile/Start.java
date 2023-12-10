package DungeonsOfLatserolf.map.tile;

import java.awt.image.BufferedImage;

public class Start extends TileTypeEntity {
    public boolean openOutput;

    public Start(BufferedImage assetImage, BufferedImage assetImageOpen) {
        super(assetImage, assetImageOpen);
        this.openOutput = false;
    }

    public boolean getOpenOutput() { // ver se a porta esta aberta
        return openOutput;
    }

    public void setOpenOutput(boolean openOutput) { // abrir a porta
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
