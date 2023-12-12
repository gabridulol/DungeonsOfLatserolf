package DungeonsOfLatserolf.entity.monster;

import java.util.ArrayList;

import DungeonsOfLatserolf.graphics.AssetLibrary;

public class MonsterGenerator {
        private ArrayList<MonsterCategory> monsterCategory;

        public MonsterGenerator(AssetLibrary assetLibrary) {
                monsterCategory = new ArrayList<MonsterCategory>();

                monsterCategory.add(new MonsterCategory("Galinha",
                                "Uma ave doméstica que foi transformada em uma fera selvagem por uma maldição. Ela tem penas vermelhas e pretas, um bico afiado e garras poderosas. Ela ataca com bicadas e arranhões, e pode botar ovos explosivos. Ela é muito barulhenta e agressiva, e não gosta de ser incomodada.",
                                1, 0.2, assetLibrary.getImage("chicken")));
                monsterCategory.add(new MonsterCategory("Goblin",
                                "Uma criatura pequena e verde que vive em cavernas e florestas. Ele tem orelhas pontudas, dentes tortos e olhos amarelos. Ele usa roupas rasgadas e armas improvisadas, como facas e paus. Ele é covarde e trapaceiro, e gosta de roubar e enganar os outros. Ele tem medo de fogo e luz.",
                                2, 0.3, assetLibrary.getImage("goblin")));
                monsterCategory.add(new MonsterCategory("Esqueleto",
                                "Um cadáver reanimado por magia negra. Ele tem ossos brancos e secos, sem carne ou pele. Ele usa armaduras e armas antigas, como espadas e machados. Ele é silencioso e obediente, e segue as ordens de seu mestre. Ele não sente dor nem emoções, e pode se recompor se for desmontado.",
                                2, 0.3, assetLibrary.getImage("skeleton")));
                monsterCategory.add(new MonsterCategory("Lich",
                                "Um mago poderoso que se tornou imortal ao transferir sua alma para um objeto. Ele tem uma aparência cadavérica, com pele pálida e cabelos ralos. Ele usa mantos escuros e joias místicas, como anéis e colares. Ele é inteligente e cruel, e busca aumentar seu conhecimento e poder. Ele controla os mortos-vivos e lança feitiços devastadores.",
                                4, 0.25, assetLibrary.getImage("lich")));
                monsterCategory.add(new MonsterCategory("Dragão",
                                "Uma criatura lendária que tem escamas, asas e garras. Ele tem uma cor variada, dependendo de seu elemento, como vermelho para fogo, azul para água, ou verde para terra. Ele usa sua respiração, como fogo, gelo, ou veneno, para atacar seus inimigos. Ele é sábio e orgulhoso, e guarda tesouros e segredos em sua caverna. Ele é respeitado e temido por todos.",
                                5, 0.2, assetLibrary.getImage("dragon")));
                monsterCategory.add(new MonsterCategory("Armadura Animada",
                                "Uma massa metálica cintilante que ganhou vida por meio de encantamentos arcanos. Seu movimento é gracioso e fluido, como se dançasse pelo campo de batalha, protegendo seu mestre com habilidades defensivas surpreendentes.",
                                3, 0.5, assetLibrary.getImage("animatedarmor")));
                monsterCategory.add(new MonsterCategory("Morcego",
                                "Um morcego noturno, de asas imponentes e olhos luminosos que brilham no escuro. Sua habilidade de sonar é tão refinada que pode detectar a presença de qualquer intruso, tornando-o um mensageiro silencioso e eficaz para seus mestres sombrios.",
                                1, 0.2, assetLibrary.getImage("bat")));
                monsterCategory.add(new MonsterCategory("Observador",
                                "Uma esfera flutuante com olhos sinistros que emitem raios mágicos. Cada olho tem uma função única, desde desintegrar seus inimigos até distorcer a realidade. Seu olhar penetrante é capaz de desvendar segredos mais profundos do que a mente pode suportar.",
                                4, 0.25, assetLibrary.getImage("beholder")));
                monsterCategory.add(new MonsterCategory("Cubo Gelatinoso",
                                "Uma massa translúcida que rasteja pelo chão, o cubo gelatinoso se camufla como uma poça de água viscosa. Aqueles que subestimam sua presença podem se encontrar presos em sua viscosidade ácida, uma ameaça enganadora.",
                                5, 0.2, assetLibrary.getImage("cube")));
                monsterCategory.add(new MonsterCategory("Demilich",
                                "Um esqueleto flutuante, adornado com joias antigas e enfeites mortais. Sua caveira resplandece com um brilho sobrenatural, enquanto uma aura de poder arcano envolve o ambiente ao seu redor. Cada olhar de seus olhos vazios suga a essência vital dos incautos.",
                                5, 0.2, assetLibrary.getImage("demilich")));
                monsterCategory.add(new MonsterCategory("Demônio",
                                "Uma entidade infernal, com chifres retorcidos e pele enegrecida. Suas asas escuras e olhos flamejantes revelam a natureza ardente de sua origem. Possui habilidades mágicas capazes de invocar horrores e encher a atmosfera com um cheiro de enxofre.",
                                4, 0.25, assetLibrary.getImage("demon")));
                monsterCategory.add(new MonsterCategory("Sapo",
                                "Este sapo peculiar exala uma aura mágica. Sua língua é capaz de capturar pequenos objetos, e sua pele secreta uma substância alucinógena. Aqueles que menosprezam sua aparência inofensiva podem encontrar-se presos em um mundo de ilusões.",
                                1, 0.2, assetLibrary.getImage("frog")));
                monsterCategory.add(new MonsterCategory("Devorador de Intelecto",
                                "Uma criatura grotesca com tentáculos cerebrais que se estendem em todas as direções. Sua presença sussurra a promessa de drenar a sabedoria de qualquer mente imprudente o suficiente para se aproximar. Uma aura de conhecimento roubado envolve esse ser aterrorizante.",
                                3, 0.5, assetLibrary.getImage("intellectdevourer")));
                monsterCategory.add(new MonsterCategory("Orc",
                                "Uma criatura robusta e musculosa, o orc possui uma pele áspera e presas proeminentes. Sua sociedade guerreira valoriza a força bruta, e a ferocidade de seu ataque é amplificada pelo rugido estrondoso que ecoa pelos campos de batalha.",
                                2, 0.3, assetLibrary.getImage("orc")));
                monsterCategory.add(new MonsterCategory("Rato",
                                "Este não é um rato comum. Sua pelagem prateada brilha à luz da lua, e seus olhos cintilam com inteligência incomum. Um mestre furtivo, este rato mágico pode desvendar segredos e acessar lugares inacessíveis para outros.",
                                1, 0.2, assetLibrary.getImage("rat")));
                monsterCategory.add(new MonsterCategory("Escorpião",
                                "Um escorpião gigante, suas pinças poderosas e cauda venenosa são uma ameaça mortal. Sua carapaça resistente reflete a luz, criando um brilho metálico que antecipa sua abordagem silenciosa.",
                                1, 0.2, assetLibrary.getImage("scorpion")));
                monsterCategory.add(new MonsterCategory("Troll",
                                "Uma criatura de pele áspera e regeneração acelerada. O troll é resistente e feroz, capaz de curar rapidamente mesmo dos ferimentos mais graves. Sua presença evoca um odor forte e selvagem, alertando aqueles que ousam se opor a ele.",
                                3, 0.5, assetLibrary.getImage("troll")));
                monsterCategory.add(new MonsterCategory("Lobiomem",
                                "Uma figura humana que se transforma sob a luz do luar, o lobisomem possui pelagem densa e olhos selvagens. Sua mordida carrega uma maldição contagiosa, transformando aqueles que sobrevivem em criaturas semelhantes.",
                                3, 0.5, assetLibrary.getImage("werewolf")));
                monsterCategory.add(new MonsterCategory("Bruxa",
                                "Vestida em trajes escuros e rodeada por um halo de mistério, a bruxa é uma conjuradora de feitiços sinistros. Seu caldeirão fumegante borbulha com poções mágicas, enquanto corvos negros a rodeiam, servindo como seus olhos e ouvidos nos recantos mais sombrios do reino.",
                                3, 0.5, assetLibrary.getImage("witch")));
                monsterCategory.add(new MonsterCategory("Mímico",
                                "Camuflado como um objeto comum, este ser metamórfico espera pacientemente sua presa. Quando menos se espera, revela sua verdadeira forma, uma gosma viscosa repleta de dentes afiados. Sua capacidade de se disfarçar o torna um mestre na arte da emboscada.",
                                3, 0.5, assetLibrary.getImage("mimic")));
        }

        public MonsterEntity generateMonster() {
                while (true) {
                        double random = (double) (Math.random());
                        int randomMonster = (int) (Math.random() * monsterCategory.size());
                        if (random <= monsterCategory.get(randomMonster).getProbability()) {
                                MonsterEntity monster = new MonsterEntity(monsterCategory.get(randomMonster));
                                return monster;
                        }
                }
        }
}
