public class BatalhaController {
    private BatalhaModel batalhaModel;
    private BatalhaView batalhaView;

    public BatalhaController(BatalhaModel batalhaModel, BatalhaView batalhaView) {
        this.batalhaModel = batalhaModel;
        this.batalhaView = batalhaView;
    }

    public void realizarBatalha(Carta atacante, Carta defensor, int jogadorDefensor, Arena arena) {
        batalhaModel.realizarBatalha(atacante, defensor, jogadorDefensor, arena);
    }
}
