public class CartaUnique extends Carta {
    public CartaUnique(String nome, String imagem, String tipo, Raridade raridade, HabilidadeC habilidade, int ataque, int defesa, int custo, int valorEmCardCoins) {
        super(nome, imagem, tipo, raridade, habilidade, ataque + 1, defesa + 1, custo, valorEmCardCoins);
        // Adicione uma habilidade padrão extra aleatória
        this.setHabilidade(gerarHabilidadeAleatoria());
    }

    // Método para gerar uma habilidade aleatória
    private HabilidadeC gerarHabilidadeAleatoria() {
        HabilidadeC.HabilidadeCart[] habilidades = HabilidadeC.HabilidadeCart.values();
        int indiceAleatorio = (int) (Math.random() * habilidades.length); // Calcula o índice aleatório

        // Obtém uma habilidade com base no índice aleatório
        HabilidadeC habilidade = new HabilidadeC();
        habilidade.setHabilidadeCart(habilidades[indiceAleatorio]);

        return habilidade;
    }
}
