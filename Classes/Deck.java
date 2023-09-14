public class Deck {
    private String nome;
    private int quantidadeCartas;
    private boolean disponibilidade;
    private Carta[] cartas;

    public Deck(String nome) {
        this.nome = nome;
        this.quantidadeCartas = 0;
        this.disponibilidade = false;
        this.cartas = new Carta[60];;
       }

    //Metodo GET
    public String getNome(){
        return nome;
    }
    public int quantidadeCartas(){
        return quantidadeCartas;
    }
    public boolean disponibilidade(){
        return disponibilidade;
    }
    public Carta[] getCartas(){
        return cartas;
    }

    public void atualizarDisponibilidade() {
        if (quantidadeCartas >= 60) {
            disponibilidade = true;
        } else {
            disponibilidade = false;
        }
    }

    public void adicionarCarta(Carta carta, Inventario Inventario){ // recebe carta que a gente quer e o invent para poder remover a carta dele
        // verifica se o deck bateu o limite minimo e se a carta que a gente quer botar não esta repetindo 3 vzs exeto mana
        if(quantidadeCartas  <  60 && !possuiMaximoRepetidas(carta)){
            cartas[quantidadeCartas] = carta;
            quantidadeCartas++;
            //aqui teria que ter o metodo que remove a carta do inventario e bota no deck
            // Inventario.removerCarta(carta);
        }
        atualizarDisponibilidade();
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