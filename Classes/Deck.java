public class Deck {
    private String nome;
    private int quantidadeCartas;
    private boolean disponibilidade = false;
    private Carta[] cartas = new Carta[60];

    public Deck(String nome, int quantidadeCartas, boolean disponibilidade, Carta[] cartas) {
        this.nome = nome;
        this.quantidadeCartas = quantidadeCartas;
        this.disponibilidade = disponibilidade;
        this.cartas = cartas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdCartas() {
        return quantidadeCartas;
    }

    public void setQtdCartas(int qtdCartas) {
        this.quantidadeCartas = qtdCartas;
    }

    public boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Carta[] getCartas() {
        return cartas;
    }

    public void setCarta(Carta[] cartas) {
        this.cartas = cartas;
    }

    public void atualizarDisponibilidadeCarta() {
        if (quantidadeCartas >= 60 && quantidadeCartas < 120) {
            disponibilidade = true;
        } else {
            disponibilidade = false;
        }
    }

    public void adicionarCarta(Carta carta, Inventario inventario) {
        // Verifica se o deck não atingiu o limite máximo e se a carta não está repetindo 3 vezes (exceto mana)
        if (quantidadeCartas < 60 && !possuiMaximoRepetidas(carta)) {
            cartas[quantidadeCartas] = carta;
            quantidadeCartas++;

            // Remove a carta do inventário
            boolean removidaDoInventário = inventario.removerCarta(carta.getNome());

            // Verifica se a carta foi removida com sucesso do inventário
            if (!removidaDoInventário) {
                System.out.println("A carta não foi encontrada no inventário.");
                // Você pode lidar com esse cenário de acordo com sua lógica de negócios.
            }
        }

        atualizarDisponibilidadeCarta();
    }

    public boolean possuiMaximoRepetidas(Carta carta) {
        if (carta.getNome().equals("mana")) {
            return false; // Cartas de mana podem ter mais de 3 repetidas
        }
        int contador = 0;
        for (int i = 0; i < quantidadeCartas; i++) {
            if (cartas[i].getNome().equals(carta.getNome())) {
                contador++;
                if (contador >= 3) {
                    return true;
                }
            }
        }
        return false;
    }
}