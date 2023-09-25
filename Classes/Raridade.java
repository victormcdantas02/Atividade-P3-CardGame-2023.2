public enum Raridade {
    COMUM(80),
    INCOMUM(15),
    RARA(4),
    MUITO_RARA(0.8),
    EPICA(0.2);

    private final double probabilidade;

    private Raridade(double probabilidade) {
        this.probabilidade = probabilidade;
    }

    public double getProbabilidade() {
        return probabilidade;
    }
}
