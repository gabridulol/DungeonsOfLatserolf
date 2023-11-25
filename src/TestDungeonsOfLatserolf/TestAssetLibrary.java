package TestDungeonsOfLatserolf;

import DungeonsOfLatserolf.graphics.AssetLibrary;
import DungeonsOfLatserolf.map.tile.*;;

public class TestAssetLibrary {
    public static void main(String[] args) {
        AssetLibrary assetLibrary = new AssetLibrary();
        assetLibrary.printHashMap();

        TileTypeEntity tileTypeEntity = new Wall(assetLibrary.getImage("wall(0)"));

    }
}
