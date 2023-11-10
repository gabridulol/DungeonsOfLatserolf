package TestDungeonsOfLatserolf;

import DungeonsOfLatserolf.component.TileComponent;
import DungeonsOfLatserolf.entity.ChestEntity;
import DungeonsOfLatserolf.entity.TileTypeEntity;

public class TestChest {
    public static void main(String[] args) {

        TileTypeEntity tile = new ChestEntity(false, 4);
        System.out.println(tile.getTileType() + " " + tile.getCharTileType());

        if (tile.isInterable()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        tile.setTileType(TileComponent.OPEN_CHEST);
        System.out.println(tile.getTileType() + " " + tile.getCharTileType());

        if (tile.isInterable()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
