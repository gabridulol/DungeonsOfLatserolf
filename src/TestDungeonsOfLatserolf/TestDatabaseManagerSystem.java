package TestDungeonsOfLatserolf;

import DungeonsOfLatserolf.DatabaseManagerSystem;
import DungeonsOfLatserolf.PlayerEntity;

public class TestDatabaseManagerSystem {
    public static void main(String[] args) {
        PlayerEntity playerEntity = new PlayerEntity("gabriel.r.marques@ufv.br", "dulol", 0);
        new DatabaseManagerSystem().newUser(playerEntity);
        
    }
}
