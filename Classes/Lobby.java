import java.util.Random;

public class Lobby {
    private Usuario[] jogadores;
    private int numJogadores;
    private int maxJogadores;

    public Lobby(int maxJogadores) {
        this.maxJogadores = maxJogadores;
        jogadores = new Usuario[maxJogadores];
        numJogadores = 0;
    }

    public void joinGame(Usuario player) {
        if (numJogadores < maxJogadores) {
            jogadores[numJogadores] = player;
            numJogadores++;
            matchPlayers(player);
        } else {
            System.out.println("Lobby cheio. Não é possível ingressar na partida.");
        }
    }

    private void matchPlayers(Usuario player) {
        for (int i = 0; i < numJogadores; i++) {
            if (jogadores[i] != null && !jogadores[i].equals(player)) {
                // Encontrou um adversário de nível igual e mesmo modo de jogo.
                Usuario adversario = jogadores[i];
                iniciarPartida(player, adversario);
                break;
            }
        }
    }

    private void iniciarPartida(Usuario player, Usuario adversario) {
        System.out.println("Iniciando partida entre " + player.getNome() + " e " + adversario.getNome());
    }

    public void iniciarModoDupla() {
        if (numJogadores < 4) {
            System.out.println("Não há jogadores suficientes para o modo de dupla.");
            return;
        }

        // Embaralhe os jogadores aleatoriamente
        shufflePlayers();

        // Divida os jogadores em duas equipes aleatórias
        int equipe1Size = numJogadores / 2;
        int equipe2Size = numJogadores - equipe1Size;

        Usuario[] equipe1 = new Usuario[equipe1Size];
        Usuario[] equipe2 = new Usuario[equipe2Size];

        for (int i = 0; i < equipe1Size; i++) {
            equipe1[i] = jogadores[i];
        }

        for (int i = equipe1Size; i < numJogadores; i++) {
            equipe2[i - equipe1Size] = jogadores[i];
        }

        System.out.println("Equipe 1:");
        for (Usuario jogador : equipe1) {
            System.out.println(jogador.getNome());
        }

        System.out.println("Equipe 2:");
        for (Usuario jogador : equipe2) {
            System.out.println(jogador.getNome());
        }
    }

    private void shufflePlayers() {
        Random random = new Random();

        for (int i = numJogadores - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Usuario temp = jogadores[i];
            jogadores[i] = jogadores[j];
            jogadores[j] = temp;
        }
    }
}