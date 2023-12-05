package TestDungeonsOfLatserolf;


import DungeonsOfLatserolf.system.BattleSystem;
import DungeonsOfLatserolf.entity.player.*;
import DungeonsOfLatserolf.entity.monster.*;

public class TesteBatalha {
    public static void main(String[] args) {
        PlayerEntity playerEntity = new PlayerEntity(null);
        MonsterGenerator monsterGenerator = new MonsterGenerator();
        

        BattleSystem battleSystem = new BattleSystem(monsterGenerator.generateMonster(), playerEntity);
        if(battleSystem.acceptBattle()){
            battleSystem.startBattle();
        }
    }
}