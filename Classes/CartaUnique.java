public class CartaUnique extends Carta {
    // Atributos específicos de CartaUnique
    

    public CartaUnique(String nome, String imagem, String tipo, Raridade raridade, HabilidadeC habilidade, int ataque, int defesa, int custo, int valorEmCardCoins) {
        super(nome, imagem, tipo, raridade, habilidade, ataque + 1, defesa + 1, custo, valorEmCardCoins);
        
    }


    // Outros métodos, se necessário
}