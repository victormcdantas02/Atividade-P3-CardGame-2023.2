import java.util.Random;

public class CartaUnique extends Carta {
    private HabilidadeC habilidadeExtra;

    public CartaUnique(String nome, String imagem, String tipo, Raridade raridade, HabilidadeC habilidade, int ataque, int defesa, int custo, int valorEmCardCoins) {
        super(nome, imagem, tipo, raridade, habilidade, ataque + 1, defesa + 1, custo, valorEmCardCoins);
        this.habilidadeExtra = gerarHabilidadeExtraAleatoria();
    }

    public HabilidadeC getHabilidadeExtra() {
        return habilidadeExtra;
    }

    public void setHabilidadeExtra(HabilidadeC habilidadeExtra) {
        this.habilidadeExtra = habilidadeExtra;
    }

    private HabilidadeC gerarHabilidadeExtraAleatoria() {
        HabilidadeC [] habilidades = HabilidadeC.values();
        Random random = new Random();
        int indiceAleatorio = random.nextInt(habilidades.length);
        return habilidades[indiceAleatorio];
    }
}