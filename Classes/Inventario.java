public class Inventario {
    private String[] cartas = new String[200];
    private int nivelAtual = 1;
    private int cardCoins = 0;

    public Inventario(String[] cartas, int nivelAtual, int cardCoins) {
        this.cartas = cartas;
        this.nivelAtual = nivelAtual;
        this.cardCoins = cardCoins;
    }

    public String[] getCartas() {
        return cartas;
    }

    public void setCartas(String[] cartas) {
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

    public boolean removerCarta(String nomeCarta) {
        for (int i = 0; i < cartas.length; i++) {
            if (cartas[i] != null && cartas[i].equals(nomeCarta)) {
                cartas[i] = null;
                return true; // Carta removida com sucesso
            }
        }
        return false; // Carta não encontrada no inventário
    }
}