public class Usuario {
    private String nome;
    private String cpf;
    private String senha;
    private int idade;
    private String sexo;
    private String email;
    private int nivel = 0;
    private int cardCoins = 0;
    private Deck[] decks;
    private Inventario inventario;
    private Deck deckAtivo; // Adicione um atributo para representar o deck ativo do usuário

    public Usuario(String nome, String cpf, String senha, String sexo, String email, int idade, int nivel) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.sexo = sexo;
        this.email = email;
	    this.nivel = nivel;
        this.idade = idade;
        this.decks = new Deck[5];
        this.inventario = new Inventario(new Carta[200], 1, 0); // Aqui você pode ajustar os valores iniciais do inventário
    }
    
    public String getNome(){
        return nome;
    }
     public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setNivel(int nivel) {
	this.nivel = nivel;
    }
    
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    public int getCardCoins() {
        return cardCoins;
    }

    public void setCardCoins(int cardCoins) {
        this.cardCoins = cardCoins;
    }

    public Deck[] getDecks() {
        return decks;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public Deck getDeckAtivo() {
        return deckAtivo;
    }

    public void selecionarDeckAtivo(int indice) {
        if (indice >= 0 && indice < decks.length) {
            deckAtivo = decks[indice];
            System.out.println("Deck ativo selecionado: " + deckAtivo.getNome());
        } else {
            System.out.println("Índice de deck inválido.");
        }
    }

    public boolean adicionarDeck(Deck deck) {
        // Verifica se o usuário já possui o número máximo de decks permitidos (5)
        if (decks.length >= 5) {
            System.out.println("Você já atingiu o número máximo de decks permitidos.");
            return false; // Não foi possível adicionar o deck
        }

        // Verifica se o deck já está na lista
        for (Deck existingDeck : decks) {
            if (existingDeck != null && existingDeck.getNome().equals(deck.getNome())) {
                System.out.println("Este deck já está na sua lista de decks.");
                return false; // Não foi possível adicionar o deck
            }
        }

        // Encontra um espaço vazio no vetor de decks
        for (int i = 0; i < decks.length; i++) {
            if (decks[i] == null) {
                decks[i] = deck; // Adiciona o deck ao vetor de decks
                System.out.println("Deck adicionado com sucesso.");
                return true; // Deck adicionado com sucesso
            }
        }

        return false; // Não foi possível adicionar o deck (nenhum espaço vazio encontrado)
    }

    public void adicionarCartaAoDeck(Carta carta) {
        // Verifique se o deck ativo está definido
        if (deckAtivo != null) {
            // Tente adicionar a carta ao deck ativo
            boolean cartaAdicionada = deckAtivo.adicionarCarta(carta, inventario);

            if (cartaAdicionada) {
                System.out.println("Carta adicionada ao deck com sucesso.");
            } else {
                System.out.println("Não foi possível adicionar a carta ao deck.");
            }
        } else {
            System.out.println("Deck ativo não definido. Selecione um deck ativo primeiro.");
        }
    }
    

    public boolean possuiMaximoRepetidas(Carta carta) {
        // Verifique se o deck ativo está definido
        if (deckAtivo != null) {
            return deckAtivo.possuiMaximoRepetidas(carta); // Chame o método do Deck para verificar a repetição
        } else {
            System.out.println("Deck ativo não definido. Selecione um deck ativo primeiro.");
            return false; // Por padrão, considere que não possui repetidas se o deck ativo não estiver definido
        }
    }


    @Override
    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf + "\nNível: " + nivel + "\nCardCoins: " + cardCoins;
    }
	public int getPontosVida() {
		return 0;
	}
}
