public class DeckController {
    private Deck deck;
    private DeckView deckView;

    public DeckController(Deck deck, DeckView deckView) {
        this.deck = deck;
        this.deckView = deckView;
    }

    public void iniciar() {
        deckView.mostrarMensagem("Bem-vindo ao Deck Builder!");

        // Solicitar o nome do deck ao usuário
        String nomeDoDeck = deckView.obterNomeDoDeck();
        deck = new Deck(nomeDoDeck);

        // Mostra o menu principal
        executarMenuPrincipal();
    }

    private void executarMenuPrincipal() {
        int opcao;
        do {
            opcao = deckView.obterOpcaoDoMenu();

            switch (opcao) {
                case 1:
                    adicionarCartaAoDeck();
                    break;
                case 2:
                    removerCartaDoDeck();
                    break;
                case 3:
                    visualizarCartasDoDeck();
                    break;
                case 4:
                    deckView.mostrarMensagem("Saindo do Deck Builder. Até logo!");
                    break;
                default:
                    deckView.mostrarMensagem("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    private void adicionarCartaAoDeck() {
        String nomeDaCarta = deckView.obterNomeDaCarta();

        // Criar uma Carta com informações básicas (substituir conforme necessário)
        Carta carta = new Carta(false, nomeDaCarta, "", "Tipo", Raridade.COMUM, null, 1, 1, 1, 1);

        // Adicionar a carta ao deck
        boolean sucesso = deck.adicionarCarta(carta, null);

        if (sucesso) {
            deckView.mostrarMensagem("Carta adicionada ao deck com sucesso.");
        } else {
            deckView.mostrarMensagem("Não foi possível adicionar a carta ao deck. Verifique as condições.");
        }
    }

    private void removerCartaDoDeck() {
        String nomeDaCarta = deckView.obterNomeDaCarta();

        // Simulação: Criar uma Carta com informações básicas (substituir conforme necessário)
        Carta carta = new Carta(false, nomeDaCarta, "", "Tipo", Raridade.COMUM, null, 1, 1, 1, 1);

        // Remover a carta do deck
        boolean sucesso = deck.removerCarta(carta, null);

        if (sucesso) {
            deckView.mostrarMensagem("Carta removida do deck com sucesso.");
        } else {
            deckView.mostrarMensagem("Não foi possível remover a carta do deck. Verifique as condições.");
        }
    }

    private void visualizarCartasDoDeck() {
        Carta[] cartasNoDeck = deck.getCartas();

        if (cartasNoDeck.length > 0) {
            deckView.mostrarMensagem("Cartas no deck:");

            for (Carta carta : cartasNoDeck) {
                if (carta != null) {
                    deckView.mostrarMensagem("- " + carta.getNome());
                }
            }
        } else {
            deckView.mostrarMensagem("O deck está vazio. Adicione cartas antes de visualizar.");
        }
    }
}
