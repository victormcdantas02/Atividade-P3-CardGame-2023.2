import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class ArenaDupla extends Arena {
    private Usuario jogador3;
    private Usuario jogador4;
    private Deck deckJogador3;
    private Deck deckJogador4;
    private Carta[] maoJogador3;
    private Carta[] maoJogador4;
    private int manaMaximaJogador3;
    private int manaMaximaJogador4;
    private Carta[][] campoJogador3;
    private Carta[][] campoJogador4;
    

    public ArenaDupla(Usuario jogador1, Usuario jogador2, Usuario jogador3, Usuario jogador4, Deck deckJogador1, Deck deckJogador2, Deck deckJogador3, Deck deckJogador4) {
        super(jogador1, jogador2, deckJogador1, deckJogador2);
        this.jogador3 = jogador3;
        this.jogador4 = jogador4;
        this.deckJogador3 = deckJogador3;
        this.deckJogador4 = deckJogador4;
        this.campoJogador3 = campoJogador3;
        this.campoJogador4 = campoJogador4;
        this.maoJogador3 = new Carta[11];
        this.maoJogador4 = new Carta[11];
    }

    public Carta[] getMaoJogador3() {
        return maoJogador3;
    }
    public Carta[] getMaoJogador4() {
        return maoJogador4;
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
    public Carta[][] getCampoJogador3(){
        return campoJogador3;
    }
    public void setCampoJogador3(Carta[][] campoJogador3){
        this.campoJogador3 = campoJogador3;
    }
    public Carta[][] getCampoJogador4(){
        return campoJogador4;
    }
    public void setCampoJogador4(Carta[][] campoJogador4){
        this.campoJogador4 = campoJogador4;
    }
    public Usuario getJogador3(){
        return jogador3;
    }
    public void setJogador3(Usuario jogador3){
        this.jogador3 = jogador3;
    }
    public Usuario getJogador4(){
        return jogador4;
    }
    public void setJogador4(Usuario jogador4){
        this.jogador4 = jogador4;
    }

    @Override
    public void sacarCartas(Usuario jogador) {
        int numeroDeCartasASacar = 7;

        Random random = new Random();
        List<Usuario> jogadores = new ArrayList<>();
        jogadores.add(getJogador1());
        jogadores.add(getJogador2());
        jogadores.add(jogador3);
        jogadores.add(jogador4);

        for (Usuario j : jogadores) {
            Carta[] maoDoJogador;
            Deck deckDoJogador;

            if (j == jogador) {
                maoDoJogador = (j == jogador1) ? getMaoJogador1() : 
               (j == jogador2) ? getMaoJogador2() : 
               (j == jogador3) ? maoJogador3 : 
               (j == jogador4) ? maoJogador4 : null;
                deckDoJogador = (j == jogador1) ? getDeckJogador1() : (j == jogador2) ? getDeckJogador2() : (j == jogador3) ? deckJogador3 : deckJogador4;
            } else {
                continue;
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
                deckDoJogador.removerCarta(cartaSacada, null);
            }
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
        Deck deckDoJogador;
        Carta[] maoDoJogador;
        int manaMaximaDoJogador;
    
        if (jogador == 1) {
            deckDoJogador = getDeckJogador1();
            maoDoJogador = getMaoJogador1();
            manaMaximaDoJogador = getManaMaximaJogador1();
        } else if (jogador == 2) {
            deckDoJogador = getDeckJogador2();
            maoDoJogador = getMaoJogador2();
            manaMaximaDoJogador = getManaMaximaJogador2();
        } else if (jogador == 3) {
            deckDoJogador = deckJogador3;
            maoDoJogador = maoJogador3;
            manaMaximaDoJogador = manaMaximaJogador3;
        } else if (jogador == 4) {
            deckDoJogador = deckJogador4;
            maoDoJogador = maoJogador4;
            manaMaximaDoJogador = manaMaximaJogador4;
        } else {
            throw new IllegalArgumentException("Número de jogador inválido.");
        }
    
        if (!deckDoJogador.isEmpty()) {
            Random random = new Random();
            int indiceAleatorio = random.nextInt(deckDoJogador.getSize());
            Carta cartaComprada = deckDoJogador.getCarta(indiceAleatorio);
            for (int i = 0; i < maoDoJogador.length; i++) {
                if (maoDoJogador[i] == null) {
                    maoDoJogador[i] = cartaComprada;
                    break;
                }
            }
            deckDoJogador.removerCarta(cartaComprada, null);
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
            maoDoJogador = getMaoJogador1();
            campoDoJogador = campoJogador1();
            manaMaximaDoJogador = getManaMaximaJogador1();
        } else if (jogador == 2) {
            maoDoJogador = getMaoJogador2();
            campoDoJogador = campoJogador2();
            manaMaximaDoJogador = getManaMaximaJogador2();
        } else if (jogador == 3) {
            maoDoJogador = getMaoJogador3();
            campoDoJogador = getCampoJogador3();
            manaMaximaDoJogador = getManaMaximaJogador3();
        } else if (jogador == 4) {
            maoDoJogador = getMaoJogador4();
            campoDoJogador = getCampoJogador4();
            manaMaximaDoJogador = getManaMaximaJogador4();
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

    public void realizarAtaque(int jogador, int[] pontosVida) {
        Carta[][] campoAtacante;
    
        if (jogador == 1) {
            campoAtacante = campoJogador1;
        } else if (jogador == 2) {
            campoAtacante = campoJogador2;
        } else if (jogador == 3) {
            campoAtacante = campoJogador3;
        } else if (jogador == 4) {
            campoAtacante = campoJogador4;
        } else {
            throw new IllegalArgumentException("Número de jogador inválido.");
        }
    
        for (int linha = 0; linha < campoAtacante.length; linha++) {
            for (int coluna = 0; coluna < campoAtacante[linha].length; coluna++) {
                Carta cartaAtacante = campoAtacante[linha][coluna];
    
                if (cartaAtacante != null) {
                    if (cartaAtacante.podeAtacar()) {
                        int jogadorDefensor = (jogador % 2) + 1;
                        Carta cartaDefensora = campoJogador(jogadorDefensor)[linha][coluna];
    
                        if (cartaDefensora != null) {
                            int dano = 1;
                            pontosVida[jogadorDefensor - 1] -= dano;
                        }
    
                        cartaAtacante.setPodeAtacar(false);
                    }
                }
            }
        }
    }
    
    private Carta[][] campoJogador(int jogador) {
        if (jogador == 1) {
            return campoJogador1;
        } else if (jogador == 2) {
            return campoJogador2;
        } else if (jogador == 3) {
            return campoJogador3;
        } else if (jogador == 4) {
            return campoJogador4;
        } else {
            throw new IllegalArgumentException("Número de jogador inválido.");
        }
    }
    
}