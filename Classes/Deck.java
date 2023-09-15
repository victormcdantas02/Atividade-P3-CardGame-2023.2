public class Deck {
    private String nome;
    private int quantidadeCartas;
    private boolean disponibilidade;
    private Carta[] cartas;

    public Deck(String nome) {
        this.nome = nome;
        this.quantidadeCartas = quantidadeCartas;
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

    //Metodo SET
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setQuantCartas(int quantCartas){
        this.quantidadeCartas = quantidadeCartas;
    }
    public void setDisponibilidade(boolean disponibilidade){
        this.disponibilidade = disponibilidade;
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