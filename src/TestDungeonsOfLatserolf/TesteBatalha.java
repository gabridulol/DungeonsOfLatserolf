package TestDungeonsOfLatserolf;


import DungeonsOfLatserolf.system.BattleSystem;
import DungeonsOfLatserolf.entity.player.*;
import DungeonsOfLatserolf.entity.monster.*;

public class TesteBatalha {
    public static void main(String[] args) {
        PlayerEntity playerEntity = new PlayerEntity(null);
        MonsterEntity monsterEntity = new MonsterEntity();

        BattleSystem battleSystem = new BattleSystem(monsterEntity, playerEntity);
        battleSystem.battle();
    }
}
