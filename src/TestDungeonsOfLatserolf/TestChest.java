package TestDungeonsOfLatserolf;

import DungeonsOfLatserolf.map.tile.Chest;
import DungeonsOfLatserolf.map.tile.TileComponent;
import DungeonsOfLatserolf.map.tile.TileTypeEntity;

public class TestChest {
    public static void main(String[] args) {
        TileTypeEntity chest = new Chest();

        // Criando um baú fechado com 100 moedas de ouro e uma chave
        ((Chest) chest).setKeyChest(true);
        ((Chest) chest).setGoldPieces(100);

        System.out.println("Chest is walkable: " + chest.isWalkable());
        System.out.println("Chest is interactable: " + chest.isInteractable());
        System.out.println("Chest is open: " + ((Chest) chest).isOpenChest());
        System.out.println("Chest has a key: " + ((Chest) chest).isKeyChest());
        System.out.println("Chest gold pieces: " + ((Chest) chest).getGoldPieces());
        System.out.println("Chest char tile type: " + chest.getCharTileType());
        System.out.println("Chest tile type: " + chest.getTileType());
        System.out.println();

        // Abrindo o baú e pegando o ouro e a chave
        ((Chest) chest).setOpenChest(true);
        ((Chest) chest).setKeyChest(false);
        ((Chest) chest).setGoldPieces(0);

        System.out.println();
        chest.setTileType(TileComponent.OPEN_CHEST);
        System.out.println("Chest is walkable: " + chest.isWalkable());
        System.out.println("Chest is interactable: " + chest.isInteractable());
        System.out.println("Chest is open: " + ((Chest) chest).isOpenChest());
        System.out.println("Chest has a key: " + ((Chest) chest).isKeyChest());
        System.out.println("Chest gold pieces: " + ((Chest) chest).getGoldPieces());
        System.out.println("Chest char tile type: " + chest.getCharTileType());
        System.out.println("Chest tile type: " + chest.getTileType()); 
    }
}
