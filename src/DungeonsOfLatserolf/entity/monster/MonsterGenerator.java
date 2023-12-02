package DungeonsOfLatserolf.entity.monster;

public class MonsterGenerator {
    MonsterCategory monsterCategory[];

    public MonsterGenerator() {
        monsterCategory = new MonsterCategory[3];
        monsterCategory[0] = new MonsterCategory("Galinha", "Uma galinha", 1, 0.5);
        monsterCategory[1] = new MonsterCategory("Goblin", "Um goblin", 2, 0.3);
        monsterCategory[2] = new MonsterCategory("Orc", "Um orc", 3, 0.2);
    }

    public MonsterEntity generateMonster() {
        while (true) {
            double random = (double) (Math.random());
            int randomMonster = (int) (Math.random() * 3);
            if (random <= monsterCategory[randomMonster].getProbability()) {
                MonsterEntity monster = new MonsterEntity(monsterCategory[randomMonster]);
                return monster;
            }
        }
    }
}
