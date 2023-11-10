import java.util.Random;

public class CartaUnique extends Carta implements Ativacao {
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

     @Override
    public void ativar(Carta cartaRecebida) {
        // Implementação da ativação da CartaUnique
        if (cartaRecebida instanceof CartaUnique) {
            CartaUnique cartaUnique = (CartaUnique) cartaRecebida;

            // Ativação da primeira habilidade
            if (cartaUnique.getHabilidade() != null) {
                System.out.println("Ativação da Primeira Habilidade da Carta Unique - " + cartaUnique.getHabilidade() + " ativada ");
            } else {
                System.out.println("Carta Unique não possui Primeira Habilidade");
            }

            // Ativação da segunda habilidade
            if (cartaUnique.getHabilidadeExtra() != null) {
                System.out.println("Ativação da Segunda Habilidade da Carta Unique - " + cartaUnique.getHabilidadeExtra() + " ativada ");
            } else {
                System.out.println("Carta Unique não possui Segunda Habilidade");
            }
        } else {
            System.out.println("Não é possível ativar as habilidades. A carta não é do tipo CartaUnique.");
        }
    }
}
