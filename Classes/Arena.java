import java.util.Random;

public class Arena {
    private Usuario jogador1;
    private Usuario jogador2;
    private Deck deckJogador1;
    private Deck deckJogador2;
    private Carta[][] campoJogador1;
    private Carta[][] campoJogador2;
    private int pontosVidaJogador1;
    private int pontosVidaJogador2;
    private Carta[] maoJogador1;
    private Carta[] maoJogador2;
    private int manaMaximaJogador1;
    private int manaMaximaJogador2;
    private Carta[] cemiterioJogador1;
    private Carta[] cemiterioJogador2;

    public Arena(Usuario jogador1, Usuario jogador2, Deck deckJogador1, Deck deckJogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.deckJogador1 = deckJogador1;
        this.deckJogador2 = deckJogador2;
        this.campoJogador1 = new Carta[2][5];
        this.campoJogador2 = new Carta[2][5];
        this.pontosVidaJogador1 = 20;
        this.pontosVidaJogador2 = 20;
        this.maoJogador1 = new Carta[11]; // 0 to 10 positions
        this.maoJogador2 = new Carta[11]; // 0 to 10 positions
        this.manaMaximaJogador1 = 0;
        this.manaMaximaJogador2 = 0;
        this.cemiterioJogador1 = new Carta[100];
        this.cemiterioJogador2 = new Carta[100];
    }

    public Usuario getJogador1(){
        return jogador1;
    }

    public void setJogador1(Usuario jogador1){
        this.jogador1 = jogador1;
    }

    public Usuario getJogador2(){
        return jogador2;
    }

    public void setJogador2(Usuario jogador2){
        this.jogador2 = jogador2;
    }

    public Deck getDeckJogador1(){
        return deckJogador1;
    }

    public void setDeckJogador1(Deck deckJogador1){
        this.deckJogador1 = deckJogador1;
    }

    public Deck getDeckJogador2(){
        return deckJogador2;
    }

    public void setDeckJogador2(Deck deckJogador2){
        this.deckJogador2 = deckJogador2;
    }

    public Carta[][] campoJogador1(){
        return campoJogador1;
    }

    public void setCampoJogador1(Carta[][] campoJogador1){
        this.campoJogador1 = campoJogador1;
    }

    public Carta[][] campoJogador2(){
        return campoJogador2;
    }

    public void setCampoJogador2(Carta[][] campoJogador2){
        this.campoJogador2 = campoJogador2;
    }

    public int getPontosVidaJogador1(){
        return pontosVidaJogador1;
    }

    public int getPontosVidaJogador2(){
        return pontosVidaJogador2;
    }
     public Carta[] getMaoJogador1() {
        return maoJogador1;
    }

    public void setMaoJogador1(Carta[] maoJogador1) {
        this.maoJogador1 = maoJogador1;
    }
    public Carta[] getMaoJogador2() {
        return maoJogador2;
    }

    public void setMaoJogador2(Carta[] maoJogador2) {
        this.maoJogador2 = maoJogador2;
    }
    public int getManaMaximaJogador1() {
        return manaMaximaJogador1;
    }
    public void setManaMaximaJogador1(int manaMaximaJogador1) {
        this.manaMaximaJogador1 = manaMaximaJogador1;
    }
    public int getManaMaximaJogador2() {
        return manaMaximaJogador2;
    }
    public void setManaMaximaJogador2(int manaMaximaJogador2) {
        this.manaMaximaJogador2 = manaMaximaJogador2;
    }
    public Carta[] getCemiterioJogador1() {
        return cemiterioJogador1;
    }

    public void setCemiterioJogador1(Carta[] cemiterioJogador1) {
        this.cemiterioJogador1 = cemiterioJogador1;
    }

    public Carta[] getCemiterioJogador2() {
        return cemiterioJogador2;
    }

    public void setCemiterioJogador2(Carta[] cemiterioJogador2) {
        this.cemiterioJogador2 = cemiterioJogador2;
    }

    public void sacarCartas(int jogador){
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
        int jogadorQueComeca = random.nextInt(2) + 1;
        return jogadorQueComeca;
    }
}