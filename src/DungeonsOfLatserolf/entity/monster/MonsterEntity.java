package DungeonsOfLatserolf.entity.monster;

import java.util.Random;

public class MonsterEntity {
    private MonsterCategory monsterCategory;
    private int attack;
    private int defense;
    private int health;
    private int score;
    private int level;

    Random rand = new Random();
    // private String[] names = { "Galinha", "Goblin", "Esqueleto", "Lich", "Dragon"
    // };
    // private String[] descriptions = {
    // "Uma ave doméstica que foi transformada em uma fera selvagem por uma
    // maldição. Ela tem penas vermelhas e pretas, um bico afiado e garras
    // poderosas. Ela ataca com bicadas e arranhões, e pode botar ovos explosivos.
    // Ela é muito barulhenta e agressiva, e não gosta de ser incomodada.",
    // "Uma criatura pequena e verde que vive em cavernas e florestas. Ele tem
    // orelhas pontudas, dentes tortos e olhos amarelos. Ele usa roupas rasgadas e
    // armas improvisadas, como facas e paus. Ele é covarde e trapaceiro, e gosta de
    // roubar e enganar os outros. Ele tem medo de fogo e luz.",
    // "Um cadáver reanimado por magia negra. Ele tem ossos brancos e secos, sem
    // carne ou pele. Ele usa armaduras e armas antigas, como espadas e machados.
    // Ele é silencioso e obediente, e segue as ordens de seu mestre. Ele não sente
    // dor nem emoções, e pode se recompor se for desmontado.",
    // "Um mago poderoso que se tornou imortal ao transferir sua alma para um
    // objeto. Ele tem uma aparência cadavérica, com pele pálida e cabelos ralos.
    // Ele usa mantos escuros e joias místicas, como anéis e colares. Ele é
    // inteligente e cruel, e busca aumentar seu conhecimento e poder. Ele controla
    // os mortos-vivos e lança feitiços devastadores.",
    // "Uma criatura lendária que tem escamas, asas e garras. Ele tem uma cor
    // variada, dependendo de seu elemento, como vermelho para fogo, azul para água,
    // ou verde para terra. Ele usa sua respiração, como fogo, gelo, ou veneno, para
    // atacar seus inimigos. Ele é sábio e orgulhoso, e guarda tesouros e segredos
    // em sua caverna. Ele é respeitado e temido por todos." };

    public MonsterEntity(MonsterCategory monsterCategory) {
        this.monsterCategory = monsterCategory;
        int power = monsterCategory.getPower();

        health = (rand.nextInt(10) + 5 + power * 2);
        attack = ((rand.nextInt(10) + 5 + power * 2) / 3);
        defense = ((rand.nextInt(10) + 5 + power * 2) / 3);
        score = attack * defense + level * health;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setHealth(int health) {
        this.health -= health;
    }

    public void setXP(int xP) {
        score = xP;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getArtigo(){
        if (monsterCategory.getName() == "Galinha")
            return "uma";
        return "um";
    }

    public String getName() {
        return monsterCategory.getName();
    }

    public String getDescription() {
        return monsterCategory.getDescription();
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public int getXP() {
        return score;
    }

    public int getLevel() {
        return level;
    }

    public Random getRand() {
        return rand;
    }

    public MonsterCategory getMonsterCategory() {
        return monsterCategory;
    }

    public void setMonsterCategory(MonsterCategory monsterCategory) {
        this.monsterCategory = monsterCategory;
    }

    // public String[] getNames() {
    // return names;
    // }

    // public String[] getDescriptions() {
    // return descriptions;
    // }

}