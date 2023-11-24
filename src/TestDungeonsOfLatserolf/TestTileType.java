package TestDungeonsOfLatserolf;

import DungeonsOfLatserolf.map.tile.Chest;
import DungeonsOfLatserolf.map.tile.Door;
import DungeonsOfLatserolf.map.tile.Floor;
import DungeonsOfLatserolf.map.tile.Start;
import DungeonsOfLatserolf.map.tile.TileComponent;
import DungeonsOfLatserolf.map.tile.TileTypeEntity;
import DungeonsOfLatserolf.map.tile.Wall;

public class TestTileType {
    public static void main(String[] args) {
        TileTypeEntity board = new TileTypeEntity(TileComponent.BOARD);
        TileTypeEntity wall = new TileTypeEntity(TileComponent.WALL);
        TileTypeEntity verticalWall = new TileTypeEntity(TileComponent.VERTICAL_WALL);
        TileTypeEntity horizontalWall = new TileTypeEntity(TileComponent.HORIZONTAL_WALL);
        TileTypeEntity floor = new TileTypeEntity(TileComponent.FLOOR);
        TileTypeEntity simpleDoor = new TileTypeEntity(TileComponent.SIMPLE_DOOR);
        TileTypeEntity monsterDoor = new TileTypeEntity(TileComponent.MONSTER_DOOR);
        TileTypeEntity openDoor = new TileTypeEntity(TileComponent.OPEN_DOOR);
        TileTypeEntity chest = new TileTypeEntity(TileComponent.CHEST);
        TileTypeEntity keyChest = new TileTypeEntity(TileComponent.KEY_CHEST);
        TileTypeEntity openChest = new TileTypeEntity(TileComponent.OPEN_CHEST);
        TileTypeEntity start = new TileTypeEntity(TileComponent.START);
        System.out.println("Test TileType");
        System.out.println(board.getTileType() + " " + board.getCharTileType());
        System.out.println(wall.getTileType() + " " + wall.getCharTileType());
        System.out.println(verticalWall.getTileType() + " " + verticalWall.getCharTileType());
        System.out.println(horizontalWall.getTileType() + " " + horizontalWall.getCharTileType());
        System.out.println(floor.getTileType() + " " + floor.getCharTileType());
        System.out.println(simpleDoor.getTileType() + " " + simpleDoor.getCharTileType());
        System.out.println(monsterDoor.getTileType() + " " + monsterDoor.getCharTileType());
        System.out.println(openDoor.getTileType() + " " + openDoor.getCharTileType());
        System.out.println(chest.getTileType() + " " + chest.getCharTileType());
        System.out.println(keyChest.getTileType() + " " + keyChest.getCharTileType());
        System.out.println(openChest.getTileType() + " " + openChest.getCharTileType());
        System.out.println(start.getTileType() + " " + start.getCharTileType());
    }
}
