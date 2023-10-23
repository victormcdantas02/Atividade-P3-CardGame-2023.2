import java.util.Random;

public class ArenaDupla extends Arena {
    private Usuario jogador3;
    private Usuario jogador4;
    private Deck deckJogador3;
    private Deck deckJogador4;
    private Carta[] maoJogador3;
    private Carta[] maoJogador4;

    public ArenaDupla(Usuario jogador1, Usuario jogador2, Usuario jogador3, Usuario jogador4, Deck deckJogador1, Deck deckJogador2, Deck deckJogador3, Deck deckJogador4) {
        super(jogador1, jogador2, deckJogador1, deckJogador2);
        this.jogador3 = jogador3;
        this.jogador4 = jogador4;
        this.deckJogador3 = deckJogador3;
        this.deckJogador4 = deckJogador4;
        this.maoJogador3 = new Carta[11];
        this.maoJogador4 = new Carta[11];
    }

    // Sobrescreva o método saque para acomodar quatro jogadores
    @Override
    public void saqueCartas(int jogador) {
        if (jogador == 1) {
            super.saqueCartas(1);
        } else if (jogador == 2) {
            super.saqueCartas(2);
        } else if (jogador == 3) {
            saqueCartas(3, maoJogador3, deckJogador3);
        } else if (jogador == 4) {
            saqueCartas(4, maoJogador4, deckJogador4);
        } else {
            throw new IllegalArgumentException("Número de jogador inválido.");
        }
    }

    // Sobrescreva o método inicio para acomodar quatro jogadores
    @Override
    public int inicio() {
        Random random = new Random();
        int jogadorQueComeca = random.nextInt(4) + 1;
        return jogadorQueComeca;
    }

    @Override
    public void turno(int jogador) {
        if (jogador == 1 || jogador == 2) {
            super.turno(jogador);
        } else if (jogador == 3) {
            System.out.println("Turno do Jogador 3");
            realizarCompra(jogador);
            realizarPosicionamento(jogador);
            realizarAtaque(jogador);
        } else if (jogador == 4) {
            System.out.println("Turno do Jogador 4");
            realizarCompra(jogador);
            realizarPosicionamento(jogador);
            realizarAtaque(jogador);
        } else {
            throw new IllegalArgumentException("Número de jogador inválido.");
        }
    }

    private void realizarCompra(int jogador) {
        // Implemente a lógica de compra para os jogadores 3 e 4
    }

    private void realizarPosicionamento(int jogador) {
        // Implemente a lógica de posicionamento para os jogadores 3 e 4
    }

    private void realizarAtaque(int jogador, Carta[] aliado) {
        // Implemente a lógica de ataque para os jogadores 3 e 
    }
}