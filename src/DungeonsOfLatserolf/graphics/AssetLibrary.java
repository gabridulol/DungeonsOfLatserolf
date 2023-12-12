package DungeonsOfLatserolf.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.util.HashMap;

public class AssetLibrary {
    private static final String PATH_TO_ASSETS = "./res/assets";

    private HashMap<String, BufferedImage> assets;

    public AssetLibrary() {
        assets = new HashMap<>();
        loadAssets();
    }

    public void setAssets(HashMap<String, BufferedImage> assets) {
        this.assets = assets;
    }

    public BufferedImage getImage(String fileName) {
        return assets.get(fileName);
    }

    private void loadAssets() {
        File assetsFolder = new File(PATH_TO_ASSETS);

        if (assetsFolder.exists() && assetsFolder.isDirectory()) {
            String[] assetsNames = assetsFolder.list();
            if (assetsNames != null) {
                for (String assetName : assetsNames) {
                    String keyString = assetName.substring(0, assetName.length() - 4);
                    BufferedImage valueImage = loadImage(assetName);
                    if (keyString != null && valueImage != null) {
                        assets.put(keyString, valueImage);
                    }
                }
            } else {
                System.out.println("Folder is empty.");
            }
        } else {
            System.out.println("Path to assets does not exist or is not a directory.");
        }
    }

    public BufferedImage loadImage(String fileName) {
        String filePath = PATH_TO_ASSETS + "/" + fileName;

        try {
            return ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public HashMap<String, BufferedImage> getAssets() {
        return assets;
    }
}
