public class Lobby {
    private Deck[] decksDisponiveis; // Array de decks disponíveis
    private Usuario[] jogadoresEmEspera; // Array de jogadores em espera
    private int numDecks; // Número atual de decks disponíveis
    private int numJogadoresEmEspera; // Número atual de jogadores em espera

    public Lobby(int capacidadeMaxima) {
        decksDisponiveis = new Deck[capacidadeMaxima];
        jogadoresEmEspera = new Usuario[capacidadeMaxima];
        numDecks = 0;
        numJogadoresEmEspera = 0;
    }
}