public class Carta {
    private String nome;
    private String imagem;
    private String tipo;
    private Raridade raridade;
    private int ataque;
    private int defesa;
    private int custo;
    private HabilidadeC habilidade;
    private int quantidade; // Novo atributo para controlar a quantidade
    private int valorEmCardCoins;

    public Carta(String nome, String imagem, String tipo, Raridade raridade, HabilidadeC habilidade, int ataque, int defesa, int custo, int valorEmCardCoins) {
        this.nome = nome;
        this.imagem = imagem;
        this.tipo = tipo;
        this.raridade = raridade;
        this.ataque = ataque;
        this.defesa = defesa;
        this.custo = custo;
        this.habilidade = habilidade;
        this.quantidade = 0; // Inicializa a quantidade como 0
        this.valorEmCardCoins = valorEmCardCoins;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public boolean podeAdicionarAoDeck() {
        // Verifica se a carta é uma mana ou se a quantidade no deck ainda não atingiu 3
        return "mana".equalsIgnoreCase(tipo) || quantidade < 3;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Raridade getRaridade() {
        return raridade;
    }

    public void setRaridade(Raridade raridade) {
        this.raridade = raridade;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public HabilidadeC getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(HabilidadeC habilidade) {
        this.habilidade = habilidade;
    }

    public boolean estaDisponivel() {
        return false;
    }

    //

    public int getValorEmCardCoins() {
        return valorEmCardCoins;
    }

    public void setValorEmCardCoins(int valorEmCardCoins) {
        this.valorEmCardCoins = valorEmCardCoins;
    }
    
}