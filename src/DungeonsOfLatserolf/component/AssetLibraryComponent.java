package DungeonsOfLatserolf.component;

import java.awt.Image;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.util.HashMap;
import java.util.Map.Entry;

public class AssetLibraryComponent {
    private static final String PATH_TO_ASSETS = "./res/assets";

    private HashMap<String, Image> assets;

    public AssetLibraryComponent() {
        assets = new HashMap<>();
        loadAssets();
    }

    private void loadAssets() {
        File assetsFolder = new File(PATH_TO_ASSETS);

        if (assetsFolder.exists() && assetsFolder.isDirectory()) {
            String[] assetsNames = assetsFolder.list();

            if (assetsNames != null) {
                for (String assetName : assetsNames) {
                    String keyString = assetName.substring(0, assetName.length() - 4);
                    Image valueImage = loadImage(assetName);
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

    public Image loadImage(String fileName) {
        String filePath = PATH_TO_ASSETS + "/" + fileName;
        try {
            return ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Image getImage(String fileName) {
        return assets.get(fileName);
    }

    public <K, V> void printHashMap() {
        for (Entry<String, Image> entry : assets.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println();
        }
    }
}
