import java.util.Random;

public class Deck {
    private String nome;
    private boolean disponibilidade = false;
    private Carta[] cartas = new Carta[60]; // Tamanho máximo do deck
    private int size;

    public Deck(String nome) {
        this.nome = nome;
    }

    public int getSize(){
        return size;
    }

    public String getNome() {
        return nome;
    }

    public boolean isDisponivel() {
        return disponibilidade;
    }

    public Carta[] getCartas() {
        return cartas;
    }

    public boolean isEmpty() {
        // Verifique se o deck está vazio
        return size == 0;
    }

    private void verificarDisponibilidade() {
        // Verificar se o deck atingiu a disponibilidade
        if (cartas.length >= 60 && !possuiMaximoRepetidas()) {
            disponibilidade = true;
            System.out.println("O deck agora está disponível para uso em partidas.");
        }
    }

    public boolean adicionarCarta(Carta carta, Inventario inventario) {
        // Verificar se o deck já está disponível
        if (disponibilidade) {
            System.out.println("Este deck já está disponível para uso.");
            return false;
        }

        // Verificar se o deck já contém 60 cartas
        if (size >= 60) {
            System.out.println("Este deck já contém o número máximo de cartas (60).");
            return false;
        }

        // Verificar se o inventário possui a carta
        if (inventario.removerCarta(carta)) {
            // Adicionar a carta ao deck
            for (int i = 0; i < cartas.length; i++) {
                if (cartas[i] == null) {
                    cartas[i] = carta;
                    size++; // Aumentar o tamanho do deck
                    System.out.println("Carta adicionada ao deck com sucesso.");
                    verificarDisponibilidade();
                    return true;
                }
            }
        } else {
            System.out.println("Você não possui esta carta no inventário.");
        }

        return false;
    }

    public boolean removerCarta(Carta carta, Inventario inventario) {
        // Verificar se o deck já está disponível
        if (disponibilidade) {
            System.out.println("Este deck já está disponível para uso.");
            return false;
        }

        // Verificar se o deck contém a carta
        for (int i = 0; i < cartas.length; i++) {
            if (cartas[i] != null && cartas[i].getNome().equalsIgnoreCase(carta.getNome())) {
                // Remover a carta do deck
                cartas[i] = null;
                size--; // Reduzir o tamanho do deck
                System.out.println("Carta removida do deck com sucesso.");

                // Adicionar a carta de volta ao inventário
                inventario.adicionarCarta(carta);
                verificarDisponibilidade();
                return true;
            }
        }

        System.out.println("Esta carta não está no deck.");
        return false;
    }

    public boolean possuiMaximoRepetidas() {
        // Verificar se o deck possui mais de 3 cartas repetidas (exceto mana)
        int contadorMana = 0;
        for (Carta carta : cartas) {
            if (carta != null) {
                if (carta.getNome().equalsIgnoreCase("mana")) {
                    contadorMana++;
                }
                if (contadorMana >= 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean possuiMaximoRepetidas(Carta carta) {
        if ("mana".equalsIgnoreCase(carta.getTipo())) {
            return false; // Cartas de mana podem ter mais de 3 repetidas
        }
        
        int contador = 0;
        for (Carta cartaNoDeck : cartas) {
            if (cartaNoDeck != null && cartaNoDeck.getNome().equalsIgnoreCase(carta.getNome())) {
                contador++;
                if (contador >= cartaNoDeck.getQuantidade()) {
                    return true; // O deck atingiu o número máximo de repetições desta carta
                }
            }
        }
        return false; // O deck não atingiu o número máximo de repetições desta carta
    }

    public void embaralharCemiterio() {
        Random random = new Random();

        for (int i = size - 1; i > 0; i--) {
            int indiceAleatorio = random.nextInt(i + 1);
            Carta temp = cartas[i];
            cartas[i] = cartas[indiceAleatorio];
            cartas[indiceAleatorio] = temp;
        }
    }
}