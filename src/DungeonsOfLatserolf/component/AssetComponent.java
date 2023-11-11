package DungeonsOfLatserolf.component;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class AssetComponent {
    private BufferedImage asset;
    private String path;

    public AssetComponent(String path) {
        this.path = path;
        try {
            this.asset = ImageIO.read(new File(this.path));
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}