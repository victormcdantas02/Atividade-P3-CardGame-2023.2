import java.util.Random;

public class LobbyDupla {
    private Usuario[] jogadores;
    private int numJogadores;
    private static final int MAX_JOGADORES = 8; 

    public LobbyDupla() {
        jogadores = new Usuario[MAX_JOGADORES];
        numJogadores = 0;
    }

    public Usuario[] getJogadores() {
        return jogadores;
    }

    public int getNumJogadores() {
        return numJogadores;
    }

    public void joinGame(Usuario player) {
        if (numJogadores < MAX_JOGADORES) {
            jogadores[numJogadores] = player;
            numJogadores++;
            matchPlayers(player);
        } else {
            System.out.println("Lobby cheio. Não é possível entrar na partida.");
        }
    }

    private void matchPlayers(Usuario player) {
        if (numJogadores >= 4) {
            Usuario[] playersCopy = new Usuario[numJogadores - 1];
            int index = 0;

            for (int i = 0; i < numJogadores; i++) {
                if (!jogadores[i].equals(player)) {
                    playersCopy[index] = jogadores[i];
                    index++;
                }
            }

            shuffleArray(playersCopy);

            Usuario[] selectedPlayers = new Usuario[4];
            selectedPlayers[0] = player;
            System.arraycopy(playersCopy, 0, selectedPlayers, 1, 3);

            shuffleArray(selectedPlayers);
            Usuario[] time1 = {selectedPlayers[0], selectedPlayers[1]};
            Usuario[] time2 = {selectedPlayers[2], selectedPlayers[3]};

            iniciarPartida(time1, time2);
        }
    }

    private void iniciarPartida(Usuario[] time1, Usuario[] time2) {
        System.out.println("Iniciando partida entre:");
        System.out.println("Time 1:");
        for (Usuario jogador : time1) {
            System.out.println(jogador.getNome());
        }
        System.out.println("Time 2:");
        for (Usuario jogador : time2) {
            System.out.println(jogador.getNome());
        }
    }

    private void shuffleArray(Usuario[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Usuario temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
