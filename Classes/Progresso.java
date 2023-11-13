public abstract class Progresso {
    protected String[] premiacoes;
    protected int premiacaoAtual;
    public Progresso() {
        this.premiacoes = new String[60];
        this.premiacaoAtual = 0;
    }
    public abstract void entregarPremiacao(Usuario user);

    public abstract void progresso(Usuario user);
}
