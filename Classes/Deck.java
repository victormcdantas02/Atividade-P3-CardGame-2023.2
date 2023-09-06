public class Deck {
        
        private String nome;
        private String[] cartas;
        private boolean disponibilidade;
        private String[] inventario;
        private int quantidadeCartas;
        
        public Deck(String nome) {
            this.nome = nome;
            this.cartas = new String[60]; // Tamanho máximo de um deck
            this.disponibilidade = false;
            this.inventario = new String[60]; // Tamanho máximo do inventário
            this.quantidadeCartas = 0;
        }
    
}
