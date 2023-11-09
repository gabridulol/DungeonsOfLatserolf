Nome do jogo : Dungeons of Latserolf

* é um labirinto (dungeon) com várias fases
* no labirinto:
    * entrada/saída
        para sair do labirinto para próxima fase, é necessário encontrar 3 chaves espalhadas pela dungeon
    * paredes
        bloqueia movimento
    * chão
        pode andar
    * baús
        baús podem ou não conter chave
            se contem chave
                pega a chave
            se não contem
                pega o que tiver ali dentro (gold -> pontução)
    * portas
        abriu porta
            as portas tem chance de conter monstros
                se contem monstro
                    inicia combate
                        rola iniciativa para decidir quem começa
                        quem ganhou ataca - rola o dado para ver se acerta
                        ataca até um dos combatentes morrer
                    fim do combate
                        reseta atributos
                        libera passagem
                    fugir
                        não libera passagem da porta, pegue outro caminho
                não contem monstro
                    libera passagem

* jogador
    nome
    vida
    defesa  
    ataque
    inventário [CHAVES]
    pontuação

* monstro
    nome
    vida
    defesa
    ataque