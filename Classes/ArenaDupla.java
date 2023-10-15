import java.util.Random;
public class ArenaDupla extends Arena {
    private Usuario jogador3;
    private Usuario jogador4;
    private Deck deckJogador3;
    private Deck deckJogador4;
    private Carta[][] campoJogador3;
    private Carta[][] campoJogador4;
    private int pontosVidaJogador3;
    private int pontosVidaJogador4;
    private int pontosVidaEquipe1;
    private int pontosVidaEquipe2;
    private Carta[] maoJogador3;
    private Carta[] maoJogador4;
    private int manaMaximaJogador3;
    private int manaMaximaJogador4;
    private Carta[] cemiterioJogador3;
    private Carta[] cemiterioJogador4;

    public ArenaDupla(Usuario jogador1, Usuario jogador2, Usuario jogador3, Usuario jogador4, Deck deckJogador1, Deck deckJogador2, Deck deckJogador3, Deck deckJogador4) {
        super(jogador1, jogador2, deckJogador1, deckJogador2);
        this.jogador3 = jogador3;
        this.jogador4 = jogador4;
        this.deckJogador3 = deckJogador3;
        this.deckJogador4 = deckJogador4;
        this.campoJogador3 = new Carta[2][5];
        this.campoJogador4 = new Carta[2][5];
        this.pontosVidaJogador3 = 20;
        this.pontosVidaJogador4 = 20;
        this.pontosVidaEquipe1 = 40;
        this.pontosVidaEquipe2 = 40;
        this.maoJogador3 = new Carta[11];
        this.maoJogador4 = new Carta[11];
        this.manaMaximaJogador3 = 0;
        this.manaMaximaJogador4 = 0;
        this.cemiterioJogador3 = new Carta[100];
        this.cemiterioJogador4 = new Carta[100];
    }

    

    public Usuario getJogador3() {
        return jogador3;
    }

    public int getPontosVidaEquipe1() {
        return pontosVidaEquipe1;
    }

    public void setPontosVidaEquipe1(int pontosVidaEquipe1) {
        this.pontosVidaEquipe1 = pontosVidaEquipe1;
    }

    public int getPontosVidaEquipe2() {
        return pontosVidaEquipe2;
    }

    public void setPontosVidaEquipe2(int pontosVidaEquipe2) {
        this.pontosVidaEquipe2 = pontosVidaEquipe2;
    }

    public void setJogador3(Usuario jogador3) {
        this.jogador3 = jogador3;
    }

    public Usuario getJogador4() {
        return jogador4;
    }

    public void setJogador4(Usuario jogador4) {
        this.jogador4 = jogador4;
    }

    public Deck getDeckJogador3() {
        return deckJogador3;
    }

    public void setDeckJogador3(Deck deckJogador3) {
        this.deckJogador3 = deckJogador3;
    }

    public Deck getDeckJogador4() {
        return deckJogador4;
    }

    public void setDeckJogador4(Deck deckJogador4) {
        this.deckJogador4 = deckJogador4;
    }

    public Carta[][] getCampoJogador3() {
        return campoJogador3;
    }

    public void setCampoJogador3(Carta[][] campoJogador3) {
        this.campoJogador3 = campoJogador3;
    }

    public Carta[][] getCampoJogador4() {
        return campoJogador4;
    }

    public void setCampoJogador4(Carta[][] campoJogador4) {
        this.campoJogador4 = campoJogador4;
    }

    public int getPontosVidaJogador3() {
        return pontosVidaJogador3;
    }

    public void setPontosVidaJogador3(int pontosVidaJogador3) {
        this.pontosVidaJogador3 = pontosVidaJogador3;
    }

    public int getPontosVidaJogador4() {
        return pontosVidaJogador4;
    }

    public void setPontosVidaJogador4(int pontosVidaJogador4) {
        this.pontosVidaJogador4 = pontosVidaJogador4;
    }

    public Carta[] getMaoJogador3() {
        return maoJogador3;
    }

