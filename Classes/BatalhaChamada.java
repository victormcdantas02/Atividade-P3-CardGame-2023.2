

public class BatalhaChamada {
    private BatalhaModelo BatalhaModelo;
    private BatalhaView batalhaView;

    public BatalhaChamada(BatalhaModelo batalhaModelo, BatalhaView batalhaView) {
        this.BatalhaModelo = batalhaModelo;
        this.batalhaView = batalhaView;
    }

    public void realizarBatalha(Carta atacante, Carta defensor, int jogadorDefensor, Arena arena) {
        BatalhaModelo.realizarBatalha(atacante, defensor, jogadorDefensor, arena);
    }
}
