import java.util.Random;

public class Loja {
    private String numeroCartao;
    private String codigoVerificador;
    private boolean promocao = false;

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

    public void compraDeBooster(Usuario usuario, Inventario inventario) {
        // Verificar a quantidade de cardcoins do usuário
        int cardcoinsDoUsuario = usuario.getCardCoins();
        int precoBooster = promocao ? 150 : 100; // Preço do booster com ou sem promoção

        if (cardcoinsDoUsuario >= precoBooster) {
            int quantidadeCartasBooster = 12; // Um booster contém 12 cartas aleatórias

            for (int i = 0; i < quantidadeCartasBooster; i++) {
                // Simular a obtenção de cartas aleatórias
                Carta cartaAleatoria = gerarCartaAleatoria(inventario);

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

    public void compraDeBoosterPlus(Usuario usuario, Inventario inventario) {
        BoosterPlus boosterPlus = new BoosterPlus();
        int cardcoinsDoUsuario = usuario.getCardCoins();
        int precoBoosterPlus = promocao ? 150 : 125; // Preço do booster plus com ou sem promoção
    
        if (cardcoinsDoUsuario >= precoBoosterPlus) {
            int quantidadeCartasBooster = 12;
    
            for (int i = 0; i < quantidadeCartasBooster; i++) {
                Carta cartaAleatoria = boosterPlus.gerarCartaAleatoria(inventario);
    
                // Verifica se o inventário está cheio
                if (inventario.estaCheio()) {
                    System.out.println("Inventário está cheio. Você não pode adicionar mais cartas.");
                    break; // Sai do loop se o inventário estiver cheio
                }
    
                // Adiciona a carta ao inventário do usuário
                inventario.adicionarCarta(cartaAleatoria);
            }
    
            cardcoinsDoUsuario -= precoBoosterPlus;
            usuario.setCardCoins(cardcoinsDoUsuario);
    
            System.out.println("Compra de Booster Plus bem-sucedida!");
        } else {
            System.out.println("Você não possui cardcoins suficientes para comprar um Booster Plus.");
        }
    }


    public Carta gerarCartaAleatoria(Inventario inventario) {
        // Simulação de geração de uma carta aleatória
        Random random = new Random();
    
        // Verifique se o inventário do usuário não está vazio
        Carta[] cartasDisponiveis = inventario.getCartas();
        if (cartasDisponiveis == null || cartasDisponiveis.length == 0) {
            System.out.println("Seu inventário de cartas está vazio.");
            return null;
        }
    
        // Gere um índice aleatório para selecionar uma carta do inventário
        int indiceAleatorio = random.nextInt(cartasDisponiveis.length);
        Carta cartaAleatoria = cartasDisponiveis[indiceAleatorio];
    
        // Crie uma nova carta com base na carta selecionada, modificando-a de acordo com a raridade
        Carta cartaGerada = new Carta(
            cartaAleatoria.getNome(),
            cartaAleatoria.getImagem(),
            cartaAleatoria.getTipo(),
            modificarRaridade(cartaAleatoria.getRaridade()), // Modifique a raridade com base nas probabilidades
            cartaAleatoria.getHabilidade(),
            cartaAleatoria.getAtaque() + 1, // Adicione +1 no ataque
            cartaAleatoria.getDefesa() + 1, // Adicione +1 na defesa
            cartaAleatoria.getCusto(),
            cartaAleatoria.getValorEmCardCoins()
        );
    
        return cartaGerada;
    }
    
    // Método para modificar a raridade com base nas probabilidades
    private Raridade modificarRaridade(Raridade raridadeOriginal) {
        Random random = new Random();
        double valorAleatorio = random.nextDouble() * 100;
    
        if (valorAleatorio <= Raridade.COMUM.getProbabilidade()) {
            return Raridade.COMUM;
        } else if (valorAleatorio <= Raridade.INCOMUM.getProbabilidade()) {
            return Raridade.INCOMUM;
        } else if (valorAleatorio <= Raridade.RARA.getProbabilidade()) {
            return Raridade.RARA;
        } else if (valorAleatorio <= Raridade.MUITO_RARA.getProbabilidade()) {
            return Raridade.MUITO_RARA;
        } else {
            return Raridade.EPICA;
        }
    }  
}
