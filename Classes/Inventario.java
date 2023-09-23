public class Inventario {
    private Carta[] cartas = new Carta[200];
    private int nivelAtual = 1;
    private int cardCoins = 0;

    public Inventario(Carta[] cartas, int nivelAtual, int cardCoins) {
        this.cartas = cartas;
        this.nivelAtual = nivelAtual;
        this.cardCoins = cardCoins;
    }

    public Carta[] getCartas() {
        return cartas;
    }

    public void setCartas(Carta [] cartas) {
        this.cartas = cartas;
    }

    public int getNivelAtual() {
        return nivelAtual;
    }

    public void setNivelAtual(int nivel) {
        this.nivelAtual = nivel;
    }

    public int getCardCoins() {
        return cardCoins;
    }

    public void setCardCoins(int cardcoins) {
        this.cardCoins = cardcoins;
    }

    public boolean removerCarta(Carta carta) {
        for (int i = 0; i < cartas.length; i++) {
            if (cartas[i] != null && cartas[i].equals(carta)) {
                cartas[i] = null;
                return true; // Carta removida com sucesso
            }
        }
        return false; // Carta não encontrada no inventário
    }

    public boolean estaCheio() {
        for (Carta carta : cartas) {
            if (carta == null) {
                return false; // Se encontrar uma posição vazia, o inventário não está cheio
            }
        }
        return true; // Se todas as posições estiverem ocupadas, o inventário está cheio
    }

    public boolean adicionarCarta(Carta carta) {
        for (int i = 0; i < cartas.length; i++) {
            if (cartas[i] == null) {
                cartas[i] = carta;
                return true; // Carta adicionada com sucesso
            }
        }
        return false; // Não foi possível adicionar a carta (inventário cheio)
    }
}