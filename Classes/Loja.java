import java.util.Random;

public class Loja {
    private String numeroCartao;
    private String codigoVerificador;
    private boolean promocao = false;
    private Booster booster;

    public Loja(String numeroCartao, String codigoVerificador) {
        this.numeroCartao = numeroCartao;
        this.codigoVerificador = codigoVerificador;
        this.booster = new Booster();
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCodigoVerificador() {
        return codigoVerificador;
    }

    public void setCodigoVerificador(String codigoVerificador) {
        this.codigoVerificador = codigoVerificador;
    }

    public void comprarBooster(Usuario usuario, Inventario inventario) {
        comprarBooster(usuario, inventario, false);
    }

    public void comprarBooster(Usuario usuario, Inventario inventario, boolean especial) {
        int cardcoinsDoUsuario = usuario.getCardCoins();
        int precoBooster = especial ? 150 : 100;

        if (cardcoinsDoUsuario >= precoBooster) {
            int quantidadeCartasBooster = 12;

            for (int i = 0; i < quantidadeCartasBooster; i++) {
                Carta cartaAleatoria = gerarCartaAleatoria(inventario);

                if (!usuario.possuiMaximoRepetidas(cartaAleatoria)) {
                    usuario.adicionarCartaAoDeck(cartaAleatoria);
                } else {
                    int valorCardcoins = 10;
                    cardcoinsDoUsuario += valorCardcoins;
                }
            }

            cardcoinsDoUsuario -= precoBooster;
            usuario.setCardCoins(cardcoinsDoUsuario);

            System.out.println("Compra bem-sucedida! Você recebeu " + quantidadeCartasBooster + " cartas no seu deck.");
        } else {
            System.out.println("Você não possui cardcoins suficientes para comprar um booster.");
        }
    }

    private Carta gerarCartaAleatoria(Inventario inventario) {
        Random random = new Random();

        double valorAleatorio = random.nextDouble() * 100;

        if (valorAleatorio <= Raridade.COMUM.getProbabilidade()) {
            return new Carta("NomeComum", "ImagemComum", "TipoComum", Raridade.COMUM, null, 1, 1, 1, 1);
        } else if (valorAleatorio <= Raridade.INCOMUM.getProbabilidade()) {
            return new Carta("NomeIncomum", "ImagemIncomum", "TipoIncomum", Raridade.INCOMUM, null, 2, 2, 2, 2);
        } else if (valorAleatorio <= Raridade.RARA.getProbabilidade()) {
            return new Carta("NomeRara", "ImagemRara", "TipoRara", Raridade.RARA, null, 3, 3, 3, 3);
        } else if (valorAleatorio <= Raridade.MUITO_RARA.getProbabilidade()) {
            return new Carta("NomeMuitoRara", "ImagemMuitoRara", "TipoMuitoRara", Raridade.MUITO_RARA, null, 4, 4, 4, 4);
        } else {
            return new CartaUnique("NomeUnica", "ImagemUnica", "TipoUnica", Raridade.EPICA, null, 5, 5, 5, 5);
        }
    }
}