package DungeonsOfLatserolf.map.tile;

import DungeonsOfLatserolf.graphics.AssetImage;

public class Start extends TileTypeEntity{
    public boolean openOutput;
    
    public Start(AssetImage assetImage, AssetImage assetImageOpen) {
        super(assetImage, assetImageOpen);
        this.openOutput = false;
    }

    public void canBeOpened(int keys) {
        if (keys == 3)
            this.openOutput = true;
    }

    public boolean getOpenOutput() {  // ver se a porta esta aberta
        return openOutput;
    }

    public void setOpenOutput(boolean openOutput) { // abrir a porta
        this.openOutput = openOutput;
    }

    @Override
    public AssetImage getAssetImage(){
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
    public boolean isInteractable(){
        return true;
    }
}
