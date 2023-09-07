public class Usuario {
    private String user;
    private String cpf;
    private String senha;
    private int idade;
    private String sexo;
    private String email;
    private int nivel = 1;
    private String [] decks = new String[5];
    private double cardcoins = 0;

    public Usuario(String user, String cpf, String senha, int idade, String sexo, String email, int nivel, String[] decks, double cardcoins) {
        this.user = user;
        this.cpf = cpf;
        this.senha = senha;
        this.idade = idade;
        this.sexo = sexo;
        this.email = email;
        this.nivel = nivel;
        this.decks = decks;
        this.cardcoins = cardcoins;
    }

    //////////////////////////////////
    public String getUser() {
        return user;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public int getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEmail() {
        return email;
    }

    public int getNivel() {
        return nivel;
    }

    public String[] getDecks() {
        return decks;
    }

    public double getCardcoins() {
        return cardcoins;
    }

    /////////////////////////////
    public void setUser(String user) {
        this.user = user;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setDecks(String[] decks) {
        this.decks = decks;
    }

    public void setCardcoins(double cardcoins) {
        this.cardcoins = cardcoins;
    }
    
}
