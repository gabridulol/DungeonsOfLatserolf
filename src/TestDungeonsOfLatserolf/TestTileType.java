package TestDungeonsOfLatserolf;

import DungeonsOfLatserolf.TileType;
import DungeonsOfLatserolf.TileComponent;

public class TestTileType {
    public static void main(String[] args) {
        TileType board = new TileType(TileComponent.BOARD);
        TileType wall = new TileType(TileComponent.WALL);
        TileType verticalWall = new TileType(TileComponent.VERTICAL_WALL);
        TileType horizontalWall = new TileType(TileComponent.HORIZONTAL_WALL);
        TileType floor = new TileType(TileComponent.FLOOR);
        TileType simpleDoor = new TileType(TileComponent.SIMPLE_DOOR);
        TileType monsterDoor = new TileType(TileComponent.MONSTER_DOOR);
        TileType openDoor = new TileType(TileComponent.OPEN_DOOR);
        TileType chest = new TileType(TileComponent.CHEST);
        TileType keyChest = new TileType(TileComponent.KEY_CHEST);
        TileType openChest = new TileType(TileComponent.OPEN_CHEST);
        TileType start = new TileType(TileComponent.START);
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
