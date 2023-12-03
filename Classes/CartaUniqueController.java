public class CartaUniqueController {
    private CartaUnique cartaUnique;
    private CartaUniqueView cartaUniqueView;

    public CartaUniqueController(CartaUnique cartaUnique, CartaUniqueView cartaUniqueView) {
        this.cartaUnique = cartaUnique;
        this.cartaUniqueView = cartaUniqueView;
    }

    public void exibirDetalhesCartaUnique() {
        cartaUniqueView.exibirDetalhesCartaUnique(cartaUnique);
    }
}
