import java.util.Random;

public class Raridade {
    public enum Enumerate{
    COMUM(80),
    INCOMUM(15),
    RARA(4),
    MUITO_RARA(0.8),
    EPICA(0.2);

    private final double probabilidade;

    private Enumerate(double probabilidade) {
        this.probabilidade = probabilidade;
    }

    public double getProbabilidade() {
        return probabilidade;
        }
    }
}
