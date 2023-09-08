public class Deck {
    private String nome;
    private int quantidadeDeCartas;
    private boolean disponibilidade;
    private Carta[] inventario;

    public Deck(String nome) {
        this.nome = nome;
        this.disponibilidade = false;
        this.inventario = new Carta[60];
    }

    public void compraDeBooster(Usuario usuario) {
           }
}

