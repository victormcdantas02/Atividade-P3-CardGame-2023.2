public class CartaController {
    private Carta carta;
    private CartaView cartaView;

    public CartaController(Carta carta, CartaView cartaView) {
        this.carta = carta;
        this.cartaView = cartaView;
    }

    public void exibirDetalhesCarta() {
        cartaView.exibirDetalhesCarta(carta);
    }
}
