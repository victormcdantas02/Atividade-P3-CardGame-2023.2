public class LojaController {
    private Loja loja;
    private Usuario usuario;
    private Inventario inventario;
    private LojaView lojaView;

    public LojaController(Loja loja, Usuario usuario, Inventario inventario, LojaView lojaView) {
        this.loja = loja;
        this.usuario = usuario;
        this.inventario = inventario;
        this.lojaView = lojaView;
    }

    public void comprarBooster() {
        try {
            loja.compraDeBooster(usuario, inventario);
            lojaView.exibirMensagem("Compra de booster realizada com sucesso!");
        } catch (InsuficientCoinException e) {
            lojaView.exibirMensagem("Erro na compra de booster: " + e.getMessage());
        }
    }

    public void comprarBoosterPlus() {
        loja.compraDeBoosterPlus(usuario, inventario);
        lojaView.exibirMensagem("Compra de booster plus realizada com sucesso!");
    }
}
