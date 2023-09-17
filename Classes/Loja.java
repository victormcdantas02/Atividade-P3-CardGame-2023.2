import java.util.Random;

public class Loja {
    private String numeroCartao;
    private String codigoVerificador;

    public Loja(String numeroCartao, String codigoVerificador) {
        this.numeroCartao = numeroCartao;
        this.codigoVerificador = codigoVerificador;
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

    public void compraDeBooster(Usuario usuario) {
        // Verificar a quantidade de cardcoins do usuário
        int cardcoinsDoUsuario = usuario.getCardCoins();
        int precoBooster = 100; // Suponha que um booster custa 100 cardcoins

        if (cardcoinsDoUsuario >= precoBooster) {
            int quantidadeCartasBooster = 12; // Um booster contém 12 cartas aleatórias

            for (int i = 0; i < quantidadeCartasBooster; i++) {
                // Simular a obtenção de cartas aleatórias
                Carta cartaAleatoria = gerarCartaAleatoria();

                // Verificar se o deck do usuário já possui 3 unidades dessa carta (exceto mana)
                if (!usuario.possuiMaximoRepetidas(cartaAleatoria)) {
                    // Adicionar a carta ao deck do usuário
                    usuario.adicionarCartaAoDeck(cartaAleatoria);
                } else {
                    // O usuário já possui 3 unidades da carta, receber cardcoins
                    int valorCardcoins = 10; // Suponha que o valor seja 10 cardcoins
                    cardcoinsDoUsuario += valorCardcoins;
                }
            }

            // Deduzir o preço do booster dos cardcoins do usuário
            cardcoinsDoUsuario -= precoBooster;
            usuario.setCardCoins(cardcoinsDoUsuario);

            System.out.println("Compra bem-sucedida! Você recebeu " + quantidadeCartasBooster + " cartas no seu deck.");
        } else {
            System.out.println("Você não possui cardcoins suficientes para comprar um booster.");
        }
    }

    public Carta gerarCartaAleatoria() {
        // Simulação de geração de uma carta aleatória
        Random random = new Random();
        String[] nomesCartas = {"Carta 1", "Carta 2", "Carta 3", "Carta 4", "Carta 5"};
        String nomeAleatorio = nomesCartas[random.nextInt(nomesCartas.length)];
        int ataqueAleatorio = random.nextInt(10) + 1;
        int defesaAleatoria = random.nextInt(10) + 1;

        // carta retorna menos variáveis devido à falta de métodos/enums que serão efetuados na 2ª entrega
        int raridadeAleatoria = random.nextInt(5); // 0 a 4, representando raridade comum, incomum, rara, super rara, épica
        return null;

    }
}