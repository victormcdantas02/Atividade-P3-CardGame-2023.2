public class Enumerate {

    public enum Raridade {
    COMUM(80),
    INCOMUM(15),
    RARA(4),
    MUITO_RARA(0.8),
    EPICA(0.2);

    private final double probabilidadeDrop;

    private Raridade(double probabilidadeDrop) {
        this.probabilidadeDrop = probabilidadeDrop;
    }

    public double getProbabilidadeDrop() {
        return probabilidadeDrop;
    }
}
