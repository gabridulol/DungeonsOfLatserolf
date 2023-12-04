package DungeonsOfLatserolf.entity.monster;

public class MonsterGenerator {
    MonsterCategory monsterCategory[];

    public MonsterGenerator() {
        monsterCategory = new MonsterCategory[5];
        monsterCategory[0] = new MonsterCategory("Galinha", "Uma ave doméstica que foi transformada em uma fera selvagem por uma maldição. Ela tem penas vermelhas e pretas, um bico afiado e garras poderosas. Ela ataca com bicadas e arranhões, e pode botar ovos explosivos. Ela é muito barulhenta e agressiva, e não gosta de ser incomodada.", 1, 0.5);
        monsterCategory[1] = new MonsterCategory("Goblin", "Uma criatura pequena e verde que vive em cavernas e florestas. Ele tem orelhas pontudas, dentes tortos e olhos amarelos. Ele usa roupas rasgadas e armas improvisadas, como facas e paus. Ele é covarde e trapaceiro, e gosta de roubar e enganar os outros. Ele tem medo de fogo e luz.", 2, 0.3);
        monsterCategory[2] = new MonsterCategory("Esqueleto", "Um cadáver reanimado por magia negra. Ele tem ossos brancos e secos, sem carne ou pele. Ele usa armaduras e armas antigas, como espadas e machados. Ele é silencioso e obediente, e segue as ordens de seu mestre. Ele não sente dor nem emoções, e pode se recompor se for desmontado.", 3, 0.2);
        monsterCategory[3] = new MonsterCategory("Lich", "Um mago poderoso que se tornou imortal ao transferir sua alma para um objeto. Ele tem uma aparência cadavérica, com pele pálida e cabelos ralos. Ele usa mantos escuros e joias místicas, como anéis e colares. Ele é inteligente e cruel, e busca aumentar seu conhecimento e poder. Ele controla os mortos-vivos e lança feitiços devastadores.", 4, 0.1);
        monsterCategory[4] = new MonsterCategory("Dragon", "Uma criatura lendária que tem escamas, asas e garras. Ele tem uma cor variada, dependendo de seu elemento, como vermelho para fogo, azul para água, ou verde para terra. Ele usa sua respiração, como fogo, gelo, ou veneno, para atacar seus inimigos. Ele é sábio e orgulhoso, e guarda tesouros e segredos em sua caverna. Ele é respeitado e temido por todos.", 5, 0.05);
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
