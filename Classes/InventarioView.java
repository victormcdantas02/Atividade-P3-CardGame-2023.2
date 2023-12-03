import java.util.List;

public class InventarioView {
    public void exibirInventario(Inventario inventario) {
        System.out.println("Nível Atual: " + inventario.getNivelAtual());
        System.out.println("CardCoins: " + inventario.getCardCoins());
        System.out.println("Cartas no Inventario:");
        exibirCartas(inventario.getCartas());
    }

    private void exibirCartas(Carta[] cartas) {
        for (Carta carta : cartas) {
            if (carta != null) {
                System.out.println("Nome: " + carta.getNome() + ", Tipo: " + carta.getTipo());
            }
        }
    }
}
