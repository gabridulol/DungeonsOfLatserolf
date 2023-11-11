package TestDungeonsOfLatserolf;

import DungeonsOfLatserolf.component.TileComponent;
import DungeonsOfLatserolf.entity.ChestEntity;
import DungeonsOfLatserolf.entity.TileTypeEntity;

public class TestChest {
    public static void main(String[] args) {
        TileTypeEntity chest = new ChestEntity();

        // Criando um baú fechado com 100 moedas de ouro e uma chave
        ((ChestEntity) chest).setKeyChest(true);
        ((ChestEntity) chest).setGoldPieces(100);

        System.out.println("Chest is walkable: " + chest.isWalkable());
        System.out.println("Chest is interactable: " + chest.isInteractable());
        System.out.println("Chest is open: " + ((ChestEntity) chest).isOpenChest());
        System.out.println("Chest has a key: " + ((ChestEntity) chest).isKeyChest());
        System.out.println("Chest gold pieces: " + ((ChestEntity) chest).getGoldPieces());
        System.out.println("Chest char tile type: " + chest.getCharTileType());
        System.out.println("Chest tile type: " + chest.getTileType());
        System.out.println();

        // Abrindo o baú e pegando o ouro e a chave
        ((ChestEntity) chest).setOpenChest(true);
        ((ChestEntity) chest).setKeyChest(false);
        ((ChestEntity) chest).setGoldPieces(0);

        System.out.println();
        chest.setTileType(TileComponent.OPEN_CHEST);
        System.out.println("Chest is walkable: " + chest.isWalkable());
        System.out.println("Chest is interactable: " + chest.isInteractable());
        System.out.println("Chest is open: " + ((ChestEntity) chest).isOpenChest());
        System.out.println("Chest has a key: " + ((ChestEntity) chest).isKeyChest());
        System.out.println("Chest gold pieces: " + ((ChestEntity) chest).getGoldPieces());
        System.out.println("Chest char tile type: " + chest.getCharTileType());
        System.out.println("Chest tile type: " + chest.getTileType()); 
    }
}
