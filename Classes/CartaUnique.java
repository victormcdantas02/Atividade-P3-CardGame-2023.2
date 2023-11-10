import java.util.Random;

public class CartaUnique extends Carta {
    private HabilidadeC habilidadeExtra;

    public CartaUnique(boolean podeAtacar, String nome, String imagem, String tipo, Raridade raridade, HabilidadeC habilidadeExtra, int ataque, int defesa, int custo, int valorEmCardCoins) {
        super(podeAtacar, nome, imagem, tipo, raridade, habilidadeExtra, ataque, defesa, custo, valorEmCardCoins);
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
