package TestNewGameImplementation.gfx;

import java.io.File;
import java.util.Map;
import java.net.URL;
import java.util.HashMap;

public class SpriteLibrary {
    private static final String PATH_TO_UNITS = "./res/sprites/units";

    private Map<String, SpriteSet> units;

    public SpriteLibrary() {
        this.units = new HashMap<>();
        loadSpritesFromDisk();
    }

    private void loadSpritesFromDisk() {
        String[] folderNames = getFolderNames(PATH_TO_UNITS);

        for (String folderName : folderNames) {
            SpriteSet spriteSet = new SpriteSet();
            String pathToFolder = PATH_TO_UNITS + "/" + folderName;
            String[] sheetsInFolder = getSheetsInFolder(pathToFolder);

            for (String sheetName : sheetsInFolder) {
                spriteSet.addSheet(
                    sheetName.substring(0, sheetName.length() - 4),
                    ImageUtils.loadImage(pathToFolder + "/" + sheetName)
                    );
            }

            units.put(folderName, spriteSet);
        }
    }

    private String[] getSheetsInFolder(String basePath) {
        URL resource = ClassLoader.getSystemResource(basePath);
        if (resource != null) {
            File file = new File(resource.getFile());
            return file.list((current, name) -> new File(current, name).isFile());
        }
        return new String[0]; // or handle the null resource case appropriately
    }
    
    private String[] getFolderNames(String basePath) {
        URL resource = ClassLoader.getSystemResource(basePath);
        if (resource != null) {
            File file = new File(resource.getFile());
            return file.list((current, name) -> new File(current, name).isDirectory());
        }
        return new String[0]; // or handle the null resource case appropriately
    }

    public SpriteSet getUnit(String name) {
        return units.get(name);
    }
}
