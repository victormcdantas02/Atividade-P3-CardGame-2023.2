public enum HabilidadeC {
    LAPADA("Lapada"),
    ESQUIVA("Esquiva"),
    PROVOCAR("Provocar"),
    CAMUFLAR("Camuflar"),
    RESISTIR("Resistir");

    private final String descricao;

    HabilidadeC(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}