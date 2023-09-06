public class Deck {
        
    private String nome;
    private String[] cartas;
    private boolean disponibilidade;
    private int tamanhoAtual;
    private Inventario inventario;

    public Deck(String nome, int tamanhoMaximo, Inventario inventario) {
        this.nome = nome;
        this.cartas = new String[tamanhoMaximo];
        this.disponibilidade = false;
        this.tamanhoAtual = 0;
        this.inventario = inventario;
    }
}

