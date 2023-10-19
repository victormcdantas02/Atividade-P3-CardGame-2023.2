import java.util.Random;

public class Arena {
    private Usuario jogador1;
    private Usuario jogador2;
    private Deck deckJogador1;
    protected Deck deckJogador2;
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
        this.maoJogador1 = new Carta[11]; 
        this.maoJogador2 = new Carta[11]; 
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

    public void sacarCartas(Usuario jogador){
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

            int cartaIndex = random.nextInt(deckDoJogador.getSize());
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

    public void turno(int jogador) {
        if (jogador == 1) {
            System.out.println("Turno do Jogador 1");
            realizarCompra(jogador);
            realizarPosicionamento(jogador);
            realizarAtaque(jogador);
        } else if (jogador == 2) {
            System.out.println("Turno do Jogador 2");
            realizarCompra(jogador);
            realizarPosicionamento(jogador);
            realizarAtaque(jogador);
        } else {
            throw new IllegalArgumentException("Número de jogador inválido.");
        }
    }

    private void realizarCompra(int jogador) {
        Deck deckDoJogador;
        Carta[] maoDoJogador;
        int manaMaximaDoJogador;

        if (jogador == 1) {
            deckDoJogador = deckJogador1;
            maoDoJogador = maoJogador1;
            manaMaximaDoJogador = manaMaximaJogador1;
        } else if (jogador == 2) {
            deckDoJogador = deckJogador2;
            maoDoJogador = maoJogador2;
            manaMaximaDoJogador = manaMaximaJogador2;
        } else {
            throw new IllegalArgumentException("Número de jogador inválido.");
        }

        if (!deckDoJogador.isEmpty()) {
            Random random = new Random();
            int indiceAleatorio = random.nextInt(deckDoJogador.size());
            Carta cartaComprada = deckDoJogador.getCarta(indiceAleatorio);
            for (int i = 0; i < maoDoJogador.length; i++) {
                if (maoDoJogador[i] == null) {
                    maoDoJogador[i] = cartaComprada;
                    break;
                }
            }
            deckDoJogador.removerCarta(indiceAleatorio);
            manaMaximaDoJogador += 1;
        } else {
            System.out.println("O deck está vazio. Não é possível comprar mais cartas.");
        }
    }

    private void realizarPosicionamento(int jogador) {
        Carta[] maoDoJogador;
        Carta[][] campoDoJogador;
        int manaMaximaDoJogador;
    
        if (jogador == 1) {
            maoDoJogador = maoJogador1;
            campoDoJogador = campoJogador1;
            manaMaximaDoJogador = manaMaximaJogador1;
        } else if (jogador == 2) {
            maoDoJogador = maoJogador2;
            campoDoJogador = campoJogador2;
            manaMaximaDoJogador = manaMaximaJogador2;
        } else {
            throw new IllegalArgumentException("Número de jogador inválido.");
        }
    
        if (manaMaximaDoJogador >= 1) {
            for (int linha = 0; linha < campoDoJogador.length; linha++) {
                for (int coluna = 0; coluna < campoDoJogador[linha].length; coluna++) {
                    if (campoDoJogador[linha][coluna] == null) {
                        campoDoJogador[linha][coluna] = null;
                        manaMaximaDoJogador -= 1;
                        return;
                    }
                }
            }
        } else {
            for (int linha = 1; linha < campoDoJogador.length; linha++) {
                for (int coluna = 0; coluna < campoDoJogador[linha].length; coluna++) {
                    if (campoDoJogador[linha][coluna] == null) {
                        for (int i = 0; i < maoDoJogador.length; i++) {
                            if (maoDoJogador[i] != null) {
                                campoDoJogador[linha][coluna] = maoDoJogador[i];
                                maoDoJogador[i] = null;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void realizarAtaque(int jogador) {
        Carta[][] campoAtacante;
        Carta[][] campoDefensor;
        
        if (jogador == 1) {
            campoAtacante = campoJogador1;
            campoDefensor = campoJogador2;
        } else if (jogador == 2) {
            campoAtacante = campoJogador2;
            campoDefensor = campoJogador1;
        } else {
            throw new IllegalArgumentException("Número de jogador inválido.");
        }
    
        for (int linha = 0; linha < campoAtacante.length; linha++) {
            for (int coluna = 0; coluna < campoAtacante[linha].length; coluna++) {
                Carta cartaAtacante = campoAtacante[linha][coluna];
                
                if (cartaAtacante != null) {
                    if (cartaAtacante.podeAtacar()) {
                        Carta cartaDefensora = campoDefensor[linha][coluna];
                        
                        if (cartaDefensora != null) {
                            int dano = 1; 
                            if (jogador == 1) {
                                pontosVidaJogador2 -= dano;
                            } else if (jogador == 2) {
                                pontosVidaJogador1 -= dano;
                            }
                        }
                        
                        cartaAtacante.setPodeAtacar(false);
                    }
                }
            }
        }
    }
       
}