package TestDungeonsOfLatserolf;


import DungeonsOfLatserolf.system.BattleSystem;
import DungeonsOfLatserolf.entity.player.*;
import DungeonsOfLatserolf.graphics.AssetLibrary;

import java.util.concurrent.atomic.AtomicBoolean;

import DungeonsOfLatserolf.entity.monster.*;

public class TesteBatalha {
    public static void main(String[] args) {
        AssetLibrary assetLibrary = new AssetLibrary();

        PlayerEntity playerEntity = new PlayerEntity(null);
        MonsterGenerator monsterGenerator = new MonsterGenerator(assetLibrary);
        AtomicBoolean batalhando = new AtomicBoolean(false);

        BattleSystem battleSystem = new BattleSystem(monsterGenerator.generateMonster(), playerEntity, new AssetLibrary());
        
        if(battleSystem.acceptBattle()){
            battleSystem.startBattle(batalhando);
        }
    }
}