    public void setMaoJogador3(Carta[] maoJogador3) {
        this.maoJogador3 = maoJogador3;
    }

    public Carta[] getMaoJogador4() {
        return maoJogador4;
    }

    public void setMaoJogador4(Carta[] maoJogador4) {
        this.maoJogador4 = maoJogador4;
    }

    public int getManaMaximaJogador3() {
        return manaMaximaJogador3;
    }

    public void setManaMaximaJogador3(int manaMaximaJogador3) {
        this.manaMaximaJogador3 = manaMaximaJogador3;
    }

    public int getManaMaximaJogador4() {
        return manaMaximaJogador4;
    }

    public void setManaMaximaJogador4(int manaMaximaJogador4) {
        this.manaMaximaJogador4 = manaMaximaJogador4;
    }

    public Carta[] getCemiterioJogador3() {
        return cemiterioJogador3;
    }

    public void setCemiterioJogador3(Carta[] cemiterioJogador3) {
        this.cemiterioJogador3 = cemiterioJogador3;
    }

    public Carta[] getCemiterioJogador4() {
        return cemiterioJogador4;
    }

    public void setCemiterioJogador4(Carta[] cemiterioJogador4) {
        this.cemiterioJogador4 = cemiterioJogador4;
    }

    public void sacarCartas(int jogador) {
        int numeroDeCartasASacar = 7;

        Random random = new Random();

        Carta[] maoDoJogador;
        Deck deckDoJogador;

        if (jogador == 1) {
            maoDoJogador = maoJogador1;
            deckDoJogador = deckJogador1;
        } else if (jogador == 2) {
            maoDoJogador = maoJogador2;
            deckDoJogador = deckJogador2;
        } else if (jogador == 3) {
            maoDoJogador = maoJogador3;
            deckDoJogador = deckJogador3;
        } else if (jogador == 4) {
            maoDoJogador = maoJogador4;
            deckDoJogador = deckJogador4;
        } else {
            throw new IllegalArgumentException("Número de jogador inválido.");
        }

        for (int i = 0; i < maoDoJogador.length; i++) {
            maoDoJogador[i] = null;
        }

        for (int i = 0; i < numeroDeCartasASacar; i++) {
            if (deckDoJogador.isEmpty()) {
                deckDoJogador.embaralharCemiterio();
            }

            int cartaIndex = random.nextInt(deckDoJogador.size());
            Carta cartaSacada = deckDoJogador.getCarta(cartaIndex);
            maoDoJogador[i] = cartaSacada;
            deckDoJogador.removerCarta(cartaIndex);
        }
    }

    public int inicio() {
        Random random = new Random();
        int jogadorQueComeca = random.nextInt(4) + 1;
        return jogadorQueComeca;
    }

    public void turno(int jogador, Carta[] aliados, Carta[] inimigos) {
        if (jogador == 1) {
            System.out.println("Turno do Jogador 1");
            realizarCompra(jogador);
            realizarPosicionamento(jogador);
            realizarAtaque(jogador, inimigos);
        } else if (jogador == 2) {
            System.out.println("Turno do Jogador 2");
            realizarCompra(jogador);
            realizarPosicionamento(jogador);
            realizarAtaque(jogador, inimigos);
        } else if (jogador == 3) {
            System.out.println("Turno do Jogador 3");
            realizarCompra(jogador);
            realizarPosicionamento(jogador);
            realizarAtaque(jogador, inimigos);
        } else if (jogador == 4) {
            System.out.println("Turno do Jogador 4");
            realizarCompra(jogador);
            realizarPosicionamento(jogador);
            realizarAtaque(jogador, inimigos);
        } else {
            throw new IllegalArgumentException("Número de jogador inválido.");
        }
    }

    public void realizarCompra(int jogador, Carta[] aliados) {
    }
    
    public void realizarPosicionamento(int jogador, Carta[] aliados) {
    }
    
    public void realizarAtaque(int jogador, Carta[] aliados, Carta[] inimigos) {
    }    
}
