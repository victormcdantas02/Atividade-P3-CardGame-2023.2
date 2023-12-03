public class InventarioController {
    private Inventario inventario;
    private InventarioView inventarioView;

    public InventarioController(Inventario inventario, InventarioView inventarioView) {
        this.inventario = inventario;
        this.inventarioView = inventarioView;
    }

    public void adicionarCartaAoInventario(Carta carta) {
        if (inventario.adicionarCarta(carta)) {
            System.out.println("Carta adicionada ao inventário com sucesso.");
        } else {
            System.out.println("Não foi possível adicionar a carta ao inventário.");
        }
    }

    public void removerCartaDoInventario(Carta carta) {
        if (inventario.removerCarta(carta)) {
            System.out.println("Carta removida do inventário com sucesso.");
        } else {
            System.out.println("A carta não foi encontrada no inventário.");
        }
    }

    public void exibirInventario() {
        inventarioView.exibirInventario(inventario);
    }
}
