public class Lobby {
    
    private Usuario[] jogadores;
    private int numJogadores;
    
    public Usuario[] getJogadores() {
        return jogadores;
    }

    public void setJogadores(Usuario[] jogadores) {
        this.jogadores = jogadores;
    }
    
    public int getNumJogadores() {
        return numJogadores;
    }

    public void setNumJogadores(int numJogadores) {
        this.numJogadores = numJogadores;
    }
    
    public Lobby(int maxJogadores) {
        jogadores = new Usuario[maxJogadores];
        numJogadores = 0;
    } 

    public void joinGame(Usuario player) {
        if (numJogadores < jogadores.length) {
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
    }
}
