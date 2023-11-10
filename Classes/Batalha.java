public class Batalha {
    public static void realizarBatalha(Carta atacante, Carta defensor, int jogadorDefensor, Arena arena) {
        if (!atacante.podeAtacar()) {
            System.out.println("A carta atacante não pode atacar neste turno.");
            return;
        }

        int dano = atacante.getAtaque();
        defensor.setDefesa(defensor.getDefesa() - dano);

        if (defensor.getDefesa() <= 0) {
            System.out.println("A carta defensora foi destruída.");

            // Chama a ativação da habilidade da carta atacante
            if (atacante instanceof Ativacao) {
                ((Ativacao) atacante).ativar(atacante);
            }

            if (jogadorDefensor == 1) {
                enviarParaCemiterio(defensor, arena.getCemiterioJogador1());
            } else if (jogadorDefensor == 2) {
                enviarParaCemiterio(defensor, arena.getCemiterioJogador2());
            }
        }

        atacante.setPodeAtacar(false);
        fimDeTurno(arena);
    }

    private static void enviarParaCemiterio(Carta carta, Carta[] cemiterio) {
        for (int i = 0; i < cemiterio.length; i++) {
            if (cemiterio[i] == null) {
                cemiterio[i] = carta;
                break;
            }
        }
    }

    private static void fimDeTurno(Arena arena) {
        int pontosVidaJogador1 = arena.getPontosVidaJogador1();
        int pontosVidaJogador2 = arena.getPontosVidaJogador2();

        if (pontosVidaJogador1 < 1) {
            System.out.println("Jogador 2 é o vencedor");
            darCardCoins(arena, 2, 100);
            darCardCoins(arena, 1, 10);
        } else if (pontosVidaJogador2 < 1) {
            System.out.println("Jogador 1 é o vencedor");
            darCardCoins(arena, 1, 100);
            darCardCoins(arena, 2, 10);
        }
    }

    private static void darCardCoins(Arena arena, int jogador, int quantidade) {
        if (jogador == 1) {
            Inventario inventarioJogador1 = arena.getJogador1().getInventario();
            int cardCoinsAtuais = inventarioJogador1.getCardCoins();
            inventarioJogador1.setCardCoins(cardCoinsAtuais + quantidade);
        } else if (jogador == 2) {
            Inventario inventarioJogador2 = arena.getJogador2().getInventario();
            int cardCoinsAtuais = inventarioJogador2.getCardCoins();
            inventarioJogador2.setCardCoins(cardCoinsAtuais + quantidade);
        } else {
            throw new IllegalArgumentException("Número de jogador inválido.");
        }
    }
}
