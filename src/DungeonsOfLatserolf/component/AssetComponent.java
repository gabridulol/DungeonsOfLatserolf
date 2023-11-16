package DungeonsOfLatserolf.component;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class AssetComponent {
    private BufferedImage asset;

    public AssetComponent(String path) {
        try {
            this.asset = ImageIO.read(new File(path));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public BufferedImage getAsset() {
        return asset;
    }

    public void setAsset(BufferedImage asset) {
        this.asset = asset;
    }
}